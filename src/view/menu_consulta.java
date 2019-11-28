package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class menu_consulta extends JDialog {

	JButton nome, cpf, cargo;
	JLabel titulo;
	
	public menu_consulta(Frame dono, boolean modal) {
		//geral (inicio)
		super(dono, "Consultas", modal);
		Container tela = getContentPane();
		ImageIcon icone_tela = new ImageIcon("Icones/coin.png");
		tela.setLayout(null);
		setIconImage(icone_tela.getImage());

		//definições
		nome = new JButton("Consulta por Nome");
		cargo = new JButton("Consulta por Cargo");
		cpf = new JButton("Consulta por CPF");
		titulo = new JLabel("Consultas");
		titulo.setFont(new Font("Arial", Font.BOLD, 18));
		
		//setBounds(começo em X, começo em Y, Comprimento, Altura)
		titulo.setBounds(80, 15, 200, 20);
		nome.setBounds(23, 50, 200, 30);
		cargo.setBounds(23, 90, 200, 30);
		cpf.setBounds(23, 130, 200, 30);
		
		//eventos
		nome.addActionListener(
		         new ActionListener() {
		            public void actionPerformed( ActionEvent e ) {
		            	tela_con_nome janela_con_nome = new tela_con_nome(null, true);
			            janela_con_nome.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			            janela_con_nome.setVisible(true);
		            }
		         }
		);
		
		cargo.addActionListener(
		         new ActionListener() {
		            public void actionPerformed( ActionEvent e ) {
		            	tela_con_cargo janela_con_cargo = new tela_con_cargo(null, true);
			            janela_con_cargo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			            janela_con_cargo.setVisible(true);
		            }
		         }
		);
		
		cpf.addActionListener(
		         new ActionListener() {
		            public void actionPerformed( ActionEvent e ) {
		            	tela_con_cpf janela_con_cpf = new tela_con_cpf(null, true);
			            janela_con_cpf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			            janela_con_cpf.setVisible(true);
		            }
		         }
		);
		
		//add no Container
		tela.add(nome);
		tela.add(cargo);
		tela.add(cpf);
		tela.add(titulo);
		
		//geral (final)
		setSize(250, 210);
		setLocationRelativeTo(null);
		setResizable(false);
		tela.setBackground(new Color(194, 249, 153));
	}
	
}
