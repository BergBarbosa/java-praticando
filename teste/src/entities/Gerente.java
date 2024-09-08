package entities;

public class Gerente extends Funcionario {
	private String department;

	public Gerente() {
	}

	public Gerente(Integer id, String name, Integer age, Double salary, String department) {
		super(id, name, age, salary);
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public void calcularBonus(double percentage) {
		salary += salary * percentage / 100;
	}

	public String toString() {
		return getDepartment();
	}

}
