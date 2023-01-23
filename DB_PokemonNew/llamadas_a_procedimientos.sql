use pokemonnew;
#------------------------- CONSULTAS
call consulta_pokemon(2,2,'mew');#consulta por id, version o nombre

call consulta_pokemon_nombre('bulbasaur',1);#consulta por nombre

call consulta_pokemon_all();#consulta de todos los pokes

call consulta_movimientos();#consulta de movimientos con su tipo

#------------------------ INSERT
call alta_habilidad(192,'testeo telequines');

call Alta_Movimiento(624,'testeo movimiento karatazo',2,100,50,100);

call Alta_tipo(19,'testeo de tipo',18);

call Alta_Pokemon(725,'testpokenuevo',3,33,44);

call Alta_habilidades_pokemon(722,13,0,7);

call alta_movimientos_pokemon(1,1,15,6,1);

#---------------------- UPDATE
call modifica_habilidades(2,'drizzle');

call modifica_movimientos(2,'karate-chop',2,50,25,100);

call modifica_tipos(1,'norrmal',1);

call modifica_pokemon(1,'bulbasaur',7,69,64);

call Modifica_Pokemon_Habilidades(222,1,55,0);

#------------------- DELETE
call Borrar_Habilidades(192);

call Borrar_Movimientos(624);

call Borrar_Tipos(19);

call Borrar_Pokemon(725);

call Borrar_PokeHab(722,7);