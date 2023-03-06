package com.project.PokeDex.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.PokeDex.exceptions.PokeExceptions;
import com.project.PokeDex.mapper.MovesInToDTOToMoves;
import com.project.PokeDex.model.entity.Moves;
import com.project.PokeDex.model.repository.MovesRepository;
import com.project.PokeDex.service.dto.MovesInDTO;
import com.project.PokeDex.util.Validations;

@Service
public class MovesService {
	
	private final MovesRepository repository;
	private final MovesInToDTOToMoves mapper;
	private final Validations validate = new Validations();
	
	public MovesService(MovesRepository repository, MovesInToDTOToMoves mapper) {
//		super();
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public Moves createMoves(MovesInDTO movesInDTO) {
		validate.validateMoves(movesInDTO);
		Moves moves = mapper.map(movesInDTO);
		return this.repository.save(moves);
	}
	
	public List<Moves> findAll(){
		return this.repository.findAll();
	}
	
	public Optional<Moves> findById(int id){
		Optional<Moves> optionalMoves = this.repository.findById(id);
		if(optionalMoves.isEmpty())throw new PokeExceptions("Not Found",HttpStatus.NOT_FOUND);
		return optionalMoves;
	}
	
	@Transactional
	public void updateById(int id, MovesInDTO movesInDTO) {
		validate.validateMoves(movesInDTO);
		if(this.repository.findById(id).isEmpty())throw new PokeExceptions("Not Found",HttpStatus.NOT_FOUND);
		this.repository.updateMoves(id, movesInDTO.getMove_name(), movesInDTO.getType_id(), movesInDTO.getMove_power(), movesInDTO.getMove_pp(), 
				movesInDTO.getMove_accuracy());
	}
	
	public void deleteById(int id) {
		if(this.repository.findById(id).isEmpty())throw new PokeExceptions("Not Found",HttpStatus.NOT_FOUND);
		this.repository.deleteById(id);
	}
}
