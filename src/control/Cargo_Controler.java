package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.Cargo;

public class Cargo_Controler {
	private String archive = "./cargos.txt";

	public void save(Cargo c) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(archive, true));
		writer.append(String.format("%s;%s", c.getPk_id(), c.getNome()));
		writer.newLine();
		writer.close();
	}

	public Cargo[] getAll() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(archive));
		int counter = 0;
		while (reader.readLine() != null)
			counter++;
		reader = new BufferedReader(new FileReader(archive));
		Cargo[] returnCargos = new Cargo[counter];
		for (int i = 0; i < counter; i++) {
			returnCargos[i] = new Cargo();
		}
		for (int i = 0; i < counter; i++) {
			String readed = reader.readLine();
			returnCargos[i].setPk_id(Integer.parseInt(readed.split(";")[0]));
			returnCargos[i].setNome(readed.split(";")[1]);
		}
		return returnCargos;
	}

	public Cargo getById(int id) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(archive));
		for (; reader.ready();) {
			String readed = reader.readLine();
			if (Integer.parseInt(readed.split(";")[0]) == id) {
				Cargo c = new Cargo();
				c.setPk_id(Integer.parseInt(readed.split(";")[0]));
				c.setNome(readed.split(";")[0]);
				return c;
			}
		}
		return null;
	}
}