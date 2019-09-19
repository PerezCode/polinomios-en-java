package polinomios;

import java.util.Scanner;

public class Polinomios {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        String polinomioEnString1 = "-5x^5+x^2+x-3";
        String polinomioEnString2 = "x^3";
        Polinomio myPolinomio1 = new Polinomio(polinomioEnString1);
        Polinomio myPolinomio2 = new Polinomio(polinomioEnString2);
        int array1[] = myPolinomio1.getVector();
        int array2[] = myPolinomio2.getVector();
        //Mostrando el vector con el grado y los coeficientes.
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }
        System.out.println("Du-> " + myPolinomio1.getDatosUtiles());
        System.out.println();
        
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + " ");
        }
        System.out.println("Du-> " + myPolinomio2.getDatosUtiles());
    }
}