package view;

import java.util.Scanner;

import controller.Metodos;

public class Main {

	public static void main(String[] args) {

		Metodos metodos = new Metodos();
		Scanner sc = new Scanner(System.in);

		int opc = 0;

		while (opc != 9) {

			System.out
					.println("Escolha a opção desejada: \n 1 - Listar processos ativos \n 2 - Ecerrar processo por PID"
							+ "\n" + " 3 - Ecerrar processo por NOME \n 9 - Finalizar Prgrama");
			opc = sc.nextInt();

			switch (opc) {

			case 1:
				metodos.listaProcessos(metodos.identificaSO());
				break;

			case 2:
				sc.nextLine();
				System.out.print("Por favor, insira o PID do processo: ");
				System.out.println();
				String pid = sc.nextLine();
				metodos.encerraProcessoPid(pid, metodos.identificaSO());
				break;

			case 3:
				sc.nextLine();
				System.out.print("Por favor, insira o NOME do processo: ");
				System.out.println();
				String processo = sc.nextLine();
				metodos.encerraProcessoNome(processo, metodos.identificaSO());
				break;

			case 9:

				System.out.println("Programa Finalizado. Até logo! ");
				break;

			default:
				System.out.println("Opção Inválida!");
				break;

			}

		}

	}

}