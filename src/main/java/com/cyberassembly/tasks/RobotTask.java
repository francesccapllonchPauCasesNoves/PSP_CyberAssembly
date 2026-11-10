package com.cyberassembly.tasks;

import com.cyberassembly.model.CintaTransportadora;

public class RobotTask implements Runnable{

    int idBot;
    Bateria bateriaAgafada;

    public RobotTask(int idBot, CintaTransportadora cinta) {
        this.idBot = idBot;
    }

    public int getIdBot() {
        return idBot;
    }

    @Override
    public void run() {
        
        
    }
    
}
