package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Veiculo {
	private int id;
	private String marca;
	private String modelo;
	private int ano;
	private float quilometragem;	
	
	public Veiculo() {
		id = -1;
		marca = "";
		modelo = "";
		ano = 0;
		quilometragem = 0;
	}

	public Veiculo(int id, String marca, String modelo, int ano, float quilometragem) {
		setId(id);
		setMarca(marca);
		setModelo(modelo);
		setAno(ano);
		setQuilometragem(quilometragem);
	}		
	
	public int getID() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public float getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(float quilometragem) {
		this.quilometragem = quilometragem;
	}


	/**
	 * Método sobreposto da classe Object. É executado quando um objeto precisa
	 * ser exibido na forma de String.
	 */
	@Override
	public String toString() {
		return "Veiculo: Marca: " + marca + "   Modelo: " + modelo + "   Ano: " + ano + "   Quilometragem: "
				+ quilometragem;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (this.getID() == ((Veiculo) obj).getID());
	}	
}