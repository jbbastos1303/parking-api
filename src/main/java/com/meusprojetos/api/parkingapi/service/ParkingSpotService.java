package com.meusprojetos.api.parkingapi.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.meusprojetos.api.parkingapi.model.ParkingSpotModel;
import com.meusprojetos.api.parkingapi.repository.ParkingSpotRepository;

import jakarta.transaction.Transactional;

@Service
public class ParkingSpotService {
	
	//TODO interface
	
	final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    @Transactional
	public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
		return parkingSpotRepository.save(parkingSpotModel);
	}

	public boolean existsByPlacaVeiculo(String placaVeiculo) {
		return parkingSpotRepository.existsByPlacaVeiculo(placaVeiculo);
	}

	public boolean existsByNumeroVaga(String numeroVaga) {
		return parkingSpotRepository.existsByNumeroVaga(numeroVaga);
	}

	public boolean existsByApartamentoAndBloco(String apartamento, String bloco) {
		return parkingSpotRepository.existsByApartamentoAndBloco(apartamento, bloco);
	}

	public Page<ParkingSpotModel> findAll(Pageable pageable) {
		return parkingSpotRepository.findAll(pageable);
	}

	public Optional<ParkingSpotModel> findById(UUID id) {
		return parkingSpotRepository.findById(id);
	}
	@Transactional
	public void delete(ParkingSpotModel parkingSpotModel) {
		parkingSpotRepository.delete(parkingSpotModel);
	}

}
