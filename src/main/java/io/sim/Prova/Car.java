package io.sim.Prova;

import de.tudresden.sumo.cmd.Vehicle;
import de.tudresden.sumo.objects.SumoColor;
import it.polito.appeal.traci.SumoTraciConnection;

/* Tratamentos da classe Carro */

public class Car extends Vehicle implements Runnable {
    private double FuelTank;
    private String id;
    private SumoTraciConnection sumo;
    private TransportService ts;
    private SumoColor color;
    private Route rota;
    private long aquisitionRate;
    private int personCapacity;
    private int personNumber;
    //Cliente da Company

    public Car(String ident, Route _rota, SumoTraciConnection _sumo, SumoColor _cor, long _aquisitionRate, int _capacity, int _personNumber){ //Construtor do carro
        this.FuelTank = 10;
        this.id = ident;
        this.sumo = _sumo;
        this.rota = _rota;
        this.color = _cor;
        this.personCapacity = _capacity;
        this.personNumber = _personNumber;
        this.aquisitionRate = _aquisitionRate;
        ts = new TransportService(false, ident, this, sumo);
    }

    public void gastaCombus(){
        try {
            double aux;
            aux = (double) sumo.do_job_get(Vehicle.getFuelConsumption(this.id));
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

    public Route getRoute() {
        return this.rota;
    }
    
    public String getId() {
        return this.id;
    }

    public int getPersonCapacity() {
        return this.personCapacity;
    }

    public int getPersonNumber() {
        return this.personNumber;
    }

    public long getAcquisitionRate() {
        return this.aquisitionRate;
    }

    public void setFuelTank(double litros){
        this.FuelTank += litros;
    }

    public SumoColor getColor() {
        return this.color;
    }

    @Override
    public void run(){
        try {
            ts.setOn_off(true);
            ts.start();
            Thread.sleep(500);
            try {
                String currentEdge = (String) this.sumo.do_job_get(Vehicle.getRoadID(this.id));
                while (!rota.isEnded(currentEdge)) {   
                    currentEdge = (String) this.sumo.do_job_get(Vehicle.getRoadID(this.id));
                    Thread.sleep(500);
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                ts.setOn_off(false);
                System.out.println("Carro " + this.id + " terminou a rota");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
