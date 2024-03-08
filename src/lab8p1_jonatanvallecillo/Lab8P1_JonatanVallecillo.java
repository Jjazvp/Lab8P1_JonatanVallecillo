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
    static GreatHouse Atreidis = new GreatHouse("Atreidis", 300, 300, 300);
    static GreatHouse Harkonnen = new GreatHouse("Harkonnen", 300,0, 500);
    static GreatHouse Corrino = new GreatHouse("Corrino", 300,0, 500);

    public static void main(String[] args) {
        int menu = 1;
        int opcion = 0;
        while(menu == 1){
            int val = 1;
            while(val == 1){
                System.out.print("***** MENU *****\n"
                        + "1. Dune en java\n"
                        + "2. Salir\n"
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
                    if(Atreidis.getDinero() > 0){
                        while(val == 1){
                            System.out.print("\nElija una de las grandes casas para atacar: \n"
                                + "1. Casa Harkonnen\n"
                                + "2. Casa Corrino\n"
                                + "Ingrese su opcion: ");
                            opcion = leer.nextInt();
                            if(opcion > 0 && opcion < 3){
                                val = 0;
                            }else if(Corrino.getDefensas() < 0 || Harkonnen.getDefensas() < 0 || Corrino.getRecursos() < 0 || Harkonnen.getRecursos() < 0){
                                System.out.println("Ha derrotado a esta casa, elija otra.");
                            }else{
                                System.out.println("ERROR. Intente de nuevo.");
                            }
                        }

                        GreatHouse atacado = new GreatHouse(nombre, recursos, dinero, defensas);
                        switch(opcion){
                            case 1:
                                System.out.println("La casa Atreidis ataca a la casa Harkonnen");
                                atacado = Harkonnen;
                                ataque(Atreidis, atacado);
                                break;
                            case 2:
                                System.out.println("La casa Atreidis ataca a la casa Corrino");
                                atacado = Corrino;
                                ataque(Atreidis, atacado);

                                break;
                        }
                    }else{
                        System.out.println("No tiene suficiente dinero");
                    }
                    break;
            }
        }
        
        if(Atreidis.getDinero() < 0){
            Atreidis.setDinero(0);
        }
        
        if(Harkonnen.getDefensas() <= 0){
            System.out.println("Ha derrotado a la casa de Harkonnen");
        }else if(Corrino.getDefensas() <= 0){
            System.out.println("Ha derrotado a la casa de Corrino");
        }
        
        if(Harkonnen.getDefensas() <= 0 && Corrino.getDefensas() <= 0){
            System.out.println("Ha ganado!");
            continuar = 0;
        }
        
        System.out.println();
    }
    
    public static void ataque(GreatHouse Atreidis, GreatHouse atacado){
        int val = 1;
        int daño = 0;
        int k = 0;
        int m = 0;
        int chance = 0;
        int vida = 0;
        int money = 0;
        int recurs = 0;
        while(val == 1){
            k = rand.nextInt(9);
            if(k == 5 || k == 7 || k == 9){
                val = 0;
            }
        }
 
        double exp = 0;
        m = Atreidis.getRecursos();
        
        for(int i = 0; i < k; i++){
            exp = Math.pow(-1, i);
            chance = rand.nextInt(8) + 1;
            daño += (m*exp)*(i+1)/(10);
        }
        
        if(Atreidis.getRecursos() > daño){
            vida = atacado.getDefensas();
            money = Atreidis.getDinero();
            recurs = atacado.getRecursos();
            vida -= daño;
            money -= daño;
            recurs -= (daño * 2);
            atacado.setDefensas(vida);
            atacado.setRecursos(recurs);
            Atreidis.setDinero(money);
            System.out.println("*La casa Atreidis ataca a la "+atacado.getNombre());
            System.out.println("*La casa "+atacado.getNombre()+" perdio "+recurs+" recursos");
            System.out.println("*La casa "+atacado.getNombre()+" perdio "+daño+" defensa");
            
            if(chance == 1){
                m = Atreidis.getRecursos();
                for(int i = 0; i < k; i++){
                    exp = Math.pow(-1, i);
                    chance = rand.nextInt(8) + 1;
                    daño += (m*exp)*(i+1)/(10);
                }
                if(atacado.getRecursos() > daño){
                    vida -= daño;
                    Atreidis.setDefensas(vida);
                    System.out.println("*La casa Atreidis perdio "+daño+" de defensas");
                }
            }
            
            money = Atreidis.getDinero() + 15;
            Atreidis.setDinero(money);
            System.out.println("Consiguio 15 de dinero adicional");
            
            if(atacado.getNombre() == "Harkonnen"){
                Harkonnen = atacado; 
            }else{
                Corrino = atacado;
            }
        }else{
            System.out.println("No tiene suficientes recursos");
        }
    }
}
