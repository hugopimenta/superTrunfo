package superTrunfo.player;

import java.util.Scanner;

import superTrunfo.card.Card;

/**
 * A interface de player é utilizada para podermos implementar diversos tipos de jogadores
 * como jogador local ou computador.  
 */
public interface Player {
	// Escolhe qual será o atributo da rodada
	public Card.Attribute chooseRoundAttribute(Scanner scanner, Card card);
	
	// Retorna o valor do atributo da rodada
	public Object value(Card.Attribute attribute);
	
	// Retorna a carta do topo da pilha do jogador 
	public Card getCard();
	
	// Visualiza carta do topo
	public Card peekCard();
	
	// Retorna o nome
	public String getName();
	
	// Seta o nome
	public void setName(String name);
	
	// Adiciona uma carta
	public void addCard(Card card);
	
	// Quantidade de cartas
	public int getNumberOfCards();
	
	
}
