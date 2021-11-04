package com;

import java.util.Scanner;

public class Cliente {

	private String nome;
	private ContaCorrente conta;
	
	
	//O construtor recebe um nome(do cliente) e o n�mero da conta (que ser� atribuido � inst�ncia da conta corrente)
	public Cliente(String nome, int numero) {
		this.nome = nome;
		this.conta = new ContaCorrente(numero);
		this.conta.setCliente(this);
	}
	

	public String getNome() {
		return nome;
	}

	public ContaCorrente getConta() {
		return conta;
	}

	
	//Realiza as opera��es de saque e dep�sito com valores recebidos do usu�rio pelo Scanner
	public void opera() {
		Scanner sc = new Scanner(System.in);
		int escolha;
		double dep;
		double saq;
		
		System.out.println("\nOl� " + nome);
		System.out.print("Valor a ser depositado: R$");
		dep = sc.nextDouble();
		System.out.print("Valor a ser sacado: R$");
		saq = sc.nextDouble();
		
		conta.depositaValor(dep);
		conta.retiraValor(saq);
		
		
	}
}
