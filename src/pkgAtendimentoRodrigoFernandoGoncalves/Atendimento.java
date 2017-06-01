/*
 	Programa Atendimento
 	Programadores: Fernando Gonçalves e Rodrigo Martins
 	Data: JUN 2017
  
 */

package pkgAtendimentoRodrigoFernandoGoncalves;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;
import java.util.Scanner;

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
				+ "3 - Atender Clientes\n" + "4 - Liberar todos os clientes\n"
				+ "5 - Verificar quantidade de clientes a atender\n" + "6 - Localizar cliente por número\n"
				+ "7 - Localizar cliente por nome\n" + "8 - Emitir relatório de clientes\n"
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

	// metodo que mostra dados do cliente ao receber o numero do cartão como
	// parametro
	public static void localizaPorNumero(int cartao) {
		aux = inicio;
		int achou = 0;
		int contador = 1;
		while (aux != null) {
			if (aux.cartao == cartao) {
				achou++;
				JOptionPane.showMessageDialog(null,
						"DADOS DO CLIENTE:\n" + "\nCARTÃO: " + aux.cartao + "\n" + "NOME: " + aux.nome + "\n"
								+ "SOBRENOME:" + aux.sobreNome + "\n" + "VALOR: " + aux.valor + "\n" + "POSIÇÃO: "
								+ contador + "a. POSIÇÃO\n",
						"MENSAGEM DO PROGRAMA", JOptionPane.CLOSED_OPTION);

			}
			aux = aux.prox;
			contador++;
		}
		if (achou == 0)
			JOptionPane.showMessageDialog(null, "Cartão não cadastrado", "MENSAGEM DO PROGRAMA",
					JOptionPane.CLOSED_OPTION);
	}

	// metodo mostra dados do cliente ao receber o nome como parametro
	public static void localizarPorNome(String nome) {
		aux = inicio;
		int achou = 0;
		int contador = 1;
		while (aux != null) {
			if (aux.nome.equals(nome)) {
				achou++;
				JOptionPane.showMessageDialog(null,
						"DADOS DO CLIENTE:\n" + "\nCARTÃO: " + aux.cartao + "\n" + "NOME: " + aux.nome + "\n"
								+ "SOBRENOME:" + aux.sobreNome + "\n" + "VALOR: " + aux.valor + "\n" + "POSIÇÃO: "
								+ contador + "a. POSIÇÃO\n",
						"MENSAGEM DO PROGRAMA", JOptionPane.CLOSED_OPTION);

			}
			aux = aux.prox;
			contador++;
		}
		if (achou == 0)
			JOptionPane.showMessageDialog(null, "Nome não cadastrado", "MENSAGEM DO PROGRAMA",
					JOptionPane.CLOSED_OPTION);
	}

	// metodo mostra todos os valores superiores a um valor passado como
	// parametro
	public static void mostraValorSuperior(double valor) {
		aux = inicio;
		JTextArea saida = new JTextArea(6, 35);
		JScrollPane scroll = new JScrollPane(saida);
		saida.append("CARTÃO\t NOME\t SOBRENOME\t VALOR ");
		saida.append("\n-----------------------------------------------------------------------------\n");
		while (aux != null) {
			if (aux.valor > valor)
				saida.append(aux.cartao + "\t " + aux.nome + "\t" + aux.sobreNome + "\t" + aux.valor + "\n");
			aux = aux.prox;
		}
		JOptionPane.showMessageDialog(null, scroll, "ATENDIMENTOS COM VALORES SUPERIORES A:" + valor,
				JOptionPane.CLOSED_OPTION);
	}

	public static void filaVazia() {
		JOptionPane.showMessageDialog(null, "NÃO HÁ ATENDIMENTOS", "MENSAGEM DO PROGRAMA", JOptionPane.CLOSED_OPTION);
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
						JOptionPane.showMessageDialog(null, scroll, "CONSULTAR DADOS DO ATENDIMENTO",
								JOptionPane.CLOSED_OPTION);

					}

				}
				if (op == 3) {
					if (inicio == null)
						filaVazia();
					else {
						JOptionPane.showMessageDialog(null,
								"CARTÃO: " + inicio.cartao + ", NOME: " + inicio.nome + " foi atendido(a)!",
								"MENSAGEM DO PROGRAMA", JOptionPane.CLOSED_OPTION);
						inicio = inicio.prox;
					}

				}
				// Libera os clientes.
				if (op == 4) {
					if (inicio == null) {
						filaVazia();
					} else {
						inicio = null;
						JOptionPane.showMessageDialog(null, "**O ATENDIMENTO FOI LIBERADO**", "MENSAGEM",
								JOptionPane.CLOSED_OPTION);
					}
				}
				// Verifica o número de clientes na fila.
				if (op == 5) {
					if (inicio == null) {
						filaVazia();
					} else {
						int n = 0;
						aux = inicio;
						double soma = 0;
						while (aux != null) {
							soma += aux.valor;
							aux = aux.prox;
							n++;

						} // Fecha o while
						JOptionPane.showMessageDialog(null,
								"O ATENDIMENTO CONTÉM: " + n + " ELEMENTOS.\nVALOR TOTAL:" + soma, "MENSAGEM",
								JOptionPane.CLOSED_OPTION);
					}

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
					String nome = JOptionPane.showInputDialog("Nome do cliente");
					if (inicio == null)
						filaVazia();
					else
						localizarPorNome(nome);
				}
				if (op == 8) {
					if (inicio == null)
						filaVazia();
					else {
						aux = inicio;
						try (FileWriter arq = new FileWriter("/home/galatico/Atendimento.txt"); // mudar
																								// para
																								// diretorio
																								// desejado
								PrintWriter gravar = new PrintWriter(arq)) {

							while (aux != null) {
								gravar.printf("\n%d, %s, %s, %.2f \n", aux.cartao, aux.nome, aux.sobreNome, aux.valor);
								aux = aux.prox;
							}
							gravar.printf("---------------------------\n"
									+ "corporygth (b) by: Fernando Gonçalves, Rodrigo Martins\n");

						} catch (IOException e) {
							e.printStackTrace();
							e.getMessage();
							System.err.println("MENSSAGEM / CLASS ArquivoTexto \nErro ao tentar gravar no arquivo");
						}
						JOptionPane.showMessageDialog(null, "ARQUIVO GRAVADO COM SUCESSO", "MENSAGEM DO SISTEMA",
								JOptionPane.CLOSED_OPTION);
					}
				}
				if (op == 9) {
					int resp = JOptionPane.showConfirmDialog(null, "DESEJA VER O ARQUIVO?", "MENSAGEM",
							JOptionPane.YES_NO_OPTION);
					if (resp == JOptionPane.YES_NO_OPTION) {
						try {
							Runtime pro = Runtime.getRuntime();
							pro.exec("gedit /home/galatico/Atendimento.txt");
						} catch (Exception e) {
							e.printStackTrace();
							e.getMessage();
							System.err.println("ERRO . . .");
						}
					}
				}
				if (op == 10) {
					String val = JOptionPane.showInputDialog("FILTRAR ATENDIMENTOS PARA VALORES SUPERIORES A:");
					double valor = Double.parseDouble(val);
					if (inicio == null)
						filaVazia();
					else {
						mostraValorSuperior(valor);
					}

				}
				// Mostra o hashcode
				if (op == 11) {
					if (inicio == null) {
						filaVazia();
					} else {
						int numCartao = Integer.parseInt(JOptionPane.showInputDialog(null,
								"FILTRAR HASHCODES COM VALORES SUPERIORES A: "));
						aux = inicio;

						int cont = 0;

						while (aux != null) {
							if (numCartao == aux.cartao) {

								cont++;
								aux = inicio;
								JTextArea saidas = new JTextArea(6, 35);
								JScrollPane scrolls = new JScrollPane(saidas);
								saidas.append("NOME\t ENDEREÇO\t PROX");
								saidas.append(
										"\n-----------------------------------------------------------------------------\n");
								while (aux != null) {
									if (aux.prox == fim)
										saidas.append(aux.nome + "\t " + aux.hashCode() + "\t" + fim.hashCode() + "\n");
									else
										saidas.append(aux.nome + "\t " + aux.hashCode() + "\t" + fim.hashCode() + "\n");
									aux = aux.prox;

								}
								JOptionPane.showMessageDialog(null, scrolls, "CONSULTAR DADOS DO ATENDIMENTO",
										JOptionPane.INFORMATION_MESSAGE);

							} else {
								break;
							}
							aux = aux.prox;
						}

					}

				}
				// Sobre o programa
				if (op == 12) {

					JOptionPane.showMessageDialog(null,
							"PROGRAMA DE ATENDIMENTO AO CLIENTE\n-------------------------------------------------------------------------------\nCopyright(c) Galatico Corp Ltda\nProgramadores: Rodrigo Martins, Fernando Gonçalves\nVersão 1.0\nData: Junho 2017",
							"SOBRE O PROGRAMA", JOptionPane.CLOSED_OPTION);

				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Encerrando o programa...", "MENSAGEM", JOptionPane.CLOSED_OPTION);
				System.out.println("Erro");
				e.printStackTrace();
				e.getMessage();
				break;
			}
		} while (op != 13);
		JOptionPane.showMessageDialog(null, "* \t PROGRAMA FINALIZADO!\t *", "MENSAGEM", JOptionPane.CLOSED_OPTION);

	}

}
