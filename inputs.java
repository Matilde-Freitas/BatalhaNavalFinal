package trabalho1_v_final;

import java.util.Scanner;

public class inputs
{

	public static int check_N(boolean val_N, Scanner scan)
	{
		System.out.println();
		int N = 0;

		while (val_N)
		{
			System.out.print("Número de linhas (entre 15 e 30): ");

			if (scan.hasNextInt())
			{
				N = scan.nextInt();

				if (N > 14 && N < 31)
				{
					val_N = false;
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
		return N;
	}
	
	public static int check_M(boolean val_M, Scanner scan)
	{
		System.out.println();
		int M = 0;

		while (val_M)
		{
			System.out.print("Número de colunas (entre 15 e 30): ");

			if (scan.hasNextInt())
			{
				M = scan.nextInt();

				if (M > 14 && M < 31)
				{
					val_M = false;
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
		return M;
	}
	
	public static int check_navios(boolean val_navios, Scanner scan, int N, int M)
	{
		System.out.println();
		int navios = 0;
		int max_navios = (N*M)/4;

		while (val_navios)
		{
			System.out.print("Número de navios a colocar (mínimo de 3 e máximo de " + max_navios + "): ");

			if (scan.hasNextInt())
			{
				navios = scan.nextInt();

				if (navios >= 3 && navios <= max_navios)
				{
					val_navios = false;
				}

				else
				{
					System.out.println("Número de navios fora dos limites");
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

		return navios;
	}
	
	public static int check_shot(boolean val_shot, Scanner scan, int numS, int N, int M)
	{
		
		int min_shot = numS;
		int max_shot = N*M;
		
		System.out.println();
		int shots = 0;
		while (val_shot)
		{
			System.out.print("Número máximo de disparos (entre " + min_shot + " e " + max_shot + "): ");

			if (scan.hasNextInt())
			{
				shots = scan.nextInt();
				
				if (shots <= max_shot && shots >= min_shot)
				{
					val_shot = false;
				}
				
				else
				{
					System.out.println("Número fora dos limites");
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
		return shots;
	}


}
