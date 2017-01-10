package com.tennis.game;

public class TennisGame1 implements TennisGame {

	private ScoreBoard scoreBoard;

	public TennisGame1(String player1Name, String player2Name) {

		this.scoreBoard = new ScoreBoard(new Player(player1Name, 0), new Player(player2Name, 0));
	}

	public void wonPoint(String playerName) {
		if (scoreBoard.getPlayer1().getName().equals(playerName)) {
			scoreBoard.getPlayer1().addScore();
		} else {
			scoreBoard.getPlayer2().addScore();
		}
	}

	public String getScore() {
		if (scoreBoard.isTie()) {
			return scoreBoard.displayTie();
		} else if (scoreBoard.isAboveFour()) {
			return scoreBoard.displayAboveFour();
		}
		return scoreBoard.displayScore();
	}

}
