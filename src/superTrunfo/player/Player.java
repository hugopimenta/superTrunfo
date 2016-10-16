package superTrunfo.player;

import superTrunfo.card.Card;

/**
 * A interface de player é utilizada para podermos implementar diversos tipos de jogadores
 * como jogador local ou computador.  
 */
public interface Player {
	// Escolhe qual será o atributo da rodada
	public Card.Attribute chooseRoundAttribute();
	
	// Retorna o valor do atributo da rodada
	public Object value(Card.Attribute attribute);
	
	// Retorna a carta do topo da pilha do jogador 
	public Card getCard();
	
	public String getName();
	
	public void setName(String name);
	
}
