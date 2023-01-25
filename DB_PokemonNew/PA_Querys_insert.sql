use pokemonnew;

drop procedure if exists alta_habilidad;
drop procedure if exists alta_movimiento;
drop procedure if exists alta_tipo;
drop procedure if exists alta_pokemon;
drop procedure if exists alta_habilidades_pokemon;
drop procedure if exists alta_movimientos_pokemon;

delimiter //
create procedure `Alta_Habilidad`(in id int, in `name` varchar(79))
begin
insert into abilities(abil_id,abil_name) values (id,`name`);
end //
delimiter ;

delimiter //
create procedure `Alta_Movimiento`(in nombre varchar(79),in idTipo int,in poder int, in pp int,in accu int)
begin
insert into moves(move_name,type_id,move_power,move_pp,move_accuracy) values(nombre,idTipo,poder,pp,accu);
end //
delimiter ;

delimiter //
create procedure `Alta_Tipo`(in ID int,in nombre varchar(79),in tipoID int)
begin
insert into `types`(type_id,type_name,damage_type_id) values(Id,nombre,tipoID);
end //
delimiter ;

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

delimiter //
create procedure `Alta_Movimientos_Pokemon`(in pokID int,in vers int,moveID int,in met int,in lvl int)
begin
insert into pokemon_moves(pok_id,version_group_id,move_id,method_id,`level`) values (pokID,vers,moveID,met,lvl);
end //
delimiter ;

