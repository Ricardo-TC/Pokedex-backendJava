package com.project.PokeDex.mapper;

import org.springframework.stereotype.Component;

import com.project.PokeDex.model.entity.Pokemon;
import com.project.PokeDex.service.dto.PokemonInDTO;

@Component
public class PokemonInToDTOToPokemon implements IMapper<PokemonInDTO, Pokemon>{

	@Override
	public Pokemon map(PokemonInDTO in) {
		Pokemon pokemon = new Pokemon();
		pokemon.setPok_name(in.getName());
		pokemon.setPok_height(in.getHeight());
		pokemon.setPok_weight(in.getWeight());
		pokemon.setPok_base_experience(in.getBase_exp());
		return pokemon;
	}
}
