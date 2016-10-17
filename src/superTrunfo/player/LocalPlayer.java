package superTrunfo.player;

import java.util.Scanner;

import superTrunfo.card.Card;
import superTrunfo.card.Card.Attribute;

public class LocalPlayer extends BasePlayer implements Player {

	public Attribute chooseRoundAttribute(Scanner scanner, Card card) {
		scanner.nextLine();
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
			if (card.getCodeNumber().equals("S")) {
				option = Attribute.Code;
				break;
			}
		default:
			System.out.println("Op��o inv�lida.");
			return chooseRoundAttribute(scanner, card);
		}
		return option;
	}	

}
