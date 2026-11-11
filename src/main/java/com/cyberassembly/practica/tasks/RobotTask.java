package com.cyberassembly.practica.tasks;

import com.cyberassembly.practica.model.CintaTransportadora;
import com.cyberassembly.practica.view.ConsoleView;

public class RobotTask implements Runnable{

    int idBot;
    CintaTransportadora cinta;
    Bateria bateriaAgafada;

    public RobotTask(int id, CintaTransportadora cinta) {
        this.idBot = id;
        this.cinta = cinta;
    }

    public int getIdBot() {
        return idBot;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            
            try {
                bateriaAgafada = cinta.consumirBateria();
                Thread.sleep(500);
                ConsoleView.BateriaConsumida(this,bateriaAgafada);
            } catch (InterruptedException ex) {
                System.getLogger(RobotTask.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        } 
    }
    
}
