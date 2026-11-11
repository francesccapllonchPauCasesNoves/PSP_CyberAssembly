package com.cyberassembly.practica.tasks;

import com.cyberassembly.practica.model.CentralSoldadora;
import com.cyberassembly.practica.model.CintaTransportadora;
import com.cyberassembly.practica.view.ConsoleView;

public class RobotTask implements Runnable{

    int idBot;
    CintaTransportadora cinta;
    Bateria bateriaAgafada;
    CentralSoldadora central;

    public RobotTask(int id, CintaTransportadora cinta, CentralSoldadora central) {
        this.idBot = id;
        this.cinta = cinta;
        this.central = central;
    }

    public int getIdBot() {
        return idBot;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            
            try {
                ConsoleView.Agafant(this);
                Thread.sleep(500);

                bateriaAgafada = cinta.consumirBateria();
                ConsoleView.BateriaConsumida(this,bateriaAgafada);

                central.centralSoldadora(this, bateriaAgafada);

            } catch (InterruptedException ex) {
                System.getLogger(RobotTask.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        } 
    }
    
}
