package io.sim.Prova;

/* Classe das relações com o Posto de Gasolina */

public class FStation extends Thread {
    private double fuel = 5.87; //Combustível = R$5.87
    private int bombas = 2; //Bombas existentes no Posto de Gasolina
    private Conta account;
    //Talvez um BOOL que diz se as bombas estão disponíveis ou não.
    //Cliente AlphaBank

    //Função que recebe uma quantia do motorista e retorna os litros abastecidos.
    public synchronized double abastecer(double litros) {
        this.bombas--;
        double cobranca = 0.0;             
        try {
            while (this.bombas == 0) {
                wait(); // Carros Aguardam para abastecer
            }

            cobranca = litros*fuel;      //Preço cobrado: Litros abastecidos * fuel
            sleep(120000);
            this.notifyAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.bombas++;
        }
        return cobranca;
    }

    //Método para execução da Thread
    public void run(){

    }
}
