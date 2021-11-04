package com;

import java.util.ArrayList;
import java.util.Scanner;

public class Banco {

	private String nome;
	//Cria e instancia uma coleção de clientes
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	public Banco(String nome) {
		this.nome = nome;
	}
	
	//Adiciona um cliente ao Arraylist de objetos
	public void addCliente(Cliente cliente) {
		
		clientes.add(cliente);
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int option = 0;
		boolean logged = false;
		
		//Cria um banco, 3 clientes e realiza as operações de saque e depósito com os clientes
		Banco banco = new Banco("Santander");
		
		int accountNum = 0;
		
		
		
		while(true) {
			menu();

	        option = Integer.parseInt(sc.nextLine());
	        
	        switch(option) {
	        	case 1: {
	        		
	        		String name;
	        		int num;
	        		
	        		System.out.println("Digite o nome do titular: ");
	        		name = sc.nextLine();
	        		
	        		System.out.println("Digite o número da conta: ");
	        		num = Integer.parseInt(sc.nextLine());
	        		
	        		Cliente cliente = new Cliente(name, num);
	        		
	        		Cliente found = null;
	        		
	        		for(Cliente fetch : banco.clientes) {
	        			if(fetch.getConta().getNumero() == num) {
	        				found = fetch;
	        				break;
	        			}
	        		
	        		}
	        		
	        		if(found != null) {
	        			System.out.println("Conta já registrada");
	        		}
	        		
	        		else {
	        			banco.addCliente(cliente);
	        		}
	        	break;
	        	}
	        	
	        	case 2:{
	        		System.out.println("Digite o número da conta: ");
	        		
	        		int conta = Integer.parseInt(sc.nextLine());
	        		Cliente found = null;
	        		
	        		for(Cliente fetch : banco.clientes) {
	        			if(fetch.getConta().getNumero() == conta) {
	        				found = fetch;
	        				break;
	        			}
	        		
	        		}
	        		
	        		if(found != null) {
	        			found.getConta().imprimeConta();
	        		}
	        		else {
	        			System.out.println("Conta corrente não encontrada.");
	        		}
	        	break;
	        	}
	        	
	        	case 3:{
	        		System.out.println("Digite o número da conta: ");
	        		
	        		int conta = Integer.parseInt(sc.nextLine());
	        		Cliente found = null;
	        		
	        		for(Cliente fetch : banco.clientes) {
	        			if(fetch.getConta().getNumero() == conta) {
	        				found = fetch;
	        				break;
	        			}
	        		
	        		}
	        		
	        		if(found != null) {
	        			System.out.println("---Olá " + found.getNome() + "---");
	        			found.getConta().imprimeConta();
	        			accountNum = clientes.indexOf(found);
	        			logged = true;
	        			
	        		}
	        		else {
	        			System.out.println("Conta corrente não encontrada.");
	        		}
	        	break;
	        	}
	        	
	        	case 4: {
	        		
	        		if(logged == true) {
		        		double value;
		        		
		        		System.out.println("Digite o valor a ser sacado: ");
		        		value = Double.parseDouble(sc.nextLine());
		        		if(value <= 0) {
		        			System.out.println("O valor deve ser maior do que 0.");
		        		}
		        		else {
		        			clientes.get(accountNum).getConta().retiraValor(value);
			        		clientes.get(accountNum).getConta().imprimeConta();
		        		}
		        		
		        		
	        		}
	        		else {
	        			System.out.println("Você não está logado.");
	        		}
	        		
	        	break;
	        	}
	        	
	        	case 5: {
	        		if(logged == true) {
		        		double value;
		        		
		        		System.out.println("Digite o valor a ser depositado: ");
		        		value = Double.parseDouble(sc.nextLine());
		        		if(value <= 0) {
		        			System.out.println("O valor deve ser maior do que 0.");
		        		}
		        		else {
			        		clientes.get(accountNum).getConta().depositaValor(value);
			        		clientes.get(accountNum).getConta().imprimeConta();
		        		}
	        		}
	        		else {
	        			System.out.println("Você não está logado.");
	        		}
	        	break;
	        	}
	        	
	        	case 6: {
	        		
	        		System.out.println("---Clientes---");
	        		
	        		for(int i = 0; i < clientes.size(); i++) {
	        			System.out.println(clientes.get(i).getNome());
	        		}
	            break;
	        	}
	        	
	        	case 7: {
	        		System.out.println("Programa Encerrado");

	                System.exit(0);
	            break;
	        	}
	        	default:{

	                System.out.println("Opção inválida");

	            }
	        		
	        }
		}		
				
	}
	
	
	public static void menu() {
		System.out.println("\nMenu de Opções :");

	    System.out.println("1 : Cadastrar Cliente");

	    System.out.println("2 : Consultar Cliente");
	    
	    System.out.println("3 : Entrar");

	    System.out.println("4 : Sacar ");

	    System.out.println("5 : Depositar ");
	    
	    System.out.println("6 : Listar Clientes ");

	    System.out.println("7 : Sair ");
	}
}
