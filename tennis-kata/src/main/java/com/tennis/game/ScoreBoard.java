package com.tennis.game;

import static com.tennis.game.Point.*;
import static java.lang.Math.abs;

/**
 * @author sbandy
 *
 */
public class ScoreBoard {

	private static final String WIN_FOR = "Win for ";
	private static final String ADVANTAGE = "Advantage ";
	private static final String ALL_SUFFIX = "-All";
	private Player player1;
	private Player player2;

	public ScoreBoard(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public Player getPlayer1() {
		return player1;
	}

	
	public Player getPlayer2() {
		return player2;
	}

	public boolean isTie() {
		return player1.getScore() == player2.getScore();
	}

	public String displayTie() {
		return player1.getScore() < 3 ? values()[player1.getScore()].toString() + ALL_SUFFIX : Deuce.toString();
	}

	public boolean isAboveFour() {
		return player1.getScore() >= 4 || player2.getScore() >= 4;
	}

	public String displayAboveFour() {
		int scoreDiffrence = player1.getScore() - player2.getScore();
		if (abs(scoreDiffrence) == 1) {
			return advantage(scoreDiffrence);
		}
		return scoreDiffrence >= 2 ? WIN_FOR + player1.getName() : WIN_FOR + player2.getName();
	}

	private String advantage(int scoreDiffrence) {
		return scoreDiffrence == 1 ? ADVANTAGE + player1.getName() : ADVANTAGE + player2.getName();
	}

	public String displayScore() {
		return values()[player1.getScore()] + "-" + values()[player2.getScore()];
	}

}
