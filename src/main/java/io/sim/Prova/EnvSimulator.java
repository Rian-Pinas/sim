package io.sim.Prova;

import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;
import it.polito.appeal.traci.SumoTraciConnection;

import de.tudresden.sumo.objects.SumoColor;

public class EnvSimulator extends Thread{

    private SumoTraciConnection sumo;

    public EnvSimulator(){

    }

	@Override
    public void run(){

		/* SUMO */
		String sumo_bin = "sumo-gui";		
		String config_file = "map/map.sumo.cfg";
		
		// Sumo connection
		this.sumo = new SumoTraciConnection(sumo_bin, config_file);
		sumo.addOption("start", "1"); // auto-run on GUI show
		sumo.addOption("quit-on-end", "1"); // auto-close on end

		try {
			sumo.runServer(1234);

			

			ABank banco = new ABank(6000);
			Company comp = new Company("data/dados2.xml", 5000);
			comp.start();
			banco.start();
			Thread.sleep(5000);

			int fuelType = 2;
			int fuelPreferential = 2;
			double fuelPrice = 5.87;
			int personCapacity = 1;
			int personNumber = 1;
			Random rand = new Random();

			ArrayList<Car> carros = new ArrayList<Car>();
			for (Integer motorista=0; motorista<1; motorista++){
				System.out.println("Created car");
				Route _rota = comp.getNextRoute();
				SumoColor _color = new SumoColor(rand.nextInt(255)+100, rand.nextInt(255)+100, rand.nextInt(255)+100, 255);
				Car _car = new Car("CAR" + motorista.toString(), _rota , sumo, _color, 500, personCapacity, personNumber);
				carros.add(_car);
			}

			for (Car c : carros){
				Thread thread = new Thread(c, c.getId());
				thread.start();
			}

			while (true) {
				try {
					this.sumo.do_timestep();
					Thread.sleep(100);
				} catch (Exception e) {

				}
			}

			
		
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

    }

}
