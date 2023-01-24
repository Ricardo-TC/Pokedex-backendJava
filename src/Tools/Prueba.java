package Tools;

import Controllers.TypeController;
import Models.TypeModel;

import java.sql.SQLException;
import java.util.List;

public class Prueba {
    public static void main(String[] args) throws SQLException {
        TypeController controler = new TypeController();
        //System.out.println(controler.getType(3).toString());

        List<TypeModel> lista = controler.getAll();

        for (int i = 0; i <= lista.size()-1; i++) {
            System.out.println(lista.get(i).toString());
        }
    }
}
