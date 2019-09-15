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
    private char vectorEnChar[];
    private int datosUtiles;
    private int vector[];
    

    public Polinomio(String vectorEnString) {
        this.vector = new int[10];
        
        //VectorEnChar toma el tamaño de vectorEnString
        this.vectorEnChar = vectorEnString.toCharArray();
        setGrado(this.vectorEnChar);
    }
    
    public void setGrado(char[] vectorEnChar) {
        
        //Encontrando exponente mayor
        int exponente = 0;
        for (int i = 0; i < vectorEnChar.length; i++) {
            if(vectorEnChar[i] == '^'){
                if(Character.getNumericValue(vectorEnChar[i+1]) > exponente){
                    exponente = Character.getNumericValue(vectorEnChar[i+1]);
                }
            }else if(vectorEnChar[i] == 'X' && vectorEnChar[i+1] == ' '){
                if(1 > exponente){
                    exponente = 1;
                }
                i++;
            }else if(vectorEnChar[i] == ' '){
            }else if(vectorEnChar[i] == '-' || vectorEnChar[i] == '+'){
            }else if(vectorEnChar[i] == 'X' && (vectorEnChar[i+1] == '+' ||
                    vectorEnChar[i+1] == '-')){
                    if(1>exponente){
                        exponente = 1;
                    }
           }
        }
        this.vector[0] = exponente;
    }
    
    public int[] getVector(){
        return this.vector;
    }
}
