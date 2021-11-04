package com;

import java.util.Scanner;

public class Cliente {

	private String nome;
	private ContaCorrente conta;
	
	
	//O construtor recebe um nome(do cliente) e o número da conta (que será atribuido à instância da conta corrente)
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

	
	//Realiza as operações de saque e depósito com valores recebidos do usuário pelo Scanner
	public void opera() {
		Scanner sc = new Scanner(System.in);
		int escolha;
		double dep;
		double saq;
		
		System.out.println("\nOlá " + nome);
		System.out.print("Valor a ser depositado: R$");
		dep = sc.nextDouble();
		System.out.print("Valor a ser sacado: R$");
		saq = sc.nextDouble();
		
		conta.depositaValor(dep);
		conta.retiraValor(saq);
		
		
	}
}
