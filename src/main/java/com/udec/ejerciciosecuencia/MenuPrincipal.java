/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.ejerciciosecuencia;
import java.util.Scanner;


/**
 *
 * @author Corin Viracachá
 * Clase principal en esta clase se solicitaran los numeros
 */
public class MenuPrincipal {
    /**
     * La variable ingreso es para la lectura de los datos
     * El variable numeros es un vector que almacena los numeros ingresados
     */
    Scanner ingreso;  
    private String numeros[];
    
    /**
     * Constructor de la clase MenuPrincipal, en este se llama el metodo llenarVector
     */
    public MenuPrincipal(){
        llenarVector();
    }
    /**
     * Metodo para inicializar el programa
     * @param args 
     */
    public static void main(String [] args){
        MenuPrincipal menu=new MenuPrincipal();
    }
    
    /**
     * Metodo encargado de solicitar los numeros y guardar la informacion en un vector de tipo string
     */
    private void llenarVector() {       
        char continuar='s';
        String numero;
        String secuencia="";
        ingreso=new Scanner(System.in);       
        while(continuar=='s'){
            System.out.println("Ingrese el número:");
            numero=ingreso.next();
            numero=numero.concat("/");
            secuencia=secuencia.concat(numero);
            System.out.println("Desea registrar mas numeros s/n");
            continuar=ingreso.next().charAt(0);    
        }
        numeros=secuencia.split("/");
        SecuenciaNumeros claseSecuencia=new SecuenciaNumeros(numeros);                     
    }


    
}
