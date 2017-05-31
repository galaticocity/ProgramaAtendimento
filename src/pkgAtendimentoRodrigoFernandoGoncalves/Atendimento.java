package pkgAtendimentoRodrigoFernandoGoncalves;

import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Atendimento {
	Scanner enter = new Scanner(System.in);

	public static class Fila {
		public int cartao;
		public String nome;
		public String sobreNome;
		public Double valor;
		public Fila prox;
	}

	public static String menu() {
		return "MENU DE OPÇÕES\n" + "1 - Recepcionar Cliente\n" + "2 - Consultar clientes a serem atendidos\n"
				+ "3 - Atender Clientes\n" + "4 - Liberar todos os clientes "
				+ "5 - Verificar quantidade de clientes a atender\n" + "6 - Localizar cliente por número\n"
				+ "7 - Localizar cliente por nome\n" + "8 - Emitir relatório de clientes "
				+ "9 - Ver Relatórios de clientes\n" + "10 - Filtrar Clientes por valor\n"
				+ "11 - Ver endereços de hash\n" + "12 - Sobre\n " + "13 - Sair";
	}

	// metodo abaixo verifica se a lista contem numero do cartão cadastrado
	public static boolean verificaNumCadastro(int cartao) {

		return true;
	}

	public static void filaVazia() {
		JOptionPane.showMessageDialog(null, "NÃO HÁ ATENDIMENTOS", "MENSAGEM DO PROGRAMA", 0);
	}

	public static void main(String[] args) {

		Fila inicio = null;
		Fila fim = null;
		Fila aux;
		int op = 0;
		do {
			try {
				op = Integer.parseInt(JOptionPane.showInputDialog(menu(), "1"));
				if (op < 1 || op > 13)
					JOptionPane.showMessageDialog(null, "Opção Inválida!", "MENSAGEM", JOptionPane.CLOSED_OPTION);
				if (op == 1) {
					Fila novo = new Fila();

					String numCartao = JOptionPane.showInputDialog(null, "NÚMERO DO CARTÃO");
					String nome = JOptionPane.showInputDialog(null, "NOME");
					String sobrenome = JOptionPane.showInputDialog(null, "SOBRENOME");
					String valor = JOptionPane.showInputDialog(null, "VALOR");

					// converte os valores recebidos como string
					novo.cartao = Integer.parseInt(numCartao);
					novo.nome = nome;
					novo.sobreNome = sobrenome;
					novo.valor = Double.parseDouble(valor);
					novo.prox = null;

					// caso a fila estiver vazia preenche no inicio
					if (inicio == null) {
						inicio = novo;
						fim = novo;
					} else if (!verificaNumCadastro(novo.cartao)) {
						JOptionPane.showMessageDialog(null, "Esse número do cartão já foi usado.\n Favor verificar!");
					} else {
						fim.prox = novo;
						fim = novo;
					}
					aux = fim;
					fim = novo;

				}
				if (op == 2) {
					if (inicio == null)
						filaVazia();
					else {
						aux = inicio;
						JTextArea saida = new JTextArea(6, 35);
						JScrollPane scroll = new JScrollPane(saida);
						saida.append("CARTÃO\t NOME\t SOBRENOME\t VALOR ");
						saida.append("\n---------------------------------\n");
						while (aux != null) {
							saida.append(aux.cartao + "\t " + aux.nome + "\t" + aux.sobreNome + "\t" + aux.valor);
							aux = aux.prox;
						}
						JOptionPane.showMessageDialog(null, scroll, "Consultar Fila", JOptionPane.INFORMATION_MESSAGE);

					}

				}
				if (op == 3) {

				}
				if (op == 4) {

				}
				if (op == 5) {

				}
				if (op == 6) {

				}
				if (op == 7) {

				}
				if (op == 8) {

				}
				if (op == 9) {

				}
				if (op == 10) {

				}
				if (op == 11) {

				}
				if (op == 12) {

				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Encerrando o programa...", "MENSAGEM", JOptionPane.CLOSED_OPTION);
				break;
			}
		} while (op != 13);
		JOptionPane.showMessageDialog(null, "=======\t PROGRAMA ENCERRADO!\t ======", "MENSAGEM",
				JOptionPane.CLOSED_OPTION);

	}

}
