package com.project.PokeDex.mapper;

import org.springframework.stereotype.Component;

import com.project.PokeDex.model.entity.Types;
import com.project.PokeDex.service.dto.TypesInDTO;

@Component
public class TypesInToDTOToTypes implements IMapper<TypesInDTO,Types>{

	@Override
	public Types map(TypesInDTO in) {
		Types types = new Types();
		types.setType_name(in.getType_name());
		types.setDamage_type_id(in.getDamage_type_id());
		return types;
	}

}
