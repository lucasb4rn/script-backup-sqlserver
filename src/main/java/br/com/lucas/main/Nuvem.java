package br.com.lucas.main;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class Nuvem {

	private TextField txtCaminhoDrive;
	private Button botaoLocalParaArmazenarBackup;
	private Label campoObrigatorioBackup;
	private Label localSelecionadoParaArmazenarBackup;

	public Nuvem() {
		this.txtCaminhoDrive = new TextField();
		this.botaoLocalParaArmazenarBackup = new Button("Carregar Nuvem ou Disco");
		this.campoObrigatorioBackup = new Label("Seleção obrigatória");
		this.localSelecionadoParaArmazenarBackup = new Label();
	}

	public TextField getTxtCaminhoDrive() {
		txtCaminhoDrive.setEditable(false);
		return txtCaminhoDrive;
	}

	public Button getBotaoLocalParaArmazenarBackup() {
		return botaoLocalParaArmazenarBackup;
	}

	public Label getCampoObrigatorioBackup() {
		campoObrigatorioBackup.setTextFill(Color.RED);
		return campoObrigatorioBackup;
	}

	public Label getLocalSelecionadoParaArmazenarBackup() {
		return localSelecionadoParaArmazenarBackup;
	}

}
