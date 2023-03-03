package trabalho1_v_final;

public class ManageStats
{
	public static void printMed(int[] jogadasTotal, int numJogo)
	{
		double total = 0;
		double jogadasSoma = 0;
		
		for (int i = 1; i <= numJogo; i++)
		{
			total++;
			jogadasSoma = jogadasSoma + jogadasTotal[i];
			
		}
		
		double jogadasMed = jogadasSoma / total;
		
		System.out.println("Média de jogadas por partida: " + jogadasMed);
		
	}
	
	public static void printPerc(char[] resultado, int numJogo, int[] jogadasTotal, char vitoria, char derrota, char abandono)
	{
		double vitorias = 0;
		double abandonos = 0;
		double derrotas = 0;
		double total = 0;
		
		for (int i = 1; i <= numJogo; i++)
		{
			total++;
			
			if (resultado[i] == vitoria)
			{
				vitorias++;
			}
			
			else if (resultado[i] == derrota)
			{
				derrotas++;
			}
			
			else
			{
				abandonos++;
			}
		}
		
		System.out.println();
		
		double V_perc = (vitorias / total) * 100;
		double D_perc = (derrotas / total) * 100;
		double A_perc = (abandonos / total) * 100;
		
		System.out.println("Percentagem de vitórias: " + V_perc + "%");
		System.out.println("Percentagem de derrotas: " + D_perc + "%");
		System.out.println("Percentagem de abandonos: " + A_perc + "%");
		
	}

	public static void printStatsTotal(char[] resultado, int numJogo, int[] jogadasTotal)
	{
		System.out.print("Número do jogo:    ");
		for (int i = 1; i <= numJogo; i++)
		{
			System.out.print(i + "   ");
		}

		System.out.println();
		System.out.print("Resultado:         ");

		for (int i = 1; i <= numJogo; i++)
		{
			System.out.print(resultado[i] + "   ");
		}
		
		System.out.println();
		System.out.print("Jogadas:           ");
		
		for (int i = 1; i <= numJogo; i++)
		{
			if (jogadasTotal[i] < 10)
			{
				System.out.print(jogadasTotal[i] + "   ");
			}
			else
			{
				System.out.print(jogadasTotal[i] + "  ");
			}
		}
		
		System.out.println();
		System.out.println("\nLegenda: 'A' - Abandonado , 'V' - Vitória , 'D' - Derrota");
		

	}

}
