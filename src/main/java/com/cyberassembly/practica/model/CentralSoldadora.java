package com.cyberassembly.practica.model;

import java.util.concurrent.Semaphore;

import com.cyberassembly.practica.tasks.Bateria;
import com.cyberassembly.practica.tasks.RobotTask;
import com.cyberassembly.practica.view.ConsoleView;

public class CentralSoldadora {

    Semaphore estacions = new Semaphore(3);
    int[] numEstacio = new int[3];
    Semaphore certificador = new Semaphore(1);

    public void soldar(RobotTask robot, Bateria bateriaAgafada) throws InterruptedException{
        try{
            estacions.acquire();
            ocuparEstacio();
            ConsoleView.Soldant(robot);
            Thread.sleep(500);
            ConsoleView.BateriaSoldada(robot, bateriaAgafada);
        }finally{
            estacions.release();
            alliberarEstacio();
        }
    }

    public void certificar(RobotTask robot, Bateria bateriaAgafada) throws InterruptedException{
        try {
            ConsoleView.ProvarCertificarBateria(robot, bateriaAgafada);
            certificador.acquire();
            Thread.sleep(500);
            ConsoleView.CertificarBateria(robot, bateriaAgafada);
        } finally {
            certificador.release();
        }
    }

    public synchronized void generarAveria(int num) throws InterruptedException{
        if(numEstacio[num] == 0){ 
            numEstacio[num] = -1;
            estacions.acquire();

            new Thread(() -> {
            try {
                Thread.sleep(500);
                ConsoleView.EstacioArreglada(num);;
                tecnicManteniment(num);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            }).start();

            
        }        
    }

    public synchronized void tecnicManteniment(int num) throws InterruptedException{
        numEstacio[num] = 0;
        estacions.release();
    }

    public synchronized void ocuparEstacio(){
        for (int i = 0; i < numEstacio.length; i++) {
            if(numEstacio[i] == 0){
                numEstacio[i] = 1;
                break;
            }
        }
    }

    public synchronized void alliberarEstacio(){
        for (int i = 0; i < numEstacio.length; i++) {
            if(numEstacio[i] == 1){
                numEstacio[i] = 0;
                break;
            }
        }
    }

    
}
