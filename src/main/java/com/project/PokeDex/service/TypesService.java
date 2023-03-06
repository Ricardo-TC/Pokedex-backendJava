package com.project.PokeDex.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.PokeDex.exceptions.PokeExceptions;
import com.project.PokeDex.mapper.TypesInToDTOToTypes;
import com.project.PokeDex.model.entity.Types;
import com.project.PokeDex.model.repository.TypesRepository;
import com.project.PokeDex.service.dto.TypesInDTO;
import com.project.PokeDex.util.Validations;

@Service
public class TypesService {

	private final TypesInToDTOToTypes mapper;
	private final TypesRepository repository;
	private final Validations validate = new Validations();
	public TypesService(TypesInToDTOToTypes mapper, TypesRepository repository) {
//		super();
		this.mapper = mapper;
		this.repository = repository;
	}
	
	public Types createTypes(TypesInDTO typesInDTO) {
		validate.validateTypes(typesInDTO);
		Types types = mapper.map(typesInDTO);
		return this.repository.save(types);
	}
	
	public List<Types> findAll(){
		return this.repository.findAll();
	}
	
	public Optional<Types> findById(int id){
		Optional<Types> optionalTypes = this.repository.findById(id);
		if(optionalTypes.isEmpty())throw new PokeExceptions("Data not Found",HttpStatus.NOT_FOUND);
		return optionalTypes;
	}
	
	@Transactional
	public void updateTypesById(int id, TypesInDTO typesInDTO) {
		validate.validateTypes(typesInDTO);
		if(this.repository.findById(id).isEmpty())throw new PokeExceptions("Data not Found",HttpStatus.NOT_FOUND);
		this.repository.updateTypes(id, typesInDTO.getType_name(), typesInDTO.getDamage_type_id());
	}
	
	public void deleteById(int id) {
		if(this.repository.findById(id).isEmpty())throw new PokeExceptions("Data not Found",HttpStatus.NOT_FOUND);
		this.repository.deleteById(id);
	}
}
