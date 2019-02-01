package br.com.lucas.main;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class BancoEmpresa {

	private Label lblNomeBancoDeDados;
	private TextField txtNomeBancoDeDados;
	private Label campoObrigatorioBanco;
	private Label lblNomeEmpresa;
	private TextField txtEmpresa;

	public BancoEmpresa() {
		this.lblNomeBancoDeDados = new Label("Nome do banco:");
		this.txtNomeBancoDeDados = new TextField();
		this.campoObrigatorioBanco = new Label("Preenchimento obrigatório");
		this.lblNomeEmpresa = new Label("Nome da Empresa");
		this.txtEmpresa = new TextField();
	}

	public Label getLblNomeBancoDeDados() {
		return lblNomeBancoDeDados;
	}

	public TextField getTxtNomeBancoDeDados() {
		return txtNomeBancoDeDados;
	}

	public Label getCampoObrigatorioBanco() {
		campoObrigatorioBanco.setTextFill(Color.RED);

		return campoObrigatorioBanco;
	}

	public Label getLblNomeEmpresa() {
		return lblNomeEmpresa;
	}

	public TextField getTxtEmpresa() {
		return txtEmpresa;
	}

}
