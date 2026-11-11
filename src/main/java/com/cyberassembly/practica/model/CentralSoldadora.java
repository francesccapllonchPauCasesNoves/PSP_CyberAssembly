package com.cyberassembly.practica.model;

import java.util.concurrent.Semaphore;

import com.cyberassembly.practica.tasks.Bateria;
import com.cyberassembly.practica.tasks.RobotTask;
import com.cyberassembly.practica.view.ConsoleView;

public class CentralSoldadora {

    Semaphore estacions = new Semaphore(3);

    public void centralSoldadora(RobotTask robot, Bateria bateriaAgafada) throws InterruptedException{

        try{
            ConsoleView.Soldant(robot);
            Thread.sleep(500);
            estacions.acquire();
            ConsoleView.BateriaSoldada(robot, bateriaAgafada);
        }finally{
            estacions.release();
        }
    }
    
}
