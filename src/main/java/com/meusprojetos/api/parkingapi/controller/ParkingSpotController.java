package com.meusprojetos.api.parkingapi.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meusprojetos.api.parkingapi.dto.ParkingSpotDTO;
import com.meusprojetos.api.parkingapi.model.ParkingSpotModel;
import com.meusprojetos.api.parkingapi.service.ParkingSpotService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/")
public class ParkingSpotController {
	
	//TODO classe validacao
	//TODO parametros no getall
	//TODO filtros
	//TODO relacionamentos
	
	final ParkingSpotService parkingSpotService;

	public ParkingSpotController(ParkingSpotService parkingSpotService) {
		this.parkingSpotService = parkingSpotService;
	}
	
	@PostMapping("parking-spot")
	public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDTO parkingSpotDTO){
		if(parkingSpotService.existsByPlacaVeiculo(parkingSpotDTO.getPlacaVeiculo())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: A placa já está em uso!");
		}
		if(parkingSpotService.existsByNumeroVaga(parkingSpotDTO.getNumeroVaga())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: A vaga já está em uso!");
		}
		if(parkingSpotService.existsByApartamentoAndBloco(parkingSpotDTO.getApartamento(), parkingSpotDTO.getBloco())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Vaga já registrada para este apartamento/bloco!");
		}
		
		var parkingSpotModel = new ParkingSpotModel();
		BeanUtils.copyProperties(parkingSpotDTO, parkingSpotModel);
		parkingSpotModel.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
	}
	
	@GetMapping("all-spots")
	public ResponseEntity<Page<ParkingSpotModel>> getAllParkingSpots(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC)Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll(pageable));
	}
	
	@GetMapping("find-spot/{id}")
	public ResponseEntity<Object> getOneParkingSpot(@PathVariable(value = "id") UUID id){
		Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
		if(!parkingSpotModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não encontrada!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelOptional.get());
	}
	
	@DeleteMapping("delete-spot/{id}")
	public ResponseEntity<Object> deleteParkingSpot(@PathVariable(value = "id") UUID id){
		Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
		if(!parkingSpotModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não encontrada!");
		}
		parkingSpotService.delete(parkingSpotModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Vaga excluída com sucesso!");
	}
	
	@PutMapping("atualiza-spot/{id}")
	public ResponseEntity<Object> updateParkingSpot(@PathVariable(value = "id") UUID id,
													@RequestBody @Valid ParkingSpotDTO parkingSpotDTO){
		Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
		if(!parkingSpotModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não encontrada!");
		}
		var parkingSpotModel = new ParkingSpotModel();
		BeanUtils.copyProperties(parkingSpotDTO, parkingSpotModel);
		parkingSpotModel.setId(parkingSpotModelOptional.get().getId());
		parkingSpotModel.setDataRegistro(parkingSpotModelOptional.get().getDataRegistro());
		return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.save(parkingSpotModel));
	}

}
