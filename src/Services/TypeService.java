package Services;

import Models.TypeModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static Tools.DBCon.getConnection;

public class TypeService {

    public TypeService(){}
    private PreparedStatement sentencia = null;
    private ResultSet reSet = null;
    private TypeModel resultado = null;


    public TypeModel getType(int id){
        //la conexion a la bd para el id del tipo y se regresa un typemodel

        try (Connection con = getConnection()) {
            sentencia = con.prepareStatement("call consulta_tipos_id(?)");
            sentencia.setInt(1,id);

            reSet = sentencia.executeQuery();

            if(reSet.next())
                resultado = new TypeModel(reSet.getInt(1),reSet.getString(2),reSet.getInt(3));

        }catch(Exception e){
            e.printStackTrace();
        }
        return resultado;
    }

    public List<TypeModel> getAll(){
        List<TypeModel> listado = new ArrayList<>();

        try (Connection con = getConnection()){
            sentencia = con.prepareStatement("call consulta_tipos()");

            reSet = sentencia.executeQuery();
            while(reSet.next()){
                listado.add(new TypeModel(reSet.getInt(1),reSet.getString(2),reSet.getInt(3)));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return listado;
    }
}
