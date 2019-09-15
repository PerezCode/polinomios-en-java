/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polinomios;

/**
 *
 * @author david
 */
public class Polinomio {
    private char vectorEnChar[] = new char[20];
    private int datosUtiles;
    private int vector[] = new int[10];
    

    public Polinomio(String vectorEnString) {
        this.vectorEnChar = vectorEnString.toCharArray();
        buildVector(this.vectorEnChar);
    }
    
    public void buildVector(char[] vectorEnChar) {
        //Aqui se va a armar el vector con los coeficientes
        
        //Encontrando grado mayor
        char exponente = '0';
        for (int i = 0; i < vectorEnChar.length; i++) {
            if(vectorEnChar[i] == '^'){
                if(vectorEnChar[i+1] > exponente){
                    exponente = vectorEnChar[i+1];
                }
            }   
        }
        this.vector[0] = Character.getNumericValue(exponente);
    }
    
    public int[] getVector(){
        return this.vector;
    }
}
