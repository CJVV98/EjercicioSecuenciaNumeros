/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.ejerciciosecuencia;
import java.util.Scanner;


/**
 *
 * @author Corin Viracacha
 * Clase encargada de solicitar la secuencia, organizar los numeros y definir que elementos hacen falta dentro de la secuencia
 */
public class SecuenciaNumeros {
    /**
     * El vector numeros almacena los numeros, segun la conversion de string a short
     * la variable contador me permite identificar que numeros estan repetidos
     */
    private short[] numeros;
    private String faltantes;

    /**
     * Constructor de la clase, llamada al metodo llenarVector
     */
    
    public SecuenciaNumeros() {
       llenarVector();       
    }
    
    /**
     * Metodo encargado de solicitar los numeros y guardar la informacion en un vector de tipo string
     */
    private void llenarVector() {
        String numerosIngresados[];
        char continuar='s';
        String numero;
        String secuencia="";
        Scanner ingreso=new Scanner(System.in);       
        while(continuar=='s'){
            System.out.println("Ingrese el número:");
            numero=ingreso.next();
            numero=numero.concat("/");
            secuencia=secuencia.concat(numero);
            System.out.println("Desea registrar mas numeros s/n");
            continuar=ingreso.next().charAt(0);    
        }
        numerosIngresados=secuencia.split("/");   
        conversionNumeros(numerosIngresados);
    }  
    
    /**
     * Este metodo se encarga de la conversion del vector string al vector short
     * @param datosNumericos, parametro que recibe los numeros en un vector tipo string
     */
    private void conversionNumeros(String[] datosNumericos){
        numeros=new short[datosNumericos.length];
        for(int i=0;i<datosNumericos.length;i++){  
               numeros[i]=Short.parseShort(datosNumericos[i]);                                   
        }
        ordenarNumeros();
        identificarFaltantes();
        imprimirFaltantes();
    }

    /**
     * Este metodo organiza los numeros de manera ascendente, por el metodo burbuja
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
     * Metodo que se encarga de identificar los faltantes de la secuencia
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
