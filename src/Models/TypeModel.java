package Models;

public class TypeModel {

    private int id;
    private String nombre;
    private int dmgID;

    public TypeModel(){}

    public TypeModel(int id, String nombre, int dmgID) {
        this.id = id;
        this.nombre = nombre;
        this.dmgID = dmgID;
    }

    @Override
    public String toString() {
        return "TypeModel{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", dmgID=" + dmgID +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDmgID() {
        return dmgID;
    }

    public void setDmgID(int dmgID) {
        this.dmgID = dmgID;
    }
}
