package Services;

import Models.AbilityModel;
import Models.MoveModel;
import Models.PokemonModel;
import Models.TypeModel;
import Tools.Herramientas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static Tools.DBCon.getConnection;

public class PokemonService {

    private PreparedStatement sentencia;
    private ResultSet reSet;
    private PokemonModel resultado;
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

    public List<PokemonModel> getPokemonAll(){
        sentencia = null;reSet = null;

        List<PokemonModel> listado = new ArrayList<>();

        try(Connection con = getConnection()){
            sentencia = con.prepareStatement("call consulta_pokemon_tma_all()");
            reSet = sentencia.executeQuery();

            while (reSet.next()){
                listado.add(new PokemonModel(reSet.getString(1),reSet.getString(2),reSet.getString(3),reSet.getString(4),reSet.getString(5),reSet.getString(6),reSet.getString(7)));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return listado;
    }

    public PokemonModel getPokemonID(String id){
        sentencia = null; reSet = null; resultado = null;
        List<AbilityModel> listaGetAbility = new ArrayList<>();
        List<MoveModel>listaGetMove = new ArrayList<>();
        List<TypeModel>listaGetType = new ArrayList<>();

        try(Connection con = getConnection()){
            if(!validar.validarNumero(id))throw new Exception();

            CallableStatement callSentencia = con.prepareCall("call consulta_pokemon_tma_ID(?)");
            callSentencia.setString(1,id);
            //boolean hasData = callSentencia.execute();
            reSet = callSentencia.executeQuery();

            //if(!reSet.isBeforeFirst())throw new SQLException();
            //reSet = callSentencia.getResultSet();

            String pID="";
            String pName="";
            String pAlto="";
            String pPeso="";
            String pExp="";
            if(reSet.next()){
                pID = reSet.getString(1);
                pName = reSet.getString(2);
                pAlto = reSet.getString(3);
                pPeso = reSet.getString(4);
                pExp = reSet.getString(5);

            }
            if (!callSentencia.getMoreResults()) {
                System.out.println("Algo ha fallado. Debería haber                        habido otro ResultSet, hay que salir.");
                        System.exit(0);
            }
            reSet = callSentencia.getResultSet();
            while(reSet.next()){
                listaGetAbility.add(new AbilityModel(reSet.getString(1), reSet.getString(2)));
            }
            if (!callSentencia.getMoreResults()) {
                System.out.println("Algo ha fallado. Debería haber                        habido otro ResultSet, hay que salir.");
                System.exit(0);
            }
            reSet = callSentencia.getResultSet();
            while(reSet.next()){
                listaGetMove.add(new MoveModel(reSet.getString(1),reSet.getString(2),reSet.getString(3),reSet.getString(4),reSet.getString(5),reSet.getString(6)));
            }
            if (!callSentencia.getMoreResults()) {
                System.out.println("Algo ha fallado. Debería haber                        habido otro ResultSet, hay que salir.");
                System.exit(0);
            }
            reSet = callSentencia.getResultSet();
            while(reSet.next()){
                listaGetType.add(new TypeModel(reSet.getString(1),reSet.getString(2),reSet.getString(3)));
            }

            resultado = new PokemonModel(pID,pName,pAlto,pPeso,pExp,listaGetAbility,listaGetMove,listaGetType);


        }catch(SQLException e){
            System.out.println("Favor de revisar id: "+id);
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }

}
