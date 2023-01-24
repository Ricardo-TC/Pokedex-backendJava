package Tools;

import Controllers.TypeController;
import Models.TypeModel;

import java.sql.SQLException;
import java.util.List;

public class Prueba {
    public static void main(String[] args) throws SQLException {
        TypeController controller = new TypeController();
        Herramientas lectura = new Herramientas();
        int opcion=0,subopcion=0,id=0,dmgid=0;
        String name="";

        try{
            do{
                System.out.println("-----MENU DE OPCIONES TIPOS DE POKEMON-----");
                System.out.println("1. Insertar nuevo tipo.\n2. Consultar tipo.\n3. Actualizar tipo.\n4. Borrar tipo.\n5. Salir.\nPor favor ingrese una opcion.");
                opcion = Integer.parseInt(lectura.leerConsola());
                switch (opcion){
                    case 1://insertar
                        System.out.println("Por favor introduzca nueva ID.");
                        id=Integer.parseInt(lectura.leerConsola());
                        System.out.println("Por favor introduzca nuevo nombre.");
                        name= lectura.leerConsola();
                        System.out.println("Por favor introduzca id del daño");
                        dmgid=Integer.parseInt(lectura.leerConsola());
                        controller.createType(id,name,dmgid);
                        break;
                    case 2://consultar
                        System.out.println("##-Submenu-##");
                        System.out.println("1. Consultar por ID.\n2. consultar todos.");
                        subopcion = Integer.parseInt(lectura.leerConsola());
                        switch (subopcion) {
                            case 1 -> {//consulta por id
                                System.out.println("Por favor introduzca id a consultar");
                                id = Integer.parseInt(lectura.leerConsola());
                                System.out.println(controller.getType(id).toString());
                                //controller=null;
                            }
                            case 2 -> {//consulta todos
                                List<TypeModel> lista = controller.getAll();
                                for (TypeModel typeModel : lista) {
                                    System.out.println(typeModel.toString());
                                }
                            }
                            default -> System.out.println("Opcion no valida");
                        }
                        break;
                    case 3://actualizar tipo
                        System.out.println("Por favor introduzca ID a modificar.");
                        id=Integer.parseInt(lectura.leerConsola());
                        System.out.println("Por favor introduzca nuevo nombre.");
                        name= lectura.leerConsola();
                        System.out.println("Por favor introduzca id del daño");
                        dmgid=Integer.parseInt(lectura.leerConsola());
                        controller.updateType(id,name,dmgid);
                        break;
                    case 4://borrar tipo
                        System.out.println("Por favor introduzca id a eliminar");
                        id=Integer.parseInt(lectura.leerConsola());
                        controller.deleteType(id);
                        break;
                    case 5:
                        System.out.println("Saliendo del sistema.");
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                        break;
                }
            }while(opcion!=5);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
