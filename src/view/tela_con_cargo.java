package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import control.Funcionario_Controler;
import model.Funcionario;

public class tela_con_cargo extends JDialog{
	
	JLabel titulo;
	JTextField pesquisa;
	JButton acao;
	JTable lista;
	String[] teste = {"1", "2", "3", "4", "5", "6"}; //variavel de teste, inserir <List> depois
	
	public tela_con_cargo(Frame dono, boolean modal) {
		//geral (inicio)
		super(dono, "Consulta por Cargo", modal);
		Container tela = getContentPane();
		ImageIcon icone_tela = new ImageIcon("Icones/coin.png");
		tela.setLayout(null);
		setIconImage(icone_tela.getImage());
		
		//defini��es
		pesquisa = new JTextField("");
		acao = new JButton("Consultar");
		lista = new JTable();
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
		acao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println(pesquisa.getText());
					DefaultTableModel modelo = new DefaultTableModel();
					modelo.addColumn("nome");
					modelo.addColumn("fk_cargo");
					modelo.addColumn("cpf");
					modelo.addColumn("salario");
					modelo.addColumn("bancoHora");
					modelo.addColumn("dependentes");
					control.Funcionario_Controler c = new Funcionario_Controler();
					Funcionario[] f = c.getAll();
					for (int i = 0; i < f.length; i++) {
						Object linha[] = { f[i].getNome(), f[i].getFk_cargo(), f[i].getCpf(), f[i].getSalario(),f[i].getBanco_Horas(), f[i].getDependentes() };
						if(pesquisa.getText().contains(""+f[i].getFk_cargo())||pesquisa.getText().length()==0) {
							modelo.addRow(linha);
						}
					}
					lista.setModel(modelo);
				} catch (IOException e2) {
				}
			}
		});
		
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
