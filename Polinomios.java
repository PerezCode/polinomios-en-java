package polinomios;

import java.util.Scanner;

public class Polinomios {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        //String polinomioEnString1 = "5x^5+x^2+x-3";
        String polinomioEnString2 = "x^3+x+8";
        //Polinomio myPolinomio1 = new Polinomio(polinomioEnString1);
        Polinomio myPolinomio2 = new Polinomio(polinomioEnString2);
        
        for (int i = 0; i <= myPolinomio2.getDatosUtiles(); i++) {
            
            System.out.print("| " + myPolinomio2.getVector()[i] +" |");
        }
        
        
    }
}