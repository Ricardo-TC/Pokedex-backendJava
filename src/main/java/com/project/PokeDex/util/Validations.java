package com.project.PokeDex.util;

import java.util.regex.Pattern;

import org.springframework.http.HttpStatus;

import com.project.PokeDex.exceptions.PokeExceptions;
import com.project.PokeDex.service.dto.MovesInDTO;
import com.project.PokeDex.service.dto.PokemonInDTO;
import com.project.PokeDex.service.dto.TypesInDTO;

public class Validations {
		
	public boolean validateString(String string) {
		if(string.isEmpty())return false;
		if(!Pattern.matches("[a-zA-Z]+",string))return false;
		return true;
	}
	
	public boolean validateNumber(Integer number) {
		String chain = String.valueOf(number);
		if(number==0 || chain.isBlank())return false;
		Integer.parseInt(chain);
		return true;
	}
	
	public void validatePokemon(PokemonInDTO pokemon) {
		if(!validateString(pokemon.getName()))throw new PokeExceptions("Invalid name",HttpStatus.NOT_ACCEPTABLE);
		if(!validateNumber(pokemon.getBase_exp()))throw new PokeExceptions("Invalid base experience",HttpStatus.NOT_ACCEPTABLE);
		if(!validateNumber(pokemon.getHeight()))throw new PokeExceptions("Invalid height",HttpStatus.NOT_ACCEPTABLE);
		if(!validateNumber(pokemon.getWeight()))throw new PokeExceptions("Invalid weight",HttpStatus.NOT_ACCEPTABLE);
	}
	
	public void validateMoves(MovesInDTO moves) {
		if(!validateString(moves.getMove_name()))throw new PokeExceptions("Invalid name",HttpStatus.NOT_ACCEPTABLE);
		if(!validateNumber(moves.getMove_accuracy()))throw new PokeExceptions("Invalid accuracy",HttpStatus.NOT_ACCEPTABLE);
		if(!validateNumber(moves.getMove_power()))throw new PokeExceptions("Invalid power",HttpStatus.NOT_ACCEPTABLE);
		if(!validateNumber(moves.getMove_pp()))throw new PokeExceptions("Invalid move pp",HttpStatus.NOT_ACCEPTABLE);
		if(!validateNumber(moves.getType_id()))throw new PokeExceptions("Invalid type id",HttpStatus.NOT_ACCEPTABLE);
	}
	
	public void validateTypes(TypesInDTO types) {
		if(!validateString(types.getType_name()))throw new PokeExceptions("Invalid name",HttpStatus.NOT_ACCEPTABLE);
		if(!validateNumber(types.getDamage_type_id()))throw new PokeExceptions("Invalid damage type id",HttpStatus.NOT_ACCEPTABLE);
	}
}
