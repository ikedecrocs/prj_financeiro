package view;

import javax.swing.*;
import java.awt.*;

public class splash extends JWindow{
	
	JLabel carregando, extra;
	int duracao;

	public splash(int d) {
		duracao = d;
	}
	
	public void iniciar() {
		JPanel conteudo = (JPanel) getContentPane();
		conteudo.setBackground(new Color(194, 249, 153));
		setBounds(0, 0, 400, 100);
		
		carregando = new JLabel("Carregando...", JLabel.CENTER);
		extra = new JLabel("Atividade LP/ESW", JLabel.CENTER);
		
		conteudo.add(carregando, BorderLayout.CENTER);
		conteudo.add(extra, BorderLayout.SOUTH);
		conteudo.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0), 10));
		
		setVisible(true);
		setLocationRelativeTo(null);
		
		try {
			Thread.sleep(duracao * 1000);
		}catch(Exception e){}
		dispose();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		splash loading = new splash(1);
		loading.iniciar();
		login inicio = new login();
	}

}
