package baseball;

public class GameController {

    private boolean keepPlayingGame=true;

    public GameController() {
    }

    public void controlGame(){

        while(keepPlayingGame){
            playGame();
            askKeepPlayingGame();
        }
    }

    private void playGame(){

    }

    private void askKeepPlayingGame(){

    }


}
