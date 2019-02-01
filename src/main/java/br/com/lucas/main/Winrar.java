package br.com.lucas.main;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class Winrar {

	private Button botaoCarregarWinrar;
	private TextField txtCaminhoWinrar = new TextField();
	private Label campoObrigatorioWinrar = new Label("Seleção obrigatória");

	public Winrar() {

		this.botaoCarregarWinrar = new Button("Carregar Winrar");
		this.txtCaminhoWinrar = new TextField();
		this.campoObrigatorioWinrar = new Label("Seleção obrigatória");
	}

	public Button getBotaoCarregarWinrar() {
		return botaoCarregarWinrar;
	}

	public TextField getTxtCaminhoWinrar() {
		txtCaminhoWinrar.setEditable(false);
		txtCaminhoWinrar.setPrefWidth(425);
		return txtCaminhoWinrar;
	}

	public Label getCampoObrigatorioWinrar() {
		campoObrigatorioWinrar.setTextFill(Color.RED);
		return campoObrigatorioWinrar;
	}

}
