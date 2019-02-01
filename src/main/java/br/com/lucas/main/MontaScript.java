package br.com.lucas.main;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class MontaScript {
	
	private String shellDeFazerBackupBanco;
	private String entrarNaPastaDoWinrar;
	private String zipar;
	private String entrarNaPastaDeBackup;
	private String deletarArquivoBak;
	private String forfiles;
	private String moverArquivoParaDrive;

	public void escreve(String caminhoURLBat, String bancoDeDados, String caminhoParaGuardarBanco, String pathWinrar, String pathDrive, String nomeDaEmpresa) {

		OutputStream fos = null;

		shellDeFazerBackupBanco = "sqlcmd -S  %computername% -Q \" BACKUP DATABASE [" + bancoDeDados
				+ "] TO DISK = '" + caminhoParaGuardarBanco + "\\sgc.bak" + "' WITH INIT\"";
		
		entrarNaPastaDoWinrar = "cd " + pathWinrar;
		
		zipar = "winrar a " + caminhoParaGuardarBanco + "\\backup_riberus.rar " + caminhoParaGuardarBanco + "\\sgc.bak";
		
		entrarNaPastaDeBackup = "cd " + caminhoParaGuardarBanco;
		
		deletarArquivoBak = "del " + "sgc.bak";
		
		forfiles = "forfiles -p " + pathDrive + " -s -d -5 -m *.rar -c \"cmd /c del /f /q @path\"";
		
		moverArquivoParaDrive = "move " + "\"" + caminhoParaGuardarBanco + "\\backup_riberus.rar\" " + "\""+ pathDrive + "\\BKP-" + nomeDaEmpresa + "-%date:/=-%.rar" + "\"" ;
		
		
		try {
			fos = new FileOutputStream(caminhoURLBat);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		Writer osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);

		try {
			bw.write(shellDeFazerBackupBanco);
			bw.newLine();
			bw.write(entrarNaPastaDoWinrar);
			bw.newLine();
			bw.write(zipar);
			bw.newLine();
			bw.write(entrarNaPastaDeBackup);
			bw.newLine();
			bw.write(deletarArquivoBak);
			bw.newLine();
			bw.write(moverArquivoParaDrive);
			bw.newLine();
			bw.write(forfiles);
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}