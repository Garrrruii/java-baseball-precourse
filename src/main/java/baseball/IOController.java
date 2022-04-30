package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class IOController {

    private static int ANSWER_LENGTH = 3;

    private static final String GET_USER_ANSWER_MESSAGE="숫자를 입력해주세요 : ";
    private static final String ANNOUNCE_CORRECT_ANSWER_MESSAGE = Integer.toString(ANSWER_LENGTH) + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GET_USER_REPLY_MESSAGE="게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String KEEP_PLAYING_GAME="1";
    private static final String STOP_PLAYING_GAME="2";

    public IOController(){

    }

    public IOController(int answerLength) {
        this.ANSWER_LENGTH = answerLength;
    }

    public String getUserAnswer(){
        System.out.print(GET_USER_ANSWER_MESSAGE);

        String userAnswer=readLine();
        checkUserAnswerInputError(userAnswer);

        return userAnswer;
    }


    public boolean getUserReply(){
        System.out.println(ANNOUNCE_CORRECT_ANSWER_MESSAGE);
        System.out.println(GET_USER_REPLY_MESSAGE);

        String userReply=readLine();
        checkUserReplyInputError(userReply);

        return (userReply==KEEP_PLAYING_GAME);
    }

    private void checkUserAnswerInputError(String userAnswer){
        if(userAnswer.length()!=ANSWER_LENGTH){
            occurInputError();
        }

        for(int i=0;i<ANSWER_LENGTH;++i){
            if(isNotNaturalNumber(userAnswer.charAt(i))){
                occurInputError();
            }
        }
    }

    private void checkUserReplyInputError(String userReply){
        if(userReply==KEEP_PLAYING_GAME || userReply==STOP_PLAYING_GAME){
            return;
        }
        occurInputError();

    }

    private static boolean isNotNaturalNumber(char c){
        return (c < '1' || c > '9');
    }

    private static void occurInputError(){
        throw new IllegalArgumentException();
    }

}
