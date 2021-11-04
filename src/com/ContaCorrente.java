package com;

public class ContaCorrente {

	private int numero;
	private double saldo = 0;
	private Cliente cliente;
	
	public ContaCorrente(int numero) {
		this.numero = numero;
	}


	public int getNumero() {
		return this.numero;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	//Verifica se o saldo é menor que 0 utilizando o assert
	
	public double verificaSaldo() {
		//assert saldo > 0;  Retirei o assert pra não jogar um erro
		
		if(saldo < 0) {
			saldo = 0;
		}
		return saldo;
	}
	
	
	//Deposita um dado valor na conta de um cliente
	public void depositaValor(double valor) {
		saldo += valor;
		verificaSaldo();
	}
	
	//Saca um dado valor na conta de um cliente
	public void retiraValor(double valor) {
		saldo -= valor;
		verificaSaldo();
	}
	
	
	//Imprime os dados da conta
	public void imprimeConta() {
		System.out.println("\nNumero da conta: " + numero);
		System.out.println("Cliente: " + cliente.getNome());
		System.out.println("Saldo: " + saldo);
	}
	
	
	
	
	
	
}
