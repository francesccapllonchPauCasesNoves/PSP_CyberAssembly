package com.cyberassembly.practica.model;

import java.util.Random;

import com.cyberassembly.practica.tasks.RobotTask;
import com.cyberassembly.practica.view.ConsoleView;

public class SupervisorCentral {
    
    
    private boolean sobreescalfament = false; 
    private int usosConsecutius = 0;
    private final Random random = new Random();

    
    public synchronized void notificarUs() throws InterruptedException{
        
        usosConsecutius++;
        int probablitat = usosConsecutius * 8;
        int numRand = random.nextInt(100) + 1;

        if(numRand <= probablitat){
            sobreescalfament();
        }

    }

    public synchronized void comprovarAlerta() throws InterruptedException{
        while(sobreescalfament){
            wait();
        }
    }

    public synchronized void sobreescalfament() throws InterruptedException{
        sobreescalfament = true;
        ConsoleView.AlertaSobreescalfament();

        new Thread(() -> {
            try {
                Thread.sleep(500);
                resoldreEmergencia();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    public synchronized void resoldreEmergencia(){
        sobreescalfament = false;

        usosConsecutius = 0;

        ConsoleView.ResoldreEmergencia();
        notifyAll();
    }

    public synchronized boolean comprovarBateria(RobotTask bot ,int bateria){
        if(bateria < 20){
            new Thread(() -> {
            try {
                Thread.sleep(2000);
                ConsoleView.CarregarBateria(bot, bateria);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            }).start();
            return true;
        }
        return false;
    }

    
    
}
