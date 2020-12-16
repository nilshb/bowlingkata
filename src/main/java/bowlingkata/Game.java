package bowlingkata;

public class Game {

    public static final int GAME_FRAMES = 10;

    private static final int MAX_ROLLS = 21;

    private final int[] rolls = new int[MAX_ROLLS];
    private int currentRoll;
    private int currentframe;

    public void roll(int pins) {
        rolls[currentRoll] = pins;
        currentRoll++;
    }

    public int score() {
        int total = 0;
        resetFrame();

        for (int i = 0; i < GAME_FRAMES; i++) {
            if (isStrike()) {
                total += 10 + strikeBonus();
                nextFrame(1);
            } else if (isSpare()) {
                total += 10 + spareBonus();
                nextFrame(2);
            } else {
                total += sumOfRolls(currentframe);
                nextFrame(2);
            }
        }

        return total;
    }

    private void resetFrame() {
        currentframe = 0;
    }

    private void nextFrame(int step) {
        currentframe += step;
    }

    private boolean isStrike() {
        return rolls[currentframe] == 10;
    }

    private boolean isSpare() {
        return sumOfRolls(currentframe) == 10;
    }

    private int strikeBonus() {
        return sumOfRolls(currentframe + 1);
    }

    private int spareBonus() {
        return rolls[currentframe + 2];
    }

    private int sumOfRolls(int frameIdx) {
        return rolls[frameIdx] + rolls[frameIdx + 1];
    }

}
