/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package garadicucina;

/**
 *
 * @author aureli.giulia
 */
public class GaraDiCucina {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        //creazione monitor
        Spogliatoio s = new Spogliatoio();
        Cucina c = new Cucina();
        
        Cuoco[] cuochi = new Cuoco[10];
        
        //Creazione thread
        for(int i = 0; i < 10; i++){
            Cuoco cuoco = new Cuoco(i + 1, s, c);
            cuochi[i] = cuoco;
            cuoco.start();
        }
        
        for(Cuoco cuoco : cuochi){
            cuoco.join();
        }
        
        System.out.println("gara di cucina finita!");
    }
    
}
