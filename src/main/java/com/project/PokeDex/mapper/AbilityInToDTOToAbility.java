package com.project.PokeDex.mapper;

import org.springframework.stereotype.Component;

import com.project.PokeDex.model.entity.Ability;
import com.project.PokeDex.service.dto.AbilityInDTO;

@Component
public class AbilityInToDTOToAbility implements IMapper<AbilityInDTO, Ability> {

	@Override
	public Ability map(AbilityInDTO in) {
		Ability ability = new Ability();
		ability.setAbil_name(in.getAbil_name());
		return ability;
	}

}
