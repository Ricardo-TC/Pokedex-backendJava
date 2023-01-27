use pokemonnew;

#SET SESSION sql_mode = sys.list_add(@@session.sql_mode, 'ONLY_FULL_GROUP_BY');
#SELECT @@session.sql_mode;
SET sql_mode = '';
SET sql_mode = 'PAD_CHAR_TO_FULL_LENGTH';

drop procedure if exists consulta_pokemon;
drop procedure if exists consulta_pokemon_nombre;
drop procedure if exists consulta_pokemon_all;
drop procedure if exists Consulta_Movimientos;
drop procedure if exists Consulta_Tipos;
drop procedure if exists Consulta_Tipos_ID;
drop procedure if exists consulta_movimiento_all;
drop procedure if exists consulta_movimiento_id;
drop procedure if exists consulta_habilidad_all;
drop procedure if exists consulta_habilidad_id;
desc `abilities`;
##consulta de habilidad all
delimiter //
create procedure consulta_habilidad_all()
begin
select abil_id,abil_name
from abilities
order by abil_id;
end //
delimiter ;

delimiter //
create procedure consulta_habilidad_id(in ID int)
begin
select abil_id,abil_name
from abilities
where abil_id=ID;
end //
delimiter ;

##consulta de movimiento por id
delimiter //
create procedure consulta_movimiento_id(in ID int)
begin
select move_id,move_name,type_id,move_power,move_pp,move_accuracy
from moves
where move_id=ID;
end //
delimiter ;

##consulta de todos en movimientos
delimiter //
create procedure consulta_movimiento_all()
begin
select move_id,move_name,type_id,move_power,move_pp,move_accuracy
from moves
order by move_id;
end //
delimiter ;

## Consulta de pokemon por id y version ó nombre
delimiter //
create procedure Consulta_Pokemon (in id_pok int, in vers int, in name_pok varchar(79))
begin
select
	`pok`.`pok_id` as 'Numero',
	pok.pok_name as 'Nombre',
    pok.pok_weight as 'Peso',
    pok.pok_height as 'Altura',
    if(evol.pok_name is null,'NA',evol.pok_name) as 'Evolucion',
    if(evol.pok_name is null,'NA',evol.pok_name) as 'Evolucion',
    if(prevol.pok_name is null,'NA',prevol.pok_name) as 'PreEvolucion',
    group_concat(distinct pokmovmet.method_name separator ', ') as 'Metodo',
    group_concat(distinct mvs.move_name separator ', ') as 'Movimiento',
    group_concat(distinct abi.abil_name separator ', ') as 'Habilidades',
    group_concat(distinct typ.type_name separator ', ') as 'Elemento'
from	
	pokemon pok
left join	pokemon_moves pokmov
on	pok.pok_id = pokmov.pok_id
left join	pokemon_move_methods pokmovmet
on	pokmov.method_id = pokmovmet.method_id 
#### movimientos del poke
left join 	moves mvs
on 	mvs.move_id = pokmov.move_id
#### habilidades del pokemon
left join pokemon_abilities pokabi
on pokabi.pok_id = pok.pok_id
left join abilities abi
on abi.abil_id = pokabi.abil_id
#### elementos del pokemon
left join pokemon_types poktyp
on pok.pok_id = poktyp.pok_id
left join `types` typ
on typ.type_id = poktyp.type_id
#### pre evoluciones del pokemon
left join pokemon_evolution_matchup pkevolmat
on pok.pok_id = pkevolmat.pok_id
left join pokemon prevol
on prevol.pok_id = pkevolmat.evolves_from_species_id
#### evoluciones del pokemon
left join pokemon_evolution_matchup pkevolmat2
on pkevolmat2.evolves_from_species_id  = pok.pok_id
left join pokemon evol
on  pkevolmat2.pok_id = evol.pok_id
where pok.pok_id = id_pok and pokmov.version_group_id = vers or pok.pok_name = name_pok
group by pok.pok_id
;
end //
delimiter ;

## Consulta de pokemon por nombre
delimiter //
create procedure Consulta_Pokemon_Nombre (in name_pok varchar(79),in vers int)
begin
select
	`pok`.`pok_id` as 'Numero',
	pok.pok_name as 'Nombre',
    pok.pok_weight as 'Peso',
    pok.pok_height as 'Altura',
    if(evol.pok_name is null,'NA',evol.pok_name) as 'Evolucion',
    if(evol.pok_name is null,'NA',evol.pok_name) as 'Evolucion',
    if(prevol.pok_name is null,'NA',prevol.pok_name) as 'PreEvolucion',
    group_concat(distinct pokmovmet.method_name separator ', ') as 'Metodo',
    group_concat(distinct mvs.move_name separator ', ') as 'Movimiento',
    group_concat(distinct abi.abil_name separator ', ') as 'Habilidades',
    group_concat(distinct typ.type_name separator ', ') as 'Elemento'
from	
	pokemon pok
left join	pokemon_moves pokmov
on	pok.pok_id = pokmov.pok_id
left join	pokemon_move_methods pokmovmet
on	pokmov.method_id = pokmovmet.method_id 
#### movimientos del poke
left join 	moves mvs
on 	mvs.move_id = pokmov.move_id
#### habilidades del pokemon
left join pokemon_abilities pokabi
on pokabi.pok_id = pok.pok_id
left join abilities abi
on abi.abil_id = pokabi.abil_id
#### elementos del pokemon
left join pokemon_types poktyp
on pok.pok_id = poktyp.pok_id
left join `types` typ
on typ.type_id = poktyp.type_id
#### pre evoluciones del pokemon
left join pokemon_evolution_matchup pkevolmat
on pok.pok_id = pkevolmat.pok_id
left join pokemon prevol
on prevol.pok_id = pkevolmat.evolves_from_species_id
#### evoluciones del pokemon
left join pokemon_evolution_matchup pkevolmat2
on pkevolmat2.evolves_from_species_id  = pok.pok_id
left join pokemon evol
on  pkevolmat2.pok_id = evol.pok_id
where pok.pok_name = name_pok and pokmov.version_group_id = vers
group by pok.pok_id
;
end //
delimiter ;

## Consulta de todos los pokemon
delimiter //
create procedure Consulta_Pokemon_ALL ()
begin
select
	`pok`.`pok_id` as 'Numero',
	pok.pok_name as 'Nombre',
    pok.pok_weight as 'Peso',
    pok.pok_height as 'Altura',
    if(evol.pok_name is null,'NA',evol.pok_name) as 'Evolucion',
    if(evol.pok_name is null,'NA',evol.pok_name) as 'Evolucion',
    if(prevol.pok_name is null,'NA',prevol.pok_name) as 'PreEvolucion',
    group_concat(distinct pokmovmet.method_name separator ', ') as 'Metodo',
    group_concat(distinct mvs.move_name separator ', ') as 'Movimiento',
    group_concat(distinct abi.abil_name separator ', ') as 'Habilidades',
    group_concat(distinct typ.type_name separator ', ') as 'Elemento'
from	
	pokemon pok
left join	pokemon_moves pokmov
on	pok.pok_id = pokmov.pok_id
left join	pokemon_move_methods pokmovmet
on	pokmov.method_id = pokmovmet.method_id 
#### movimientos del poke
left join 	moves mvs
on 	mvs.move_id = pokmov.move_id
#### habilidades del pokemon
left join pokemon_abilities pokabi
on pokabi.pok_id = pok.pok_id
left join abilities abi
on abi.abil_id = pokabi.abil_id
#### elementos del pokemon
left join pokemon_types poktyp
on pok.pok_id = poktyp.pok_id
left join `types` typ
on typ.type_id = poktyp.type_id
#### pre evoluciones del pokemon
left join pokemon_evolution_matchup pkevolmat
on pok.pok_id = pkevolmat.pok_id
left join pokemon prevol
on prevol.pok_id = pkevolmat.evolves_from_species_id
#### evoluciones del pokemon
left join pokemon_evolution_matchup pkevolmat2
on pkevolmat2.evolves_from_species_id  = pok.pok_id
left join pokemon evol
on  pkevolmat2.pok_id = evol.pok_id
group by pok.pok_id
;
end //
delimiter ;

## Consulta de movimientos con su tipo
delimiter //
create procedure Consulta_Movimientos()
begin
select 
	mo.move_id as 'ID',
    mo.move_name as 'Ataque',
    ty.type_name as 'Tipo',
    mo.move_power as 'Fuerza' 
from moves mo
join `types` ty
on ty.type_id = mo.type_id
order by mo.move_id;
end //
delimiter ;

## Consulta de tipos
delimiter //
create procedure Consulta_Tipos()
begin
select 
	type_id as 'Numero',
    type_name as 'Tipo',
    damage_type_id as 'DMG ID'
from `types`;
end //
delimiter ;

## Consulta de tipos por ID
delimiter /
create procedure Consulta_Tipos_ID(in ID int)
begin
select 
	type_id as 'Numero',
    type_name as 'Tipo',
    damage_type_id as 'DMG ID'
from `types`
where type_id=ID;
end //
delimiter ;