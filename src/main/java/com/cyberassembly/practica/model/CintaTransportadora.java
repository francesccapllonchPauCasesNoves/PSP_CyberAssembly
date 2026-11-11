package com.cyberassembly.practica.model;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import com.cyberassembly.practica.tasks.Bateria;
import com.cyberassembly.practica.tasks.RobotTask;

public class CintaTransportadora {
    
    ArrayBlockingQueue<Bateria> cinta;

    final ReentrantLock lock = new ReentrantLock();
    Condition noPle = lock.newCondition();
    Condition noBuit = lock.newCondition();

    RobotTask robot;

    public CintaTransportadora(int max) {
        cinta = new ArrayBlockingQueue<>(max);
    }  

    public void afegirBateria(Bateria bateriaNova) throws InterruptedException{
        lock.lock();
        try {
            while(cinta.remainingCapacity() == 0){
                noPle.await();
            }            
            cinta.offer(bateriaNova);
            noBuit.signal();
        } finally {
            lock.unlock();
        }        
    }

    public Bateria consumirBateria() throws InterruptedException{
        lock.lock();
        try {
            while(cinta.isEmpty()){
                noBuit.await();
            }
            Bateria consumida = cinta.poll();
            noPle.signal();
            return consumida;
        } finally {
            lock.unlock();
        } 
    }
    
}
