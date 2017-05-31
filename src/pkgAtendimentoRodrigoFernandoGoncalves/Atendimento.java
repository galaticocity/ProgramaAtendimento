/*
 	Programa Atendimento
 	Programadores: Fernando Gonçalves e Rodrigo Martins
 	Data: Maio 2017
  
 */

package pkgAtendimentoRodrigoFernandoGoncalves;

import javax.swing.*;

public class Atendimento {
	public static Fila inicio = null;
	public static Fila fim = null;
	public static Fila aux;
	public static int op = 0;

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
		aux = inicio;
		while (aux != null) {
			if (aux.cartao == cartao)
				return false;
			aux = aux.prox;
		}
		return true;
	}

	// metodo que retorna dados do cliente ao receber o numero do cartão como
	// parametro
	public static void localizaPorNumero(int cartao) {
		aux = inicio;
		int achou = 0;
		int contador = 1;
		while (aux != null) {
			if (aux.cartao == cartao) {
				achou++;
				JOptionPane.showMessageDialog(null,
						"DADOS DO CLIENTE\n" + "\nCARTÃO: " + aux.cartao + "\n" + "NOME: " + aux.nome + "\n"
								+ "SOBRENOME:" + aux.sobreNome + "\n" + "VALOR: " + aux.valor + "\n" + "POSIÇÃO: "
								+ contador + "ª POSIÇÃO\n",
						"MENSAGEM DO PROGRAMA", 0);

			}
			aux = aux.prox;
			contador++;
		}
		if (achou == 0)
			JOptionPane.showMessageDialog(null, "Cartão não cadastrado", "MENSAGEM DO PROGRAMA", 0);
	}

	public static void filaVazia() {
		JOptionPane.showMessageDialog(null, "NÃO HÁ ATENDIMENTOS", "MENSAGEM DO PROGRAMA", 0);
	}

	public static void main(String[] args) {

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
						saida.append(
								"\n-----------------------------------------------------------------------------\n");
						while (aux != null) {
							saida.append(
									aux.cartao + "\t " + aux.nome + "\t" + aux.sobreNome + "\t" + aux.valor + "\n");
							aux = aux.prox;
						}
						JOptionPane.showMessageDialog(null, scroll, "Consultar Fila", JOptionPane.INFORMATION_MESSAGE);

					}

				}
				if (op == 3) {
					if (inicio == null)
						filaVazia();
					else {
						JOptionPane.showMessageDialog(null,
								"CARTÃO" + inicio.cartao + ", NOME: " + inicio.nome + " foi atendido (a)",
								"MENSAGEM DO PROGRAMA", 0);
						inicio = inicio.prox;
					}

				}
				if (op == 4) {

				}
				if (op == 5) {

				}
				if (op == 6) {
					String num = JOptionPane.showInputDialog("Informe o número do cartão");
					int cartao = Integer.parseInt(num);
					if (inicio == null)
						filaVazia();
					else
						localizaPorNumero(cartao);

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
