package com.project.PokeDex.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.PokeDex.model.entity.Pokemon;
import com.project.PokeDex.service.PokemonService;
import com.project.PokeDex.service.dto.PokemonInDTO;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/Pokemon")
public class PokemonController {

	private final PokemonService pokemonService;
	
	public PokemonController(PokemonService pokemonService) {
		//super();
		this.pokemonService = pokemonService;
	}
	
	@PostMapping
	public Pokemon createPokemon(@RequestBody PokemonInDTO pokemonInDTO) {
		return this.pokemonService.createPokemon(pokemonInDTO);
	}
	
	@GetMapping
	public List<Pokemon> findAll(){
		return this.pokemonService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Pokemon> findById(@PathVariable("id") int id){
		return this.pokemonService.findById(id);
	}
	
	@PatchMapping("/{id}")
	//public ResponseEntity<Void> update(@PathVariable("id,nombre,peso,alto,exp") int id,String nombre,int peso, int alto,int exp){
	//public ResponseEntity<Void> update(@PathVariable("id") int id,@PathVariable("nombre") String nombre,@PathVariable("peso") int peso,@PathVariable("alto") int alto,@PathVariable("exp") int exp){
	public ResponseEntity<Void> update(@PathVariable ("id") int id, @RequestBody PokemonInDTO pokemonInDTO){
		this.pokemonService.updatePokeById(id, pokemonInDTO);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		this.pokemonService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	/*
	@GetMapping("/getByHeigh")
	public List<Pokemon> findBy(){
		return this.pokemonService.findByHeight();
	}	*/
	
	@GetMapping("/CompletePokemon")
	public ResponseEntity<List<Pokemon>> getAllPokes(){
		return this.pokemonService.getAllPokes();
	}
	
	@GetMapping("/CompletePokemon/{id}")
	public ResponseEntity<Pokemon> getPokemonById(@PathVariable("id") int id){
		return this.pokemonService.getPokemonById(id);
	}
	
	@GetMapping("/DetailedInfo")
	public ResponseEntity<List<Pokemon>> readAllAboutPokes(){
		return this.pokemonService.readAllAboutPokes();
	}
}
