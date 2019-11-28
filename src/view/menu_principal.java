package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class menu_principal extends JFrame{
	
	JButton cadFun, cadCargo, Consulta;
	JLabel titulo;

	public menu_principal() {
		//geral (inicio)
		super("Sistema Financeiro");
		Container tela = getContentPane();
		ImageIcon icone_tela = new ImageIcon("Icones/coin.png");
		setLayout(null);
		setIconImage(icone_tela.getImage());
		
		//definições
		cadFun = new JButton("Cadastro de Funcionário");
		cadCargo = new JButton("Cadastro de Cargo");
		Consulta = new JButton("Consultas");
		titulo = new JLabel("Sistema Financeiro");
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		
		//setBounds(começo em X, começo em Y, Comprimento, Altura)
		titulo.setBounds(57, 30, 200, 20);
		cadFun.setBounds(48, 80, 200, 30);
		cadCargo.setBounds(48, 130, 200, 30);
		Consulta.setBounds(48, 180, 200, 30);
		
		//eventos
		cadFun.addActionListener(
		         new ActionListener() {
		            public void actionPerformed( ActionEvent e ) {
		               tela_cad_fun janela_cad_fun = new tela_cad_fun(null, true);
		               janela_cad_fun.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		               janela_cad_fun.setVisible(true);
		            }
		         }
		);
		
		cadCargo.addActionListener(
		         new ActionListener() {
		            public void actionPerformed( ActionEvent e ) {
		               tela_cad_cargo janela_cad_cargo = new tela_cad_cargo(null, true);
		               janela_cad_cargo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		               janela_cad_cargo.setVisible(true);
		            }
		         }
		);
		
		Consulta.addActionListener(
		         new ActionListener() {
		            public void actionPerformed( ActionEvent e ) {
		               menu_consulta janela_consulta = new menu_consulta(null, true);
		               janela_consulta.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		               janela_consulta.setVisible(true);
		            }
		         }
		);
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				int i = JOptionPane.showConfirmDialog(null ,"Tem certeza que deseja sair?", "Saída",JOptionPane.YES_NO_OPTION);
				if (i == JOptionPane.YES_OPTION) {
					System.exit(0);
				} 
			}
		});
		
		//add no Container
		tela.add(cadFun);
		tela.add(cadCargo);
		tela.add(Consulta);
		tela.add(titulo);
		
		//geral (final)
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setSize(300, 270);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		tela.setBackground(new Color(194, 249, 153));
	}
}
