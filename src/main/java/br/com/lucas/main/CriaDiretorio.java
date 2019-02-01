package br.com.lucas.main;

import java.io.File;

import javax.swing.JOptionPane;

public class CriaDiretorio {
	
	private File diretorioArquivo;
	private File diretorio;
	
	public void criarDiretorio() {
		
        try {
            diretorio = new File("C:\\Backup_Automatico_Riberus");
            diretorio.mkdir();
            diretorioArquivo = new File("C:\\Backup_Automatico_Riberus\\BKP_RIBERUS.bat"); 
            diretorioArquivo.createNewFile();
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar o diretorio");
            System.out.println(ex);
        }
    }
	
	
	public File getDiretorio() {
		return diretorio;
	}



	public void setDiretorio(File diretorio) {
		this.diretorio = diretorio;
	}



	public File getDiretorioArquivo() {
		return diretorioArquivo;
	}



	public void setDiretorioArquivo(File diretorioArquivo) {
		this.diretorioArquivo = diretorioArquivo;
	}


}
