package com.cyberassembly.practica.tasks;

import com.cyberassembly.practica.model.CintaTransportadora;
import com.cyberassembly.practica.view.ConsoleView;

public class AGVTask implements Runnable{

    CintaTransportadora cinta;
    int comptador = 0;

    public AGVTask(CintaTransportadora cinta){
        this.cinta = cinta;
    }

    
    @Override
    public void run(){
        for (int i = 0; i < 15; i++) {
            comptador++;
            Bateria bateriaNova = new Bateria(comptador);
            try {
                
                cinta.afegirBateria(bateriaNova);
                ConsoleView.Afegint();
                Thread.sleep(500);
                ConsoleView.BateriaAfegida(bateriaNova);
            } catch (InterruptedException ex) {
                System.getLogger(AGVTask.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
            
        }
        
    }
    
}
