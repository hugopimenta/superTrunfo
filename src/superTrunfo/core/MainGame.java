package superTrunfo.core;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

import superTrunfo.Setup;
import superTrunfo.card.Card;
import superTrunfo.player.ComputerPlayer;
import superTrunfo.player.LocalPlayer;
import superTrunfo.player.Player;

public class MainGame {

	public static void main(String[] args) throws Exception {
		List<Player> players = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		GameInterface.printGameEntrance();
		int numberOfPlayers = GameInterface.numberOfPlayers(scanner);

		System.out.println("Jogador 1\nNome: ");
		LocalPlayer humanPlayer = new LocalPlayer();
		String name = scanner.next();
		humanPlayer.setName(name);
		players.add(humanPlayer);

		for (int i = 1; i < numberOfPlayers; i++) {
			Player player = new ComputerPlayer();
			player.setName("Bot" + i);
			players.add(player);
		}
		Deque<Card> gameCards = Setup.getGameDeque();
		for (Player player : players) {
			for (int i = 0; i < Setup.getNumberOfCards() / numberOfPlayers; i++) {
				Card card = gameCards.pop();
				player.addCard(card);
			}
			if (numberOfPlayers == 3) {
				if (!gameCards.isEmpty())
					player.addCard(gameCards.pop());
			}
		}
		Round round = Round.getInstance();
		while (players.size() > 1) {
			Player roundWinner = round.newRound(players, humanPlayer, scanner);
			players.remove(roundWinner);
			players.add(0, roundWinner);

			for (Player defeated : players) {
				if (defeated.getNumberOfCards() == 0) {
					players.remove(defeated);
				}
			}
		}
		scanner.close();
		GameInterface.printGameWinner(players.get(0));
	}

}
