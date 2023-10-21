package io.sim.Prova;

import de.tudresden.sumo.cmd.Vehicle;

/* Tratamentos da classe Carro */

public class Car extends Vehicle implements Runnable {
    private double FuelTank;
    private String id;
    private FStation fuelstate;
    private Auto auto;
    private TransportService ts;
    //Cliente da Company

    public Car(String ident, Auto auto, TransportService ts){ //Construtor do carro
        this.FuelTank = 10;
        this.id = ident;
        this.auto = auto;
        this.ts = ts;
    }

    public String getID(){
        return id;
    }

    public void gastaCombus(){
        //Pega o valor que está sendo gasto de gasolina
        //decrementa esse valor do FuelTank
        try {
            double aux;
            aux = (double) auto.getSumo().do_job_get(Vehicle.getFuelConsumption(this.id));
            FuelTank -= aux;
            if (FuelTank <= 3){
                this.abastecer();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public Auto getAuto(){
        return this.auto;
    }

    public void setFuelTank(double litros){
        this.FuelTank += litros;
    }

    //Método para execução da Thread
    public void run(){
        
    }
}
