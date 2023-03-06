package com.project.PokeDex.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.PokeDex.model.entity.Moves;

public interface MovesRepository extends JpaRepository<Moves, Integer>{

	@Modifying
	@Query(value = "call Modifica_Movimientos(:id,:name,:typeid,:movepower,:movepp,:moveacc)",nativeQuery = true)
	public void updateMoves(@Param("id") int id,@Param("name") String name,@Param("typeid") int typeid,
			@Param("movepower") int movep,@Param("movepp") int movepp,@Param("moveacc") int moveacc);
}
