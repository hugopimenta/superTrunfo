package superTrunfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

import superTrunfo.card.Card;
import superTrunfo.card.CardBuilder;

public class Setup {
	
	private static int numberOfCards = 0;
	
	// Retorna as cartas do jogo, em ordem aleatória
	public static Deque<Card> getGameDeque() throws FileNotFoundException {
		List<Card> cardList = new ArrayList<>();
		Scanner scan = new Scanner(new File("cards.txt"));
		while(scan.hasNext()) {
			String line = scan.nextLine();
			String[] v = line.split(";");
			numberOfCards++;
			
			// codigo;tipo;nome;cilindradas;potencia;rotacoes;velocidade;peso
			Card card = new CardBuilder().code(v[0]).type(v[1]).name(v[2]).cc(Integer.valueOf(v[3]))
					.power(Integer.valueOf(v[4])).rpm(Integer.valueOf(v[5])).speed(Integer.valueOf(v[6]))
					.weight(Integer.valueOf(v[7])).build();
			cardList.add(card);
		}
		scan.close();
		Collections.shuffle(cardList);
		
		// Monta o deque
		Deque<Card> deque = new ArrayDeque<>();
		for(Card card: cardList) {
			deque.add(card);
		}
		return deque;
	}
	
	public static int getNumberOfCards() {
		return numberOfCards;
	}
}
