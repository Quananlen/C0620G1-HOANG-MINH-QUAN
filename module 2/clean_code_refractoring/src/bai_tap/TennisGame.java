package bai_tap;

public class TennisGame {

    public static final String DASH = "-";

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        boolean isEqual = player1Score == player2Score;
        boolean isGreaterThan4 = player1Score >= 4 || player2Score >= 4;
        if (isEqual) return getEqualScore(player1Score);
        if (isGreaterThan4) return getAdvantageScore(player1Score, player2Score);
        return getDifferentScore(player1Score, player2Score);
    }

    public static String getEqualScore(int playerScore) {
        switch (playerScore) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    public static String getAdvantageScore(int player1Score, int player2Score) {
        int minusResult = player1Score - player2Score;
        boolean player1Advantage = minusResult == 1;
        boolean player2Advantage = minusResult == -1;
        boolean player1Win = minusResult >= 2;
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
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
    }
}
