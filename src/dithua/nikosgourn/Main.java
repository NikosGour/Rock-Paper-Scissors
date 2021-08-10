package dithua.nikosgourn;

import dithua.nikosgourn.Choices.*;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Choice[] choices = {new Rock(), new Paper(), new Scissors()};

        Scanner scan = new Scanner(System.in);
        System.out.printf("Pick an option : ");
        int i = scan.nextInt();
        scan.nextLine();

        Choice choice = choices[i];
        Random rand = new Random();
        Choice botChoice = choices[rand.nextInt(3)];
        System.out.println(choice);
        System.out.println(botChoice);
        choice.gameResult(botChoice);
    }
}
