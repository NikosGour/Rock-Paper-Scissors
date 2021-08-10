package dithua.nikosgourn.Choices;

import dithua.nikosgourn.Main;

public class Rock extends Choice{


    @Override
    public void gameResult(Choice otherChoice) {
        if (otherChoice instanceof Scissors){
            Main.gameCondition.setText("You Win!");
        }
        else if (otherChoice instanceof Paper)
        {
            Main.gameCondition.setText("You Lose!");
        }
        else Main.gameCondition.setText("Tie!");
    }
}
