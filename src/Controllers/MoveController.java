package Controllers;

import Models.MoveModel;
import Services.MoveService;

import java.util.List;

public class MoveController {

    MoveService servicio = new MoveService();

    public void CreateMove(MoveModel movimiento){
        if(servicio.CreateMove(movimiento))
            System.out.println("Movimiento creado correctamente.");
        else
            System.out.println("Error al crear el movimiento.");
    }

    public MoveModel getMoveID(String id){
        return servicio.getMoveID(id);
    }

    public List<MoveModel> getMoveAll(){
        return servicio.getMoveAll();
    }

    public void updateMove(MoveModel movimiento){
        if(servicio.updateMove(movimiento))
            System.out.println("Movimiento actuailzado.");
        else
            System.out.println("Error al actualizar movimiento.");
    }

    public void deleteMove(String id){
        if(servicio.deteleMove(id))
            System.out.println("Movimiento eliminado de registro");
        else
            System.out.println("Error al eliminar movimiento");
    }
}
