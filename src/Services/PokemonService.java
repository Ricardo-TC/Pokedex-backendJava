package Services;

import Models.AbilityModel;
import Models.MoveModel;
import Models.PokemonModel;
import Models.TypeModel;
import Tools.Herramientas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Tools.DBCon.getConnection;

public class PokemonService {

    private PreparedStatement sentencia;
    private ResultSet reSet;
    private Herramientas validar = new Herramientas();

    public boolean createPokemon(PokemonModel poke){
        //agregarEl poke
        sentencia = null; reSet = null;

        if(!validar.validarNumero(poke.getId()))return false;
        if(!validar.validarCadena(poke.getName()))return false;
        if(!validar.validarNumero(poke.getHeight()))return false;
        if(!validar.validarNumero(poke.getWeight()))return false;
        if(!validar.validarNumero(poke.getExp()))return false;

        try(Connection con = getConnection()){
            sentencia = con.prepareStatement("call alta_pokemon(?,?,?,?,?)");
            sentencia.setString(1,poke.getId());
            sentencia.setString(2,poke.getName());
            sentencia.setString(3,poke.getHeight());
            sentencia.setString(4,poke.getWeight());
            sentencia.setString(5,poke.getExp());
            reSet = sentencia.executeQuery();

            for(AbilityModel habilidad : poke.getHabilidades() ){

                //invocar alta_habilidades_pokemon(poke.id, habilidad.id,0,1)
                sentencia = con.prepareStatement("call alta_habilidades_pokemon(?,?,?,?)");
                sentencia.setString(1,poke.getId());
                sentencia.setString(2,habilidad.getId());
                sentencia.setString(3,"0");
                sentencia.setString(4,"1");
                System.out.println(sentencia.toString());
                reSet = sentencia.executeQuery();
            }
            for(MoveModel movimiento : poke.getMovimientos()){

                sentencia = con.prepareStatement("call alta_movimientos_pokemon(?,?,?,?,?)");
                sentencia.setString(1,poke.getId());
                sentencia.setString(2,"1");
                sentencia.setString(3,movimiento.getId());
                sentencia.setString(4,"2");
                sentencia.setString(5,"0");
                reSet = sentencia.executeQuery();
            }
            for(TypeModel tipo : poke.getTipos()){

                sentencia = con.prepareStatement("call alta_tipos_pokemon(?,?,?)");
                sentencia.setString(1, poke.getId());
                sentencia.setString(2, tipo.getId());
                sentencia.setString(3,"5");
                reSet = sentencia.executeQuery();
            }

        }catch(SQLException e){
            System.out.println("Error servicio"+e.toString());
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
