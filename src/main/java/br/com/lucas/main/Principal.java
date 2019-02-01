package br.com.lucas.main;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

//Se quisermos que essa classe trate evento, ela deve herdar de EventHandler
public class Principal extends Application {

	protected File selectedDirectoryWinrar;
	protected File selectedDirectoryDrive;

	@Override
	public void start(final Stage stage) throws Exception {

		final File localSalvarOArquivo = new File("C:\\Backup_Automatico_Riberus\\BKP_RIBERUS.bat");
		
		Winrar winrar = new Winrar();
		Nuvem nuvem = new Nuvem();
		BancoEmpresa bancoEmpresa = new BancoEmpresa();
		LocalDoScript localDoScript = new LocalDoScript();
		
		
		//label de erros
		final Label invisivel = new Label("");
		invisivel.setVisible(false);
		
		//criar box para por os itens
		

		
		
		
		//informações empresa e banco de dados
		final VBox empresaBancoBoxVertifical = new VBox();
		empresaBancoBoxVertifical.getChildren().addAll(bancoEmpresa.getLblNomeEmpresa(), bancoEmpresa.getTxtEmpresa());
		empresaBancoBoxVertifical.setAlignment(Pos.TOP_LEFT);
		empresaBancoBoxVertifical.setPadding(new Insets(10));
		
		final VBox bancoDeDadosBoxVertical = new VBox();
		bancoDeDadosBoxVertical.getChildren().addAll(bancoEmpresa.getLblNomeBancoDeDados(), bancoEmpresa.getTxtNomeBancoDeDados());
		bancoDeDadosBoxVertical.setAlignment(Pos.TOP_LEFT);
		bancoDeDadosBoxVertical.setPadding(new Insets(10));
		
		final HBox empresaBancoBoxHorizontal = new HBox();
		empresaBancoBoxHorizontal.getChildren().addAll(bancoDeDadosBoxVertical, empresaBancoBoxVertifical);
		
		
		
		//winrar
		final VBox winrarBoxVertifical = new VBox();
		winrarBoxVertifical.getChildren().addAll(winrar.getBotaoCarregarWinrar(), winrar.getTxtCaminhoWinrar());
		winrarBoxVertifical.setPadding(new Insets(10));
		
		
		//caminho do script		
		final HBox localScriptBoxHorizontal = new HBox();
		localScriptBoxHorizontal.getChildren().addAll(localDoScript.getLocalOndeFoiArmazenadoOScript(), localDoScript.getBotaoAbrirLocalDoScript());
		
		final VBox localScriptSalvoBoxVertifical = new VBox();
		localScriptSalvoBoxVertifical.getChildren().addAll(localDoScript.getTitulo(), localScriptBoxHorizontal);
		localScriptSalvoBoxVertifical.setAlignment(Pos.TOP_LEFT);
		localScriptSalvoBoxVertifical.setPadding(new Insets(10));
		
		
		
		//declaração dos botões
		Button botaoGerarScript = new Button("Gerar Script");
		Button botaoSair = new Button("Sair");
		Button botaoLimpar = new Button("Limpar");
		
		
		
		//inserção dos botões
		HBox botoesBoxHorizontal = new HBox();
		botoesBoxHorizontal.getChildren().addAll(botaoGerarScript, botaoLimpar, botaoSair);
		botoesBoxHorizontal.setSpacing(10);
		botoesBoxHorizontal.setAlignment(Pos.CENTER);
		botoesBoxHorizontal.setPadding(new Insets(10));

		
		
		//nuvem
		final VBox boxVerticalNuvem = new VBox();
		boxVerticalNuvem.getChildren().addAll(nuvem.getBotaoLocalParaArmazenarBackup(), nuvem.getTxtCaminhoDrive());
		boxVerticalNuvem.setAlignment(Pos.TOP_LEFT);
		boxVerticalNuvem.setPadding(new Insets(10));
		


		
		

		
		final VBox raiz = new VBox();
		raiz.getChildren().addAll(empresaBancoBoxHorizontal, winrarBoxVertifical, boxVerticalNuvem, localScriptSalvoBoxVertifical, botoesBoxHorizontal);
		raiz.setTranslateY(5);
		raiz.setPadding(new Insets(10));

		Scene cena = new Scene(raiz, 520, 330);
		stage.setTitle("Backup Automatico Riberus");
		stage.setScene(cena);
		stage.resizableProperty().setValue(Boolean.FALSE);
		stage.show();
			
		
		localDoScript.getBotaoAbrirLocalDoScript().setOnAction(new EventHandler<ActionEvent>() {
			public void handle(final ActionEvent e) {
				
				if(localDoScript.getLocalOndeFoiArmazenadoOScript().getText().length() > 0) {
					
					Desktop desktop = Desktop.getDesktop();
					File dirToOpen = null;
					dirToOpen = new File(localDoScript.getLocalOndeFoiArmazenadoOScript().getText());
					try {
						desktop.open(dirToOpen);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}
			}
			
		});

		botaoGerarScript.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				MontaScript escreveScript = new MontaScript();
				CriaDiretorio diretorio = new CriaDiretorio();
				diretorio.criarDiretorio();

				if (diretorio.getDiretorio().getPath() != null && selectedDirectoryWinrar != null
						&& selectedDirectoryDrive != null && bancoEmpresa.getTxtNomeBancoDeDados().getText().length() > 0) {

					escreveScript.escreve(localSalvarOArquivo.getPath(), bancoEmpresa.getTxtNomeBancoDeDados().getText(),
							diretorio.getDiretorio().getPath(), selectedDirectoryWinrar.getPath(),
							selectedDirectoryDrive.getAbsolutePath(), bancoEmpresa.getTxtEmpresa().getText());

					localDoScript.getLocalOndeFoiArmazenadoOScript().setText(diretorio.getDiretorio().getPath());

				}

				if (winrar.getTxtCaminhoWinrar().getText().length() <= 0 && winrarBoxVertifical.getChildren().size() == 2) {
					stage.setHeight(stage.getHeight() + 15);
					winrarBoxVertifical.getChildren().add(0, winrar.getCampoObrigatorioWinrar());

				}

				if (nuvem.getTxtCaminhoDrive().getText().length() <= 0 && boxVerticalNuvem.getChildren().size() == 2) {
					stage.setHeight(stage.getHeight() + 15);
					boxVerticalNuvem.getChildren().add(0, nuvem.getCampoObrigatorioBackup());

				}

				if (bancoEmpresa.getTxtNomeBancoDeDados().getText().length() <= 0 && bancoDeDadosBoxVertical.getChildren().size() == 2) {
					stage.setHeight(stage.getHeight() + 15);
					bancoDeDadosBoxVertical.getChildren().add(0, bancoEmpresa.getCampoObrigatorioBanco());
					empresaBancoBoxVertifical.getChildren().add(0, invisivel);

				}

			}

		});

		bancoEmpresa.getTxtNomeBancoDeDados().focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

				if (newValue != false) {

					if (bancoDeDadosBoxVertical.getChildren().size() == 3) {
						bancoDeDadosBoxVertical.getChildren().remove(0);
						empresaBancoBoxVertifical.getChildren().remove(0);
						
						stage.setHeight(stage.getHeight() - 15);
					}

				}

			}

		});

		botaoLimpar.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(final ActionEvent e) {
				nuvem.getTxtCaminhoDrive().setText("");
				winrar.getTxtCaminhoWinrar().setText("");
				nuvem.getTxtCaminhoDrive().setText("");
				bancoEmpresa.getTxtNomeBancoDeDados().setText("");
				localDoScript.getLocalOndeFoiArmazenadoOScript().setText("");
				bancoEmpresa.getTxtEmpresa().setText("");

				if (winrarBoxVertifical.getChildren().size() == 3) {
					winrarBoxVertifical.getChildren().remove(0);
					stage.setHeight(stage.getHeight() - 15);
				}

				if (bancoDeDadosBoxVertical.getChildren().size() == 3) {
					bancoDeDadosBoxVertical.getChildren().remove(0);
					empresaBancoBoxVertifical.getChildren().remove(0);
					stage.setHeight(stage.getHeight() - 15);
				}

				if (boxVerticalNuvem.getChildren().size() == 3) {
					boxVerticalNuvem.getChildren().remove(0);
					stage.setHeight(stage.getHeight() - 15);
				}

			}
		});

		winrar.getBotaoCarregarWinrar().setOnAction(new EventHandler<ActionEvent>() {
			public void handle(final ActionEvent e) {
				final DirectoryChooser directoryChooser = new DirectoryChooser();

				selectedDirectoryWinrar = directoryChooser.showDialog(stage);

				if (selectedDirectoryWinrar != null) {
					winrar.getTxtCaminhoWinrar().setText(selectedDirectoryWinrar.getPath());
					winrar.getTxtCaminhoWinrar().setEditable(false);

					selectedDirectoryWinrar.getPath();
				}

				if (winrarBoxVertifical.getChildren().size() == 3) {
					winrarBoxVertifical.getChildren().remove(0);
					stage.setHeight(stage.getHeight() - 15);
				}

			}
		});

		nuvem.getBotaoLocalParaArmazenarBackup().setOnAction(new EventHandler<ActionEvent>() {
			public void handle(final ActionEvent e) {
				final DirectoryChooser directoryChooserNovo = new DirectoryChooser();

				selectedDirectoryDrive = directoryChooserNovo.showDialog(stage);
				if (selectedDirectoryDrive != null) {

					nuvem.getTxtCaminhoDrive().setText(selectedDirectoryDrive.getPath());
					nuvem.getTxtCaminhoDrive().setEditable(false);

					selectedDirectoryDrive.getAbsolutePath();
				}

				if (boxVerticalNuvem.getChildren().size() == 3) {
					boxVerticalNuvem.getChildren().remove(0);
					stage.setHeight(stage.getHeight() - 15);
				}

			}
		});

		botaoSair.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				stage.close();
			}
		});

	}

	public static void main(String[] args) {
		launch();
	}

}