package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Metodos {
	
	public Metodos() {
		super();
	}

	public String identificaSO() {

		String os = System.getProperty("os.name");
		return os;
	}

	public void listaProcessos(String sO) {

		if (sO.contains("Windows")) {

			try {

				
				Process processo = Runtime.getRuntime().exec("tasklist");

				InputStream fluxo = processo.getInputStream();

				InputStreamReader leitor = new InputStreamReader(fluxo);

				BufferedReader buffer = new BufferedReader(leitor);

				String linha = buffer.readLine();

				while (linha != null) {

					System.out.println(linha);

					linha = buffer.readLine();
				}
				System.out.println();

				buffer.close();
				leitor.close();
				fluxo.close();

			} catch (Exception e) {
				String msgErro = e.getMessage();
				System.err.println(msgErro);
			}
		} else if (sO.contains("Linux")) {

			try {
				Process processo = Runtime.getRuntime().exec("ps");

				InputStream fluxo = processo.getInputStream();

				InputStreamReader leitor = new InputStreamReader(fluxo);

				BufferedReader buffer = new BufferedReader(leitor);

				String linha = buffer.readLine();

				while (linha != null) {

					System.out.println(linha);

					linha = buffer.readLine();
				}
				System.out.println();

				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (Exception e) {
				String msgErro = e.getMessage();
				System.err.println(msgErro);
			}

		} else {
			System.out.println("Configurações do sistema não encontradas!" + "\n");
		}
	}

	public void encerraProcessoPid(String pid, String sO) {

		
		StringBuffer buffer = new StringBuffer();

		if (sO.contains("Windows")) {
			
			String cmdPid = "TASKKILL /PID";
			String cmdNome = "TASKKILL /IM";

			int pidNumber = 0;

			try {
				pidNumber = Integer.parseInt(pid);
				buffer.append(cmdPid);
				buffer.append(" ");
				buffer.append(pidNumber);

				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException except) {
					except.printStackTrace();
				}

			} catch (NumberFormatException e) {
				buffer.append(cmdNome);
				buffer.append(" ");
				buffer.append(pid);
			}

		} else if (sO.contains("Linux")) {
			
			String cmdPid = "kill";
			String cmdNome = "pkill";
			
			int pidNumber = 0;

			try {
				pidNumber = Integer.parseInt(pid);
				buffer.append(cmdPid);
				buffer.append(" ");
				buffer.append(pidNumber);

				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException except) {
					except.printStackTrace();
				}

			} catch (NumberFormatException e) {
				buffer.append(cmdNome);
				buffer.append(" ");
				buffer.append(pid);
			}

		} else {
			System.out.println("Configurações do sistema não encontradas!" + "\n");
		}

	}

	public void encerraProcessoNome(String processo, String sO) {

		StringBuffer buffer = new StringBuffer();

		if (sO.contains("Windows")) {

			String cmdPid = "TASKKILL /PID";
			String cmdNome = "TASKKILL /IM";

			try {

				buffer.append(cmdNome);
				buffer.append(" ");
				buffer.append(processo);

				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException except) {
					except.printStackTrace();
				}

			} catch (NumberFormatException e) {
				buffer.append(cmdPid);
				buffer.append(" ");
				buffer.append(processo);
			}

		} else if (sO.contains("Linux")) {

			String cmdPid = "kill";
			String cmdNome = "pkill";

			try {

				buffer.append(cmdNome);
				buffer.append(" ");
				buffer.append(processo);

				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException except) {
					except.printStackTrace();
				}

			} catch (NumberFormatException e) {
				buffer.append(cmdPid);
				buffer.append(" ");
				buffer.append(processo);
			}

		} else {
			System.out.println("Configurações do sistema não encontradas!" + "\n");
		}

	}

}