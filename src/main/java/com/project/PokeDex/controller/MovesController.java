package com.project.PokeDex.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.PokeDex.model.entity.Moves;
import com.project.PokeDex.service.MovesService;
import com.project.PokeDex.service.dto.MovesInDTO;

@RestController
@RequestMapping("/Moves")
public class MovesController {

	private final MovesService movesService;
	
	public MovesController(MovesService movesService) {
//		super();
		this.movesService = movesService;
	}

	@PostMapping
	public Moves createMoves(@RequestBody MovesInDTO moevsInDTO) {
		return this.movesService.createMoves(moevsInDTO);
	}
	
	@GetMapping
	public List<Moves> findAll(){
		return this.movesService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Moves> findById(@PathVariable("id") int id){
		return this.movesService.findById(id);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Void> updateMoves(@PathVariable("id") int id, @RequestBody MovesInDTO movesInDTO) {
		this.movesService.updateById(id, movesInDTO);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id){
		this.movesService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
