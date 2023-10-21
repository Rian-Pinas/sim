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
        if (driver.getConta().getSaldo() >= litros*preco) {   //e ela realiza o abastecimento.
            double cobranca, saldonovo;
            cobranca = fuelstate.abastecer(litros, this.driver);
            saldonovo = driver.getConta().getSaldo()-cobranca;
            driver.getConta().setSaldo(saldonovo);
            System.out.println("Transação concluída, novo saldo: R$" + driver.getConta().getSaldo());
        } else {
            System.out.println("Saldo Insuficiente.");
        }
    }

    public void pagamento(String senha){ //BotPayment faz o pagamento de 3,25 por km rodado do driver
        if(senha.equals(comp.getConta().getSenha())){
            double saldonovocomp = comp.getConta().getSaldo() - 3.25;
            comp.getConta().setSaldo(saldonovocomp);

            double saldonovodriver = driver.getConta().getSaldo() + 3.25;
            driver.getConta().setSaldo(saldonovodriver);

            System.out.println("Transação concluída: pagamento de R$" + 3.25 + " ao motorista");
        } else {
            System.out.println("Senha incorreta");
        }
    }

    public void run(){

    }
}
