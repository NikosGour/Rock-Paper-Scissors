package dithua.nikosgourn;

import dithua.nikosgourn.Choices.*;
import dithua.nikosgourn.Choices.Choice;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Choice[] choices = {new Rock(), new Paper(), new Scissors()};
//
//        Scanner scan = new Scanner(System.in);
//        System.out.printf("Pick an option : ");
//        int i = scan.nextInt();
//        scan.nextLine();
//
        Choice choice;
        Random rand = new Random();
        Choice botChoice = choices[rand.nextInt(3)];

        JFrame win = new JFrame();
        win.setLayout(null);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setResizable(false);
        win.setSize(1100,700);
        win.getContentPane().setBackground(Color.WHITE);

        JPanel rock = getjPanel(100,100,300,300);
        JPanel paper = getjPanel(400 , 100 , 300, 300);
        JPanel scissors = getjPanel(700 , 100 , 300, 300);

        ImageIcon rockI = new ImageIcon("src/dithua/nikosgourn/assets/rock.png");
        ImageIcon paperI = new ImageIcon("src/dithua/nikosgourn/assets/paper.png");
        ImageIcon scissorsI = new ImageIcon("src/dithua/nikosgourn/assets/scissors.png");

        JButton rockB = getButton(rockI);
        JButton paperB = getButton(paperI);
        JButton scissorsB = getButton(scissorsI);

        rock.add(rockB);
        paper.add(paperB);
        scissors.add(scissorsB);
        win.add(rock);
        win.add(paper);
        win.add(scissors);

//        System.out.println(choice);
        System.out.println(botChoice);
//        choice.gameResult(botChoice);

        win.setVisible(true);
    }

    private static JButton getButton(ImageIcon image) {
        JButton button = new JButton();
        button.setContentAreaFilled(false);
        button.setIcon(image);
        return button;
    }

    private static JPanel getjPanel(int x , int y , int width , int height) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEtchedBorder());
        panel.setBounds(x,y,width,height);
        panel.setLayout(new BorderLayout());
        return panel;
    }
}
