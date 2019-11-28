package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class tela_con_cargo extends JDialog{
	
	JLabel titulo;
	JTextField pesquisa;
	JButton acao;
	JList lista;
	String[] teste = {"1", "2", "3", "4", "5", "6"}; //variavel de teste, inserir <List> depois
	
	public tela_con_cargo(Frame dono, boolean modal) {
		//geral (inicio)
		super(dono, "Consulta por Cargo", modal);
		Container tela = getContentPane();
		ImageIcon icone_tela = new ImageIcon("Icones/coin.png");
		tela.setLayout(null);
		setIconImage(icone_tela.getImage());
		
		//definições
		pesquisa = new JTextField("");
		acao = new JButton("Consultar");
		lista = new JList(teste);
		lista.setVisibleRowCount(5);
		JScrollPane rolagem = new JScrollPane(lista);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		titulo = new JLabel("Consulta por Cargo");
		titulo.setFont(new Font("Arial", Font.BOLD, 16));
		
		//setBounds
		titulo.setBounds(61, 15, 200, 20);
		pesquisa.setBounds(38, 50, 200, 20);
		acao.setBounds(85, 80, 100, 20);
		rolagem.setBounds(20, 125, 234, 125);
					
		//eventos
		acao.addActionListener(
		        new ActionListener() {
		            public void actionPerformed( ActionEvent e ) {
		               //inserir metodo consultar
		            }
		         }
		);
		
		//add no container
		tela.add(titulo);
		tela.add(pesquisa);
		tela.add(acao);
		tela.add(rolagem);
		
		//geral (final)
		setSize(280, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		tela.setBackground(new Color(194, 249, 153));
	}

}
