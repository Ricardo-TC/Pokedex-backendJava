package com.project.PokeDex.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.PokeDex.model.entity.Types;
import com.project.PokeDex.service.TypesService;
import com.project.PokeDex.service.dto.TypesInDTO;

@RestController
@RequestMapping("/Types")
public class TypesController {

	private final TypesService typesServices;

	public TypesController(TypesService typesServices) {
//		super();
		this.typesServices = typesServices;
	}
	
	@PostMapping
	public Types createTypes(@RequestBody TypesInDTO typesInDTO) {
		return this.typesServices.createTypes(typesInDTO);
	}
	
	@GetMapping
	public List<Types> findAll(){
		return this.typesServices.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Types> findById(@PathVariable("id") int id){
		return this.typesServices.findById(id);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") int id,@RequestBody TypesInDTO typesInDTO){
		this.typesServices.updateTypesById(id, typesInDTO);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id){
		this.typesServices.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
