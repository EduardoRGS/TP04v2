package view;

import java.awt.*;
import modelo.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controle.*;

	/**
	 * Essa classe controla a funcionalidade
	 * de criar uma janela, titulos 
	 * e os bot�es da Biblioteca
	 * @author Eduardo Ribeiro
	 * @version 1.0 (Abril 2021)
	 */

public class TelaBiblioteca implements ActionListener{
	private JFrame janela;	
	private JLabel titulo;
	private JButton pesquisa;	// Bot�o para Pesquisar
	private JTextField valorPesquisa;	// JTextField para escrever o livro que quer pesquisar
	private static ControleDados dados;
	private String s;
	private int opcao;
	
	/**
	 * M�todo que mostra a janela de pesquisa
	 * junto do bot�o de pesquisa de Livros/Usuarios
	 * @param d Classe ControleDados 
	 * @param op posi��o do livro/usuario 
	 */
	public void pesquisa(ControleDados d, int op) {
		dados = d;
		opcao = op;
		
		switch (op) {
		case 3:
			
			janela = new JFrame("Busca de Livros");
			titulo = new JLabel("Pesquisar Livros");
			pesquisa = new JButton("Pesquisar");
			valorPesquisa = new JTextField(200);
			
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(100, 10, 250, 30);
			pesquisa.setBounds(130, 105, 100,30);
			valorPesquisa.setBounds(30, 70, 300, 30);
			
			janela.setLayout(null);
			
			janela.add(titulo);
			janela.add(pesquisa);
			janela.add(valorPesquisa);
			
			
			janela.setSize(400, 250);
			janela.setVisible(true);
			
			pesquisa.addActionListener(this);
			
			break;
			
		default:
			JOptionPane.showMessageDialog(null,"Op��o n�o encontrada!", null
			,JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	/**
	 * M�todo que controla a a��o do bot�o de pesquisa
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == pesquisa) {	// Pesquisa o Livro
			if(opcao == 3) {
				s = valorPesquisa.getText();
				if(dados.pesquisa(s) >= 0) {
					
					mensagemSucessoPesquisa();	// Caso livro igual o livro pesquisado
				} else {
					
					 mensagemErroPesquisa();	// Caso livro pesquisa n�o for igual livros cadasrados
				}
			}
		}
	}
	
	/**
	 * M�todo de mensagem de sucesso
	 * Caso busque um livro/usuario cadastrado
	 */
	public void mensagemSucessoPesquisa() {
		
		JOptionPane.showMessageDialog(null, "Livro Pesquisado encontrado", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	/**
	 * M�todo de mensagem de erro
	 * Caso o busca por um livro/usuario n�o cadastrado
	 */
	public void mensagemErroPesquisa() {
		JOptionPane.showMessageDialog(null,"LIVRO N�O ENCONTRADO!\n"
				+ "Pesquise novamente!!!"
				, null, 
				JOptionPane.ERROR_MESSAGE);
	}

}
