/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.ejerciciosecuencia;


/**
 *
 * @author Corin Viracacha
 * Clase encargada de organizar y definir que elementos hacen falta de la secuencia 
 */
public class SecuenciaNumeros {
    /**
     * El vector numeros almacena los numeros, segun la conversion de string a short
     * la variable contador me permite identificar que numeros estan repetidos
     */
    private final short[] numeros;
    private String faltantes;

 /**
  * Este metodo se encarga de la conversion del vector string al vector short
  * @param datosNumericos, parametro que recibe los numeros en un vector pero de tipo string
  */
    public SecuenciaNumeros(String[] datosNumericos) {
        numeros=new short[datosNumericos.length];
        for(int i=0;i<datosNumericos.length;i++){  
               numeros[i]=Short.parseShort(datosNumericos[i]);                                   
        }
        ordenarNumeros();
        identificarFaltantes();
        imprimirFaltantes();
        
    }
  
/**
  * Este metodo organiza los numeros de manera ascendente
*/
    private void ordenarNumeros() {
        short auxiliar;
        for(int i=0;i<numeros.length;i++){
            for(int j=0;j<numeros.length;j++){
                if(numeros[j]>numeros[i]){
                    auxiliar=numeros[j];
                    numeros[j]=numeros[i];
                    numeros[i]=auxiliar;
                }
            }
        }
    }
    
/**
 * Metodo que se encarga de identificar los faltantes
 */
    private void identificarFaltantes() { 
        faltantes="Rpt: ";
        short contador;
        for (short i = numeros[0]; i <=numeros[numeros.length-1]; i++) {
            contador=0;
            for(short numero:numeros){
                if(i==numero){
                    contador++;
                }
            }
            if(contador==0){               
                faltantes=faltantes.concat(" / "+String.valueOf(i));                
            }            
        }
        
    }
/**
 * Metodo encargado de imprimir los numeros faltantes de la secuencia
 */
    private void imprimirFaltantes() {
        String red="\033[31m";
        System.out.println(red+"Los numeros faltantes de la secuencia son: ");
        System.out.println(faltantes);

    
    }
    
    
    
}
