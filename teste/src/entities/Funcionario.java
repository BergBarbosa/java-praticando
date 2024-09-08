package entities;

public class Funcionario extends Pessoa {
	protected Double salary;
	
	public Funcionario() {
	}
	
	public Funcionario(Integer id, String name, Integer age, Double salary, String department) {
		super(id, name, age);
		this.salary = salary;
	}
	
	public Funcionario(Integer id, String name, Integer age, Double salary) {
		super(id, name, age);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void calcularBonus(double percentage) {
		salary += salary * percentage / 100;
	}

	@Override
	public void trabalhar() {
		System.out.println(getName() + " está trabalhando.");

	}

	@Override
	public void descansar() {
		System.out.println("Funcionário " + getName() + " entrará em período de férias.");

	}

	public String toString() {
		return "Id: " + getId() + ", " + "Nome: " + getName() + ", " + "Idade: " + getAge() + ", " + "Salário: " + String.format("%.2f", salary);
	}
}
