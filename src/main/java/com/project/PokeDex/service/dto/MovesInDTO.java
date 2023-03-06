package com.project.PokeDex.service.dto;

import lombok.Data;

@Data
public class MovesInDTO {

	private String move_name;
	private int type_id;
	private int move_power;
	private int move_pp;
	private int move_accuracy;
	public String getMove_name() {
		return move_name;
	}
	public void setMove_name(String move_name) {
		this.move_name = move_name;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public int getMove_power() {
		return move_power;
	}
	public void setMove_power(int move_power) {
		this.move_power = move_power;
	}
	public int getMove_pp() {
		return move_pp;
	}
	public void setMove_pp(int move_pp) {
		this.move_pp = move_pp;
	}
	public int getMove_accuracy() {
		return move_accuracy;
	}
	public void setMove_accuracy(int move_accuracy) {
		this.move_accuracy = move_accuracy;
	}
}
