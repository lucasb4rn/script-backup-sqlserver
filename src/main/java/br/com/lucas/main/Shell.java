package br.com.lucas.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shell {

	private String bancoDeDados;
	private String shell;

	public void executaShell(String bancoDeDados) {

		shell = "sqlcmd -S  %computername% -Q \" BACKUP DATABASE [" + bancoDeDados
				+ "] TO DISK = 'C:\\SGC.bak' WITH INIT\"";

		try {
			Process process = Runtime.getRuntime().exec(shell);
			System.out.println("the output stream is " + process.getOutputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String s;
			while ((s = reader.readLine()) != null) {
				System.out.println("The inout stream is " + s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getBancoDeDados() {
		return bancoDeDados;
	}

	public void setBancoDeDados(String bancoDeDados) {
		this.bancoDeDados = bancoDeDados;
	}

	public String getShell() {
		return shell;
	}

	public void setShell(String shell) {
		this.shell = shell;
	}

}
