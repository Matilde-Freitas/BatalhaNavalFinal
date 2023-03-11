package trabalho1_v_final;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ManageTabuleiro
{
	public static int[] gerarCoordenadas(int tipo_navio, int N, int M)
	{
		// 1) S 2) SS (horl) 3) SS (ver) 4) SSSS (hor) 5) SSSS (ver)

		int[] coordenadas_navio = new int[2];
		int c1 = 0;
		int c2 = 0;

		if (tipo_navio == 1)
		{
			c1 = new Random().nextInt(N);
			c2 = new Random().nextInt(M);

		}

		else if (tipo_navio == 2)
		{
			c1 = new Random().nextInt(N);
			c2 = new Random().nextInt(M - 1);

			if (c2 < 0)
			{
				c2 = 0;
			}

		}

		else if (tipo_navio == 3)
		{
			c1 = new Random().nextInt(N - 1);
			c2 = new Random().nextInt(M);

			if (c1 < 0)
			{
				c1 = 0;
			}

		}

		else if (tipo_navio == 4)
		{
			c1 = new Random().nextInt(N);
			c2 = new Random().nextInt(M - 3);

			if (c2 < 0)
			{
				c2 = 0;
			}

		}

		else if (tipo_navio == 5)
		{
			c1 = new Random().nextInt(N - 3);
			c2 = new Random().nextInt(M);

			if (c1 < 0)
			{
				c1 = 0;
			}
		}

		coordenadas_navio[0] = c1;
		coordenadas_navio[1] = c2;

		return coordenadas_navio;
	}

	public static int[] gerarCoordenadas2(int tipo_navio, int orientacao, int N, int M)
	{

		// 0 - tipo S ; 1 - tipo SS ; 2 - tipo SSSS
		// 0 - norte ; 1 - sul ; 2 - este ; 3 - oeste

		int[] coordenadas_navio = new int[2];
		int c1 = 0;
		int c2 = 0;

		if (tipo_navio == 0)
		{
			c1 = new Random().nextInt(N);
			c2 = new Random().nextInt(M);

		}

		else if (tipo_navio == 1)
		{
			c1 = new Random().nextInt(N);
			c2 = new Random().nextInt(M);

			if (orientacao == 0)
			{
				while (c1 < 1)
				{
					c1 = new Random().nextInt(N);
				}
			}

			else if (orientacao == 1)
			{
				while (c1 >= (N - 1))
				{
					c1 = new Random().nextInt(N);
				}

			}

			else if (orientacao == 2)
			{
				while (c2 >= (M - 1))
				{
					c2 = new Random().nextInt(M);
				}
			}

			else
			{
				while (c2 < 1)
				{
					c2 = new Random().nextInt(M);
				}
			}
		}

		else
		{
			c1 = new Random().nextInt(N);
			c2 = new Random().nextInt(M);

			if (orientacao == 0)
			{
				while (c1 < 3)
				{
					c1 = new Random().nextInt(N);
				}
			}

			else if (orientacao == 1)
			{
				while (c1 >= (N - 3))
				{
					c1 = new Random().nextInt(N);
				}
			}

			else if (orientacao == 2)
			{
				while (c2 >= (M - 3))
				{
					c2 = new Random().nextInt(M);
				}
			}

			else
			{
				while (c2 < 3)
				{
					c2 = new Random().nextInt(M);
				}
			}
		}

		coordenadas_navio[0] = c1;
		coordenadas_navio[1] = c2;

		return coordenadas_navio;
	}

	public static char[][] criarTabuleiro(int N, int M, char water, int navios_colocados, int navios, char ship)
	{
		char[][] tabuleiro = new char[N][M];
		int tipo_navio;
		int[] local;
		char possivel_local;
		char possivel_local1;
		char possivel_local2;
		char possivel_local3;
		char possivel_local4;

		for (char[] row : tabuleiro)
		{
			Arrays.fill(row, water);
		}
		while (navios_colocados < 1)
		{
			tipo_navio = 1;
			local = gerarCoordenadas(tipo_navio, N, M);

			possivel_local = tabuleiro[local[0]][local[1]];

			if (possivel_local == water)
			{
				tabuleiro[local[0]][local[1]] = ship;
				navios_colocados++;
			}
		}

		while (navios_colocados < 2)
		{
			tipo_navio = new Random().nextInt(1, 4);
			local = gerarCoordenadas(tipo_navio, N, M);

			if (tipo_navio == 2)
			{
				possivel_local1 = tabuleiro[local[0]][local[1]];
				possivel_local2 = tabuleiro[local[0]][(local[1] + 1)];

				if (possivel_local1 == water && possivel_local2 == water)
				{
					tabuleiro[local[0]][local[1]] = ship;
					tabuleiro[local[0]][(local[1] + 1)] = ship;
					navios_colocados++;
				}
			}

			else if (tipo_navio == 3)
			{
				possivel_local1 = tabuleiro[local[0]][local[1]];
				possivel_local2 = tabuleiro[(local[0] + 1)][local[1]];

				if (possivel_local1 == water && possivel_local2 == water)
				{
					tabuleiro[local[0]][local[1]] = ship;
					tabuleiro[(local[0] + 1)][local[1]] = ship;
					navios_colocados++;
				}
			}
		}

		while (navios_colocados < 3)
		{

			tipo_navio = new Random().nextInt(3, 6);
			local = gerarCoordenadas(tipo_navio, N, M);

			if (tipo_navio == 4)
			{
				possivel_local1 = tabuleiro[local[0]][local[1]];
				possivel_local2 = tabuleiro[local[0]][(local[1] + 1)];
				possivel_local3 = tabuleiro[local[0]][(local[1] + 2)];
				possivel_local4 = tabuleiro[local[0]][(local[1] + 3)];

				if (possivel_local1 == water && possivel_local2 == water && possivel_local3 == water
						&& possivel_local4 == water)
				{
					tabuleiro[local[0]][local[1]] = ship;
					tabuleiro[local[0]][(local[1] + 1)] = ship;
					tabuleiro[local[0]][(local[1] + 2)] = ship;
					tabuleiro[local[0]][(local[1] + 3)] = ship;
					navios_colocados++;
				}
			}

			else if (tipo_navio == 5)
			{
				possivel_local1 = tabuleiro[local[0]][local[1]];
				possivel_local2 = tabuleiro[(local[0] + 1)][local[1]];
				possivel_local3 = tabuleiro[(local[0] + 2)][local[1]];
				possivel_local4 = tabuleiro[(local[0] + 3)][local[1]];

				if (possivel_local1 == water && possivel_local2 == water && possivel_local3 == water
						&& possivel_local4 == water)
				{
					tabuleiro[local[0]][local[1]] = ship;
					tabuleiro[(local[0] + 1)][local[1]] = ship;
					tabuleiro[(local[0] + 2)][local[1]] = ship;
					tabuleiro[(local[0] + 3)][local[1]] = ship;
					navios_colocados++;
				}
			}

		}

		while (navios_colocados < navios)
		{
			tipo_navio = new Random().nextInt(0, 6);
			// 1) S 2) SS (horl) 3) SS (ver) 4) SSSS (hor) 5) SSSS (ver)

			local = gerarCoordenadas(tipo_navio, N, M);

			if (tipo_navio == 1)
			{
				possivel_local = tabuleiro[local[0]][local[1]];

				if (possivel_local == water)
				{
					tabuleiro[local[0]][local[1]] = ship;
					navios_colocados++;
				}
			}

			else if (tipo_navio == 2)
			{
				possivel_local1 = tabuleiro[local[0]][local[1]];
				possivel_local2 = tabuleiro[local[0]][(local[1] + 1)];

				if (possivel_local1 == water && possivel_local2 == water)
				{
					tabuleiro[local[0]][local[1]] = ship;
					tabuleiro[local[0]][(local[1] + 1)] = ship;
					navios_colocados++;
				}
			}

			else if (tipo_navio == 3)
			{
				possivel_local1 = tabuleiro[local[0]][local[1]];
				possivel_local2 = tabuleiro[(local[0] + 1)][local[1]];

				if (possivel_local1 == water && possivel_local2 == water)
				{
					tabuleiro[local[0]][local[1]] = ship;
					tabuleiro[(local[0] + 1)][local[1]] = ship;
					navios_colocados++;
				}
			}

			else if (tipo_navio == 4)
			{
				possivel_local1 = tabuleiro[local[0]][local[1]];
				possivel_local2 = tabuleiro[local[0]][(local[1] + 1)];
				possivel_local3 = tabuleiro[local[0]][(local[1] + 2)];
				possivel_local4 = tabuleiro[local[0]][(local[1] + 3)];

				if (possivel_local1 == water && possivel_local2 == water && possivel_local3 == water
						&& possivel_local4 == water)
				{
					tabuleiro[local[0]][local[1]] = ship;
					tabuleiro[local[0]][(local[1] + 1)] = ship;
					tabuleiro[local[0]][(local[1] + 2)] = ship;
					tabuleiro[local[0]][(local[1] + 3)] = ship;
					navios_colocados++;
				}
			}

			else if (tipo_navio == 5)
			{
				possivel_local1 = tabuleiro[local[0]][local[1]];
				possivel_local2 = tabuleiro[(local[0] + 1)][local[1]];
				possivel_local3 = tabuleiro[(local[0] + 2)][local[1]];
				possivel_local4 = tabuleiro[(local[0] + 3)][local[1]];

				if (possivel_local1 == water && possivel_local2 == water && possivel_local3 == water
						&& possivel_local4 == water)
				{
					tabuleiro[local[0]][local[1]] = ship;
					tabuleiro[(local[0] + 1)][local[1]] = ship;
					tabuleiro[(local[0] + 2)][local[1]] = ship;
					tabuleiro[(local[0] + 3)][local[1]] = ship;
					navios_colocados++;
				}
			}

		}

		return tabuleiro;
	}

	public static char[][] criarTabuleiro2(int N, int M, char water, int navios, char ship)
	{
		char[][] tabuleiro = new char[N][M];
		int tipo_navio;
		int orientacao;
		int[] local = new int[2];
		int tentativa = 0;
		int navios_colocados = 0;

		char possivel_local;
		char possivel_local1;
		char possivel_local2;
		char possivel_local3;
		char possivel_local4;

		// 0 - tipo S ; 1 - tipo SS ; 2 - tipo SSSS
		// 0 - norte ; 1 - sul ; 2 - este ; 3 - oeste

		for (char[] row : tabuleiro)
		{
			Arrays.fill(row, water);
		}

		while (navios_colocados < navios && tentativa <= 100)
		{
			tentativa++;

			if (navios_colocados == 0)
			{
				tipo_navio = 0;
			}

			else if (navios_colocados == 1)
			{
				tipo_navio = 1;
			}

			else if (navios_colocados == 2)
			{
				tipo_navio = 2;
			}

			else
			{
				tipo_navio = new Random().nextInt(3);
			}

			if (tipo_navio == 0)
			{
				orientacao = 0;
				local = gerarCoordenadas2(tipo_navio, orientacao, N, M);
				possivel_local = tabuleiro[local[0]][local[1]];

				if (possivel_local == water)
				{
					tabuleiro[local[0]][local[1]] = ship;
					navios_colocados++;
				}
			}

			else if (tipo_navio == 1)
			{
				orientacao = new Random().nextInt(4);
				local = gerarCoordenadas2(tipo_navio, orientacao, N, M);

				if (orientacao == 0)
				{
					possivel_local1 = tabuleiro[local[0]][local[1]];
					possivel_local2 = tabuleiro[local[0] - 1][local[1]];

					if (possivel_local1 == water && possivel_local2 == water)
					{
						tabuleiro[local[0]][local[1]] = ship;
						tabuleiro[local[0] - 1][local[1]] = ship;
						navios_colocados++;
					}
				}

				else if (orientacao == 1)
				{
					possivel_local1 = tabuleiro[local[0]][local[1]];
					possivel_local2 = tabuleiro[local[0] + 1][local[1]];

					if (possivel_local1 == water && possivel_local2 == water)
					{
						tabuleiro[local[0]][local[1]] = ship;
						tabuleiro[local[0] + 1][local[1]] = ship;
						navios_colocados++;
					}
				}

				else if (orientacao == 2)
				{
					possivel_local1 = tabuleiro[local[0]][local[1]];
					possivel_local2 = tabuleiro[local[0]][local[1] + 1];

					if (possivel_local1 == water && possivel_local2 == water)
					{
						tabuleiro[local[0]][local[1]] = ship;
						tabuleiro[local[0]][local[1] + 1] = ship;
						navios_colocados++;
					}
				}

				else
				{
					possivel_local1 = tabuleiro[local[0]][local[1]];
					possivel_local2 = tabuleiro[local[0]][local[1] - 1];

					if (possivel_local1 == water && possivel_local2 == water)
					{
						tabuleiro[local[0]][local[1]] = ship;
						tabuleiro[local[0]][local[1] - 1] = ship;
						navios_colocados++;
					}
				}
			}

			else if (tipo_navio == 2)
			{
				orientacao = new Random().nextInt(4);
				local = gerarCoordenadas2(tipo_navio, orientacao, N, M);

				if (orientacao == 0)
				{
					possivel_local1 = tabuleiro[local[0]][local[1]];
					possivel_local2 = tabuleiro[local[0] - 1][local[1]];
					possivel_local3 = tabuleiro[local[0] - 2][local[1]];
					possivel_local4 = tabuleiro[local[0] - 3][local[1]];

					if (possivel_local1 == water && possivel_local2 == water && possivel_local3 == water
							&& possivel_local4 == water)
					{
						tabuleiro[local[0]][local[1]] = ship;
						tabuleiro[local[0] - 1][local[1]] = ship;
						tabuleiro[local[0] - 2][local[1]] = ship;
						tabuleiro[local[0] - 3][local[1]] = ship;
						navios_colocados++;
					}
				}

				else if (orientacao == 1)
				{
					possivel_local1 = tabuleiro[local[0]][local[1]];
					possivel_local2 = tabuleiro[local[0] + 1][local[1]];
					possivel_local3 = tabuleiro[local[0] + 2][local[1]];
					possivel_local4 = tabuleiro[local[0] + 3][local[1]];

					if (possivel_local1 == water && possivel_local2 == water && possivel_local3 == water
							&& possivel_local4 == water)
					{
						tabuleiro[local[0]][local[1]] = ship;
						tabuleiro[local[0] + 1][local[1]] = ship;
						tabuleiro[local[0] + 2][local[1]] = ship;
						tabuleiro[local[0] + 3][local[1]] = ship;
						navios_colocados++;
					}
				}

				else if (orientacao == 2)
				{
					possivel_local1 = tabuleiro[local[0]][local[1]];
					possivel_local2 = tabuleiro[local[0]][local[1] + 1];
					possivel_local3 = tabuleiro[local[0]][local[1] + 2];
					possivel_local4 = tabuleiro[local[0]][local[1] + 3];

					if (possivel_local1 == water && possivel_local2 == water && possivel_local3 == water
							&& possivel_local4 == water)
					{
						tabuleiro[local[0]][local[1]] = ship;
						tabuleiro[local[0]][local[1] + 1] = ship;
						tabuleiro[local[0]][local[1] + 2] = ship;
						tabuleiro[local[0]][local[1] + 3] = ship;
						navios_colocados++;
					}
				}

				else
				{
					possivel_local1 = tabuleiro[local[0]][local[1]];
					possivel_local2 = tabuleiro[local[0]][local[1] - 1];
					possivel_local3 = tabuleiro[local[0]][local[1] - 2];
					possivel_local4 = tabuleiro[local[0]][local[1] - 3];

					if (possivel_local1 == water && possivel_local2 == water && possivel_local3 == water
							&& possivel_local4 == water)
					{
						tabuleiro[local[0]][local[1]] = ship;
						tabuleiro[local[0]][local[1] - 1] = ship;
						tabuleiro[local[0]][local[1] - 2] = ship;
						tabuleiro[local[0]][local[1] - 3] = ship;
						navios_colocados++;
					}
				}
			}
		}

		if (tentativa > 100)
		{
			System.out.println(
					"Excedeu o número máximo de tentativas de colocação. Por favor inserir novos valores iniciais");
			tabuleiro = new char[2][2];
		}

		return tabuleiro;

	}

	public static void printTabuleiro(char[][] tabuleiro, char water, char ship, int N, int M)
	{
		System.out.print("    ");

		for (int i = 0; i < M; i++)
		{

			if (i < 9)
			{
				System.out.print(i + 1 + "  ");
			}
			else
			{
				System.out.print(i + 1 + " ");
			}
		}

		System.out.println();

		for (int row = 0; row < N; row++)
		{
			if (row < 9)
			{
				System.out.print(row + 1 + "   ");
			}

			else
			{
				System.out.print(row + 1 + "  ");
			}

			for (int col = 0; col < M; col++)
			{
				char posicao = tabuleiro[row][col];

				// if (posicao == ship)
				// {
				// System.out.print(water + " ");
				// }
				//
				// else
				// {
				System.out.print(posicao + "  ");
				// }
			}

			System.out.println();
		}
	}

	public static int[] inserirCoordenadas(int N, int M, Scanner scan)
	{
		int row = 0;
		int col = 0;
		boolean val_linha = true;
		boolean val_col = true;
		int[] coordenadas = new int[2];

		while (val_linha)
		{
			System.out.print("Linha: ");

			if (scan.hasNextInt())
			{
				row = scan.nextInt();

				if (row <= N && row >= 1)
				{
					coordenadas[0] = row - 1;
					val_linha = false;
					scan.nextLine();
				}

				else
				{
					System.out.println("Dimensões fora dos limites");
					System.out.println();
					scan.nextLine();
				}
			}

			else
			{
				System.out.println("Formato inválido");
				System.out.println();
				scan.nextLine();
			}
		}

		System.out.println();

		while (val_col)
		{
			System.out.print("Coluna: ");

			if (scan.hasNextInt())
			{
				col = scan.nextInt();

				if (col <= M && col >= 1)
				{
					coordenadas[1] = col - 1;
					val_col = false;
					scan.nextLine();
				}

				else
				{
					System.out.println("Dimensões fora dos limites");
					System.out.println();
					scan.nextLine();
				}
			}

			else
			{
				System.out.println("Formato inválido");
				System.out.println();
				scan.nextLine();
			}
		}

		return coordenadas;
		// return new int[] { row - 1, col - 1 };

	}

	public static char avaliarShot(int[] coordenadasJogador, char[][] tabuleiro, char ship, char water, char hit,
			char miss)
	{
		int row = coordenadasJogador[0];
		int col = coordenadasJogador[1];
		char alvo = tabuleiro[row][col];

		String message;

		if (alvo == ship)
		{
			message = "Acertou!";
			alvo = hit;
		}

		else if (alvo == water)
		{
			message = "Água!";
			alvo = miss;
		}

		else
		{
			message = "Já atingido";
		}

		System.out.println(message);
		System.out.println();
		return alvo;

	}

	public static char[][] atualizarTabuleiro(char[][] tabuleiro, int[] coordenadasJogador, char resultadoShot)
	{
		int row = coordenadasJogador[0];
		int col = coordenadasJogador[1];
		tabuleiro[row][col] = resultadoShot;
		return tabuleiro;
	}

	public static int contarS(char[][] tabuleiro, char ship, int N, int M)
	{
		int numS = 0;

		for (int row = 0; row < N; row++)
		{
			for (int col = 0; col < M; col++)
			{
				if (tabuleiro[row][col] == ship)
				{
					numS++;
				}
			}
		}

		return numS;
	}

	public static boolean iniciarNovoJogo(boolean val_jogo, Scanner scan)
	{
		boolean val_escolha = true;
		int i = 0;

		while (val_escolha)
		{
			System.out.println("Insira [1] para jogar novamente e [2] para voltar ao menu principal.");
			i = scan.nextInt();

			if (i == 1)
			{
				val_escolha = false;
				val_jogo = true;
			}

			else if (i == 2)
			{
				val_escolha = false;
				val_jogo = false;
			}

			else
			{
				System.out.println("Valor inválido");
				val_escolha = true;
			}
		}
		return val_jogo;
	}

	public static boolean abandonarJogo(boolean val_abandonar, Scanner scan)
	{
		boolean val_escolha = true;
		String i;

		System.out.println("Prima enter para continuar a jogar ou escreva 'quit' para abandonar a partida.");

		while (val_escolha)
		{
			i = scan.nextLine();

			if (i.equals(""))
			{
				val_escolha = false;
				val_abandonar = false;
			}

			else if (i.equals("quit"))
			{
				val_escolha = false;
				val_abandonar = true;
			}

			else
			{
				System.out.println("Formato inválido");
				System.out.println("Prima enter para continuar a jogar ou escreva 'quit' para abandonar a partida.");
			}
		}
		return val_abandonar;
	}

}
