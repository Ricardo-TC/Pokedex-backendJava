package Models;

public class MoveModel {

    private String id;
    private String name;
    private String type_id;
    private String power;
    private String pp;
    private String accuracy;

    public MoveModel(){}

    public MoveModel(String name, String type_id, String power, String pp, String accuracy) {
        this.name = name;
        this.type_id = type_id;
        this.power = power;
        this.pp = pp;
        this.accuracy = accuracy;
    }

    public MoveModel(String id, String name, String type_id, String power, String pp, String accuracy) {
        this.id = id;
        this.name = name;
        this.type_id = type_id;
        this.power = power;
        this.pp = pp;
        this.accuracy = accuracy;
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

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getPp() {
        return pp;
    }

    public void setPp(String pp) {
        this.pp = pp;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    @Override
    public String toString() {
        return "MoveModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type_id='" + type_id + '\'' +
                ", power='" + power + '\'' +
                ", pp='" + pp + '\'' +
                ", accuracy='" + accuracy + '\'' +
                '}';
    }
}
