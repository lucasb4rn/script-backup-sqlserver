package br.com.lucas.utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Teste extends JFrame {

	public static void main(String[] args) {

		JFrame janela = new JFrame("Argentum");
		JButton botaoCarregar = new JButton("Carregar Winrar");
		JButton botaoSair = new JButton("Sair");
		JLabel lblBanco = new JLabel("Nome do Banco");
		final JTextField areaTextoOrigem = new JTextField(25);
		JTextField nomeDoBanco = new JTextField(10);
		
		
		
		JPanel painel = new JPanel();
		painel.add(lblBanco);
		painel.add(nomeDoBanco);
		painel.add(botaoCarregar);
		painel.add(areaTextoOrigem);
		painel.add(botaoSair);
		janela.add(painel);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.pack();
		janela.setSize(300, 200);
		janela.setVisible(true);

		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		botaoCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int returnVal = chooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String nome = chooser.getCurrentDirectory() + chooser.getSelectedFile().getName();
					areaTextoOrigem.setText(nome);
				}

			}

		});

		
		


		
		
		
		
	}

}
