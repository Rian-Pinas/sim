package io.sim.Prova;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Relatorio {
    private String timestamp, fuelType;
    private int id_car, id_route;
    private double speed, distance, fuelConsumption, CO2, longitude, latitude;

    public Relatorio (String timestamp,int id_car,int id_route,double speed,double distance,double fuelConsumption,String Fueltype,double CO2,double longitude,double latitude){
        this.timestamp = timestamp;
        this.id_car = id_car;
        this.id_route = id_route;
        this.speed = speed;
        this.distance = distance;
        this.fuelConsumption = fuelConsumption;
        this.fuelType = Fueltype;
        this.CO2 = CO2;
        this.longitude = longitude;
        this.latitude = latitude;
    }
/* 
    public void dados() {
        // Simulação de coleta de dados do SUMO (substitua por sua lógica real)
            "Timestamp " + timestamp, 
            "ID Car " + id_car, 
            "ID Route " + id_route,
            "Speed " + speed,
            "Distance " + distance, 
            "FuelConsumption " + fuelConsumption, 
            "FuelType" + fuelType, 
            "CO2Emission " + CO2, 
            "longitude " + longitude, 
            "latitude " + latitude;
        
        // Caminho para o arquivo CSV de saída
        String csvFilePath = "relatorio_sumo.csv";

        try {
            // Cria um BufferedWriter para escrever no arquivo CSV
            BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath));

            // Escreve os dados do SUMO no arquivo CSV
            for (String line : sumoData) {
                writer.write(line);
                writer.newLine();
            }

            // Fecha o BufferedWriter
            writer.close();

            System.out.println("Dados do SUMO foram salvos em " + csvFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/}
