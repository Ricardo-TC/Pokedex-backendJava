package com.project.PokeDex.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;

@Data
@Entity
@Table(name = "pokemon")
public class Pokemon {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name="native", strategy="native")
	@Column(name = "pok_id")
	private int pok_id;
	//.IDENTITY
	//@Column("pok_name")
	//private String name;
	@Column(name = "pok_name")
	private String pok_name;
	@Column(name = "pok_height")
	private int pok_height;
	@Column(name = "pok_weight")
	private int pok_weight;
	@Column(name = "pok_base_experience")
	private int pok_base_experience;
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.MERGE,CascadeType.PERSIST})//CascadeType.ALL
	@JoinTable(
			name = "pokemon_abilities",
			joinColumns = {@JoinColumn(name = "pok_id")},//, referencedColumnName = "id"
			inverseJoinColumns = {@JoinColumn(name = "abil_id")})//, referencedColumnName = "id"
	private Set<Ability> abilities = new HashSet<>();
	//////////////
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.MERGE,CascadeType.PERSIST})//CascadeType.ALL
	@JoinTable(
			name = "pokemon_moves",
			joinColumns = {@JoinColumn(name = "pok_id")},//, referencedColumnName = "id"
			inverseJoinColumns = {@JoinColumn(name = "move_id")})//, referencedColumnName = "id"
	private Set<Moves> moves = new HashSet<>();
	/////////////
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.MERGE,CascadeType.PERSIST})//CascadeType.ALL
	@JoinTable(
			name = "pokemon_types",
			joinColumns = {@JoinColumn(name = "pok_id")},//, referencedColumnName = "id"
			inverseJoinColumns = {@JoinColumn(name = "type_id")})//, referencedColumnName = "id"
	private Set<Types> types = new HashSet<>();
	
	
	public void addAbility(Ability ability) {
		this.abilities.add(ability);
		ability.getPokemons().add(this);
	}
	
	public void removeAbility(int abil_id) {
		Ability ability = this.abilities.stream().filter(t -> t.getAbil_id() == abil_id).findFirst().orElse(null);
		if(ability != null) {
			this.abilities.remove(ability);
			ability.getPokemons().remove(this);
		}
	}

	public int getPok_id() {
		return pok_id;
	}

	public void setPok_id(int pok_id) {
		this.pok_id = pok_id;
	}

	public String getPok_name() {
		return pok_name;
	}

	public void setPok_name(String pok_name) {
		this.pok_name = pok_name;
	}

	public int getPok_height() {
		return pok_height;
	}

	public void setPok_height(int pok_height) {
		this.pok_height = pok_height;
	}

	public int getPok_weight() {
		return pok_weight;
	}

	public void setPok_weight(int pok_weight) {
		this.pok_weight = pok_weight;
	}

	public int getPok_base_experience() {
		return pok_base_experience;
	}

	public void setPok_base_experience(int pok_base_experience) {
		this.pok_base_experience = pok_base_experience;
	}

	public Set<Ability> getAbilities() {
		return abilities;
	}

	public void setAbilities(Set<Ability> abilities) {
		this.abilities = abilities;
	}

	public Set<Moves> getMoves() {
		return moves;
	}

	public void setMoves(Set<Moves> moves) {
		this.moves = moves;
	}

	public Set<Types> getTypes() {
		return types;
	}

	public void setTypes(Set<Types> types) {
		this.types = types;
	}

//	private List<Ability> abilities;
//	public List<Ability> getAbilities() {
//		return abilities;
//	}
//	public void setAbilities(List<Ability> abilities) {
//		this.abilities = abilities;
//	}
//	
	
	
}