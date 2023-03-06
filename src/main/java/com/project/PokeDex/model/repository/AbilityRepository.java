package com.project.PokeDex.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.PokeDex.model.entity.Ability;

public interface AbilityRepository extends JpaRepository<Ability,Integer> {

	@Modifying
	@Query(value = "call Modifica_Habilidades(:id,:name)",nativeQuery = true)
	public void updateAbilityById(@Param("id") int id, @Param("name") String name);
	
//	List<Ability> findAbilityById(int abil_id);
	
}
