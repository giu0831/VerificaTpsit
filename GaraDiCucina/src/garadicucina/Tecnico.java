/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garadicucina;

/**
 * Thraed dle tecnico
 * @author aureli.giulia
 */
public class Tecnico extends Thread{
    private Cucina c;

    /**
     * Costruttore
     * @param c cucina
     */
    public Tecnico(Cucina c) {
        this.c = c;
    }
    
    @Override
    public void run(){
        try {
            c.aggiustaFornello();
            System.out.println("il tecnico ha aggiustato i fornelli");
        } catch (InterruptedException ie) {
            System.getLogger(ie.getMessage());
        }
    }
}
