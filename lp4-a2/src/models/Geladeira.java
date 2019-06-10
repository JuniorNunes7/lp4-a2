package models;

public class Geladeira {
	
	private String modelo;
	private Integer volume;
	private Integer numero_portas;
	private Boolean faz_gelo;
	
	public Geladeira (String modelo, Integer volume, Integer numero_portas, Boolean faz_gelo) {
		this.modelo = modelo;
		this.volume = volume;
		this.numero_portas = numero_portas;
		this.faz_gelo = faz_gelo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Integer getNumero_portas() {
		return numero_portas;
	}

	public void setNumero_portas(Integer numero_portas) {
		this.numero_portas = numero_portas;
	}

	public Boolean getFaz_gelo() {
		return faz_gelo;
	}

	public void setFaz_gelo(Boolean faz_gelo) {
		this.faz_gelo = faz_gelo;
	}
}
