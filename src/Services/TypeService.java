package Services;

import Models.TypeModel;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static Tools.DBCon.getConnection;

public class TypeService {

    private PreparedStatement sentencia = null;
    private ResultSet reSet = null;
    private TypeModel resultado = null;

    public TypeService(){}

    private boolean validarTipo(TypeModel tipo){//Validacion de datos
        if(tipo.getNombre().isEmpty() || tipo.getNombre()==null)//valida si los datos son nulos o vacios
            return false;

        if(!Pattern.matches("[a-zA-Z]+",tipo.getNombre())) {//valida si la cadena tiene los caracteres adecuados
            System.out.println("Dato invalido: "+tipo.getNombre());
            return false;
        }


        return true;
    }

    public TypeModel getType(int id){
        //la conexion a la bd para el id del tipo y se regresa un typemodel
        reSet=null;
        resultado=null;
        try (Connection con = getConnection()) {
            sentencia = con.prepareStatement("call consulta_tipos_id(?)");
            sentencia.setInt(1,id);

            reSet = sentencia.executeQuery();

            if(!reSet.isBeforeFirst())//verifica si el ResulSet esta vacio
                throw new SQLException();

            if(reSet.next()){
                System.out.println(reSet.getString(2));
                resultado = new TypeModel(reSet.getInt(1),reSet.getString(2),reSet.getInt(3));
            }

        }catch(SQLException e){
            System.out.println("\n -----El dato ingresado "+id+" no existe-----\n");
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }

        return resultado;
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

    public boolean createType(TypeModel tipo) {
        sentencia = null;
        validarTipo(tipo);
        if(!validarTipo(tipo)){
            System.out.println("Favor de ingresar el nombre correcto");
            return false;
        }
        try(Connection con = getConnection()){
            sentencia = con.prepareStatement("call alta_tipo(?,?,?)");
            sentencia.setInt(1,tipo.getId());
            sentencia.setString(2,tipo.getNombre());
            sentencia.setInt(3,tipo.getDmgID());

            reSet = sentencia.executeQuery();
        }catch(SQLException e){
            System.out.println("\n  -----Dato duplicado, favor de ingresar un dato valido diferente del ID: "+tipo.getId()+"-----\n");
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateType(TypeModel tipo){
        sentencia = null;
        try(Connection con = getConnection()){
            sentencia = con.prepareStatement("call modifica_tipos(?,?,?)");
            sentencia.setInt(1,tipo.getId());
            sentencia.setString(2,tipo.getNombre());
            sentencia.setInt(3,tipo.getDmgID());

            reSet = sentencia.executeQuery();
        }catch (SQLException e){
            System.out.println("\n -----Revisa el dato ingresado-----\n");
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteType(int id)throws SQLException{
        sentencia=null;
        try(Connection con = getConnection()){
            sentencia = con.prepareStatement("call borrar_tipos(?)");
            sentencia.setInt(1,id);

            reSet = sentencia.executeQuery();
        }catch(SQLException e){
            return false;
        }
        return true;
    }
}
