package baseball;

//import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.Random;

public class GameController {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUMBER_RANGE = MAX_NUMBER - MIN_NUMBER;
    private static final int ANSWER_LENGTH = 3;

    private boolean keepPlayingGame = true;

    private final IOController ioController = new IOController(ANSWER_LENGTH);

    public GameController() {
    }

    public void controlGame() {

        while (keepPlayingGame) {
            playGame();
            askKeepPlayingGame();
        }
    }

    private void playGame() {
        String realAnswer = getRealAnswerByRandom();
        boolean isCorrectAnswer = false;

        while (!isCorrectAnswer) {
            String userAnswer = ioController.getUserAnswer();
            isCorrectAnswer = checkUserAnswer(realAnswer, userAnswer);
        }
    }

    private void askKeepPlayingGame() {
        keepPlayingGame = ioController.getUserReply();
    }

    private String getRealAnswerByRandom() {
        boolean[] existence = new boolean[NUMBER_RANGE];
        String realAnswer = "";

        for (int i = 0; i < ANSWER_LENGTH; ++i) {
            int randomNumber = pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (existence[randomNumber - MIN_NUMBER]) {
                i--;
                continue;
            }

            existence[randomNumber - MIN_NUMBER] = true;
            realAnswer += Integer.toString(randomNumber);
        }

        return realAnswer;
    }

    private boolean checkUserAnswer(String realAnswer, String userAnswer) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < ANSWER_LENGTH; ++i) {
            if (isStrike(realAnswer.charAt(i), userAnswer.charAt(i))) {
                strikeCount++;
                continue;
            }
            if (isBall(realAnswer, userAnswer.charAt(i))) {
                ballCount++;
            }
        }

        ioController.announceTurnResult(strikeCount, ballCount);

        return isCorrectAnswer(strikeCount, ballCount);
    }

    private boolean isStrike(char realChar, char userChar) {
        return realChar == userChar;
    }

    private boolean isBall(String realAnswer, char userChar) {
        for (int i = 0; i < ANSWER_LENGTH; ++i) {
            if (realAnswer.charAt(i) == userChar) {
                return true;
            }
        }
        return false;
    }

    private boolean isCorrectAnswer(int strikeCount, int ballCount) {
        return (strikeCount == ANSWER_LENGTH && ballCount == 0);
    }

    private int pickNumberInRange(int min, int max) {
        if (min > max) {
            int tmp = min;
            min = max;
            max = tmp;
        }

        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
