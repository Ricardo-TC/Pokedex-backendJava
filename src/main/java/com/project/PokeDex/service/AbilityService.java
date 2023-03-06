package com.project.PokeDex.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.project.PokeDex.exceptions.PokeExceptions;
import com.project.PokeDex.mapper.AbilityInToDTOToAbility;
import com.project.PokeDex.model.entity.Ability;
import com.project.PokeDex.model.repository.AbilityRepository;
import com.project.PokeDex.service.dto.AbilityInDTO;
import com.project.PokeDex.util.Validations;

@Service
public class AbilityService {
	private final AbilityRepository repository;
	private final AbilityInToDTOToAbility mapper;
	private final Validations validate = new Validations();
	public AbilityService(AbilityRepository repository, AbilityInToDTOToAbility mapper) {
//		super();
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public Ability createAbility(AbilityInDTO abilityInDTO) {
		if(!validate.validateString(abilityInDTO.getAbil_name()))throw new PokeExceptions("Invalid data, please check: name",HttpStatus.NOT_ACCEPTABLE);
		Ability ability = mapper.map(abilityInDTO);
		return this.repository.save(ability);
	}
	
	public List<Ability> findAll(){
		return this.repository.findAll();
	}
	
	public Optional<Ability> findById(int id){
		Optional<Ability> optionalAbility = this.repository.findById(id); 
		if(optionalAbility.isEmpty())throw new PokeExceptions("Data not found",HttpStatus.NOT_FOUND);
		return optionalAbility;
	}
	
	@Transactional
	public void updateById(int id, AbilityInDTO abilityInDTO) {
		if(!validate.validateString(abilityInDTO.getAbil_name()))throw new PokeExceptions("Invalid data, please check: name", HttpStatus.NOT_ACCEPTABLE);
		if(this.repository.findById(id).isEmpty())throw new PokeExceptions("Data not found", HttpStatus.NOT_FOUND);
		this.repository.updateAbilityById(id, abilityInDTO.getAbil_name());
	}
	
	public void deleteById(int id) {
		if(this.repository.findById(id).isEmpty())throw new PokeExceptions("Data not found", HttpStatus.NOT_FOUND);
		this.repository.deleteById(id);
	}
}
