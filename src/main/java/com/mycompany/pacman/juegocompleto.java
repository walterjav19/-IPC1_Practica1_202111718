/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pacman;

import java.util.Scanner;

/**
 *
 * @author walte
 */
public class juegocompleto {
    
    //datos para el historial e info arriba del tablero
    String nombre;
    String nombres[] = new String[10];
    int punto;
    int puntos[] = new int[10];
    int vidas=3;
    int partidas = 0;

    //datos para el tablero
    int premios,paredes,trampas,x,y;
    
    
    //tablero y movimiento
    public String tablerog[][] = new String[10][10];
    public String tablerop[][] = new String[6][5];
    String marcop[][]=new String[5][6];
    String marcog[][]=new String[10][10];
    String tamaño,tamañon;
 
   
     //lector de datos
   Scanner teclado= new Scanner(System.in);
    
    public void inicio(){
        
        
        int n;
        
        
        do{
        System.out.println("===MENÚ DE INICIO===");
        System.out.println("1. Iniciar Juego");
        System.out.println("2. Historial de partidas");
        System.out.println("3. Salir");
        System.out.println("Ingrese la opcion");
        n=teclado.nextInt();
            switch (n) 
        {
            case 1:  
            juego();
            break;
            case 2:  
            System.out.println("=======HISTORIAL DE PARTIDAS=======");
            
            System.out.print("No.");
                    System.out.print("\tUSUARIO");
                    System.out.println("\tPUNTEO");
                    for (int i = 0; i < nombres.length; i++) {
                        if (nombres[i] != null) {// si detecta el almacenamiento de la variable se imprime
                            System.out.print(i+1);
                            System.out.print("\t" + nombres[i]);
                            System.out.print("\t" + puntos[i]);
                            System.out.println("");
                        }else{
                            break;
                        }
                    }
            
            break;
            case 3:
            System.exit(0);
            break;
            default:
            System.out.println("elija una opcion entre 1-3");    
        }  
        }while(n!=3);
            
        
    }
    
    
    public void historialfp() {

        partidas = partidas + 1;

        if (partidas == 1) {
            nombres[0] = nombre;
            puntos[0] = punto;
        } else {
            for (int i = 0; i < nombres.length; i++) {
                if (nombres[i] == null) {//el arreglo en un inicio no debe tener almacenado un nombre debe estar vacia o null " "
                    nombres[i] = nombre;
                    puntos[i] = punto;
                    break;
                }
            }
        }
    }
    
    
    
    public void juego(){
        
        
        System.out.println("Ingrese su nombre:");
        nombre=teclado.next();
        System.out.println("=======INGRESE DIMENSIONES DEL TABLERO=======");
        System.out.println("por favor ingrese los siguientes valores:");
        
      
            do{
                 System.out.println("TABLERO[p-g]:");
                 tamaño=teclado.nextLine();
                 tamañon=tamaño.toLowerCase();
                 if(!(tamañon.equals("g") || tamañon.equals("p"))){
                     System.out.println("Ingrese valores p o g(pequeño o grande)");
                 } 
            }while (!(tamañon.equals("g") || tamañon.equals("p")));
        
      
            
       
       switch(tamaño.toLowerCase()){
            case "g":
                System.out.println("---TABLERO GRANDE---");
                tablerogrande();
            break; 
            case "p":
                System.out.println("---TABLERO PEQUEÑO---");
                tableropequenio();
            break; 
        }
        
        
       
        
    }
    
    
    public void Tableros() {

        if (tamañon.equalsIgnoreCase("p")) { 
            System.out.println("Usuario: " + nombre );
            System.out.println("Punteo: " + punto );
            System.out.println("Vidas: " + vidas );
             
            for (int i = 0; i < marcop.length; i++) {
                System.out.print("|");
                for (int j = 0; j < marcop[0].length; j++) {

                    System.out.printf("%2s", marcop[i][j]);

                }
                System.out.print("|");
                System.out.println("");
            }
            System.out.println("-------------");
        } else {     
            

        }

    }
    
     
    
   
    
    public void tablerogrande(){
        //premios 40% =100*40% paredes y trampas 20%=100*20%
     do{
           System.out.println("PREMIOS[1-40]:");
           premios=teclado.nextInt(); 
           if(premios>40){
            System.out.println("Ingrese un numero de premios entre el rango 1-40");
        }
        }while(premios>40);
     
        
       do{
           System.out.println("PAREDES[1-20]:");
        paredes=teclado.nextInt();
        if(paredes>20){
            System.out.println("Ingrese un numero de paredes entre el rango 1-20");
        }
       }while(paredes>20);
        
        
        do{
        System.out.println("TRAMPAS[1-20]:");
        trampas=teclado.nextInt();
        if(trampas>20){
            System.out.println("Ingrese un numero de trampas entre el rango 1-20");
        }
        }while(trampas>20);
        
        
        System.out.println("===Ingrese posicion Inicial===");
    
    do{
        System.out.println("Ingrese Columna:");
        x=teclado.nextInt();
        if(x>10){
            System.out.println("Ingrese una fila del 1 al 10");
        }
        }while(x>10);
    
    
    do{
        System.out.println("Ingrese fila:");
        y=teclado.nextInt();
        if(y>10){
            System.out.println("Ingrese una fila del 1 al 10");
        }
        }while(y>10);
        
       for (int i = 0; i < marcog.length; i++) {
                for (int j = 0; j < marcog[0].length; j++) {
                    if (marcog[i][j] == null) {
                        marcog[i][j] = " ";
                    } 
                }
    }
       
       
            System.out.println("Usuario: " + nombre );
            System.out.println("Punteo: " + punto );
            System.out.println("Vidas: " + vidas );
            System.out.println("----------------------");
            for (int i = 0; i < marcog.length; i++) {
                System.out.print("|");
                for (int j = 0; j < marcog[0].length; j++) {

                    System.out.printf("%2s",marcog[i][j]);

                }
                System.out.print("|");
                System.out.println("");
            }
            System.out.println("----------------------");
 
       
       
       
      historialfp();  
    }
    
    
    
    
            
    
    public  void tableropequenio(){
        //premios 40% =30*40% paredes y trampas 20%=30*20% 30 es el numero de espacios del tab
        
     do{
           System.out.println("PREMIOS[1-12]:");
           premios=teclado.nextInt(); 
           if(premios>12){
            System.out.println("Ingrese un numero de premios entre el rango 1-12");
        }
        }while(premios>12);
     
        
       do{
           System.out.println("PAREDES[1-6]:");
        paredes=teclado.nextInt();
        if(paredes>6){
            System.out.println("Ingrese un numero de paredes entre el rango 1-6");
        }
       }while(paredes>6);
        
        
        do{
        System.out.println("TRAMPAS[1-6]:");
        trampas=teclado.nextInt();
        if(trampas>6){
            System.out.println("Ingrese un numero de trampas entre el rango 1-6");
        }
        }while(trampas>6);    
    
 
    
    
    System.out.println("===Ingrese posicion Inicial===");
    
    do{
        System.out.println("Ingrese Columna:");
        x=teclado.nextInt();
        if(trampas>6){
        System.out.println("Ingrese una fila del 1 al 6");
        }
        }while(trampas>6);
    
    
    do{
        System.out.println("Ingrese fila:");
        y=teclado.nextInt();
        if(trampas>5){
            System.out.println("Ingrese una fila del 1 al 5");
        }
        }while(trampas>5);
    
     
    for (int i = 0; i < marcop.length; i++) {
                for (int j = 0; j < marcop[0].length; j++) {
                    if (marcop[i][j] == null) {
                        marcop[i][j] = " ";
                    } 
                }
    }
       
       
            System.out.println("Usuario: " + nombre );
            System.out.println("Punteo: " + punto );
            System.out.println("Vidas: " + vidas );
            System.out.println("--------------");
            for (int i = 0; i < marcop.length; i++) {
                System.out.print("|");
                for (int j = 0; j < marcop[0].length; j++) {

                    System.out.printf("%2s",marcop[i][j]);

                }
                System.out.print("|");
                System.out.println("");
            }
            System.out.println("--------------");

    historialfp();
    }
}
