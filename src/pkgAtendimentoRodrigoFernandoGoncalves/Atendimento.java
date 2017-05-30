package pkgAtendimentoRodrigoFernandoGoncalves;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Atendimento {
	Scanner enter = new Scanner(System.in);
	
	public static class Fila{
		public int cartao;
		public String nome;
		public String sobreNome;
		public Double valor;
		public Fila prox;
	}
	
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
				+ "12 - Sobre\n "
				+ "13 - Sair";
				}
	

	public static void main(String[] args) {
		
		Fila inicio = null;
		Fila fim = null;
		Fila aux;
		int op = 0;
		do{
			try{
				op = Integer.parseInt(JOptionPane.showInputDialog(menu(),"1"));
				if(op <1 || op > 13)
					JOptionPane.showMessageDialog(null, "Opção Inválida!",
					"MENSAGEM", JOptionPane.CLOSED_OPTION);
			}
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(null, "Encerrando o programa...",
						"MENSAGEM", JOptionPane.CLOSED_OPTION);
				break;
			}
		}while(op!=13);
		JOptionPane.showMessageDialog(null, "=======\t PROGRAMA ENCERRADO!\t ======",
				"MENSAGEM", JOptionPane.CLOSED_OPTION);


	}
	

}
