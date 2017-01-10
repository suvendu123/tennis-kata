package com.tennis.game;
import static com.tennis.game.Point.*;
import static java.lang.Math.abs;
public class TennisGame1 implements TennisGame {

	private static final int PLAYER_2 = 1;
	private static final int PLAYER_1 = 0;
	private static final String WIN_FOR = "Win for ";
	private static final String ADVANTAGE = "Advantage ";
	private static final String ALL_SUFFIX = "-All";

	private Player[] players = new Player[2];

	public TennisGame1(String player1Name, String player2Name) {
		players[PLAYER_1] = new Player(player1Name, 0);
		players[PLAYER_2] = new Player(player2Name, 0);
	}

	public void wonPoint(String playerName) {
		if (players[PLAYER_1].getName().equals(playerName)) {
			players[PLAYER_1].addScore();
		} else {
			players[PLAYER_2].addScore();
		}
	}

	public String getScore() {
		return calculateScore(players[PLAYER_1], players[PLAYER_2]);
	}

	private String calculateScore(Player player1, Player player2) {
		if (player1.getScore() == player2.getScore()) {
			return tie(player1);
		} else if (player1.getScore() >= 4 || player2.getScore() >= 4) {
			return scoreAboveFour(player1, player2);
		}
		return values()[player1.getScore()] + "-" + values()[player2.getScore()];
	}

	private String advantage(int scoreDiffrence, Player player1, Player player2) {
		return scoreDiffrence == 1 ? ADVANTAGE + player1.getName() : ADVANTAGE + player2.getName();
	}

	private String scoreAboveFour(Player player1, Player player2) {
		int scoreDiffrence = player1.getScore() - player2.getScore();
		if (abs(scoreDiffrence) == 1) {
			return advantage(scoreDiffrence, player1, player2);
		}
		return scoreDiffrence >= 2 ? WIN_FOR + player1.getName() : WIN_FOR + player2.getName();
	}

	private String tie(Player player1) {
		return player1.getScore() < 3 ? Point.values()[player1.getScore()].toString() + ALL_SUFFIX
				: Deuce.toString();

	}
}
