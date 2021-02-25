package genius;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Genius {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int nivel = 0;
		boolean continua = false;

		do {
			System.out.println("Entre o nivel desejado de 1 a 5.");
			nivel = scanner.nextInt();
			if (nivel >= 1 && nivel <= 5) {
				continua = true;
			} else {
				System.out.println("As opções de nivel devem ser de 1 a 5");
			}
		} while (continua == false);

		System.out.println("Nivel do jogo: " + nivel);

		switch (nivel) {
			case 1: {
				nivel = 3;
				break;
			}
			case 2: {
				nivel = 5;
				break;
			}
			case 3: {
				nivel = 7;
			}
				break;
			case 4: {
				nivel = 9;
			}
				break;
			case 5: {
				nivel = 11;
				break;
			}
		}
		
		List<Integer> jogada = null;
		List<Integer> tentativa = null;
		int pop = 0;
		boolean encerrado = false;

		for (int i = 0; i < nivel ; i++) {
			if (encerrado) {
				break;
			}
			int numeroAleatorio = (int) (Math.random() * 4) + 1;
			System.out.println("Número " + (i + 1) + " gerado: " + numeroAleatorio);
			
			if (jogada == null) {
				jogada = new ArrayList<>(nivel);
			}
			jogada.add(i, numeroAleatorio);

			System.out.println("Tentativa numero: " + (i + 1));
			
			for (Integer numero : jogada) {
				System.out.print(" ##### " + numero);
				try {
					TimeUnit.MILLISECONDS.sleep(1100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}System.out.println("");
			
			for (int j = 0; j < i + 1; j++) {
				
				if (tentativa == null) {
					tentativa = new ArrayList<>(nivel);
				}
				System.out.println("Entre com o numero visualizado: ");
				pop = scanner.nextInt();
				if (pop == jogada.get(j)) {
					System.out.println("Numero igual");
					tentativa.add(j, pop);
				} else {
					System.out.println("Jogo encerrado, voce errou o ultimo número digitado.");
					encerrado = true;
					break;
				}
			}
			tentativa.clear();
			if ((i + 1) == nivel) {
				System.out.println("Meus parabens. Voce tem uma otima memoria");
			}
		}
		scanner.close();
	}

}
