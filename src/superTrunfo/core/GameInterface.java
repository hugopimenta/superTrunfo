package superTrunfo.core;

import superTrunfo.card.Card;
import superTrunfo.card.Card.Attribute;
import superTrunfo.player.Player;

public final class GameInterface {

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static void printMove(Player player, Card card, Attribute attribute) {
		System.out.print(player.getName() + " - " + attribute + " = ");
		String value = null;
		switch (attribute) {
		case CC:
			value = card.getCc().toString();
			break;
		case Code:
			value = card.getCodeNumber();
			break;
		case Power:
			value = card.getPower().toString();
			break;
		case RPM:
			value = card.getRpm().toString();
			break;
		case Speed:
			value = card.getSpeed().toString();
			break;
		case Weight:
			value = card.getWeight().toString();
			break;
		default:
			break;
		}
		System.out.print(value + "\n");

	}

}
