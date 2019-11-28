package view;

import javax.swing.*;

import control.Cargo_Controler;
import model.Cargo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class tela_cad_cargo extends JDialog{
	
	//add id_cargo, nome_cargo
	
	JButton cadastrar;
	JLabel titulo, labelNome;
	JTextField nome;

	public tela_cad_cargo(Frame dono, boolean modal) {
		//geral (inicio)
		super(dono, "Cadastro de Cargo", modal);
		Container tela = getContentPane();
		ImageIcon icone_tela = new ImageIcon("Icones/coin.png");
		tela.setLayout(null);
		setIconImage(icone_tela.getImage());
		
		//definições
		cadastrar = new JButton("Cadastrar");
		titulo = new JLabel("Cadastro de Cargo");
		titulo.setFont(new Font("Arial", Font.BOLD, 16));
		labelNome = new JLabel("Nome:");
		nome = new JTextField("");
		
		//setBounds
		titulo.setBounds(59, 15, 200, 20);
		labelNome.setBounds(15, 45, 50, 20);
		nome.setBounds(75, 45, 170, 20);
		cadastrar.setBounds(10, 80, 244, 30);
		
		//eventos
		cadastrar.addActionListener(
		         new ActionListener() {
		            public void actionPerformed( ActionEvent e ) {
		              try {
		            	if(nome.getText().equals("")) {
		            		JOptionPane.showMessageDialog(null, "Preencha o campo Nome");
		            		nome.requestFocus();
		            	}else if(nome.getText().length() > 50) {
		            		JOptionPane.showMessageDialog(null, "Nome deve usar menos de 50 caracteres");
		            		nome.requestFocus();
		            	}else {
		            		Cargo cargo = new Cargo();
		            		Cargo_Controler cc = new Cargo_Controler();
		            		Cargo[] vetor = cc.getAll();
		            		cargo.setPk_id(vetor.length);
		            		cargo.setNome(nome.getText());
		            		cc.save(cargo);
		            		nome.setText("");
		            		JOptionPane.showMessageDialog(null, "Cargo Cadastrado!");
		            	}
		              }catch(IOException io) {}
		              }
		         }
		);
		
		//add no Container
		tela.add(titulo);
		tela.add(labelNome);
		tela.add(nome);
		tela.add(cadastrar);
		
		//geral (final)
		setSize(270, 150);
		setLocationRelativeTo(null);
		setResizable(false);
		tela.setBackground(new Color(194, 249, 153));
	}
}
