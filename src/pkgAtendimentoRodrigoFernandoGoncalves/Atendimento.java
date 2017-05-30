package pkgAtendimentoRodrigoFernandoGoncalves;

import java.util.Scanner;

public class Atendimento {
	Scanner enter = new Scanner(System.in);
	
	public static String menu(){
		return "MENU DE OPÇÕES\n"
				+ "1 - Recepcionar Cliente\n"
				+ "2 - Consultar clientes a serem atendidos\n"
				+ "3 - Atender Clientes\n"
				+ "4 - Liberar todos os clientes "
				+ "5 - Verificar quantidade de clientes a atender\n"
				+ "6 - Localizar cliente por número\n"
				+ "7 - Localizar cliente por nome\n"
				+ "8 - Emitir relatório de clientes "
				+ "9 - Ver Relatórios de clientes\n"
				+ "10 - Filtrar Clientes por valor\n"
				+ "11 - Ver endereços de hash\n"
				+ "12 - Sobre "
				+ "13 - Sair";
				}
	

	public static void main(String[] args) {


	}
	

}
