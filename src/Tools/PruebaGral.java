package Tools;

import Controllers.AbilityController;
import Controllers.MoveController;
import Models.AbilityModel;
import Models.MoveModel;

import java.util.List;

public class PruebaGral {
    public static void main(String[] args) {
        MoveController controller = new MoveController();
        AbilityController abilityController = new AbilityController();


        //creacion de registro nuevo
        controller.CreateMove(new MoveModel("loquito","2","55","25","85"));

        //lectura de registro por id
        System.out.println(controller.getMoveID("640").toString());
/*
        //lectura de todos los registros
        List<MoveModel> lista = controller.getMoveAll();
        for(MoveModel moveModel : lista){
            System.out.println(moveModel.toString());
        }*/

        //actualizacion de registro por id
        controller.updateMove(new MoveModel("640","loquillo","12","55","25","86"));

        //eliminacion de registro por id
        controller.deleteMove("641");


        //creacion de nuevo registro habilidad
        abilityController.createAbility(new AbilityModel("nuevo"));

        //consulta de habilidad por ID
        System.out.println(abilityController.getAbilityID("210").toString());

        /*
        //consulta de tod habilidad
        List<AbilityModel> lista = abilityController.getAbilityAll();
        for(AbilityModel abilityModel : lista)
            System.out.println(abilityModel.toString());
         */

        //modificar habilidad
        abilityController.updateAbility(new AbilityModel("193","nuevo"));

        //eliminar habilidad
        abilityController.deleteAbility("217");
    }
}
