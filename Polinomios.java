package polinomios;

import java.util.Scanner;

public class Polinomios {
    public static void main(String[] args) {
        String polinomioEnString = "-4x^2+2x^3-8x";
        polinomioEnString += " ";
        String polinomioParaEnviar = polinomioEnString.toUpperCase();
        
        Scanner entrada = new Scanner(System.in);
        
        Polinomio myPolinomio = new Polinomio(polinomioParaEnviar);
        System.out.println("Exponente mayor: " + myPolinomio.getVector()[0]);
    }
}
