package br.com.lucas.main;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LocalDoScript {

	
	private Label titulo;
	private Button botaoAbrirLocalDoScript;
	private TextField localOndeFoiArmazenadoOScript;

	public LocalDoScript() {
		this.botaoAbrirLocalDoScript = new Button("Abrir");
		this.localOndeFoiArmazenadoOScript = new TextField();
		this.titulo = new Label("Local onde foi gerado o script");

	}

	public Button getBotaoAbrirLocalDoScript() {
		return botaoAbrirLocalDoScript;
	}

	public TextField getLocalOndeFoiArmazenadoOScript() {
		localOndeFoiArmazenadoOScript.setPrefWidth(445);
		return localOndeFoiArmazenadoOScript;
	}

	public Label getTitulo() {
		return titulo;
	}

	
	
}
