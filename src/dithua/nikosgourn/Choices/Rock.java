package dithua.nikosgourn.Choices;

public class Rock extends Choice{


    @Override
    public void gameResult(Choice otherChoice) {
        if (otherChoice instanceof Scissors){
            System.out.println("You Win!");
        }
        else if (otherChoice instanceof Paper)
        {
            System.out.println("You Lose!");
        }
        else System.out.println("Tie!");
    }
}
