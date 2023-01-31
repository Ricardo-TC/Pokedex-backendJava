package Services;

import Models.TypeModel;
import Tools.Herramientas;
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
    private Herramientas validar = new Herramientas();

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

    public TypeModel getType(String id){
        //la conexion a la bd para el id del tipo y se regresa un typemodel
        reSet=null;resultado=null;

        try (Connection con = getConnection()) {
            sentencia = con.prepareStatement("call consulta_tipos_id(?)");
            sentencia.setString(1,id);

            reSet = sentencia.executeQuery();

            if(!reSet.isBeforeFirst())//verifica si el ResulSet esta vacio
                throw new SQLException();

            if(reSet.next())
                resultado = new TypeModel(reSet.getString(1),reSet.getString(2),reSet.getString(3));

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
        sentencia = null;reSet=null;
        try (Connection con = getConnection()){
            sentencia = con.prepareStatement("call consulta_tipos()");

            reSet = sentencia.executeQuery();
            while(reSet.next()){
                listado.add(new TypeModel(reSet.getString(1),reSet.getString(2),reSet.getString(3)));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listado;
    }

    public boolean createType(TypeModel tipo) {
        sentencia = null;reSet=null;

        if(!validar.validarNumero(tipo.getId()))return false;
        if(!validar.validarCadena(tipo.getNombre()))return false;
        if(!validar.validarNumero(tipo.getDmgID()))return false;

        try(Connection con = getConnection()){
            sentencia = con.prepareStatement("call alta_tipo(?,?,?)");
            sentencia.setString(1,tipo.getId());
            sentencia.setString(2,tipo.getNombre());
            sentencia.setString(3,tipo.getDmgID());

            reSet = sentencia.executeQuery();
        }catch(SQLException e){
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateType(TypeModel tipo){
        sentencia = null;reSet=null;

        if(!validar.validarNumero(tipo.getId()))return false;
        if(!validar.validarCadena(tipo.getNombre()))return false;
        if(!validar.validarNumero(tipo.getDmgID()))return false;

        try(Connection con = getConnection()){
            sentencia = con.prepareStatement("call modifica_tipos(?,?,?)");
            sentencia.setString(1,tipo.getId());
            sentencia.setString(2,tipo.getNombre());
            sentencia.setString(3,tipo.getDmgID());

            reSet = sentencia.executeQuery();
        }catch (SQLException e){
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteType(String id)throws SQLException{
        sentencia=null;

        try(Connection con = getConnection()){
            sentencia = con.prepareStatement("call borrar_tipos(?)");
            sentencia.setString(1,id);

            reSet = sentencia.executeQuery();
        }catch(SQLException e){
            return false;
        }
        return true;
    }
}
