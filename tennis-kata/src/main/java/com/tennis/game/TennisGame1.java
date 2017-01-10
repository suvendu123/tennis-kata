package com.tennis.game;

public class TennisGame1 implements TennisGame {

	private static final String WIN_FOR = "Win for ";
	private static final String ADVANTAGE = "Advantage ";
	private static final String PLAYER1 = "player1";
	private static final String PLAYER2 = "player2";
	private static final String ALL_SUFFIX = "-All";
	private int player1Score = 0;
	private int player2Score = 0;

	public TennisGame1(String player1Name, String player2Name) {
	}

	public void wonPoint(String playerName) {
		if (playerName == PLAYER1)
			player1Score += 1;
		else
			player2Score += 1;
	}

	public String getScore() {
		if (player1Score == player2Score) {
			return tie();
		} else if (player1Score >= 4 || player2Score >= 4) {
			return scoreAboveFour();
		}
		return Point.values()[this.player1Score] + "-" + Point.values()[this.player2Score];
	}

	private String advantage(int scoreDiffrence) {
		return scoreDiffrence == 1 ? ADVANTAGE + PLAYER1 : ADVANTAGE + PLAYER2;
	}

	private String scoreAboveFour() {
		int scoreDiffrence = player1Score - player2Score;
		if (Math.abs(scoreDiffrence) == 1) {
			return advantage(scoreDiffrence);
		}
		return scoreDiffrence >= 2 ? WIN_FOR + PLAYER1 : WIN_FOR + PLAYER2;
	}

	private String tie() {
		return this.player1Score < 3 ? Point.values()[this.player1Score].toString() + ALL_SUFFIX
				: Point.Deuce.toString();

	}
}
