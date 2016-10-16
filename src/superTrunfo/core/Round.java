package superTrunfo.core;

import java.util.Deque;
import java.util.List;

import superTrunfo.card.Card;
import superTrunfo.player.Player;

public class Round {
	private Deque<Card> tableCards;
	
	private static Round SINGLETON;
	
	// Construtor padrão é privado
	private Round() {}
	
	// Acesso à instância
	public static Round getInstance() {
		if (SINGLETON == null) {
			SINGLETON = new Round(); 
		}
		return SINGLETON;
	}
	
	// Retorna o vencedor da rodada
	public Player round(List<Player> players) {
		if (players.size() == 1) {
			return players.get(0);
		}
		
		Card.Attribute attribute = players.get(0).chooseRoundAttribute();
		Player winner = players.get(0);
		Card winnerCard = winner.getCard();
		GameInterface.printMove(winner, winnerCard, attribute);
		
		for(Player opponent: players) {
			Card opponentCard = opponent.getCard();
			GameInterface.printMove(opponent, opponentCard, attribute);
			int result = winnerCard.compareCards(opponentCard, attribute);
			if(result == 0) {
				continue;
			} else if (result == 1) {
				players.remove(opponent);
				tableCards.addLast(opponentCard);
			} else {
				winner = opponent;
				tableCards.addLast(winnerCard);
				winnerCard = opponentCard;
			}
		}
		
		if (players.size() > 1) {
			round(players);
		}
		
		return players.get(0);
	}

	
}
