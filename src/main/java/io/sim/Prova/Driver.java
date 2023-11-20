package io.sim.Prova;


/* Classe para tratar as relações dos Motoristas */

public class Driver extends Thread{
    private Car carro;
    private String idDriver;
    private BotPayment bot;
    private Client clientBank;
    
    public Driver (Car car, String idDriver){ //Construtor do Motorista
        this.carro = car;
        this.idDriver = idDriver;
    }

    public void abastecer(double litros, double preco){     //Abastecimento do carro.
        this.bot.pedidoAbastecer(litros,preco);             //Pedido de abastecer feito para o bot.
    }


    public Car getCar(){
        return this.carro;
    }

    //Método para execução da Thread
    public void run(){

    }
}
