use pokemonnew;
#------------------------- CONSULTAS
call consulta_pokemon(2,2,'mew');#consulta por id, version o nombre

call consulta_pokemon_nombre('bulbasaur',1);#consulta por nombre

call consulta_pokemon_all();#consulta de todos los pokes

call consulta_movimientos();#consulta de movimientos con su tipo

call consulta_movimiento_all();#consulta movimiento todos

call consulta_movimiento_id(21);#consulta movimiento por id

call consulta_tipos();#consulta todos los tipos

call Consulta_Tipos_ID(3);#consulta los tipos por id

call consulta_habilidad_all();#consulta habilidad todos

call consulta_habilidad_id(2);#consulta habilidad por id

#------------------------ INSERT
call alta_habilidad('testeo telequines');

call Alta_Movimiento('testeo movimiento karatazo',2,100,50,100);

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
call Borrar_Habilidades(199);

call Borrar_Movimientos(624);

call Borrar_Tipos(19);

call Borrar_Pokemon(725);

call Borrar_PokeHab(722,7);