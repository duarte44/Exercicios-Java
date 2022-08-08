package curso_programacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);		
		
		List<Pessoa> list = new ArrayList<>();
		
		double sum = 0;
		
		System.out.print("Quantos contribuintes? ");
		int cont = sc.nextInt();
		
		for(int i = 0; i<cont; i++) {
		System.out.println("Data #" + (i+1));
			
		System.out.print("Pessoa Física ou Juridica (f/n) ? ");
		char ch = sc.next().charAt(0);
		
		//Ler quantidade
		
		if(ch == 'f') {
			System.out.println();
			System.out.print("Digite seu nome: ");
			sc.next();
			String nome = sc.nextLine();
			//Ler nome
			
			System.out.print("Digite seu salario: ");
			double salario = sc.nextDouble();
			//ler salario
			
			System.out.print("Gasto com saude: ");
			double saude = sc.nextDouble();
			//ler gastos com saude			
			list.add(new PessoaFisica(nome, salario, saude));
			//add na lista as pessoas Fisicas
			
			}
		else {
			System.out.println();
			System.out.print("Digite seu nome: ");
			sc.next();
			String nome = sc.nextLine();
			//Ler nome
			
			System.out.print("Digite seu salario: ");
			double salario = sc.nextDouble();
			//ler salario
			
			System.out.print("Quantidade de pessoas na empresa: ");
			int imp = sc.nextInt();
			//Ler quantidade de pessoas na empresa
			
			list.add(new PessoaJuridica(nome, salario, imp));
			//add na lista as pessoas juridicas						
		}
		
		}
		System.out.println();
		System.out.println("TAXAS: ");
		
		for(Pessoa pessoa : list) {
			System.out.println();
			System.out.println(pessoa.getNome() + ": $ "+ String.format("%.2f", pessoa.renda()));
			sum += pessoa.renda();
		}
		System.out.println();
		
		System.out.printf("Total de taxas: %.2f", sum);
		
	}
}
