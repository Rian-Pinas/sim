package io.sim.Prova;

import java.util.ArrayList;

/* Classe para tratar as relações dos Motoristas */

public class Driver extends Thread{
    private Car carro;
    private ArrayList<Route> rotas;
    private Route exec;
    private ArrayList<Route> rotafim;
    private Conta conta;
    
    public Driver (Car car, ArrayList<Route> rot){ //Construtor do Motorista
        this.carro = car;
        this.rotas = rot;
    }

    /*public void execRota(){
        exec = rotas.remove(0);
        int aux = exec.getEdge().length();
        String ultimaEdge = exec.getEdge().
        if (){
            rotafim.add(exec);
        }
    }*/

    // Verifique o status dos veículos
    /*for (Car vehicle : vehicleManager.getLoaded()) {
        if (vehicle.isStopped(vehicle.getID())) {
            System.out.println("O veículo " + vehicle.getID() + " terminou sua rota.");
        }
    }*/

    //Método para execução da Thread
    public void run(){

    }
}
