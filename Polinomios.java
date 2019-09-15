package polinomios;

import java.util.Scanner;

public class Polinomios {
    public static void main(String[] args) {
        // TODO code application logic here
        String polinomioEnString = "-4X^3+2X-8";
        Scanner entrada = new Scanner(System.in);
        
        Polinomio myPolinomio = new Polinomio(polinomioEnString);
        System.out.println("Exponente mayor: " + myPolinomio.getVector()[0]);
    }
}
