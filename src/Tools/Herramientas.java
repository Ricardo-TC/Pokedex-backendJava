package Tools;

import Models.TypeModel;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Herramientas {

    public Herramientas(){}

    public String leerConsola(){
        String leerDato;
        do {
            Scanner scan = new Scanner(System.in);
            leerDato = scan.nextLine();
            if(leerDato.isBlank()){
                System.out.println("Favor de introducir un dato.");
            }else
                System.out.println();
        }while(leerDato.isBlank());
        return leerDato;
    }

    public boolean validarCadena(@NotNull String cadena){//Validacion de datos
        if(cadena.isEmpty()) {//valida si los datos son nulos o vacios
            System.out.println("No debe estar vacio: "+cadena);
            return false;
        }

        if(!Pattern.matches("[a-zA-Z]+",cadena)) {//valida si la cadena tiene los caracteres adecuados
            System.out.println("Dato invalido: "+cadena);
            return false;
        }

        return true;
    }

    public boolean validarNumero(String numero){
        if(numero==""){
            System.out.println("Se debe ingresar un valor no nulo: "+numero);
            return false;
        }else{
            try{
                Integer.parseInt(numero);
                return true;
            }catch(Exception e) {
                System.out.println("Error:"+numero);
                return false;
            }
        }
    }

}
