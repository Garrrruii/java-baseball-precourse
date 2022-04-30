package baseball;

public class GameController {

    private boolean keepPlayingGame = true;
    private int ANSWER_LENGTH = 3;

    private IOController ioController = new IOController(ANSWER_LENGTH);

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
            String userAnswer = ioController.getUserAnswer();;
            isCorrectAnswer=checkUserAnswer();
        }
    }


    private void askKeepPlayingGame() {
        keepPlayingGame= ioController.getUserReply();
    }

    private String getRealAnswerByRandom() {
        return "123";
    }

    private boolean checkUserAnswer(){
        int strikeCount=0;
        int ballCount=0;

        for(int i=0;i<ANSWER_LENGTH;++i){

        }

        return false;
    }

    private boolean isStrike(char realChar, char userChar){
        return realChar==userChar;
    }
}
