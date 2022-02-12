

package com.mycompany.pacman;

import java.util.Random;
import java.util.Scanner;


public class principal {
    
 
    
    public static void main(String args[]){
        
        Scanner teclado= new Scanner(System.in);
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
            historial();
            break;
            case 3:
            System.exit(0);
            break;
            default:
            System.out.println("elija una opcion entre 1-3");    
        }  
        }while(n!=3);
            
        
    }
    
    
    //datos para el historial
    public static String nombre="";
    String nombres[] = new String[10];
    public static int punto=0;
    int punteos[] = new int[10];
    //datos para el tablero
    public static int premios,paredes,trampas,x,y;
    public static int vidas=3;
    
    public static void juego(){
        
        String tamaño,tamañon;
        
        int i=0;
        Scanner teclado= new Scanner(System.in);
        System.out.println("Ingrese su nombre:");
        nombre=teclado.nextLine();
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
    
    static void historial(){
        System.out.println("=======HISTORIAL DE PARTIDAS=======");
          
    }
    
   
    
    public static void tablerogrande(){
            Scanner teclado= new Scanner(System.in);
            int alto, ancho;
            ancho=12;
            alto=12;
        
        boolean tablero [][] = new boolean[ancho][alto];

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
    }
    
    
    
            
    
    public static void tableropequenio(){ 
    
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
    
    }
    
}
