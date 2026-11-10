package com.cyberassembly.model;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

import com.cyberassembly.tasks.Bateria;
import com.cyberassembly.tasks.RobotTask;

public class CintaTransportadora {

    Queue<Bateria> cinta = new LinkedList<>();

    ReentrantLock lock = new ReentrantLock();

    RobotTask robot;


    public void cintaNoPlena(){

    }

    public void cintaNoBuida(){

    }
    
}
