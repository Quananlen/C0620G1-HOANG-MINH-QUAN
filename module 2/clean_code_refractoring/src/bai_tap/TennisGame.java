package bai_tap;

public class TennisGame {

    public static final String DASH = "-";
    public static final int ZERO = 0;
    public static final int FIFTEEN = 1;
    public static final int THIRTY = 2;
    public static final int FORTY = 3;

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        boolean isEqual = player1Score == player2Score;
        boolean isGreaterThan4 = player1Score >= 4 || player2Score >= 4;
        if (isEqual) return getEqualScore(player1Score);
        if (isGreaterThan4) return getAdvantageScore(player1Score, player2Score);
        return getDifferentScore(player1Score, player2Score);
    }

    public static String getEqualScore(int playerScore) {
        switch (playerScore) {
            case ZERO:
                return "Love-All";
            case FIFTEEN:
                return "Fifteen-All";
            case THIRTY:
                return "Thirty-All";
            case FORTY:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    public static String getAdvantageScore(int player1Score, int player2Score) {
        boolean player1Advantage = player1Score > player2Score;
        boolean player2Advantage = player1Score < player2Score;
        boolean player1Win = (player1Score - player2Score) >= 2;
        if (player1Advantage) return "Advantage player1";
        if (player2Advantage) return "Advantage player2";
        if (player1Win) return "Win for player1";
        return "Win for player2";
    }

    public static String getDifferentScore(int player1Score, int player2Score) {
        String score = getScoreLabel(player1Score);
        score += DASH;
        score += getScoreLabel(player2Score);
        return score;
    }

    public static String getScoreLabel(int playerScore) {
        switch (playerScore) {
            default:
                return "Love";
            case FIFTEEN:
                return "Fifteen";
            case THIRTY:
                return "Thirty";
            case FORTY:
                return "Forty";
        }
    }
}
