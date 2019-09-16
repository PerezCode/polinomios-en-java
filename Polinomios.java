package polinomios;

import java.util.Scanner;

public class Polinomios {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        String polinomioEnString = "x-4x^4+2x^3-8x+x^5";
        polinomioEnString += " ";
        polinomioEnString = polinomioEnString.toUpperCase();
        
        Polinomio myPolinomio = new Polinomio(polinomioEnString);
        int array[] = myPolinomio.getVector();
        
        //Mostrando el vector con el grado y los coeficientes.
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println("Du-> " + myPolinomio.getDatosUtiles());
    }
}
