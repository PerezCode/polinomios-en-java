package polinomios;

/**
 *
 * @author David P, Juan M, Emanuel V, Daniel.
 */
public class Polinomio {
    private char vectorEnChar[];
    private int datosUtiles;
    private int vector[];
    private int expo[];
    private int[] uExpo = new int [5];

    public Polinomio(String PoliEnString) {
        this.vector = new int[10];
        String polinomioEnString = buildString(PoliEnString);
        this.vectorEnChar = polinomioEnString.toCharArray();
        setGrado(this.vectorEnChar);
        setVector(this.vectorEnChar);
        setDatosUtiles();
        ajustarDU();
        cVector();
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
                vectorEnChar[2] == '+' || vectorEnChar[2] == '-') 
                && bandera1){
                this.vector[j] = 1;
                bandera1 = false;
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
            }else if(vectorEnChar[0] == ' ' && (vectorEnChar[1] != '-' && 
                    vectorEnChar[1] != 'X') && bandera2){
                vector[j] = Character.getNumericValue(vectorEnChar[1]);
                j++;
                bandera2 = false;
            }
        }
    }
    
    public int[] getVector(){
        return this.vector;
    }
    
    public void setDatosUtiles(){
        this.datosUtiles = this.vector[0] + 2;
    }
    
    public int getDatosUtiles(){
        return this.datosUtiles;
    }
    
    public void ajustarDU(){
        int contador = 0;
        for (int i = 0; i < this.datosUtiles; i++) {
            if(this.vector[i] == 0){
                contador++;
            }
        }
        this.datosUtiles = (this.datosUtiles - contador);
    }
    
    public void cVector(){
        int h = 0;
        //Capturo del Char las posiciones donde hay un exponente
        for (int i = 0; i < vectorEnChar.length; i++) {
            if(vectorEnChar[i] == '^'){
                //Almaceno en uExpo la la ubicacion
                uExpo[h] = i+1;
                h++;
            }
        }
        
        //Compruebo cuales son los exponentes con este ciclo
        /*for (int i = 0; i <= h-1; i++) {
            System.out.println(vectorEnChar[uExpo[i]]);
        }*/

        
    }      
}

/**
 * Esta lista es para tener control de que falta hacer y que recomendaciones hay por si alguno 
 * desea avanzar en el codigo al menos tenga una nocion de como hacerlo
 * segun el estado de avance cambiar los False por un True 
 * Gracias...
 * 
 * 1.Organizar segun el exponente y la poscion los numeros del vector = False
 * 2.Teniendo en cuenta que ya tengo los exponentes puedo hacer el metodo evaluar = False
 * 
 * vector[uExpo[i]] = coefasociado con el expo
 * - Ligar de algun modo el exponente con su posicion 
 * - Luego de tener esto hago un contador que me aumente en una variable y se me le reste al mayor expo + 1.
 * - En este caso, i  = 1; 6 - i = 5...
 * - El resultado va a ser el exponente segun la i (Cuando i sea 1 el exponente sera el 5) y asi sucecivamente. 
 * - Asi organizo todo 
 * 
 * 3.Crear el metodo sumar (Pedir el otro polinomio y crear filtrarlo hasta llevarlo al un vector organizado) = False
 * 4.Crear metodo multiplicar (Pedir el otro polinomio y crear filtrarlo hasta llevarlo al un vector organizado) = False
 */
