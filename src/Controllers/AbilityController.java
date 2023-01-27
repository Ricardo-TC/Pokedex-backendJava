package Controllers;

import Models.AbilityModel;
import Services.AbilityService;

import java.util.List;

public class AbilityController {
    private AbilityService servicio = new AbilityService();

    public void createAbility(AbilityModel habilidad){
        if(servicio.createAbility(habilidad))
            System.out.println("Habilidad creada correctamente");
        else
            System.out.println("Error al crear habilidad");
    }

    public AbilityModel getAbilityID(String id){
        return servicio.getAbilityID(id);
    }

    public List<AbilityModel> getAbilityAll(){
        return servicio.getAbilityAll();
    }

    public void updateAbility(AbilityModel habilidad){
        if(servicio.updateAbility(habilidad))
            System.out.println("Habilidad modificada correctamente");
        else
            System.out.println("Error al modificar habilidad");
    }

    public void deleteAbility(String id){
        if(servicio.deleteAbility(id))
            System.out.println("Habilidad eliminada del registro");
        else
            System.out.println("Error al eliminar habilidad");
    }
}
