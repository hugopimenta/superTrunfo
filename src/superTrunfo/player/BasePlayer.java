package superTrunfo.player;

import java.util.ArrayDeque;
import java.util.Deque;

import superTrunfo.card.Card;
import superTrunfo.card.Card.Attribute;

public abstract class BasePlayer implements Player {
	protected String name;
	protected Deque<Card> cards;

	public BasePlayer() {
		this.cards = new ArrayDeque<>();
	}
	
	@Override
	public Object value(Attribute attribute) {
		int value = 0;
		switch (attribute) {
		case CC:
			break;
		case Code:
			break;
		case Power:
			break;
		case RPM:
			break;
		case Speed:
			break;
		case Weight:
			break;
		default:
			break;
		}
		return value;
	}

	@Override
	public Card getCard() {
		return this.cards.pop();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void addCard(Card card) {
		if (card == null) {
			return;
		}
		this.cards.addLast(card);
	}
	
	@Override
	public int getNumberOfCards() {
		return this.cards.size();
	}

}
