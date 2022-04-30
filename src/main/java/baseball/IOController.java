package baseball;

//import static camp.nextstep.edu.missionutils.Console.readLine;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOController {

    private final InputStreamReader ir = new InputStreamReader(System.in);
    private final BufferedReader br = new BufferedReader(ir);

    private static int ANSWER_LENGTH = 3;

    private static final String GET_USER_ANSWER_MESSAGE="숫자를 입력해주세요 : ";
    private static final String GET_USER_REPLY_MESSAGE="게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String KEEP_PLAYING_GAME="1";
    private static final String STOP_PLAYING_GAME="2";

    public IOController(){
    }

    public IOController(int answerLength) {
        this.ANSWER_LENGTH = answerLength;
    }

    public String getUserAnswer() {
        System.out.print(GET_USER_ANSWER_MESSAGE);

        String userAnswer="";
        try{
            userAnswer=br.readLine();
            checkUserAnswerInputError(userAnswer);
        } catch(Exception e){
            occurInputError();
        };

        return userAnswer;
    }


    public boolean getUserReply(){
        System.out.println(GET_USER_REPLY_MESSAGE);

        String userReply="";
        try{
            userReply=br.readLine();
            checkUserReplyInputError(userReply);
        } catch(Exception e){
            occurInputError();
        }

        return (userReply==KEEP_PLAYING_GAME);
    }

    public void announceTurnResult(int strikeCount, int ballCount){
        String turnResultMessage = "";

        if(strikeCount==0 && ballCount==0){
            turnResultMessage="낫싱";
        }
        if(ballCount>0){
            turnResultMessage+=Integer.toString(ballCount)+"볼 ";
        }
        if(strikeCount>0 && strikeCount<ANSWER_LENGTH){
            turnResultMessage+=Integer.toString(strikeCount)+"스트라이크 ";
        }
        if(strikeCount==ANSWER_LENGTH){
           turnResultMessage=Integer.toString(ANSWER_LENGTH) + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }

        System.out.println(turnResultMessage);
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
