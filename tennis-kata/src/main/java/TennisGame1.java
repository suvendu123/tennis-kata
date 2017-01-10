
public class TennisGame1 implements TennisGame {

	private static final String ALL_SUFFIX = "-All";
	private int player1Score = 0;
	private int player2Score = 0;

	public TennisGame1(String player1Name, String player2Name) {
	}

	public void wonPoint(String playerName) {
		if (playerName == "player1")
			player1Score += 1;
		else
			player2Score += 1;
	}

	public String getScore() {
		if (player1Score == player2Score) {
			return tie();
		} else if (player1Score >= 4 || player2Score >= 4) {
			return scoreAboveFour();
		} else {
			String score = "";
			int tempScore = 0;
			for (int i = 1; i < 3; i++) {
				if (i == 1)
					tempScore = player1Score;
				else {
					score += "-";
					tempScore = player2Score;
				}
				score += scoreToNameMap(tempScore);
			}
			return score;
		}
		
	}

	private String scoreToNameMap(int tempScore) {
		return Point.values()[tempScore].toString();
	}

	private String scoreAboveFour() {
		int scoreDiffrence = player1Score - player2Score;
		if (scoreDiffrence == 1)
			return "Advantage player1";
		else if (scoreDiffrence == -1)
			return "Advantage player2";
		else if (scoreDiffrence >= 2)
			return "Win for player1";
		else
			return"Win for player2";
	}

	private String tie() {
		return this.player1Score < 3 ? Point.values()[this.player1Score].toString() + ALL_SUFFIX
				: Point.Deuce.toString();

	}
}
