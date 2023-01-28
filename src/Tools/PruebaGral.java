package Tools;

import Controllers.AbilityController;
import Controllers.MoveController;
import Controllers.PokemonController;
import Controllers.TypeController;
import Models.AbilityModel;
import Models.MoveModel;
import Models.PokemonModel;
import Models.TypeModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PruebaGral {
    public static void main(String[] args) throws SQLException {
        TypeController typeController = new TypeController();
        MoveController controller = new MoveController();
        AbilityController abilityController = new AbilityController();
        PokemonController pokemonController = new PokemonController();

        typeController.createType(new TypeModel("58","test","55"));

        System.out.println(typeController.getType("18").toString());

        List<TypeModel> listaTypePrint = typeController.getAll();
        for(TypeModel typeModel : listaTypePrint)
            System.out.println(typeModel.toString());

        typeController.updateType(new TypeModel("18","test","15"));

        typeController.deleteType("58");

/*
        //creacion de registro nuevo
        controller.CreateMove(new MoveModel("loquito","2","55","25","85"));

        //lectura de registro por id
        System.out.println(controller.getMoveID("640").toString());

        //lectura de todos los registros
        List<MoveModel> listaMovePrint = controller.getMoveAll();
        for(MoveModel moveModel : listaMovePrint){
            System.out.println(moveModel.toString());
        }

        //actualizacion de registro por id
        controller.updateMove(new MoveModel("640","loquillo","12","55","25","86"));

        //eliminacion de registro por id
        controller.deleteMove("641");


        //creacion de nuevo registro habilidad
        abilityController.createAbility(new AbilityModel("nuevo"));

        //consulta de habilidad por ID
        System.out.println(abilityController.getAbilityID("210").toString());


        //consulta de tod habilidad
        List<AbilityModel> listaAbilityPrint = abilityController.getAbilityAll();
        for(AbilityModel abilityModel : listaAbilityPrint)
            System.out.println(abilityModel.toString());


        //modificar habilidad
        abilityController.updateAbility(new AbilityModel("193","nuevo"));

        //eliminar habilidad
        abilityController.deleteAbility("217");
     */

        List<AbilityModel> abilityList = new ArrayList<>();

        abilityList.add(new AbilityModel("3","das"));

        List<MoveModel> moveList = new ArrayList<>();

        moveList.add(new MoveModel("20","otro","2","50","55","100"));

        List<TypeModel> typeList = new ArrayList<>();

        typeList.add(new TypeModel("2","adas","55"));


        pokemonController.createPokemon(new PokemonModel("735","poketest","10","50","150",abilityList,moveList,typeList));
    }
}
