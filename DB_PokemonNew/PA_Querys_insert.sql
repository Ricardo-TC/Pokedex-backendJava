use pokemonnew;

drop procedure if exists alta_habilidad;
drop procedure if exists alta_movimiento;
drop procedure if exists alta_tipo;
drop procedure if exists alta_pokemon;
drop procedure if exists alta_habilidades_pokemon;
drop procedure if exists alta_movimientos_pokemon;
drop procedure if exists alta_tipos_pokemon;
drop procedure if exists alta_pokemon_all;

delimiter //
create procedure `alta_pokemon_all`
(in pID int,in pname varchar(79),in altura int,in peso int,in exp int,   
in abID int,in hid int, in slt int,    
in ver int,in moveID int,in meth int,in lvl int,
in typeID int)
begin
insert into pokemon(pok_id,pok_name,pok_height,pok_weight,pok_base_experience)
values (pID,pname,altura,peso,exp);

insert into pokemon_abilities(pok_id,abil_id,is_hidden,slot)
values(pID,abID,hid,slt);

insert into pokemon_moves(pok_id, version_group_id, move_id, method_id, `level`)
values(pID,ver,moveID,meth,lvl);

insert into pokemon_types(pok_id,type_id,slot)
values(pID,typeID,slt);


end //
delimiter ;



################
delimiter //
create procedure `Alta_Habilidad`(in `name` varchar(79))
begin
insert into abilities(abil_name) values (`name`);
end //
delimiter ;

###################
delimiter //
create procedure `Alta_Movimiento`(in nombre varchar(79),in idTipo int,in poder int, in pp int,in accu int)
begin
insert into moves(move_name,type_id,move_power,move_pp,move_accuracy) values(nombre,idTipo,poder,pp,accu);
end //
delimiter ;

##################
delimiter //
create procedure `Alta_Tipo`(in ID int,in nombre varchar(79),in tipoID int)
begin
insert into `types`(type_id,type_name,damage_type_id) values(Id,nombre,tipoID);
end //
delimiter ;

#################
delimiter //
create procedure `Alta_Pokemon`(in ID int,in nombre varchar(79),in alt int,in peso int,in exp int)
begin
insert into pokemon(pok_id,pok_name,pok_height,pok_weight,pok_base_experience) values(Id,nombre,alt,peso,exp);
end //
delimiter ;

####################
delimiter //
create procedure `Alta_Habilidades_Pokemon`(in ID int,in abID int,in hide tinyint,in sl int)
begin
insert into pokemon_abilities(pok_id,abil_id,is_hidden,slot) values(ID,abID,hide,sl);
end //
delimiter ;
desc pokemon_abilities;

###################
delimiter //
create procedure `Alta_Movimientos_Pokemon`(in pokID int,in vers int,moveID int,in met int,in lvl int)
begin
insert into pokemon_moves(pok_id,version_group_id,move_id,method_id,`level`) values (pokID,vers,moveID,met,lvl);
end //
delimiter ;

######################
delimiter //
create procedure `Alta_Tipos_Pokemon` (in ID int,in typ_id int,in slt int)
begin
insert into pokemon_types(pok_id,type_id,slot) values(ID,typ_id,slt);
end //
delimiter ;

