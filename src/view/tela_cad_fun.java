package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import model.Funcionario;
import control.Funcionario_Controler;
import control.Cargo_Controler;
import model.Cargo;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class tela_cad_fun extends JDialog{
	
	JLabel labelNome, labelCPF, labelCargo, labelDependentes, labelSalario, labelBancoHoras, labelCargaHoraria , titulo;
	JTextField nome, dependentes, salario, banco_horas, carga_horaria;
	JFormattedTextField cpf;
	MaskFormatter mascaraCPF;
	JComboBox cargo;
	JButton cadastrar;
	
	public void finalizar() {
		Funcionario f = new Funcionario();
        String auxCPF = cpf.getText();
        auxCPF = auxCPF.replace(".", "");
        auxCPF = auxCPF.replace("-", "");
        System.out.println(auxCPF);
        f.setNome(nome.getText());
        f.setCpf(Long.parseLong(auxCPF));
        f.setFk_cargo(cargo.getSelectedIndex());
        f.setDependentes(Integer.parseInt(dependentes.getText()));
        f.setSalario(Double.parseDouble(salario.getText()));
        f.setBanco_Horas(Double.parseDouble(banco_horas.getText()));
        f.setCarga_horaria(Double.parseDouble(carga_horaria.getText()));
        Funcionario_Controler c = new Funcionario_Controler();
        try {
     	   c.save(f);
     	   Funcionario[] li = c.getAll();
     	   for(Funcionario fi : li) {
     		   fi.printAllCamps_funcionario(fi);
     	   }
         }catch(IOException ex) {
         	
         }
	}
	
	public tela_cad_fun(Frame dono, boolean modal) {
		//geral (inicio)
		super(dono, "Cadastro de Funcionário", modal);
		Container tela = getContentPane();
		ImageIcon icone_tela = new ImageIcon("Icones/coin.png");
		tela.setLayout(null);
		setIconImage(icone_tela.getImage());
		
		//definições
		labelNome = new JLabel("Nome:");
		labelCPF = new JLabel("CPF:");
		labelCargo = new JLabel("Cargo:");
		nome = new JTextField("");
		cargo = new JComboBox();
		cargo.setMaximumRowCount(5);
		cargo.setEditable(false);
		
		try {
			Cargo_Controler cc = new Cargo_Controler();
			Cargo[] lci = cc.getAll();
 	   		for(Cargo ci : lci) {
 	   			cargo.addItem(ci.getNome());
 	   		}
		}catch(IOException ex) {
		}
		
		cadastrar = new JButton("Cadastrar");
		titulo = new JLabel("Cadastro de Funcionário");
		titulo.setFont(new Font("Arial", Font.BOLD, 16));
		labelDependentes = new JLabel("Dependentes:");
		labelSalario = new JLabel("Salario");
		labelBancoHoras = new JLabel("Banco de Horas:");
		labelCargaHoraria = new JLabel("Carga Horária:");
		dependentes = new JTextField("");
		salario = new JTextField("");
		banco_horas = new JTextField("");
		carga_horaria = new JTextField("");
		
		//máscara CPF
		try {
			mascaraCPF = new MaskFormatter("###.###.###-##");
			mascaraCPF.setPlaceholderCharacter('_');
		}catch(ParseException e) {}
		cpf = new JFormattedTextField(mascaraCPF);
		
		//setBounds
		titulo.setBounds(60, 15, 200, 20);
		labelNome.setBounds(15, 50, 100, 20);
		labelCPF.setBounds(15, 80, 100, 20);
		labelCargo.setBounds(15, 110, 100, 20);
		labelDependentes.setBounds(15, 140, 100, 20);
		labelSalario.setBounds(15, 170, 100, 20);
		labelBancoHoras.setBounds(15, 200, 100, 20);
		labelCargaHoraria.setBounds(15, 230, 100, 20);
		cadastrar.setBounds(10, 270, 294, 30);
		nome.setBounds(120, 50, 170, 20);
		cpf.setBounds(120, 80, 94, 20);
		cargo.setBounds(120, 110, 170, 20);
		dependentes.setBounds(120, 140, 20, 20);
		salario.setBounds(120, 170, 60, 20);
		banco_horas.setBounds(120, 200, 60, 20);
		carga_horaria.setBounds(120, 230, 60, 20);

		
		//eventos
		cadastrar.addActionListener(
		         new ActionListener() {
		            public void actionPerformed( ActionEvent e ) {
		               boolean flagVerif = false;
		               if(nome.getText().equals("")) {
		            		   JOptionPane.showMessageDialog(null, "Preencha o campo Nome");
		            		   nome.requestFocus();
		            		} else if(nome.getText().length() > 50) {
		            		   JOptionPane.showMessageDialog(null, "Nome deve usar menos de 50 caracteres");
		            		   nome.requestFocus();
		            		} else if(cpf.getText().replace("_", "").length() <14) {
			            	   JOptionPane.showMessageDialog(null, "Preencha o campo CPF");
			            	   cpf.requestFocus();
		            		} else if(dependentes.getText().equals("")) {
			            	   JOptionPane.showMessageDialog(null, "Preencha o campo dependentes");
			            	   dependentes.requestFocus();
		            		} else if(Integer.parseInt(dependentes.getText()) >= 100) {
		            		   JOptionPane.showMessageDialog(null, "Descendentes deve ser menor que 100");
		            		   dependentes.requestFocus();
		            		} else if(salario.getText().equals("")) {
			            	   JOptionPane.showMessageDialog(null, "Preencha o campo Salario");
			            	   salario.requestFocus();
			            	} else if(banco_horas.getText().equals("")) {
			            	   JOptionPane.showMessageDialog(null, "Preencha o campo Banco de Horas");
				               banco_horas.requestFocus();
				            } else if(carga_horaria.getText().equals("")) {
				               JOptionPane.showMessageDialog(null, "Preencha o campo Carga Horária");
				               carga_horaria.requestFocus();
				            }else {
				            	flagVerif = true;
				            }
		            	   
		            	   if(flagVerif == true) {
		            		   finalizar();
		            	   }
		             }
		         }
		);
		
		//add no Container
		tela.add(titulo);
		tela.add(labelNome);
		tela.add(labelCPF);
		tela.add(labelCargo);
		tela.add(cadastrar);
		tela.add(cpf);
		tela.add(nome);
		tela.add(cargo);
		tela.add(dependentes);
		tela.add(salario);
		tela.add(banco_horas);
		tela.add(carga_horaria);
		tela.add(labelDependentes);
		tela.add(labelSalario);
		tela.add(labelBancoHoras);
		tela.add(labelCargaHoraria);
		
		//geral (final)
		setSize(320, 340);
		setLocationRelativeTo(null);
		setResizable(false);
		tela.setBackground(new Color(194, 249, 153));
	}
}
