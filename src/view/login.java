package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

public class login extends JFrame{
	
	JLabel rotuloUsuario, rotuloSenha, titulo;
	JTextField usuario;
	JPasswordField senha;
	JButton entrar;
	
	public login(){
		//geral (inicio)
		super("Login");
		Container tela = getContentPane();
		ImageIcon icone_tela = new ImageIcon("Icones/coin.png");
		tela.setLayout(null);
		setIconImage(icone_tela.getImage());
		
		//definições
		titulo = new JLabel("Login");
		titulo.setFont(new Font("Arial", Font.BOLD, 18));
		rotuloUsuario = new JLabel("Usuário:");
		rotuloSenha = new JLabel("Senha:");
		usuario = new JTextField("");
		senha = new JPasswordField(18);
		entrar = new JButton("Entrar");
		
		//setBounds
		titulo.setBounds(108, 13, 200, 20);
		rotuloUsuario.setBounds(15, 50, 50, 20);
		rotuloSenha.setBounds(15, 80, 50, 20);
		usuario.setBounds(70, 50, 170, 20);
		senha.setBounds(70, 80, 170, 20);
	    entrar.setBounds(10, 117, 244, 30);
		
		//eventos
	    entrar.addActionListener(
		         new ActionListener() {
		            public void actionPerformed( ActionEvent e ) {
		            try {
		            	BufferedReader leitor = new BufferedReader(new FileReader("Login.txt"));
		            	try {
		            		for(int c = 0; c < 1; c--) {
		            			String loginArquivado[] = new String[2];
		            			String aux;
		            			String senhaString = new String(senha.getPassword());
		            			aux = leitor.readLine();
		            			loginArquivado = aux.split(";");
		            			if(usuario.getText().equals(loginArquivado[0]) && senhaString.equals(loginArquivado[1])) {
		            				dispose();
		            				menu_principal menu = new menu_principal();
		            				break;
		            			}
		            		}
		            	}catch(Exception ex) {
		            		JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválidos", "Erro", JOptionPane.ERROR_MESSAGE,null);
		            		usuario.setText("");
		            		senha.setText("");
		            		usuario.requestFocus();
		            	}
		            }catch(IOException exe) {}
		            }
		         }
		);
		
		//Container add
	    tela.add(titulo);
	    tela.add(rotuloUsuario);
	    tela.add(rotuloSenha);
	    tela.add(usuario);
	    tela.add(senha);
	    tela.add(entrar);
		
		//geral (final)
	    setVisible(true);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(270, 187);
		setLocationRelativeTo(null);
		setResizable(false);
		tela.setBackground(new Color(194, 249, 153));
	}
}
