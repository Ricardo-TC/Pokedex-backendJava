package Services;

import Models.AbilityModel;
import Tools.Herramientas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Tools.DBCon.getConnection;

public class AbilityService {

    private PreparedStatement sentencia;
    private ResultSet reSet;
    private AbilityModel resultado = new AbilityModel();
    private Herramientas validar = new Herramientas();

    public boolean createAbility(AbilityModel habilidad){
        sentencia = null;reSet = null;

        if(!validar.validarCadena(habilidad.getName())){return false;}

        try(Connection con = getConnection()){
            sentencia = con.prepareStatement("call alta_habilidad(?)");
            sentencia.setString(1, habilidad.getName());
            reSet = sentencia.executeQuery();
        }catch (SQLException e){
            return false;
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public AbilityModel getAbilityID(String id){
        sentencia = null; reSet = null; resultado = null;

        try(Connection con = getConnection()){

            sentencia = con.prepareStatement("call consulta_habilidad_id(?)");
            sentencia.setString(1,id);
            reSet = sentencia.executeQuery();

            if(!reSet.isBeforeFirst())throw new SQLException();

            if(reSet.next())
                resultado = new AbilityModel(reSet.getString(1),reSet.getString(2));

        }catch(SQLException e){
            System.out.println("El dato ingresado no existe:"+id);
        }catch(Exception e){
            e.printStackTrace();
        }

        return resultado;
    }

    public List<AbilityModel> getAbilityAll(){
        sentencia = null; reSet = null; resultado = null;
        List<AbilityModel> listado = new ArrayList<>();

        try(Connection con = getConnection()){
            sentencia = con.prepareStatement("call consulta_habilidad_all()");
            reSet = sentencia.executeQuery();

            while(reSet.next()){
                listado.add(new AbilityModel(reSet.getString(1),reSet.getString(2)));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return listado;
    }

    public boolean updateAbility(AbilityModel habilidad){
        sentencia = null; reSet = null;

        if(!validar.validarNumero(habilidad.getId()))return false;
        if(!validar.validarCadena(habilidad.getName()))return false;

        try(Connection con = getConnection()){
            sentencia = con.prepareStatement("call modifica_habilidades(?,?)");
            sentencia.setString(1,habilidad.getId());
            sentencia.setString(2, habilidad.getName());
            reSet = sentencia.executeQuery();

        }catch(SQLException e){
            System.out.println("Revisa el dato ingresado");
            return false;
        }
        return true;
    }

    public boolean deleteAbility(String id){
        sentencia = null; reSet = null;

        try(Connection con = getConnection()){
            sentencia = con.prepareStatement("call borrar_habilidades(?)");
            sentencia.setString(1,id);
            reSet = sentencia.executeQuery();



        }catch(SQLException e){
            return false;
        }
        return true;
    }
}
