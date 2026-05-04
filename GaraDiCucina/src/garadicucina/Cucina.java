/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garadicucina;

import java.util.Random;

/**
 *
 * @author aureli.giulia
 */
public class Cucina {
    private int fornelli;
    private int resistenzaFornelli;
    private int nUtilizziFornelli;
    private Random rnd = new Random();

    /**
     * Costruttore
     */
    public Cucina() {
        fornelli = 4;
        resistenzaFornelli = 50;
        nUtilizziFornelli = 0;
    }
    
    /**
     * Metodo per entrare in cucina
     * @param id id del cuoco
     * @throws InterruptedException 
     */
    public synchronized void entra(int id) throws InterruptedException{
        while(fornelli == 0){
            wait();
        }
        fornelli--;
        System.out.println("cuoco " + id + " entra in cucina");
        //si prepara il piatto 2 volte
        for(int i = 1; i < 3; i++){
            preparaPiatto();
            System.out.println("cuoco " + id + " ha finito il " + i + " piatto");
            //controllo per vedere se si è roto il fornello
            if(rnd.nextDouble() < 0.05){
                System.out.println("fornello del cuoco " + id + " rotto!");
                chiamaTecnico();
            }
            //controllo per vedere gli utilizzi dei fornelli
            else if(nUtilizziFornelli == 5){
                System.out.println("i fornelli sono stati utilizzati 5 volte, si chiama il tecnico");
                chiamaTecnico();
            }
        }
    }
    
    /**
     * Metodo per preparare un piatto
     * @throws InterruptedException 
     */
    public void preparaPiatto() throws InterruptedException{
        int tempoDiPreparazione = rnd.nextInt(5, 31), resistenzaPersa = rnd.nextInt(1, 11);
        resistenzaFornelli -= resistenzaPersa;
        nUtilizziFornelli++;
        Thread.sleep(tempoDiPreparazione);
    }
    
    /**
     * Metodo per chiamare il tecnico
     * @throws java.lang.InterruptedException
     */
    public void chiamaTecnico() throws InterruptedException{
        Tecnico t = new Tecnico(this);
        t.start();
        t.join();
    }
    
    /**
     * Metodo per aggiustare i fornelli
     * @throws java.lang.InterruptedException
     */
    public void aggiustaFornello() throws InterruptedException{
        Thread.sleep(5000);
        nUtilizziFornelli = 0;
        resistenzaFornelli = 50;
    }
    /**
     * Metodo per uscire dalla cucina
     * @param id id del cuoco
     */
    public synchronized void esci(int id) {
        System.out.println("cuoco " + id + " esce dalla cucina");
        fornelli++;
        notifyAll();
    }
}
