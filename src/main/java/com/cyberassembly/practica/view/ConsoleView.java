package com.cyberassembly.practica.view;

import com.cyberassembly.practica.tasks.Bateria;
import com.cyberassembly.practica.tasks.RobotTask;

public class ConsoleView {

    public static void BateriaAfegida(Bateria bateriaNova) {
        System.out.println("Bateria afegida nº"+bateriaNova.getId()+" per AGV!");

    }

    public static void BateriaConsumida(RobotTask bot, Bateria bat) {
        System.out.println("Bateria nº"+bat.getId()+" consumida per robot nº"+bot.getIdBot());    }
}
