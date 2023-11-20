package io.sim.Prova;

/* Classe intermediária de pagamentos e transações de dinheiro */

public class BotPayment extends Thread {
    private Driver driver;
    private FStation fuelstate;
    private Company comp;
    
    public BotPayment(Driver driver, FStation fuelstation){ //Construtor do Bot Payment
        this.driver = driver;
        this.fuelstate = fuelstation;
    }
    
    public BotPayment(Company comp, Driver driver){
        this.driver = driver;
        this.comp = comp;
    }

    public void pedidoAbastecer(double litros, double preco){ //BotPayment faz o pedido para a FuelStation
   
    }

    public void pagamento(String senha){ //BotPayment faz o pagamento de 3,25 por km rodado do driver
        
    }

    public void run(){

    }
}
