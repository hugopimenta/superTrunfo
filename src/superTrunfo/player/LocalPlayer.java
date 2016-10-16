package superTrunfo.player;

import java.util.Deque;
import java.util.Scanner;

import superTrunfo.card.Card;
import superTrunfo.card.Card.Attribute;
import superTrunfo.core.GameInterface;

public class LocalPlayer implements Player {
	private String name;
	private Deque<Card> cards;

	public Attribute chooseRoundAttribute() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Selecione a estatistica que deseja jogar: ");
		int move = scanner.nextInt();
		Card.Attribute option = null;
		switch (move) {
		case 1:
			option = Attribute.CC;
			break;
		case 2:
			option = Attribute.Power;
			break;
		case 3:
			option = Attribute.RPM;
			break;
		case 4:
			option = Attribute.Speed;
			break;
		case 5:
			option = Attribute.Weight;
			break;
		case 6:
			if (this.cards.peek().getCodeNumber().equals("S")) {
				option = Attribute.Code;
				break;
			}
		default:
			System.out.println("Opção inválida. Aperte 'enter' para prosseguir.");
			scanner.next();
			GameInterface.clearScreen();
			chooseRoundAttribute();
		}
		scanner.close();
		return option;
	}

	public Object value(Attribute attribute) {
		
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Card getCard() {
		return cards.pop();
	}

	public void addCards(Deque<Card> cards) {
		for(Card newCard: cards) {
			this.cards.addLast(newCard);
		}
	}
	
	
	
	

}
