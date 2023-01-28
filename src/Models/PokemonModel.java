package Models;

import Models.AbilityModel.*;
import Models.MoveModel.*;
import Models.TypeModel.*;

import java.util.List;

public class PokemonModel {
    private String id;
    private String name;
    private String height;
    private String weight;
    private String exp;
    private List<AbilityModel> habilidades;
    private List<MoveModel> movimientos;
    private List<TypeModel> tipos;

    public PokemonModel(){}

    public PokemonModel(String id, String name, String height, String weight, String exp, List<AbilityModel> habilidades, List<MoveModel> movimientos, List<TypeModel> tipos) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.exp = exp;
        this.habilidades = habilidades;
        this.movimientos = movimientos;
        this.tipos = tipos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public List<AbilityModel> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<AbilityModel> habilidades) {
        this.habilidades = habilidades;
    }

    public List<MoveModel> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<MoveModel> movimientos) {
        this.movimientos = movimientos;
    }

    public List<TypeModel> getTipos() {
        return tipos;
    }

    public void setTipos(List<TypeModel> tipos) {
        this.tipos = tipos;
    }

    @Override
    public String toString() {
        return "PokemonModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", exp='" + exp + '\'' +
                ", habilidades=" + habilidades +
                ", movimientos=" + movimientos +
                ", tipos=" + tipos +
                '}';
    }
}
