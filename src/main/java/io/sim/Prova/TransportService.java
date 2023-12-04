package io.sim.Prova;

import de.tudresden.sumo.cmd.Route;
import de.tudresden.sumo.cmd.Vehicle;
import de.tudresden.sumo.objects.SumoStringList;
import it.polito.appeal.traci.SumoTraciConnection;

public class TransportService extends Thread {

	private String idTransportService;
	private boolean on_off;
	private SumoTraciConnection sumo;
	private Car car;

	public TransportService(boolean _on_off, String _idTransportService, Car _car, SumoTraciConnection _sumo) {
		this.on_off = _on_off;
		this.idTransportService = _idTransportService;
		this.car = _car;
		this.sumo = _sumo;
	}

	@Override
	public void run() {
		try {
			
			this.initializeRoutes();

			while (this.on_off) {
				Thread.sleep(this.car.getAcquisitionRate());
				if (this.getSumo().isClosed()) {
					this.on_off = false;
					System.out.println("SUMO is closed...");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initializeRoutes() {
		System.out.println("Initializing routes... car " + this.car.getId() + " route " + this.car.getRoute().getId());
		SumoStringList edge = new SumoStringList();
		edge.clear();
		String aux = this.car.getRoute().getEdge();

		for (String e : aux.split(" ")) {
			edge.add(e);
		}

		try {
			sumo.do_job_set(Route.add(this.car.getRoute().getId(), edge));

			sumo.do_job_set(Vehicle.addFull(this.car.getId(), 				//vehID
											this.car.getRoute().getId(), 	//routeID 
											"DEFAULT_VEHTYPE", 					//typeID 
											"now", 								//depart  
											"0", 								//departLane 
											"0", 								//departPos 
											"0",								//departSpeed
											"current",							//arrivalLane 
											"max",								//arrivalPos 
											"current",							//arrivalSpeed 
											"",									//fromTaz 
											"",									//toTaz 
											"", 								//line 
											this.car.getPersonCapacity(),		//personCapacity 
											this.car.getPersonNumber())		//personNumber
					);
			
			sumo.do_job_set(Vehicle.setColor(this.car.getId(), this.car.getColor()));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public boolean isOn_off() {
		return on_off;
	}

	public void setOn_off(boolean _on_off) {
		this.on_off = _on_off;
	}

	public String getIdTransportService() {
		return this.idTransportService;
	}

	public SumoTraciConnection getSumo() {
		return this.sumo;
	}
}