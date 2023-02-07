package com.meusprojetos.api.parkingapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meusprojetos.api.parkingapi.model.ParkingSpotModel;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID> {
	
	boolean existsByPlacaVeiculo(String placaVeiculo);
	boolean existsByNumeroVaga(String numeroVaga);
	boolean existsByApartamentoAndBloco(String apartamento, String bloco);

}
