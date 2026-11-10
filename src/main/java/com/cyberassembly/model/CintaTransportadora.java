package com.cyberassembly.model;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

import com.cyberassembly.tasks.Bateria;
import com.cyberassembly.tasks.RobotTask;

public class CintaTransportadora {
    
    ArrayBlockingQueue<Bateria> cinta;

    final ReentrantLock lock = new ReentrantLock();
    RobotTask robot;

    public CintaTransportadora(int max) {
        cinta = new ArrayBlockingQueue<>(max);
    }  


    public void cintaNoPlena() throws InterruptedException{
        while(cinta.remainingCapacity() == 0){
            wait();
            //agefirBateria();
        }
    }

    public void cintaNoBuida(Bateria bat, RobotTask r)throws InterruptedException{
        while(!(cinta.isEmpty())){
            //consumirBateria();

        }
    }

    public void afegirBateria(){
        //Lock
        Bateria bateriaNova = new Bateria();
        cinta.add(bateriaNova);
        System.out.println("Bateria afegida nº"+bateriaNova.getId()+" per AGV!");
    }

    public void consumirBateria(Bateria bat, RobotTask r){
        //Lock
        bat = cinta.poll();
        System.out.println("Bateria llevada de la cinta per Bot nº"+r.getIdBot());
    }
    
}
