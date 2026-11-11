package com.cyberassembly.practica.tasks;

import com.cyberassembly.practica.model.CentralSoldadora;
import com.cyberassembly.practica.model.CintaTransportadora;
import com.cyberassembly.practica.model.SupervisorCentral;
import com.cyberassembly.practica.view.ConsoleView;

public class RobotTask implements Runnable{

    int idBot;
    CintaTransportadora cinta;
    Bateria bateriaAgafada;
    CentralSoldadora central;
    SupervisorCentral certificat;

    public RobotTask(int id, CintaTransportadora cinta, CentralSoldadora central, SupervisorCentral certificat) {
        this.idBot = id;
        this.cinta = cinta;
        this.central = central;
        this.certificat = certificat;
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


                certificat.comprovarAlerta();
                central.centralSoldadora(this, bateriaAgafada);
                certificat.notificarUs();


                certificat.supervisorCentral(this, bateriaAgafada);
                

            } catch (InterruptedException ex) {
                System.getLogger(RobotTask.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        } 
    }
    
}
