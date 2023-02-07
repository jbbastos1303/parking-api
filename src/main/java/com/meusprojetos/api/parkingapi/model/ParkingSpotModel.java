package com.meusprojetos.api.parkingapi.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PARKING_SPOT")
public class ParkingSpotModel implements Serializable {
	
	
	//TODO classe carro
	//TODO classe morador
	//TODO lombok
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(nullable = false, unique = true, length = 10)
	private String numeroVaga; //parkingSpotNumber
	@Column(nullable = false, unique = true, length = 7)
	private String placaVeiculo; //licensePlateCar;
	@Column(nullable = false, length = 70)
	private String marcaVeiculo; //brandCar;
	@Column(nullable = false, length = 70)
	private String modeloVeiculo; //modelCar;
	@Column(nullable = false, length = 70)
	private String corVeiculo; //colorCar;
	@Column(nullable = false)
	private LocalDateTime dataRegistro; //registrationDate;
	@Column(nullable = false, length = 130)
	private String responsavelVeiculo; //responsibleName;
	@Column(nullable = false, length = 30)
	private String apartamento; //apartment;
	@Column(nullable = false, length = 30)
	private String bloco; //block;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getNumeroVaga() {
		return numeroVaga;
	}
	public void setNumeroVaga(String numeroVaga) {
		this.numeroVaga = numeroVaga;
	}
	public String getPlacaVeiculo() {
		return placaVeiculo;
	}
	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}
	public String getMarcaVeiculo() {
		return marcaVeiculo;
	}
	public void setMarcaVeiculo(String marcaVeiculo) {
		this.marcaVeiculo = marcaVeiculo;
	}
	public String getModeloVeiculo() {
		return modeloVeiculo;
	}
	public void setModeloVeiculo(String modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}
	public String getCorVeiculo() {
		return corVeiculo;
	}
	public void setCorVeiculo(String corVeiculo) {
		this.corVeiculo = corVeiculo;
	}
	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	public String getResponsavelVeiculo() {
		return responsavelVeiculo;
	}
	public void setResponsavelVeiculo(String responsavelVeiculo) {
		this.responsavelVeiculo = responsavelVeiculo;
	}
	public String getApartamento() {
		return apartamento;
	}
	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
	}
	public String getBloco() {
		return bloco;
	}
	public void setBloco(String bloco) {
		this.bloco = bloco;
	}
	
}
