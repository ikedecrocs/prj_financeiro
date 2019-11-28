package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Caixa_Controler {
	private String archive = "./caixa.txt";
	public void save(Double valor_caixa) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(archive));
		writer.write(""+valor_caixa);
		writer.close();
	}
	public Double read() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(archive));
		Double returnStatement = Double.parseDouble(reader.readLine());
		reader.close();
		return returnStatement;
	}
}
