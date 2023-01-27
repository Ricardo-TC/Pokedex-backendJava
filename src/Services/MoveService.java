package Services;

import Models.MoveModel;
import Tools.Herramientas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Tools.DBCon.getConnection;

public class MoveService {

    private PreparedStatement sentencia;
    private ResultSet reSet;
    private MoveModel resultado;
    private Herramientas validar = new Herramientas();

    public boolean CreateMove(MoveModel movimiento){
        sentencia=null;reSet=null;

        if(!validar.validarCadena(movimiento.getName())){return false;}
        if(!validar.validarNumero(movimiento.getType_id())){return false;}
        if(!validar.validarNumero(movimiento.getPower())){return false;}
        if(!validar.validarNumero(movimiento.getPp())){return false;}
        if(!validar.validarNumero(movimiento.getAccuracy())){return false;}

        try(Connection con = getConnection()){
            sentencia = con.prepareStatement("call alta_movimiento(?,?,?,?,?)");
            sentencia.setString(1,movimiento.getName());
            sentencia.setInt(2,Integer.parseInt(movimiento.getType_id()));
            sentencia.setInt(3,Integer.parseInt(movimiento.getPower()));
            sentencia.setInt(4,Integer.parseInt(movimiento.getPp()));
            sentencia.setInt(5,Integer.parseInt(movimiento.getAccuracy()));
            sentencia.executeQuery();
        }catch(SQLException e){
            return false;
        }catch(Exception e){
            return false;
        }
        return true;
    }

    public MoveModel getMoveID(String id){
        reSet = null;
        resultado = null;

        try(Connection con = getConnection()){

            sentencia = con.prepareStatement("call consulta_movimiento_id(?)");
            sentencia.setString(1,id);
            reSet = sentencia.executeQuery();

            if(!reSet.isBeforeFirst())throw new SQLException();

            if(reSet.next()){
                resultado = new MoveModel(reSet.getString(1),reSet.getString(2),reSet.getString(3),reSet.getString(4),reSet.getString(5),reSet.getString(6));
            }

        }catch(SQLException e){
            System.out.println("El dato ingresado no existe:"+id);
        }

        return resultado;
    }

    public List<MoveModel> getMoveAll(){
        List<MoveModel> listado = new ArrayList<>();
        sentencia = null;
        reSet = null;

        try(Connection con = getConnection()){
            sentencia = con.prepareStatement("call consulta_movimiento_all()");
            reSet = sentencia.executeQuery();

            while(reSet.next()){
                listado.add(new MoveModel(reSet.getString(1),reSet.getString(2),reSet.getString(3),reSet.getString(4),reSet.getString(5),reSet.getString(6)));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listado;
    }

    public boolean updateMove(MoveModel movimiento){
        reSet = null;sentencia = null;
        resultado = null;

        if(!validar.validarNumero(movimiento.getId()))return false;
        if(!validar.validarCadena(movimiento.getName()))return false;
        if(!validar.validarNumero(movimiento.getType_id()))return false;
        if(!validar.validarNumero(movimiento.getPower()))return false;
        if(!validar.validarNumero(movimiento.getPp()))return false;
        if(!validar.validarNumero(movimiento.getAccuracy()))return false;

        try(Connection con = getConnection()){
            sentencia = con.prepareStatement("call modifica_movimientos(?,?,?,?,?,?)");
            sentencia.setString(1,movimiento.getId());
            sentencia.setString(2,movimiento.getName());
            sentencia.setString(3,movimiento.getType_id());
            sentencia.setString(4,movimiento.getPower());
            sentencia.setString(5,movimiento.getPp());
            sentencia.setString(6,movimiento.getAccuracy());
            reSet = sentencia.executeQuery();
        }catch(SQLException e){
            System.out.println("Revisa el dato ingresado"+movimiento.getId());
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }


        return true;
    }

    public boolean deteleMove(String id){
        sentencia = null; reSet = null;

        try(Connection con = getConnection()){
            sentencia = con.prepareStatement("call borrar_movimientos(?)");
            sentencia.setString(1,id);
            reSet = sentencia.executeQuery();

            //if(!reSet.isBeforeFirst())throw new SQLException();

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
