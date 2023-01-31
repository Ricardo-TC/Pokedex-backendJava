use pokemonnew;

drop procedure if exists Borrar_Habilidades;
drop procedure if exists Borrar_Movimientos;
drop procedure if exists Borrar_Tipos;
drop procedure if exists Borrar_Pokemon;
drop procedure if exists Borrar_PokeHab;
drop procedure if exists Borrar_Poke_all;

delimiter //
create procedure Borrar_Poke_all(in ID int)
begin

delete from pokemon_abilities where pok_id=ID;
delete from pokemon_moves where pok_id=ID;
delete from pokemon_types where pok_id=ID;
delete from pokemon where pok_id=ID;

end //
delimiter ;



delimiter //
create procedure Borrar_Habilidades(in ID int)
begin
delete from abilities where abil_id=ID;
end //
delimiter ;

delimiter //
create procedure Borrar_Movimientos(in ID int)
begin
delete from moves where move_id=ID;
end //
delimiter ;

delimiter //
create procedure Borrar_Tipos(in ID int)
begin
delete from `types` where type_id=ID;
end //
delimiter ;

delimiter //
create procedure Borrar_Pokemon(in ID integer)
begin
delete from pokemon where pok_id=ID;
end //
delimiter ;

delimiter //
create procedure Borrar_PokeHab(in ID int,in slt int)
begin
delete from pokemon_abilities where pok_id=ID and slot=slt;
end //
delimiter ;