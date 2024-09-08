package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Funcionario;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		List<Funcionario> list = new ArrayList<>();
		Funcionario funcionario = new Funcionario();

		System.out.print("Quantos funcionários serão cadastrados? ");
		int quantity = sc.nextInt();

		for (int i = 0; i < quantity; i++) {
			System.out.println();
			System.out.println("Digite os dados do " + (i + 1) + "° " + "funcionário: ");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Idade: ");
			Integer age = sc.nextInt();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			System.out.print("Is there a department S/N? ");
			char resp = sc.next().charAt(0);
			if (resp == 'S' || resp == 's') {
				System.out.print("Department: ");
				String department = sc.next();
				funcionario = new Funcionario(id, name, age, salary, department);
			} else {
				funcionario = new Funcionario(id, name, age, salary);
			}
			list.add(funcionario);
		}

		System.out.println();
		System.out.println("Lista de funcionários:");
		for (Funcionario f : list) {
			System.out.println(f);
		}
		
		System.out.println();
		System.out.print("Digite o id do funcionário que vai receber uma bonificaçao: ");
		int idToBonus = sc.nextInt();

		Funcionario func = list.stream().filter(x -> x.getId() == idToBonus).findFirst().orElse(null);

		if (func == null) {
			System.out.println("ESTE ID NÃO EXISTE!");
		} else {
			System.out.print("Digite a porcentagem da bonificação do funcionário: ");
			double bonus = sc.nextDouble();
			funcionario.calcularBonus(bonus);
		}
		System.out.println();
		System.out.print("Digite o id do funcionário que irá entrar de férias: ");
		int idToVacation = sc.nextInt();
		Funcionario funcADescansar = list.stream().filter(x -> x.getId() == idToVacation).findFirst().orElse(null);
		if (funcADescansar == null) {
			System.out.println("ESTE ID NÃO EXISTE");
		} else {
			funcADescansar.descansar();
			
		}

		System.out.println();
		System.out.println("Lista de funcionários atualizados:");
		for (Funcionario f : list) {
			System.out.println(f);
			
		}

		sc.close();
	}

}
