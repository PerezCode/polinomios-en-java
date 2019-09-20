package polinomios;

import java.util.Scanner;

/**
 *
 * @author david
 */
public class Polinomio {
    private char vectorEnChar[];
    private int datosUtiles;
    private int vector[];

    public Polinomio(String PoliEnString) {
        this.vector = new int[10];
        String polinomioEnString = buildString(PoliEnString);
        this.vectorEnChar = polinomioEnString.toCharArray();
        setGrado(this.vectorEnChar);
        setDatosUtiles();
        setVector(this.vectorEnChar);
    }
    
    public String buildString(String polinomio){
        String polinomioListo = " ";
        polinomioListo += polinomio;
        polinomioListo += " ";
        polinomioListo = polinomioListo.toUpperCase();
        return polinomioListo;
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
        boolean bandera1 = true;
        boolean bandera2 = true;
        for (int i = 0; i < vectorEnChar.length; i++) {
            if(vectorEnChar[1] == 'X' && (vectorEnChar[2] == '^' ||
                    vectorEnChar[2] == '+' || vectorEnChar[2] == '-') &&
                    bandera1){
                if(vectorEnChar[2] == '^'){
                   this.vector[this.datosUtiles-(Character.getNumericValue(vectorEnChar[3]))] = 1; 
                   bandera1 = false;
                   j++;
                }else{}
                //this.vector[j] = 1;
                
            }else if(vectorEnChar[i] == '-'){
                if(vectorEnChar[i+1] == 'X' && vectorEnChar[i+2] == '^'){
                    this.vector[this.datosUtiles-(Character.getNumericValue(vectorEnChar[i+3]))] = -1;
                    j++;
                }else if(vectorEnChar[i+1] != 'X' && vectorEnChar[i+2] == 'X'){
                    numeroNegativo = "";
                    numeroNegativo += vectorEnChar[i];
                    numeroNegativo += vectorEnChar[i+1];
                    vector[this.datosUtiles-(Character.getNumericValue(vectorEnChar[i+4]))] = Integer.parseInt(numeroNegativo);
                }
                else{
                    numeroNegativo = "";
                    numeroNegativo += vectorEnChar[i];
                    numeroNegativo += vectorEnChar[i+1];
                    vector[this.datosUtiles] = Integer.parseInt(numeroNegativo);
                    j++;
                }
            }else if(vectorEnChar[i] == '+'){
                if(vectorEnChar[i+1] == 'X' && vectorEnChar[i+2] == '^'){
                    vector[this.datosUtiles-(Character.getNumericValue(vectorEnChar[i+3]))] = 1;
                    j++;
                }else if(vectorEnChar[i+1] == 'X' && vectorEnChar[i+2] != '^'){
                    vector[this.datosUtiles - 1] = 1;
                    j++;
                }else if(vectorEnChar[i+2] != 'X'){
                    vector[this.datosUtiles] = Character.getNumericValue(vectorEnChar[i+1]);
                }
            }else if(vectorEnChar[0] == ' ' && (vectorEnChar[1] != '-' && 
                    vectorEnChar[1] != 'X') && bandera2){
                if(vectorEnChar[3] == '^'){
                    vector[this.datosUtiles - (Character.getNumericValue(vectorEnChar[4]))] = Character.getNumericValue(vectorEnChar[1]);
                }else{
                 vector[this.datosUtiles-1] = Character.getNumericValue(vectorEnChar[1]);   
                }
                j++;
                bandera2 = false;
            }
        }
    }
    
    public int[] getVector(){
        return this.vector;
    }
    
    public void setDatosUtiles(){
        this.datosUtiles = this.vector[0] + 1;
    }
    
    public int getDatosUtiles(){
        return this.datosUtiles;
    }
	
    public void setEvaluar(){
        Scanner teclado = new Scanner(System.in);
        int expo;
        int evaluar;
        int h = 0;
        int m = 0;
        int resultado[] = new int [5];
        System.out.println("------------------------------------------");
        System.out.print("Ingrese el valor con que va a evaluar: ");
        evaluar = teclado.nextInt();
        for (int i = 1; i < this.datosUtiles; i++) {
            if (vector[i] != 0) {
                expo = this.datosUtiles - i;
                if(expo != 0){
                    resultado[h] = (int) Math.pow(evaluar, expo);
                    h++;
                }
            }
        }
      
        for (int i = 1; i < this.datosUtiles+1; i++) {
            if (vector[i] != 0) {
                expo = this.datosUtiles - i;
                if (expo != 0) {
                    resultado[m] = resultado[m] * vector[i];
                    m++;
                }else if (expo == 0 && vector[i] != 0){
                    resultado[m] = vector[i];
                }
            }
        }
        
        for (int i = 1; i <= h; i++) {
            if(resultado[m] < 0){
                resultado[0] += resultado[i]; 
            }else if(resultado[m] > 0 ){
                resultado[0] -= resultado[i];
            }                
        }
        System.out.println("El polinomio evaluado con el numero "+evaluar+" dio como resultado: "+resultado[0]); 
    }

        
    public void ingresartermino(){

            Scanner ingresar=new Scanner(System.in);

            int coe;
            int expo;
            System.out.println("Digite el coeficiente que desea ingresar");
            coe=ingresar.nextInt();

            System.out.println("Digite el exponente");
            expo=ingresar.nextInt();

        for (int i = 1; i < datosUtiles+1; i++) {
            int pos=datosUtiles-i;
            if(pos==expo){
                vector[i]+=coe;
            }
        } 
        for (int i = 0; i < 10; i++) {
            System.out.print(vector[i]+ " " );
        }   
    }
}
