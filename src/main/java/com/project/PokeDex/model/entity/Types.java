package com.project.PokeDex.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "types")
public class Types {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
	@GenericGenerator(strategy = "native", name = "native")
	private int type_id;
	private String type_name;
	private int damage_type_id;
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = { CascadeType.PERSIST,
			          CascadeType.MERGE},
			mappedBy = "types")
	@JsonIgnore
	private Set<Pokemon> pokemons = new HashSet<>();
	
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
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
	public Set<Pokemon> getPokemons() {
		return pokemons;
	}
	public void setPokemons(Set<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}
}
