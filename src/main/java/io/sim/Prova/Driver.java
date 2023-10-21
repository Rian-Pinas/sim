package io.sim.Prova;

import java.util.ArrayList;

import de.tudresden.sumo.cmd.Vehicle;

/* Classe para tratar as relações dos Motoristas */

public class Driver extends Thread{
    private Car carro;
    private ArrayList<Route> rotas;
    private Route exec;
    private ArrayList<Route> rotafim;
    private Conta conta;
    private BotPayment bot;
    
    public Driver (Car car, ArrayList<Route> rot, BotPayment bot){ //Construtor do Motorista
        this.carro = car;
        this.rotas = rot;
        this.bot = bot;
    }

    public void abastecer(double litros, double preco){     //Abastecimento do carro.
        this.bot.pedidoAbastecer(litros,preco);             //Pedido de abastecer feito para o bot.
    }

    public void mudaRota(){ //Compara com a edge final para saber se ja acabou a rota e muda a rota. passa para o outro array
        try {
        String aux = (String) carro.getAuto().getSumo().do_job_get(Vehicle.getRoadID(this.getCar().getAuto().getIdAuto()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Car getCar(){
        return this.carro;
    }

    public Conta getConta(){
        return this.conta;
    }

    //Método para execução da Thread
    public void run(){

    }
}
