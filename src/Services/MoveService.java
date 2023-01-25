package Services;

import Models.MoveModel;
import Tools.Herramientas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Tools.DBCon.getConnection;

public class MoveService {

    private PreparedStatement sentencia;
    private ResultSet reSet;
    private MoveModel resultado;
    private Herramientas validar = new Herramientas();

    public boolean CreateMove(MoveModel movimiento){
        sentencia=null;reSet=null;resultado=null;

        //if(!validar.validarNumero(movimiento.getId()))return false;
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
}
