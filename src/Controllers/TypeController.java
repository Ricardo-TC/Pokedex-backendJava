package Controllers;


import Models.TypeModel;
import Services.TypeService;

import java.sql.SQLException;
import java.util.List;

public class TypeController {
    //mandar a llamar getType de servicio
    TypeService servicio = new TypeService();

    public TypeController() {    }

    public TypeModel getType(int id)throws SQLException {
        return servicio.getType(id);
    }

    public List<TypeModel> getAll(){
        return servicio.getAll();
    }

    public void createType(TypeModel tipo)throws SQLException{
        if(servicio.createType(tipo))
            System.out.println("Tipo agregado correctamente");
        else
            System.out.println("Error al agregar tipo");
    }

    public boolean updateType(TypeModel tipo) throws SQLException{
        return servicio.updateType(tipo);
    }

    public void deleteType(int id) throws SQLException{
        if(servicio.deleteType(id))
            System.out.println("Tipo eliminado correctamente");
        else
            System.out.println("Error al eliminar tipo");
    }

}
