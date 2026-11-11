package com.cyberassembly.practica.model;

import java.util.concurrent.Semaphore;

import com.cyberassembly.practica.tasks.Bateria;
import com.cyberassembly.practica.tasks.RobotTask;
import com.cyberassembly.practica.view.ConsoleView;

public class SupervisorCentral {
    Semaphore estacions = new Semaphore(1);

    public void supervisorCentral(RobotTask robot, Bateria bateriaAgafada) throws InterruptedException{

        try{
            ConsoleView.ProvarCertificarBateria(robot, bateriaAgafada);
            Thread.sleep(500);
            estacions.acquire();
            ConsoleView.CertificarBateria(robot, bateriaAgafada);
        }finally{
            estacions.release();
        }
    }
    
}
