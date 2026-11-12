package com.cyberassembly.practica.view;

import com.cyberassembly.practica.tasks.Bateria;
import com.cyberassembly.practica.tasks.RobotTask;

public class ConsoleView {

    public static void Afegint() {
        System.out.println("AGV afegint...");
    }

    public static void BateriaAfegida(Bateria bateriaNova) {
        System.out.println("Bateria afegida nº"+bateriaNova.getId()+" per AGV!");
    }

    public static void Agafant(RobotTask bot) {
        System.out.println( bot.getIdBot()+" agafant...");
    }

    public static void BateriaConsumida(RobotTask bot, Bateria bat) {
        System.out.println("Bateria nº"+bat.getId()+" consumida per robot nº"+bot.getIdBot());    
    }

    public static void Soldant(RobotTask bot) {
        System.out.println(bot.getIdBot()+" soldant...");
    }

    public static void BateriaSoldada(RobotTask bot, Bateria bat) {
        System.out.println("Bateria nº"+bat.getId()+" soldada per robot nº"+bot.getIdBot()); 
    }

    public static void ProvarCertificarBateria(RobotTask bot, Bateria bat) {
        System.out.println("Robot nº"+bot.getIdBot()+" esta intentant certificar...");
    }

    public static void CertificarBateria(RobotTask bot, Bateria bat) {
        System.out.println("Robot nº"+bot.getIdBot()+" ha certificat bateria "+bat.getId());
    }

    public static void AlertaSobreescalfament() {
        System.out.println("ALERTA PER SOBREESCALFAMENT, S'ATURA L'ENTRADA AL SUPERVISOR DURANT 2 SEGONS");
    }

    public static void ResoldreEmergencia() {
        System.out.println("EMERGENCIA RESOLTA!");
    }

    public static void EstacioAvarieda(int estacio) {
        System.out.println("L'estacio nº"+estacio+" esta avariada!");
    }

    public static void EstacioArreglada(int estacio) {
        System.out.println("L'estacio nº"+estacio+" esta arreglada pel tècnic!");    
    }

    public static void CarregarBateria(RobotTask bot, int bateria) {
        System.out.println("Bateria del robot nº"+bot.getIdBot()+" al "+bateria+"%");
    }
    
}
