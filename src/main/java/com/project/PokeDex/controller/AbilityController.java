package com.project.PokeDex.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.PokeDex.model.entity.Ability;
import com.project.PokeDex.service.AbilityService;
import com.project.PokeDex.service.dto.AbilityInDTO;

@RestController
@RequestMapping("/Abilities")
public class AbilityController {
	private final AbilityService abilityService;

	public AbilityController(AbilityService abilityService) {
//		super();
		this.abilityService = abilityService;
	}
	
	@PostMapping
	public Ability createAbility(@RequestBody AbilityInDTO abilityInDTO) {
		return this.abilityService.createAbility(abilityInDTO);
	}
	
	@GetMapping
	public List<Ability> findAll(){
		return this.abilityService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Ability> findById(@PathVariable("id") int id){
		return this.abilityService.findById(id);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody AbilityInDTO abilityInDTO){
		this.abilityService.updateById(id, abilityInDTO);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") int id){
		this.abilityService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
