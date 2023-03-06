package com.project.PokeDex.service.dto;

import lombok.Data;

@Data
public class PokemonInDTO {

	private String pok_name;
	private int pok_height;
	private int pok_weight;
	private int pok_base_experience;
	public String getName() {
		return pok_name;
	}
	public void setName(String name) {
		this.pok_name = name;
	}
	public int getHeight() {
		return pok_height;
	}
	public void setHeight(int height) {
		this.pok_height = height;
	}
	public int getWeight() {
		return pok_weight;
	}
	public void setWeight(int weight) {
		this.pok_weight = weight;
	}
	public int getBase_exp() {
		return pok_base_experience;
	}
	public void setBase_exp(int base_exp) {
		this.pok_base_experience = base_exp;
	}		
}