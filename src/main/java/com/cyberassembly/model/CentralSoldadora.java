package com.cyberassembly.model;

import java.util.concurrent.Semaphore;

import com.cyberassembly.tasks.RobotTask;

public class CentralSoldadora {

    Semaphore estacions = new Semaphore(3);

    public synchronized void centralSoldadora(RobotTask robot){

    }
    
}
