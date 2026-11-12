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
    SupervisorCentral supervisor;
    int bateria = 100;

    public RobotTask(int id, CintaTransportadora cinta, CentralSoldadora central, SupervisorCentral supervisor) {
        this.idBot = id;
        this.cinta = cinta;
        this.central = central;
        this.supervisor = supervisor;
    }

    public int getIdBot() {
        return idBot;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            
            try {

                supervisor.comprovarBateria(this, bateria);

                ConsoleView.Agafant(this);
                Thread.sleep(500);

                bateriaAgafada = cinta.consumirBateria();
                ConsoleView.BateriaConsumida(this,bateriaAgafada);

                supervisor.comprovarAlerta();
                central.soldar(this, bateriaAgafada);
                supervisor.notificarUs();     
                central.certificar(this, bateriaAgafada);
                bateria = bateria -18;

            } catch (InterruptedException ex) {
                System.getLogger(RobotTask.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        } 
    }
    
}
