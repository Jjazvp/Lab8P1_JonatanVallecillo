package lab8p1_jonatanvallecillo;

import java.util.Random;
import java.util.Scanner;

public class GreatHouse {
    static Random rand = new Random();
    static Scanner leer = new Scanner(System.in);
    static String nombre = "";
    static int recursos = 0;
    static int dinero = 0;
    static int defensas = 0;

    public GreatHouse(String nombre, int recursos, int dinero, int defensas) {
        this.nombre = nombre;
        this.recursos = recursos;
        this.dinero = dinero;
        this.defensas = defensas;
        recursos += 75;
    }

    static public String getNombre() {
        return nombre;
    }

    static public int getRecursos() {
        return recursos;
    }

    static public int getDinero() {
        return dinero;
    }

    static public int getDefensas() {
        return defensas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRecursos(int recursos) {
        this.recursos = recursos;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero ;
    }

    public void setDefensas(int defensas) {
        this.defensas = defensas;
    }
    
    public static void refinar(){
        char [] array = new char [5];
        char carac = ' ';
        
        int val = 1;
        int posicion1 = 0;
        int posicion2 = 0;
        
        posicion1 = rand.nextInt(5);
        posicion2 = rand.nextInt(5);
        
        
        while(val == 1){
            if(posicion1 == posicion2){
                System.out.println("ERROR. Intente de nuevo.");
                posicion2 = rand.nextInt(5);
            }else{
                val = 0;
            }
        }
        
        for(int i = 0; i < 5; i++){
            if(posicion1 == i || posicion2 == i){
                array[i] = 'x';
            }else{
                array[i] = ' ';
            }
        }
        
        System.out.println();
        for(int i = 0; i < 5; i++){
            System.out.print("[ "+"]");
        }
        
        int val1 = 1;
        while(val1 == 1){
            System.out.println("\nIngrese posicion de la refineria: ");
            int refinar = leer.nextInt();
            if(refinar >= 0 && refinar < 5){
                array[refinar] = 'R';
                val1 = 0;
            }else{
                System.out.println("ERROR.Intente de nuevo.");
            }
        }
        
        int cont = 0;
        for(int i = 0; i < 5; i++){
            System.out.print("["+array[i]+"]");
            if(array[i] == 'x'){
                cont ++;
            }
        }
        
        int suma = 0;
        if(cont < 2){
            System.out.println("\nLa especia no ha sido refinada.");
        }else{
            System.out.println("\nLa especia fue refinada, y exportada. Consiguio "+suma+" de dinero");
            suma = rand.nextInt(100-50)+50;
        }
    }
}
