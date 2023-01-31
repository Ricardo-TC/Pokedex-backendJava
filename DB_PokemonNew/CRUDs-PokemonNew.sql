use pokemonnew;
#------------------------MODULO ABILITIES
###CREATE
delimiter //
create procedure `Alta_Habilidad`(in `name` varchar(79))
begin
insert into abilities(abil_name) values (`name`);
end //
delimiter ;

###READ
delimiter //
create procedure `consulta_habilidad_id`(in ID int)
begin
select abil_id,abil_name
from abilities
where abil_id=ID;
end //
delimiter ;

delimiter //
create procedure `consulta_habilidad_all`()
begin
select abil_id,abil_name
from abilities
order by abil_id;
end //
delimiter ;

###UPDATE
delimiter //
create procedure `Modifica_Habilidades`(in ID int, in nombre varchar(79))
begin
update abilities set abil_name=nombre where abil_id=ID;
end //
delimiter ;

###DELETE
delimiter //
create procedure `Borrar_Habilidades`(in ID int)
begin
delete from abilities where abil_id=ID;
end //
delimiter ;


#-----------------------------------MODULO MOVES
###CREATE
delimiter //
create procedure `Alta_Movimiento`(in nombre varchar(79),in idTipo int,in poder int, in pp int,in accu int)
begin
insert into moves(move_name,type_id,move_power,move_pp,move_accuracy) values(nombre,idTipo,poder,pp,accu);
end //
delimiter ;

###READ
delimiter //
create procedure `consulta_movimiento_id`(in ID int)
begin
select move_id,move_name,type_id,move_power,move_pp,move_accuracy
from moves
where move_id=ID;
end //
delimiter ;

delimiter //
create procedure `consulta_movimiento_all`()
begin
select move_id,move_name,type_id,move_power,move_pp,move_accuracy
from moves
order by move_id;
end //
delimiter ;

###UPDATE
delimiter //
create procedure `Modifica_Movimientos`(in ID int,in nombre varchar(79),in tID int,in mpower smallint,in mpp smallint,in maccu smallint)
begin
update  moves 
set move_name=nombre, type_id=tID,move_power=mpower,move_pp=mpp,move_accuracy=maccu 
where move_id=ID;
end //
delimiter ;

###DELETE
delimiter //
create procedure `Borrar_Movimientos`(in ID int)
begin
delete from moves where move_id=ID;
end //
delimiter ;

#----------------------------------MODULO TYPES
###CREATE
delimiter //
create procedure `Alta_Tipo`(in ID int,in nombre varchar(79),in tipoID int)
begin
insert into `types`(type_id,type_name,damage_type_id) values(Id,nombre,tipoID);
end //
delimiter ;

###READ
delimiter //
create procedure `Consulta_Tipos_ID`(in ID int)
begin
select 
	type_id as 'Numero',
    type_name as 'Tipo',
    damage_type_id as 'DMG ID'
from `types`
where type_id=ID;
end //
delimiter ;

delimiter //
create procedure `Consulta_Tipos`()
begin
select 
	type_id as 'Numero',
    type_name as 'Tipo',
    damage_type_id as 'DMG ID'
from `types`;
end //
delimiter ;

###UPDATE
delimiter //
create procedure `Modifica_Tipos`(in ID int,in nombre varchar(79),in dmgtipoid int)
begin
update `types` 
set type_name=nombre, damage_type_id=dmgtipoid
where type_id=ID;
end //
delimiter ;

###DELETE
delimiter //
create procedure `Borrar_Tipos`(in ID int)
begin
delete from `types` where type_id=ID;
end //
delimiter ;


#-----------------MODULO POKEMON
###CREATE
delimiter //
create procedure `Alta_Pokemon`(in ID int,in nombre varchar(79),in alt int,in peso int,in exp int)
begin
insert into pokemon(pok_id,pok_name,pok_height,pok_weight,pok_base_experience) values(Id,nombre,alt,peso,exp);
end //
delimiter ;

delimiter //
create procedure `Alta_Habilidades_Pokemon`(in ID int,in abID int,in hide tinyint,in sl int)
begin
insert into pokemon_abilities(pok_id,abil_id,is_hidden,slot) values(ID,abID,hide,sl);
end //
delimiter ;
desc pokemon_abilities;

delimiter //
create procedure `Alta_Movimientos_Pokemon`(in pokID int,in vers int,moveID int,in met int,in lvl int)
begin
insert into pokemon_moves(pok_id,version_group_id,move_id,method_id,`level`) values (pokID,vers,moveID,met,lvl);
end //
delimiter ;

delimiter //
create procedure `Alta_Tipos_Pokemon` (in ID int,in typ_id int,in slt int)
begin
insert into pokemon_types(pok_id,type_id,slot) values(ID,typ_id,slt);
end //
delimiter ;

###READ
delimiter //
create procedure `consulta_pokemon_tma_ID`(in ID int)
begin 
select pok_id,pok_name,pok_height,pok_weight,pok_base_experience from pokemon where pok_id=ID;

select ab.abil_id, ab.abil_name 
from abilities ab
join pokemon_abilities pab
on pab.abil_id = ab.abil_id 
where pab.pok_id = ID;

select ms.move_id,ms.move_name,ms.type_id,ms.move_power,ms.move_pp,ms.move_accuracy 
from moves ms
join pokemon_moves pms
on ms.move_id = pms.move_id
where pms.pok_id = ID;

select t.type_id,t.type_name,t.damage_type_id 
from `types` t
join pokemon_types pt
on pt.type_id = t.type_id
where pt.pok_id = ID;
end //
delimiter ;

delimiter //
create procedure `consulta_pokemon_tma_all`()
begin
select
	`pok`.`pok_id` as 'Numero',
	pok.pok_name as 'Nombre',
    pok.pok_weight as 'Peso',
    pok.pok_height as 'Altura',
    group_concat(distinct mvs.move_name separator ', ') as 'Movimiento',
    group_concat(distinct abi.abil_name separator ', ') as 'Habilidades',
    group_concat(distinct typ.type_name separator ', ') as 'Elemento'
    
#### movimientos del poke
from pokemon pok
left join pokemon_moves pokmvs
on pokmvs.pok_id = pok.pok_id
left join 	moves mvs
on 	pokmvs.move_id = mvs.move_id

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

group by pok.pok_id;

end //
delimiter ;

###DELETE
delimiter //
create procedure `Borrar_Poke_all`(in ID int)
begin

delete from pokemon_abilities where pok_id=ID;
delete from pokemon_moves where pok_id=ID;
delete from pokemon_types where pok_id=ID;
delete from pokemon where pok_id=ID;

end //
delimiter ;