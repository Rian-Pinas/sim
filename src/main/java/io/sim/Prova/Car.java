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

    /*private double havsin(double distancia, double lati, double longi, double latf, double longf) {
        double rterra = 6371000; //Raio da terra para latitude e longitude

        // Difereça de latitude final e inicial
        double latdif = Math.toRadians(latf - lati);
        double longdif = Math.toRadians(longf - longi);

        // Fórmula para cálculo encontrada na internet (Haversine)
        double d = Math.sin(latdif / 2) * Math.sin(latdif / 2) +
                Math.cos(Math.toRadians(lati)) * Math.cos(Math.toRadians(latf)) *
                Math.sin(longdif / 2) * Math.sin(longdif / 2);
        double aux = 2 * Math.atan2(Math.sqrt(d), Math.sqrt(1 - d));
        double dis = rterra * aux;

        return distancia + dis;
    }*/

    @Override
    public void run(){
        try {
            for(int i=0; i<100; i++) {
                ts = new TransportService(false, this.id, this, sumo);
                ts.setOn_off(true);
                ts.start();
                Thread.sleep(500);

                

                try {
                    String currentEdge = (String) this.sumo.do_job_get(Vehicle.getRoadID(this.id));
                    while (!rota.isEnded(currentEdge)) {   
                        currentEdge = (String) this.sumo.do_job_get(Vehicle.getRoadID(this.id));
                        Thread.sleep(500);
                        System.out.println(this.getId() + "Edge atual: " + currentEdge);

                        if (currentEdge.equals("15240253#0")){
                            System.out.println("Sensor 1");
                            //Adquirir dados
                        }

                        if (currentEdge.equals("15240253#2")){
                            System.out.println("Sensor 2");
                            //Adquirir dados
                        }

                        if (currentEdge.equals("586980042#0")){
                            System.out.println("Sensor 3");
                            //Adquirir dados
                        }

                        if (currentEdge.equals("589276468")){
                            System.out.println("Sensor 4");
                            //Adquirir dados
                        }

                        if (currentEdge.equals("795084568")){
                            System.out.println("Sensor 5");
                            //Adquirir dados
                        }
                    }
                } catch (Exception e){
                    e.printStackTrace();
                } finally {
                    ts.setOn_off(false);
                    System.out.println("Carro " + this.id + " terminou a rota");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
