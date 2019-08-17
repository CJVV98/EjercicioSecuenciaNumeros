/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.ejerciciosecuencia;


/**
 *
 * @author Corin Viracacha
 */
public class SecuenciaNumeros {
    private short[] numeros;
    private short contador;
    private String faltantes;

    public SecuenciaNumeros(String[] datosNumericos) {
        numeros=new short[datosNumericos.length];
        for(int i=0;i<datosNumericos.length;i++){  
               numeros[i]=Short.parseShort(datosNumericos[i]);                                   
        }
        ordenarNumeros();
        identificarFaltantes();
        imprimirfaltantes();
        
    }
  
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

    private void identificarFaltantes() { 
        faltantes="Rpt: ";
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

    private void imprimirfaltantes() {
        String red="\033[31m";
        System.out.println(red+"Los numeros faltantes de la secuencia son: ");
        System.out.println(faltantes);

    
    }
    
    
    
}
