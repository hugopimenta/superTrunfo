all:
	javac src/superTrunfo/card/Card.java
	javac src/superTrunfo/card/CardBuilder.java
	javac src/superTrunfo/player/Player.java
	javac src/superTrunfo/player/BasePlayer.java
	javac src/superTrunfo/player/LocalPlayer.java
	javac src/superTrunfo/player/ComputerPlayer.java
	javac src/superTrunfo/core/GameInterface.java
	javac src/superTrunfo/core/Round.java
	javac src/superTrunfo/Setup.java
	javac src/superTrunfo/core/MainGame.java

clean:
	rm -rf src/superTrunfo/*.class
	rm -rf src/superTrunfo/*/*.class

run:
	java src/superTrunfo/core/MainGame.class