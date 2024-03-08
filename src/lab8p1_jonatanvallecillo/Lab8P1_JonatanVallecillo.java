package lab8p1_jonatanvallecillo;

import java.util.Scanner;

public class Lab8P1_JonatanVallecillo {
    
    static String nombre = "";
    static int recursos = 0;
    static int dinero = 0;
    static int defensas = 0;
    
    public static Scanner leer = new Scanner(System.in);
    static GreatHouse Atreidis = new GreatHouse(nombre, recursos, dinero, defensas);
    static GreatHouse Harkonnen = new GreatHouse(nombre, recursos, dinero, defensas);
    static GreatHouse Corrino = new GreatHouse(nombre, recursos, dinero, defensas);

    public static void main(String[] args) {
        int menu = 1;
        int opcion = 0;
        while(menu == 1){
            int val = 1;
            while(val == 1){
                System.out.print("***** MENU *****\n"
                        + "1. Dune en java\n"
                        + "2. Salir"
                        + "Ingrese la opcion que desea: ");
                opcion = leer.nextInt();
                if(opcion > 0 && opcion < 3){
                    val = 0;
                }else{
                    System.out.println("ERROR.Intente de nuevo.");
                }
            }
            
            switch(opcion){
                case 1:
                    play();
                    break;
                case 2:
                    menu = 0;
                    break;
            }
        }
    }
    
    public static void play(){
        Atreidis.setNombre("Atreidis"); 
        Atreidis.setRecursos(300);
        Atreidis.setDinero(300);
        Atreidis.setDefensas(300);
        Harkonnen.setNombre("Harkonnen"); 
        Harkonnen.setRecursos(300);
        Harkonnen.setDinero(0);
        Harkonnen.setDefensas(500);
        Corrino.setNombre("Corrino"); 
        Corrino.setRecursos(300);
        Corrino.setDinero(0);
        Corrino.setDefensas(500);
        
        int continuar = 1;
        while(continuar == 1){
            System.out.println("\nRecursos de guerra: "+Atreidis.getRecursos());
            System.out.println("Cantidad de dinero: "+Atreidis.getDinero());
            System.out.println("Defensas: "+Atreidis.getDefensas());
            System.out.println("-------------------------------------------------------------------\n");
            continuar = 0;
            
            int menu = 1;
            int accion = 0;
            while(menu == 1){
                System.out.print("1-Refinar especia\n"
                    + "2-Reclutar legiones fremen\n"
                    + "3-Invertir en defensas\n"
                    + "4-Estadisticos de casa Corrini\n"
                    + "5-Estadisticas de casa Harkonnen\n"
                    + "6-Ataque a las grandes casas\n"
                    + "Ingrese su opcion: ");
                accion = leer.nextInt();
                if(accion > 0 && accion < 7){
                    menu = 0;
                }else{
                    System.out.println("ERROR. Intente de nuevo.");
                }
            }
            
            switch(accion){
                case 1:
                    GreatHouse.refinar();
                    break;
            }
        }
        System.out.println();
    }
}
