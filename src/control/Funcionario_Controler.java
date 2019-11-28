package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import model.Funcionario;

public class Funcionario_Controler { // nome;fk_cargo;cpf;salario;bancoHora;cargaHora;dependentes
	private String archive = "./funcionarios";

	public void save(Funcionario funcionario) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(archive, true));
		writer.append(String.format("%s;%s;%s;%s;%s;%s;%s", funcionario.getNome(), funcionario.getFk_cargo(),
				funcionario.getCpf(), funcionario.getSalario(), funcionario.getBanco_Horas(),
				funcionario.getCarga_horaria(), funcionario.getDependentes()));
		writer.newLine();
		writer.close();
	}

	public Funcionario[] getAll() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(archive));
		int counter = 0;
		while (reader.readLine() != null)
			counter++;
		reader.close();
		reader = new BufferedReader(new FileReader(archive));
		Funcionario funcionarios[] = new Funcionario[counter];
		for (int i = 0; reader.ready(); i++) {
			String data = reader.readLine();
			Funcionario bolsominion = new Funcionario();
			bolsominion.setCpf(Long.parseLong(data.split(";")[2]));
			bolsominion.setFk_cargo(Integer.parseInt(data.split(";")[1]));
			bolsominion.setNome(data.split(";")[0]);
			bolsominion.setSalario(Double.parseDouble(data.split(";")[3]));
			bolsominion.setBanco_Horas(Double.parseDouble(data.split(";")[4]));
			bolsominion.setCarga_horaria(Double.parseDouble(data.split(";")[5]));
			bolsominion.setDependentes(Integer.parseInt(""+data.split(";")[6]));
			funcionarios[i] = bolsominion;
		}
		reader.close();
		return funcionarios;
	}

	public Funcionario[] getByName(String name) throws IOException {
		Funcionario_Controler c_funcionario = new Funcionario_Controler();
		Funcionario[] funcionarios = c_funcionario.getAll();
		Funcionario[] returnFuncionarios;
		ArrayList<Funcionario> listaFuncionarioDone = new ArrayList<>();
		int counter = 0;
		for (int i = 0; i < funcionarios.length; i++) {
			if (funcionarios[i].getNome() == name) {
				listaFuncionarioDone.add(funcionarios[i]);
				counter++;
			}
		}
		returnFuncionarios = new Funcionario[counter];
		Iterator<Funcionario> iterator = listaFuncionarioDone.iterator();
		for (int i = 0; iterator.hasNext(); i++) {
			returnFuncionarios[i] = iterator.next();
		}
		return returnFuncionarios;
	}

	public Funcionario[] getByCargo(Long cargo) throws IOException {
		Funcionario_Controler c_funcionario = new Funcionario_Controler();
		Funcionario[] funcionarios = c_funcionario.getAll();
		Funcionario[] returnFuncionarios;
		ArrayList<Funcionario> listaFuncionarioDone = new ArrayList<>();
		int counter = 0;
		for (int i = 0; i < funcionarios.length; i++) {
			if (funcionarios[i].getFk_cargo() == cargo) {
				listaFuncionarioDone.add(funcionarios[i]);
				counter++;
			}
		}
		returnFuncionarios = new Funcionario[counter];
		Iterator<Funcionario> iterator = listaFuncionarioDone.iterator();
		for (int i = 0; iterator.hasNext(); i++) {
			returnFuncionarios[i] = iterator.next();
		}
		return returnFuncionarios;
	}

	public Funcionario getByCpf(Long cpf) throws IOException { // only return one, whe dont have the primary key and not
																// equals to make it easy
		Funcionario_Controler c_funcionario = new Funcionario_Controler();
		Funcionario[] funcionarios = c_funcionario.getAll();
		Funcionario returnFuncionario = new Funcionario();
		;
		ArrayList<Funcionario> listaFuncionarioDone = new ArrayList<>();
		int counter = 0;
		for (int i = 0; i < funcionarios.length; i++) {
			if (funcionarios[i].getCpf() == cpf) {
				listaFuncionarioDone.add(funcionarios[i]);
				counter++;
			}
		}
		Iterator<Funcionario> iterator = listaFuncionarioDone.iterator();
		for (int i = 0; iterator.hasNext(); i++) {
			returnFuncionario = iterator.next();
			break;
		}
		return returnFuncionario;
	}
}
