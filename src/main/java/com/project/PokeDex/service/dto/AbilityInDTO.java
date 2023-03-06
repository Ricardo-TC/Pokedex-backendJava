package com.project.PokeDex.service.dto;

import lombok.Data;

@Data
public class AbilityInDTO {

	private String abil_name;

	public String getAbil_name() {
		return abil_name;
	}

	public void setAbil_name(String abil_name) {
		this.abil_name = abil_name;
	}
	
	
}
