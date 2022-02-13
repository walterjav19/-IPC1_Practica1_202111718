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
    
    //datos para el historial
    String nombre;
    String nombres[] = new String[10];
    int punto;
    int puntos[] = new int[10];
    int vidas=3;
    int partidas = 0;

    //datos para el tablero
    int premios,paredes,trampas,x,y;
    
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
                        if (nombres[i] != null) {
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
                if (nombres[i] == null) {//la variable debe tener almacenado un nombre
                    nombres[i] = nombre;
                    puntos[i] = punto;
                    break;
                }
            }
        }
    }
    
    
    
    public void juego(){
        
        String tamaño="";
        String tamañon;
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
        
        
            int alto, ancho;
            ancho=12;
            alto=12;
        
        boolean tablerog [][] = new boolean[ancho][alto];

        for (int i = 0; i < alto; i++) {
                for (int j = 0; j < ancho; j++) {

                    int obstaculos1 = (int)(Math.random()*(ancho-3)+1);
                    int obstaculos2 = (int)(Math.random()*(ancho-3)+1);

                    if (i == 0 || i == alto-1){
                        System.out.print("---");
                   

                    } else if(j == 0 || j == ancho - 1){

                        System.out.print("|    ");

                    }else{
          
                        if(obstaculos1 == i && obstaculos2 == j){
                            System.out.print("@  ");
                        }else if(obstaculos2 == i && obstaculos1 == j){
                            System.out.print("0  ");
                        }else if(obstaculos1>= j && obstaculos1<= j){
                            System.out.print("$  ");
                        }else if(obstaculos2 == i){
                            System.out.print("x  ");
                        }else{
                            System.out.print("  "
                                    + " ");
                        }
                    }

                }
                System.out.println("");
            }
        
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
    
    int alto, ancho,x,y;
    Scanner teclado= new Scanner(System.in);
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
    
     ancho=6;
     alto=7;
        
        String IZQUIERDA = " < ";
        String DERECHA = " > ";
        String ARRIBA = " ^ ";
        String ABAJO = " V ";     
            
            
       
        boolean tablero [][] = new boolean[ancho][alto];

        for (int i = 0; i < alto; i++) {
                for (int j = 0; j < ancho; j++) {

                    
                    
                    int item1 = (int)(Math.random()*(ancho-3)+1);
                    int item2 = (int)(Math.random()*(ancho-3)+1);

                    if (i == 0 || i == alto-1){
                        System.out.print("---");
                        
                   

                    } else if(j == 0 || j == ancho-1){

                        System.out.print("|    ");

                    }else{
          
                        if(item1 == i && item2 == j){
                            System.out.print("@  ");
                        }else if(item2 == i && item1 == j){
                            System.out.print("0  ");
                        }else if(item1>= j && item1<= j){
                            System.out.print("$  ");
                        }else if(item2 == i){
                            System.out.print("x  ");
                        }else if(j == x && i == y){
                          System.out.println(">  ");  
                        }else{
                            System.out.print("  "
                                    + " ");
                        }
                    }

                }
                System.out.println("");
            }
    historialfp();
    }
}
