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
        this.datosUtiles = this.vector[0];
        setVector(this.vectorEnChar);
        setDatosUtiles(this.vector);
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
    
    public int getGrado(){
        return this.vector[0];
    }
    
    public void setVector (char[] vectorEnChar){
        int j = 1;
        String numeroNegativo;
        //Esta bandera valida que se ejecute una unica vez al primer if en caso
        //de que el primer caracter sea una X positiva.
        boolean bandera = true;
        for (int i = 0; i < vectorEnChar.length; i++) {
            if(vectorEnChar[0] == 'X' && (vectorEnChar[1] == '^' ||
                    vectorEnChar[1] == '+' || vectorEnChar[1] == '-') &&
                    bandera){
                this.vector[j] = 1;
                bandera = false;
                j++;
            }else if(vectorEnChar[i] == '-'){
                if(vectorEnChar[i+1] == 'X'){
                    this.vector[j] = -1;
                    j++;
                }else{
                    numeroNegativo = "";
                    numeroNegativo += vectorEnChar[i];
                    numeroNegativo += vectorEnChar[i+1];
                    vector[j] = Integer.parseInt(numeroNegativo);
                    j++;
                }
            }else if(vectorEnChar[i] == '+'){
                if(vectorEnChar[i+1] == 'X'){
                    vector[j] = 1;
                    j++;
                }else{
                    vector[j] = Character.getNumericValue(vectorEnChar[i+1]);
                    j++;
                }
            }
        }
    }
    
    public int[] getVector(){
        return this.vector;
    }
    
    public void setDatosUtiles(int vector[]){
        this.datosUtiles = vector[0] + 1;
    }
    
    public int getDatosUtiles(){
        return this.datosUtiles;
    }
}
