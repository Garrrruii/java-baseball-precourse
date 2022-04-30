package baseball;

public class InputController {

    private int ANSWER_LENGTH = 3;

    public InputController(){

    }

    public InputController(int answerLength) {
        this.ANSWER_LENGTH = answerLength;
    }

    public String getUserAnswer(){
        return "123";
    }

    private final String KEEP_PLAYING_GAME="1";
    private final String STOP_PLAYING_GAME="2";

    public boolean getUserReply(){
        return true;
    }

    private boolean checkUserAnswerInputError(){
        return false;
    }

    private boolean checkUserReplyInputError(){
        return false;
    }

}
