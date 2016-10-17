package superTrunfo.core;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import superTrunfo.card.Card;
import superTrunfo.player.LocalPlayer;
import superTrunfo.player.Player;

public class Round {
	private Deque<Card> tableCards;

	private static Round SINGLETON;
	
	// Construtor padrão é privado
	private Round() {
		tableCards = new ArrayDeque<>();
	}
	
	// Acesso à instância
	public static Round getInstance() {
		if (SINGLETON == null) {
			SINGLETON = new Round(); 
		}
		return SINGLETON;
	}
	
	// Retorna o vencedor da rodada
	public Player newRound(final List<Player> players, LocalPlayer humanPlayer, Scanner scanner) throws Exception {
		GameInterface.printGameStatus(players);
		if (players.size() == 1) {
			return players.get(0);
		}

		if (humanPlayer.getNumberOfCards()>0) {
			GameInterface.printCard(humanPlayer.peekCard());
		}
		
		List<Player> roundDraw = new ArrayList<>();
		Player winner = players.get(0);
		Card winnerCard = winner.getCard();

		Card.Attribute attribute = players.get(0).chooseRoundAttribute(scanner, winnerCard);
		GameInterface.printMove(winner, winnerCard, attribute);

		for(Player opponent: players) {
			if (opponent == winner)
				continue;
			Card opponentCard = opponent.getCard();
			GameInterface.printMove(opponent, opponentCard, attribute);
			int result = winnerCard.compareCards(opponentCard, attribute);
			
			if(result == 0) {
				roundDraw.add(opponent);
				tableCards.addLast(opponentCard);
				if(!roundDraw.contains(winner))
					roundDraw.add(winner);
			} else if (result == 1) {
				tableCards.addLast(opponentCard);
			} else {
				winner = opponent;
				tableCards.addLast(winnerCard);
				winnerCard = opponentCard;
			}
		}
		
		tableCards.addLast(winnerCard);

		if (roundDraw.size() > 1) {
			newRound(players, humanPlayer, scanner);
		}
		
		while(!tableCards.isEmpty()) {
			winner.addCard(tableCards.pop());
		}
		GameInterface.printRoundWinner(winner);
		TimeUnit.SECONDS.sleep(3);
		return winner;
	}

	
}
