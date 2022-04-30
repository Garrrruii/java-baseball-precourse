package baseball;

public class GameController {

    private boolean keepPlayingGame = true;
    private int ANSWER_LENGTH = 3;

    private InputController inputController = new InputController(ANSWER_LENGTH);

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
            String userAnswer = inputController.getUserAnswer();;
            isCorrectAnswer=checkUserAnswer();
        }
    }


    private void askKeepPlayingGame() {
        keepPlayingGame=inputController.getUserReply();
    }

    private String getRealAnswerByRandom() {
        return "123";
    }

    private boolean checkUserAnswer(){

        return false;
    }

    private boolean isStrike(char realChar, char userChar){
        return realChar==userChar;
    }
}
