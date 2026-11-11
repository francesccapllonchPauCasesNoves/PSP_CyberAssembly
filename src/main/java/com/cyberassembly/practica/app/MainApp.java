package com.cyberassembly.practica.app;

import com.cyberassembly.practica.model.CentralSoldadora;
import com.cyberassembly.practica.model.CintaTransportadora;
import com.cyberassembly.practica.tasks.AGVTask;
import com.cyberassembly.practica.tasks.RobotTask;

public class MainApp {
    public static void main(String[] args) {
        CintaTransportadora cinta = new CintaTransportadora(5);
        CentralSoldadora central = new CentralSoldadora();
        AGVTask agv = new AGVTask(cinta);

        RobotTask bot1 = new RobotTask(1,cinta, central);
        RobotTask bot2 = new RobotTask(2,cinta, central);
        RobotTask bot3 = new RobotTask(3,cinta, central);
        RobotTask bot4 = new RobotTask(4,cinta, central);

        Thread agvTask = new Thread(agv);

        Thread botTask1 = new Thread(bot1);
        Thread botTask2 = new Thread(bot2);
        Thread botTask3 = new Thread(bot3);
        Thread botTask4 = new Thread(bot4);


        agvTask.start();
        botTask1.start();
        botTask2.start();
        botTask3.start();
        botTask4.start();

        try {
            agvTask.join();
            botTask1.join();
            botTask2.join();
            botTask3.join();
            botTask4.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
    
}
