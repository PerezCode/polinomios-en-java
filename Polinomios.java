package polinomios;

import java.util.Scanner;

public class Polinomios {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        String polinomioEnString1 = "5x^5+x^8+x-3";
        String polinomioEnString2 = "x^3+x+8";
        
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
        System.out.println("Evaluar el polinomio 1");
        myPolinomio1.setEvaluar();
        System.out.println("------------------------------------------");
        myPolinomio1.ingresartermino();
        
        /*
        System.out.println("buscar en el polinomio 1");
        myPolinomio1.setBuscar();
        System.out.println("------------------------------------------");
        System.out.println("Evaluar el polinomio 2");
        myPolinomio2.setEvaluar();
        System.out.println("------------------------------------------");
        System.out.println("buscar en el polinomio 2");
        myPolinomio2.setBuscar(); */       
    }
    
}