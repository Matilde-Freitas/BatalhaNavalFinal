package trabalho1_v_final;

import java.util.Scanner;

public class main
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		boolean val_menu = true;
		boolean val_N = true;
		boolean val_M = true;
		boolean val_navios = true;
		boolean val_shot = true;
		boolean val_interacao = true;
		boolean val_tabuleiro_valido = true;
		boolean val_jogo = true;

		char water = '.';
		char ship = 'S';
		char hit = 'X';
		char miss = 'o';

		char[] resultado = new char[100];
		char vitoria = 'V';
		char derrota = 'D';
		char abandono = 'A';

		int numJogo = 0;
		int numS = 0;
		int[] jogadasTotal = new int[100];

		while (val_menu)
		{
			System.out.println("Insira [1] para jogar uma nova partida."
					+ "\nInsira [2] para ver o histórico de partidas." + "\nInsira [3] para sair.");
			int menu = scan.nextInt();
			scan.nextLine();

			if (menu == 3)
			{
				System.out.println("GAME OVER");
				val_menu = false;
			}

			else if (menu == 2)
			{
				System.out.println();
				ManageStats.printStatsTotal(resultado, numJogo, jogadasTotal);
				System.out.println();
				ManageStats.printPerc(resultado, numJogo, jogadasTotal, vitoria, derrota, abandono);
				System.out.println();
				ManageStats.printMed(jogadasTotal, numJogo);

				val_menu = true;
			}

			else if (menu == 1)
			{
				System.out.println("GAME START");

				while (val_jogo)
				{
					val_tabuleiro_valido = true;
					val_interacao = true;

					System.out.println("Defina as dimensões do tabuleiro.");

					int N = inputs.check_N(val_N, scan);

					int M = inputs.check_M(val_M, scan);

					int navios = inputs.check_navios(val_navios, scan, N, M);

					char tabuleiro[][] = new char[N][M];

					while (val_interacao)
					{
						tabuleiro = ManageTabuleiro.criarTabuleiro2(N, M, water, navios, ship);

						if (tabuleiro.length < 10)
						{
							val_tabuleiro_valido = false;
							val_interacao = false;
						}

						if (val_tabuleiro_valido == true)
						{
							numS = ManageTabuleiro.contarS(tabuleiro, ship, N, M);

							int max_shot = inputs.check_shot(val_shot, scan, numS, N, M);

							ManageTabuleiro.printTabuleiro(tabuleiro, water, ship, N, M);

							int jogadas = 0;

							numJogo++;

							for (int i = 0; i < max_shot; i++)
							{
								int[] coordenadasJogador = ManageTabuleiro.inserirCoordenadas(N, M, scan);
								jogadas++;
								char resultadoShot = ManageTabuleiro.avaliarShot(coordenadasJogador, tabuleiro, ship,
										water, hit, miss);

								tabuleiro = ManageTabuleiro.atualizarTabuleiro(tabuleiro, coordenadasJogador,
										resultadoShot);
								ManageTabuleiro.printTabuleiro(tabuleiro, water, ship, N, M);

								numS = ManageTabuleiro.contarS(tabuleiro, ship, N, M);

								if (numS == 0)
								{
									System.out.println("Ganhou o jogo!");
									resultado[numJogo] = vitoria;
									jogadasTotal[numJogo] = jogadas;

									val_interacao = ManageTabuleiro.iniciarNovoJogo(val_interacao, scan);
									if (val_interacao == false)
									{
										val_jogo = false;
									}
									i = max_shot;

								}

								else if (jogadas == max_shot)
								{
									System.out.println("Perdeu o jogo");
									resultado[numJogo] = derrota;
									jogadasTotal[numJogo] = jogadas;

									val_interacao = ManageTabuleiro.iniciarNovoJogo(val_interacao, scan);
									if (val_interacao == false)
									{
										val_jogo = false;
									}
									i = max_shot;

								}

								if (i < max_shot)
								{
									val_interacao = ManageTabuleiro.abandonarJogo(val_interacao, scan);
									if (val_interacao == false)
									{
										resultado[numJogo] = abandono;
										jogadasTotal[numJogo] = jogadas;
										val_interacao = ManageTabuleiro.iniciarNovoJogo(val_interacao, scan);
										if (val_interacao == false)
										{
											val_jogo = false;
										}
										i = max_shot;
									}
								}
							}
						}
					}
				}

				val_menu = true;
			}

			else
			{
				System.out.println("Erro: Não insiriu um número correto");
				val_menu = true;
			}

			System.out.println();
		}

		scan.close();
	}

}
