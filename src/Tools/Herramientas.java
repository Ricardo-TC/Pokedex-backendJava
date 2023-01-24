package Tools;

import java.util.Scanner;

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
}
