package com.project.PokeDex.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "moves")
public class Moves {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private int move_id;
	private String move_name;
	private int type_id;
	@Column(name = "move_power", nullable = true)
	private Integer move_power=0;
	@Column(name = "move_pp", nullable = true)
	private Integer move_pp=0;
	@Column(name = "move_accuracy", nullable = true)
	private Integer move_accuracy=0;
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = { CascadeType.PERSIST,
			          CascadeType.MERGE},
			mappedBy = "moves")
	@JsonIgnore
	private Set<Pokemon> pokemons = new HashSet<>();
	public int getMove_id() {
		return move_id;
	}
	public void setMove_id(int move_id) {
		this.move_id = move_id;
	}
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
	public Integer getMove_power() {
		return move_power;
	}
	public void setMove_power(Integer move_power) {
		this.move_power = move_power;
	}
	public Integer getMove_pp() {
		return move_pp;
	}
	public void setMove_pp(Integer move_pp) {
		this.move_pp = move_pp;
	}
	public Integer getMove_accuracy() {
		return move_accuracy;
	}
	public void setMove_accuracy(Integer move_accuracy) {
		this.move_accuracy = move_accuracy;
	}
	public Set<Pokemon> getPokemons() {
		return pokemons;
	}
	public void setPokemons(Set<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}
}
