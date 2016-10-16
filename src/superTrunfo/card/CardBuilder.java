package superTrunfo.card;

/**
 * Classe para gerar cartas do jogo. 
 *
 */
public class CardBuilder {
	private Card card;
	
	public CardBuilder() {
		this.card = new Card();
	}
	
	public CardBuilder code(String code) {
		this.card.setCode(code);
		return this;
	}
	public CardBuilder type(String type) {
		this.card.setType(type);
		return this;
	}
	public CardBuilder name(String name) {
		this.card.setName(name);
		return this;
	}
	public CardBuilder cc(Integer cc) {
		this.card.setCc(cc);
		return this;
	}
	
	public CardBuilder power(Integer power) {
		this.card.setPower(power);
		return this;
	}
	
	public CardBuilder rpm(Integer rpm) {
		this.card.setRpm(rpm);
		return this;
	}
	public CardBuilder speed(Integer speed) {
		this.card.setSpeed(speed);
		return this;
	}
	public CardBuilder weight(Integer weight) {
		this.card.setWeight(weight);
		return this;
	}

	public Card build() {
		return this.card;
	}
}
