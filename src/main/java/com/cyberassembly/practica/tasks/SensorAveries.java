package com.cyberassembly.practica.tasks;

import java.util.Random;

import com.cyberassembly.practica.model.CentralSoldadora;
import com.cyberassembly.practica.view.ConsoleView;

public class SensorAveries implements Runnable{

    private final Random random = new Random();
    private final CentralSoldadora central;


    public SensorAveries(CentralSoldadora central) {
        this.central = central;

    }

    @Override
    public void run() {
        
        while(true){
            try {
                Thread.sleep(2000);
                                
                int numEstacio = random.nextInt(3);
                central.generarAveria(numEstacio);
                ConsoleView.EstacioAvarieda(numEstacio);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
    
}
