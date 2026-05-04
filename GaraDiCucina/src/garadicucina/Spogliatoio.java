/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garadicucina;

/**
 * Monitor Spogliatoio
 * @author aureli.giulia
 */
public class Spogliatoio {
    private int posti;

    /**
     * Costruttore
     */
    public Spogliatoio() {
        posti = 2;
    }
    
    /**
     * Metodo per entrare nello spogliatoio
     * @param id id del cuoco
     * @throws InterruptedException 
     */
    public synchronized void entra(int id) throws InterruptedException{
        while (posti == 0) {
            wait();
        }
        posti--;
        System.out.println("cuoco " + id + " entra nello spogliatoio");
        Thread.sleep(2000);
    }
    
    /**
     * Metodo per uscire dallo spogliatoio
     * @param id 
     */
    public synchronized void esci(int id) {
        System.out.println("Cuoco " + id + " esce dallo spogliatoio");
        posti++;
        notifyAll();
    }
}
