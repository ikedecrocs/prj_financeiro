package model;

public class Funcionario { // nome;fk_cargo;cpf;salario
	private String nome;
	private int fk_cargo, dependentes;
	private long cpf;
	private double salario, banco_Horas, carga_horaria;

	public void printAllCamps_funcionario(Funcionario f) {
		System.out.println(String.format(
				"+-----------------------------------------------------------+\n" + "+name: %s\n" + "+cpf: %s\n"
						+ "+post: %s\n" + "+salary: %s\n" + "+Horary Amount: %s\n"
						+ "+Horary Charge: %s\n+Dependentes: %s\n",
				f.getNome(), f.getCpf(), f.getFk_cargo(), f.getSalario(), f.getBanco_Horas(), f.getCarga_horaria(),
				f.getDependentes()));
	}

	public int getDependentes() {
		return dependentes;
	}

	public void setDependentes(int dependentes) {
		this.dependentes = dependentes;
	}

	public double getBanco_Horas() {
		return banco_Horas;
	}

	public void setBanco_Horas(double banco_Horas) {
		this.banco_Horas = banco_Horas;
	}

	public double getCarga_horaria() {
		return carga_horaria;
	}

	public void setCarga_horaria(double carga_horaria) {
		this.carga_horaria = carga_horaria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getFk_cargo() {
		return fk_cargo;
	}

	public void setFk_cargo(int fk_cargo) {
		this.fk_cargo = fk_cargo;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
