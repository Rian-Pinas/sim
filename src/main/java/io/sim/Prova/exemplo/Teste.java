package io.sim.Prova.exemplo;

import java.util.ArrayList;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Banco banco = new Banco();
		
		ArrayList<Conta> contas = new ArrayList<>();
		
		Conta conta = new Conta(1000);
		
		contas.add(conta);

		ArrayList<Cliente> clientes = new ArrayList<>();
		
		clientes.add(new Cliente(
				"Paulo da Silva", banco, contas.get(0)));
		
		clientes.add(new Cliente(
				"Maur�cio da Silva", banco, contas.get(0)));
		clientes.add(new Cliente(
				"Fernando da Silva", banco, contas.get(0)));

		for (int i = 0; i < clientes.size(); i++) {
			clientes.get(i).start();
		}
	}
}
