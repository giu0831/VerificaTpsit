/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garadicucina;

/**
 *
 * @author aureli.giulia
 */
public class Cuoco extends Thread{
    private int id;
    private Spogliatoio s;
    private Cucina c;

    /**
     * Costruttore
     * @param s spogliatoio
     * @param c cucina
     */
    public Cuoco(int id, Spogliatoio s, Cucina c) {
        this.id = id;
        this.s = s;
        this.c = c;
    }
    
    @Override
    public void run(){
        try {
            s.entra(id);
            s.esci(id);
            
            c.entra(id);
            c.esci(id);
            
            s.entra(id);
            s.esci(id);
            
            System.out.println("cuoco " + id + " ha finito");
        } catch (InterruptedException ie) {
            System.getLogger(ie.getMessage());
        }
    }
    
}
