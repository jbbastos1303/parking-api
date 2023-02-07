package com.meusprojetos.api.parkingapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ParkingSpotDTO {
	
	//TODO lombok

	@NotBlank
	private String numeroVaga; //parkingSpotNumber
	@NotBlank
	@Size(max = 7)
	private String placaVeiculo; //licensePlateCar;
	@NotBlank
	private String marcaVeiculo; //brandCar;
	@NotBlank
	private String modeloVeiculo; //modelCar;
	@NotBlank
	private String corVeiculo; //colorCar;
	@NotBlank
	private String responsavelVeiculo; //responsibleName;
	@NotBlank
	private String apartamento; //apartment;
	@NotBlank
	private String bloco; //block;
	
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
