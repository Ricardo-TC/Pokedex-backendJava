package Controllers;


import Models.TypeModel;
import Services.TypeService;

import java.sql.SQLException;
import java.util.List;

public class TypeController {
    //mandar a llamar getType de servicio


    public TypeController() {    }

    TypeService servicio = new TypeService();

    public TypeModel getType(int id)throws SQLException {
        return servicio.getType(id);
    }

    public List<TypeModel> getAll(){
        return servicio.getAll();
    }

    public TypeModel createType(int id, String name, int dmgid)throws SQLException{
        return servicio.createType(id,name,dmgid);
    }

    public TypeModel updateType(int id, String name, int dmgid) throws SQLException{
        return servicio.updateType(id,name,dmgid);
    }

    public TypeModel deleteType(int id) throws SQLException{
        return servicio.deleteType(id);
    }

}
