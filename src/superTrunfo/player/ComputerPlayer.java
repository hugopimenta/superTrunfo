package superTrunfo.player;

import java.util.List;
import java.util.Scanner;

import superTrunfo.card.Card;
import superTrunfo.card.Card.Attribute;

public class ComputerPlayer extends BasePlayer implements Player {
	private static final int CCMEDIAN = 1000;
	private static final int POWERMEDIAN = 93;
	private static final int RPMMEDIAN = 72500;
	private static final int SPEEDMEDIAN = 193;
	private static final int WEIGHTMEDIAN = 239;

	@Override
	public Attribute chooseRoundAttribute(Scanner scanner, Card card) {
		// cilindradas;potencia;rotacoes;velocidade;peso
		// Se for supertrunfo, usará.
		// Escolhe entre os atributos aquele com maior porcentagem em relação a mediana da categoria.
		if (card.getCodeNumber().equals("S"))
			return Attribute.Code;
		
		List<Attribute> attributeList = Card.getAttributeList();
		double percentage = 0;
		Attribute attributeChoice = null;
		for(Attribute att: attributeList) {
			if (getAttributePercentage(att) > percentage) {
				percentage = getAttributePercentage(att);
				attributeChoice = att;
			}
		}
		return attributeChoice;
	}

	// Porcentagem em relação a mediana
	private double getAttributePercentage(Attribute att) {
		double percentage;
		switch (att) {
		case CC:
			percentage = cards.peek().getCc()/CCMEDIAN;
			break;
		case Power:
			percentage = cards.peek().getPower()/POWERMEDIAN;
			break;
		case RPM:
			percentage = cards.peek().getRpm()/RPMMEDIAN;
			break;
		case Speed:
			percentage = cards.peek().getSpeed()/SPEEDMEDIAN;
			break;
		case Weight:
			percentage = cards.peek().getWeight()/WEIGHTMEDIAN;
			break;
		default:
			percentage = 0;
			break;
		}
		return percentage;
	}

}
