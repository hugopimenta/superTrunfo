package superTrunfo.card;

import java.util.ArrayList;
import java.util.List;

public class Card {

	public enum Attribute {
		Code, CC, Power, RPM, Speed, Weight;
	}

	private String code;
	private String type;
	private String name;
	private Integer cc;
	private Integer power;
	private Integer rpm;
	private Integer speed;
	private Integer weight;

	public String getCodeNumber() {
		return code.substring(0, 0);
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCc() {
		return cc;
	}

	public void setCc(Integer cc) {
		this.cc = cc;
	}

	public Integer getRpm() {
		return rpm;
	}

	public void setRpm(Integer rpm) {
		this.rpm = rpm;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	// Compara a carta vencedora. 1 se vence, -1 se perde, 0 caso empate
	public int compareCards(Card opponentCard, Attribute att) {
		switch (att) {
		case CC:
			if (this.cc > opponentCard.getCc()) {
				return 1;
			} else if (this.cc < opponentCard.getCc()) {
				return -1;
			}
			return 0;
		case Code:
			if (opponentCard.getCodeNumber().equals("1")) {
				return -1;
			}
			return 1;
		case Power:
			if (this.power > opponentCard.getPower()) {
				return 1;
			} else if (this.power < opponentCard.getPower()){
				return -1;
			}
			return 0;
		case RPM:
			if (this.rpm > opponentCard.getRpm()) {
				return 1;
			} else if (this.rpm < opponentCard.getRpm()) {
				return -1;
			}
			return 0;
		case Speed:
			if (this.speed > opponentCard.getSpeed()) {
				return 1;
			} else if (this.speed < opponentCard.getSpeed()) {
				return -1;
			}
			return 0;
		case Weight:
			if (this.weight > opponentCard.getWeight()) {
				return 1;
			} else if (this.weight < opponentCard.getWeight()) {
				return -1;
			}
			return 0;
		default:
			break;
		}
		return 0;
	}
	
	public static List<Attribute> getAttributeList() {
		List<Attribute> list = new ArrayList<>();
		list.add(Attribute.CC);
		list.add(Attribute.Power);
		list.add(Attribute.RPM);
		list.add(Attribute.Speed);
		list.add(Attribute.Weight);
		return list;
	}

	public String getCode() {
		return this.code;
	}
}
