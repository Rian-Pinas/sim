package io.sim.Prova;

import de.tudresden.sumo.cmd.Vehicle;
import it.polito.appeal.traci.SumoTraciConnection;

/* Tratamentos da classe Carro */

public class Car extends Vehicle implements Runnable {
    private double FuelTank = 10;
    private SumoTraciConnection sumo;
    private String id;
    private FStation fuelstate;
    //Cliente da Company

    public Car(String ident){ //Construtor do carro
        this.id = ident;
    }

    public String getID(){
        return id;
    }

    public void gastaCombus(){
        //Pega o valor que está sendo gasto de gasolina
        //decrementa esse valor do FuelTank
        //private double auxComb = (double)this.sumo.do_job_get(Vehicle.getFuelConsumption(this.id));
    }

    public void abastecer(){
        //Se o valor do FuelTank for = 3
        //Abastece o veículo
        //Para o carro por 2 minutos

        //No caso isso acontece na classe driver e na fuel station
        //Quem deve abastercer é a fuel station
        //apenas ela poderá acrescentar o equivalente em litros
        //via método Fuel Tank do Car.
    }

    /*public void setFuelTank(double litros){
        try{
        this.sleep(120000); //Espera 2 minutos
        this.FuelTank = litros; //Enche o tanque
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    //Método para execução da Thread
    public void run(){
        while (true){
            try {
                synchronized(fuelstate) {
                    while(!fuelstate.disponivel) {
                        fuelstate.wait();
                    }
                    fuelstate.disponivel = false;
                    fuelstate.notifyAll();
                }
            } catch (Exception e){}
        }
    }
}
