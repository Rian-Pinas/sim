package io.sim.Prova;

import java.util.concurrent.locks.Lock;             //A classe ReentrantLock implementa a interface Lock
import java.util.concurrent.locks.ReentrantLock;    //e fornece sincronização para métodos


/* Classe da Conta Corrente */

public class Conta extends Thread{
    private String login;
    private String senha;
    private double saldo;
    private Lock lock = new ReentrantLock();

    public Conta(String log, String pass, double sald){ //Construtor da Conta
        this.login = log;
        this.senha = pass;
        this.saldo = sald;
    }

    public void transac(double valor) { //Método para as transações
        lock.lock(); // Bloqueia o acesso para evitar acesso simultâneo

        try {
            double novoSaldo = saldo - valor;
            if (novoSaldo >= 0) {
                saldo = novoSaldo;

                // Registra a transação com timestamp em nanossegundos
                long timestamp = System.nanoTime();
                System.out.println("Transação realizada por " + login + ": $" + valor + ", Saldo: $" + saldo + ", Timestamp: " + timestamp);
            } else {
                System.out.println("Saldo insuficiente.");
            }
        } finally {
            lock.unlock(); // Libera o acesso
        }
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void setSaldo(double saldonovo){
        this.saldo = saldonovo;
    }

    public String getSenha(){
        return this.senha;
    }

    //Método para execução da Thread
    public void run(){

    }
}
