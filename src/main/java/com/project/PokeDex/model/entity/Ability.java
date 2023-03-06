package com.project.PokeDex.model.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@Entity
@Table(name = "abilities")
public class Ability {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private int abil_id;
	private String abil_name;

	@ManyToMany(fetch = FetchType.LAZY,
			cascade = { CascadeType.PERSIST,
			          CascadeType.MERGE},
			mappedBy = "abilities")
	@JsonIgnore
	private Set<Pokemon> pokemons = new HashSet<>();

	public int getAbil_id() {
		return abil_id;
	}

	public void setAbil_id(int abil_id) {
		this.abil_id = abil_id;
	}

	public String getAbil_name() {
		return abil_name;
	}

	public void setAbil_name(String abil_name) {
		this.abil_name = abil_name;
	}

	public Set<Pokemon> getPokemons() {
		return pokemons;
	}

	public void setPokemons(Set<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

	
	
	
	
	
//	public List<Pokemon> getPokemon() {
//		return pokemon;
//	}
//	public void setPokemon(List<Pokemon> pokemon) {
//		this.pokemon = pokemon;
//	}
//	
	
	
}
