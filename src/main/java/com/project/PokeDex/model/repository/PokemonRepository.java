package com.project.PokeDex.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.PokeDex.model.entity.*;

public interface PokemonRepository extends JpaRepository<Pokemon,Integer> {
	
		
	
	//@Query(value="update pokemon set pok_name=:?2,pok_weight=?3,pok_height=?4,pok_base_experience=?5 where pok_id=?1", nativeQuery = true)
	
	
	//----------------------------------------------ESTA QUERY ES FUNCIONAL-----------------------------------------------------------
	//@Query(value="update pokemon set pok_name=:nombre,pok_weight=:peso,pok_height=:alto,pok_base_experience=:exp where pok_id=:id", nativeQuery = true)
	
	
	//public void updatePokemon(@Param("id,nombre,peso,alto,exp") int id,String nombre,int peso, int alto,int exp);
	
	@Modifying
	@Query(value = "call Update_Poke(:pid,:pname,:pheight,:pweight,:exp)", nativeQuery = true)
	//@Query(value="update pokemon set pok_name=:nombre,pok_height=:alto,pok_weight=:peso,pok_base_experience=:exp where pok_id=:id", nativeQuery = true)
	public void updatePokemon(@Param("pid") int id,@Param("pname") String nombre,@Param("pheight") int alto,@Param("pweight") int peso,@Param("exp") int exp);

	@Modifying
	@Query(value= "call read_all_about_pokes()",nativeQuery = true)
	public List<Pokemon> readAllAboutPokes();
    //@Query("SELECT pok_id, pok_name FROM pokemon WHERE pok_height = :height")
    //public List<Pokemon> findByPok_height(int height);
	
	
//	public List<Pokemon> findPokemonById(int pok_id);
	
	
}
