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
        reSet=null;
        resultado=null;
        try (Connection con = getConnection()) {
            sentencia = con.prepareStatement("call consulta_tipos_id(?)");
            sentencia.setInt(1,id);

            reSet = sentencia.executeQuery();

            if(reSet.next())
                resultado = new TypeModel(reSet.getInt(1),reSet.getString(2),reSet.getInt(3));

        }catch(SQLException e){
            System.out.println("\n -----Revisa el dato ingresado: "+id+"-----\n");
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }

        if(resultado != null){
            return resultado;
        }
        else{
            return resultado=new TypeModel(id,"No tiene datos",id);
        }
    }

    public List<TypeModel> getAll(){
        List<TypeModel> listado = new ArrayList<>();
        sentencia = null;
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

    public TypeModel createType(int id, String name, int dmgid) {
        sentencia = null;
        try(Connection con = getConnection()){
            sentencia = con.prepareStatement("call alta_tipo(?,?,?)");
            sentencia.setInt(1,id);
            sentencia.setString(2,name);
            sentencia.setInt(3,dmgid);

            reSet = sentencia.executeQuery();
        }catch(SQLException e){
            System.out.println("\n  -----Dato duplicado, favor de ingresar un dato valido diferente del ID: "+id+"-----\n");
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public TypeModel updateType(int id, String name, int dmgid){
        sentencia = null;
        try(Connection con = getConnection()){
            sentencia = con.prepareStatement("call modifica_tipos(?,?,?)");
            sentencia.setInt(1,id);
            sentencia.setString(2,name);
            sentencia.setInt(3,dmgid);

            reSet = sentencia.executeQuery();
        }catch (SQLException e){
            System.out.println("\n -----Revisa el dato ingresado-----\n");
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public TypeModel deleteType(int id)throws SQLException{
        sentencia=null;
        try(Connection con = getConnection()){
            sentencia = con.prepareStatement("call borrar_tipos(?)");
            sentencia.setInt(1,id);

            reSet = sentencia.executeQuery();
        }
        return null;
    }
}
