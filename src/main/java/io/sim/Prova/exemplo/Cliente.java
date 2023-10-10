package io.sim.Prova.exemplo;

public class Cliente extends Thread{
	
	private Banco banco;
	private Conta conta;
	private double valor = 200; // saques de R$ 200,00
	private double saques = 0;
	
	public Cliente(String _nome, Banco _banco, Conta _conta){
		super(_nome);
		this.banco = _banco;
		this.conta = _conta;
		
	}
	
	@SuppressWarnings("static-access")
	public void run(){
		double total = 0;
		while (this.banco.saque(this.conta, this.valor)) {
			try {
				total = total + this.valor;
				this.saques = this.saques + this.valor;
				System.out.println(this.getName() + " sacou R$ " + this.valor
							+ ". Saldo total �: R$ " + this.conta.getSaldo());
				
				System.out.println("Total de saques por: " + this.getName() + ": R$ " + this.saques);
				
				this.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
}