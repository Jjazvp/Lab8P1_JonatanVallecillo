package lab8p1_jonatanvallecillo;

import java.util.Random;
import java.util.Scanner;

public class Lab8P1_JonatanVallecillo {
    
    static String nombre = "";
    static int recursos = 0;
    static int dinero = 0;
    static int defensas = 0;
    
    public static Scanner leer = new Scanner(System.in);
    public static Random rand = new Random();
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
                case 2:
                    if(Atreidis.getDinero() >= 50){
                        int recurs = Atreidis.getRecursos() + 50;
                        int diner = Atreidis.getDinero() - 75;
                        Atreidis.setRecursos(recurs);
                        Atreidis.setDinero(diner);
                        System.out.println();
                        System.out.println("Ha reclutado a 1 legion fremen. Sus recursos de guerra incrementan por 50 puntos. -75 de dinero.");
                    }else{
                        System.out.println("No tiene dinero suficiente.");
                    }
                    break;
                case 3:
                    if(Atreidis.getDinero() >= 150){
                        int defens = Atreidis.getDefensas() + 75;
                        int diner = Atreidis.getDinero() - 150;
                        Atreidis.setDefensas(defens);
                        Atreidis.setDinero(diner);
                        System.out.println();
                        System.out.println("La casa astreidis aumento sus defensas. La cantidad de defensas ha aumentado por 75, -150 de dinero.");
                    }else{
                        System.out.println("No tiene dinero suficiente.");
                    }
                    break;
                case 4:
                    System.out.println("\nEstadisticas de casa Corrino:\n"
                            +"-nombre="+Corrino.getNombre()+"\n"
                            +"-recursos de guerra="+Corrino.getRecursos()+"\n"
                            +"-dinero="+Corrino.getDinero()+"\n"
                            +"-defensas="+Corrino.getRecursos());
                    break;
                case 5:
                    System.out.println("\nEstadisticas de casa Harkonnen:\n"
                            +"-nombre="+Harkonnen.getNombre()+"\n"
                            +"-recursos de guerra="+Harkonnen.getRecursos()+"\n"
                            +"-dinero="+Harkonnen.getDinero()+"\n"
                            +"-defensas="+Harkonnen.getRecursos());
                    break;
                case 6:
                    int val = 1;
                    int opcion = 0;
                    while(val == 1){
                        System.out.print("\nElija una de las grandes casas para atacar: \n"
                            + "1. Casa Corrino\n"
                            + "2. Casa Harkonnen\n"
                            + "Ingrese su opcion: ");
                        opcion = leer.nextInt();
                        if(opcion > 0 && opcion < 3){
                            val = 0;
                        }else{
                            System.out.println("ERROR. Intente de nuevo.");
                        }
                    }
                    
                    GreatHouse atacado = new GreatHouse(nombre, recursos, dinero, defensas);
                    switch(opcion){
                        case 1:
                            System.out.println("La casa Atreidis ataca a la casa Harkonnen");
                            atacado = Harkonnen;
                            break;
                        case 2:
                            System.out.println("La casa Atreidis ataca a la casa Corrino");
                            atacado = Corrino;
                            break;
                    }
                    break;
            }
        }
        System.out.println();
    }
    
    public static void ataque(GreatHouse Atreidis, GreatHouse atacado){
        int val = 1;
        int daño = 0;
        int k = 0;
        int m = 0;
        int chance = 0;
        while(val == 1){
            k = rand.nextInt(9);
            if(k == 5 || k == 7 || k == 9){
                val = 0;
            }
        }
        
        for(int i = 0; i < k; i++){
            m = GreatHouse.getRecursos();
            daño = (m*(-1)*i)*(i+1)/(10);
            if(atacado.getNombre() == "Corrino"){
                System.out.println("Hola");
            }else{
                
            }
        }
    }
}
