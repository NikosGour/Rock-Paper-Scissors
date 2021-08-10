package dithua.nikosgourn.Choices;

import dithua.nikosgourn.Main;

public class Scissors extends Choice{


    @Override
    public void gameResult(Choice otherChoice) {
        if (otherChoice instanceof Paper){
            Main.gameCondition.setText("You Win!");
        }
        else if (otherChoice instanceof Rock)
        {
            Main.gameCondition.setText("You Lose!");
        }
        else Main.gameCondition.setText("Tie!");
    }
}
