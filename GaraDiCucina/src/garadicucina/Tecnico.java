/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garadicucina;

/**
 *
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
        } catch (InterruptedException ie) {
            System.getLogger(ie.getMessage());
        }
    }
}
