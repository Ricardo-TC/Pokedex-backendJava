package Models;

public class TypeModel {

    private String id;
    private String nombre;
    private String dmgID;

    public TypeModel(String id, String nombre, String dmgID) {
        this.id = id;
        this.nombre = nombre;
        this.dmgID = dmgID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDmgID() {
        return dmgID;
    }

    public void setDmgID(String dmgID) {
        this.dmgID = dmgID;
    }

    @Override
    public String toString() {
        return "TypeModel{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", dmgID='" + dmgID + '\'' +
                '}';
    }
}
