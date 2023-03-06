package com.project.PokeDex.mapper;

import org.springframework.stereotype.Component;

import com.project.PokeDex.model.entity.Moves;
import com.project.PokeDex.service.dto.MovesInDTO;

@Component
public class MovesInToDTOToMoves implements IMapper<MovesInDTO, Moves>{

	@Override
	public Moves map(MovesInDTO in) {
		Moves moves = new Moves();
		moves.setMove_name(in.getMove_name());
		moves.setType_id(in.getType_id());
		moves.setMove_power(in.getMove_power());
		moves.setMove_pp(in.getMove_pp());
		moves.setMove_accuracy(in.getMove_accuracy());
		return moves;
	}

}
