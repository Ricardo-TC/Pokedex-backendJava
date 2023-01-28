package Controllers;

import Models.PokemonModel;
import Services.PokemonService;

public class PokemonController {

    private PokemonService servicio = new PokemonService();

    public void createPokemon(PokemonModel pokemon){
        if(servicio.createPokemon(pokemon))
            System.out.println("Pokemon creado correctamente");
        else
            System.out.println("Error al crear el pokemon");
    }
}
