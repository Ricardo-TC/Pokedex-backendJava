package com.project.PokeDex.service.dto;

import lombok.Data;

@Data
public class TypesInDTO {

	private String type_name;
	private int damage_type_id;
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public int getDamage_type_id() {
		return damage_type_id;
	}
	public void setDamage_type_id(int damage_type_id) {
		this.damage_type_id = damage_type_id;
	}
	
}
