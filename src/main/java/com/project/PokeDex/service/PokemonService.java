package com.project.PokeDex.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.PokeDex.exceptions.PokeExceptions;
import com.project.PokeDex.util.Validations;
import com.project.PokeDex.mapper.PokemonInToDTOToPokemon;
import com.project.PokeDex.model.entity.Pokemon;
import com.project.PokeDex.model.repository.PokemonRepository;
import com.project.PokeDex.service.dto.PokemonInDTO;

@Service
public class PokemonService{

	private final PokemonRepository repository;
	private final PokemonInToDTOToPokemon mapper;
	private final Validations validate = new Validations();
	
	public PokemonService(PokemonRepository repository, PokemonInToDTOToPokemon mapper) {
		//super();
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public Pokemon createPokemon(PokemonInDTO pokemonInDTO) {
//		if(!validate.validateString(pokemonInDTO.getName()))throw new PokeExceptions("Invalid data, please check: name",HttpStatus.NOT_ACCEPTABLE);
//		if(!validate.validateNumber(pokemonInDTO.getBase_exp()))throw new PokeExceptions("Invalid data, please check: exp",HttpStatus.NOT_ACCEPTABLE);
//		if(!validate.validateNumber(pokemonInDTO.getHeight()))throw new PokeExceptions("Invalid data, please check: height",HttpStatus.NOT_ACCEPTABLE);
//		if(!validate.validateNumber(pokemonInDTO.getWeight()))throw new PokeExceptions("Invalid data, please check: weight",HttpStatus.NOT_ACCEPTABLE);
		validate.validatePokemon(pokemonInDTO);
//		
//		Pokemon poke = new Pokemon();
//		Ability ability = new Ability();
//		poke.setAbilities(List.of(ability));
//		ability.setPokemon(List.of(poke));
//		this.repository.save(poke);
		
		Pokemon pokemon = mapper.map(pokemonInDTO);
		return this.repository.save(pokemon);
	}
	
	public List<Pokemon> findAll(){
		return (List<Pokemon>) this.repository.findAll();
	}
	
	public Optional<Pokemon> findById(int id) {
		Optional<Pokemon> optionalPoke = this.repository.findById(id);
		if(optionalPoke.isEmpty()) {
			throw new PokeExceptions("Data not found", HttpStatus.NOT_FOUND);
		}
		return optionalPoke;
	}
	
	@Transactional
	public void updatePokeById(int id,PokemonInDTO pokemonInDTO) {
//		if(!validate.validateString(pokemonInDTO.getName()))throw new PokeExceptions("Invalid data, please check: name",HttpStatus.NOT_ACCEPTABLE);
//		if(!validate.validateNumber(pokemonInDTO.getBase_exp()))throw new PokeExceptions("Invalid data, please check: exp",HttpStatus.NOT_ACCEPTABLE);
//		if(!validate.validateNumber(pokemonInDTO.getHeight()))throw new PokeExceptions("Invalid data, please check: height",HttpStatus.NOT_ACCEPTABLE);
//		if(!validate.validateNumber(pokemonInDTO.getWeight()))throw new PokeExceptions("Invalid data, please check: weight",HttpStatus.NOT_ACCEPTABLE);
		validate.validatePokemon(pokemonInDTO);
		if(this.repository.findById(id).isEmpty())
			throw new PokeExceptions("Data not found", HttpStatus.NOT_FOUND);
		this.repository.updatePokemon(id,pokemonInDTO.getName(),pokemonInDTO.getHeight(),pokemonInDTO.getWeight(),pokemonInDTO.getBase_exp());
		
	}
	
	public void deleteById(int id) {
		//Optional<Pokemon> optionalPoke = this.repository.findById(id);
		if(this.repository.findById(id).isEmpty())
			throw new PokeExceptions("Data not found", HttpStatus.NOT_FOUND);
		this.repository.deleteById(id);
	}
	
	
	/*
	public List<Pokemon> findByHeight(){
		return (List<Pokemon>) this.repository.findByPok_height(10);
	}*/
	
	
	public ResponseEntity<List<Pokemon>> getAllPokes(){
		List<Pokemon> pokes = new ArrayList<Pokemon>();
		repository.findAll().forEach(pokes::add);
		return new ResponseEntity<>(pokes, HttpStatus.OK);
	}
	
	public ResponseEntity<Pokemon> getPokemonById(int id){
//		
//		Pokemon pokemon = new Pokemon();
//		try {
//			pokemon = repository.findById(id)
//			        .orElseThrow(() -> new AttributeNotFoundException("Not found Tutorial with id = " + id));
//		} catch (AttributeNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Optional<Pokemon> pokemon = repository.findById(id);
		//Pokemon optPokemon = repository.findById(id).get();
		if(pokemon.isEmpty())throw new PokeExceptions("Data not found",HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(pokemon.get(),HttpStatus.OK);
		
	}
	
	
	public ResponseEntity<List<Pokemon>> readAllAboutPokes(){
		List<Pokemon> allPokes = new ArrayList<Pokemon>();
		repository.readAllAboutPokes().forEach(allPokes::add);
		return new ResponseEntity<>(allPokes,HttpStatus.OK);
	}
	
}
