package Controllers;

import Models.MoveModel;
import Services.MoveService;

public class MoveController {

    MoveService servicio = new MoveService();

    public void CreateMove(MoveModel movimiento){
        if(servicio.CreateMove(movimiento))
            System.out.println("Movimiento creado correctamente");
        else
            System.out.println("Error al crear el movimiento");
    }
}
