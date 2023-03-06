package com.project.PokeDex.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.PokeDex.model.entity.Types;

public interface TypesRepository extends JpaRepository<Types, Integer> {
	
	@Modifying
	@Query(value = "call Modifica_Tipos(:type_id,:type_name,:damage_type_id)", nativeQuery = true)
	public void updateTypes(@Param("type_id") int type_id, @Param("type_name") String type_name, @Param("damage_type_id") int damage_type_id);

}
