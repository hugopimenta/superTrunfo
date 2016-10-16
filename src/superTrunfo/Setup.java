package superTrunfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import superTrunfo.card.Card;
import superTrunfo.card.CardBuilder;

public class Setup {
	
	// Retorna as cartas do jogo, em ordem aleatória
	public List<Card> getGameDeque() {
		List<Card> deque = new ArrayList<>();
		Scanner scan = new Scanner("cards.txt");
		while(scan.hasNext()) {
			String line = scan.nextLine();
			String[] v = line.split(";");
			
			// codigo;tipo;nome;cilindradas;potencia;rotacoes;velocidade;peso
			deque.add(new CardBuilder().code(v[0]).type(v[1]).name(v[2]).cc(Integer.valueOf(v[3]))
					.power(Integer.valueOf(v[4])).rpm(Integer.valueOf(v[5])).speed(Integer.valueOf(v[6]))
					.weight(Integer.valueOf(v[7])).build());
		}
		scan.close();
		Collections.shuffle(deque);
		return deque;
	}
}
