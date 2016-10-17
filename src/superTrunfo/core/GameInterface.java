package superTrunfo.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import superTrunfo.card.Card;
import superTrunfo.card.Card.Attribute;
import superTrunfo.player.Player;

public final class GameInterface {
	private static final String SEPARATOR = "-----------------------------------";
	private static final String DOUBLE_SEPARATOR = SEPARATOR + SEPARATOR;
	
	public static void clearScreen() {
		System.out.print("\n\n\n\n\n\n\n");
		System.out.flush();
	}
	
	// @param motorcycle - 1 ou 2
	public static void printGameEntrance(int motorcycle) {
		System.out.println(DOUBLE_SEPARATOR);
		System.out.println("---------------------------- SUPER TRUNFO ----------------------------");
		System.out.println(DOUBLE_SEPARATOR);
		printMotorcycle(new Random().nextInt(3) + 1);
	}

	private static void printMotorcycle(int motorcycle) {
		Scanner file = null;
		try {
			file = new Scanner(new File("motorcycle" + motorcycle + ".txt"));
			while(file.hasNextLine()) {
				System.out.println(file.nextLine());
			}
			System.out.println(DOUBLE_SEPARATOR);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			file.close();
		}

	}

	public static int numberOfPlayers(Scanner scan) throws Exception {
		int number;
		do {
			System.out.println("Quantos jogadores (2 a 4)?");
			number = scan.nextInt();
			if (number > 4 || number < 2) {
				System.out.println("Valor inválido.");
				TimeUnit.SECONDS.sleep(1);
				GameInterface.clearScreen();
				printGameEntrance(1);
			} else
				break;
		} while (true);
		return number;
	}

	public static void printMove(Player player, Card card, Attribute attribute) {
		System.out.print(String.format("%-5s - %-6s = ", player.getName(), attribute)); 
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

	public static void printRoundWinner(Player winner) {
		System.out.println("O jogador " + winner.getName() + " venceu a rodada!");
		System.out.println(DOUBLE_SEPARATOR);
		
	}
	
	public static void printGameStatus(List<Player> players) {
		System.out.println(DOUBLE_SEPARATOR);
		for(Player player: players) {
			System.out.println(player.getName() + " - Possui " + player.getNumberOfCards() + " cartas.");
		}
		System.out.println(SEPARATOR);
	}

	public static void printCard(Card card) {
		System.out.println(SEPARATOR);
		System.out.println(card.getCode() + " - " + card.getType() + " " + card.getName());
		System.out.println(SEPARATOR);
		System.out.println("1) Cilindradas: " + card.getCc());
		System.out.println("2) Potência: " + card.getPower());
		System.out.println("3) Rotações: " + card.getRpm());
		System.out.println("4) Velocidade: " + card.getSpeed());
		System.out.println("5) Peso: " + card.getWeight());
		if(card.getCodeNumber().equals("S"))
			System.out.println("6) SuperTrunfo");
		System.out.println(SEPARATOR);
	}
	
	static void printGameWinner(Player winner) {
		printMotorcycle(5);
		System.out.println(DOUBLE_SEPARATOR);
		System.out.println("O jogador " + winner.getName() + " venceu o jogo!");
		System.out.println(DOUBLE_SEPARATOR);
	}

	public static void printDrawMessage(List<Player> roundDraw) {
		for(Player player: roundDraw) {
			System.out.print(player.getName() + ", ");
		}
		System.out.println("empataram! Nova rodada de desempate:");
		System.out.println(SEPARATOR);
		
	}

	public static void printPlayerOut(Player player) {
		printMotorcycle(6);
		System.out.println(player.getName() + " foi eliminado!!");
		System.out.println(DOUBLE_SEPARATOR);
		
	}

}
