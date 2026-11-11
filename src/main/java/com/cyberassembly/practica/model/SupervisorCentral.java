package com.cyberassembly.practica.model;

import java.util.Random;
import java.util.concurrent.Semaphore;

import com.cyberassembly.practica.tasks.Bateria;
import com.cyberassembly.practica.tasks.RobotTask;
import com.cyberassembly.practica.view.ConsoleView;

public class SupervisorCentral {
    Semaphore estacions = new Semaphore(1);
    
    private boolean sobreescalfament = false; 
    private int usosConsecutius = 0;
    private final Random random = new Random();

    public synchronized  void supervisorCentral(RobotTask robot, Bateria bateriaAgafada) throws InterruptedException{

        try{
            if(sobreescalfament) return;

            ConsoleView.ProvarCertificarBateria(robot, bateriaAgafada);
            Thread.sleep(500);

            estacions.acquire();
            usosConsecutius++;

            int probablitat = usosConsecutius * 20;
            ConsoleView.CertificarBateria(robot, bateriaAgafada);

            int numRand = random.nextInt(100) + 1;
            if(numRand <= probablitat){
                sobreescalfament();
            }
        }finally{
            estacions.release();
        }
    }

    public synchronized void sobreescalfament() throws InterruptedException{
        sobreescalfament = true;
        ConsoleView.AlertaSobreescalfament();
        
        Thread.sleep(2000);
        resoldreEmergencia();
    }

    public synchronized void resoldreEmergencia(){
        sobreescalfament = false;

        usosConsecutius = 0;

        ConsoleView.ResoldreEmergencia();
        notifyAll();
    }

    
    
}
