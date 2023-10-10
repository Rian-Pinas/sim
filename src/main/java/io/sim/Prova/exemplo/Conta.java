package io.sim.Prova.exemplo;

public class Conta {
	
	private double saldo;
	
	public Conta(double _saldo){
		this.saldo = _saldo;
		System.out.println(
				"A conta foi criada. "
						+ "Saldo inicial: R$ " + this.saldo);
	}
	
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	/*
	public synchronized double getSaldo() {
		return saldo;
	}

	public synchronized void setSaldo(double saldo) {
		this.saldo = saldo;
	}*/
		
}