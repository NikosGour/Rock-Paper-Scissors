package dithua.nikosgourn;

import dithua.nikosgourn.Choices.*;
import dithua.nikosgourn.Choices.Choice;

import javax.print.attribute.standard.OrientationRequested;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Choice[] choices = {new Rock(), new Paper(), new Scissors()};
    public static Random rand = new Random();


    public static JFrame win;
    public static JPanel leftP;
    public static JPanel midP;
    public static JPanel rightP;
    public static JButton leftB;
    public static JButton midB;
    public static JButton rightB;

    public static Choice choice;
    public static Choice botChoice;

    public static ImageIcon rockI = new ImageIcon("src/dithua/nikosgourn/assets/rock.png");
    public static ImageIcon paperI = new ImageIcon("src/dithua/nikosgourn/assets/paper.png");
    public static ImageIcon scissorsI = new ImageIcon("src/dithua/nikosgourn/assets/scissors.png");

    public static JButton reset;
    public static JLabel gameCondition;

    public static void main(String[] args) {

        botChoice = choices[rand.nextInt(3)];
        win = new JFrame();
        setup();


        win.setVisible(true);
    }

    private static void setup() {

        win.setLayout(null);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setResizable(false);
        win.setSize(1100,700);
        win.getContentPane().setBackground(Color.WHITE);

        leftP = getjPanel(100,100,300,300);
        midP = getjPanel(400 , 100 , 300, 300);
        rightP = getjPanel(700 , 100 , 300, 300);

        reset = new JButton();
        reset.setBounds(500 ,500 , 100,50);
        reset.setContentAreaFilled(false);
        reset.setBorder(BorderFactory.createEtchedBorder());
        reset.setText("Reset");
        reset.setBackground(Color.ORANGE);
        reset.setFocusPainted(false);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });


        gameCondition = new JLabel();
        gameCondition.setBounds(400 , 20 , 300 , 40);
        gameCondition.setText("This is a test");
        gameCondition.setHorizontalAlignment(SwingConstants.CENTER);


        win.add(gameCondition);
        win.add(reset);

        leftB = getButton(rockI);
        midB = getButton(paperI);
        rightB = getButton(scissorsI);

        addAction(leftB);
        addAction(midB);
        addAction(rightB);


        leftP.add(leftB);
        midP.add(midB);
        rightP.add(rightB);
        win.add(leftP);
        win.add(midP);
        win.add(rightP);


    }

    private static void reset()
    {
        botChoice = choices[rand.nextInt(3)];

        leftB.setEnabled(true);
        midB.setEnabled(true);
        rightB.setEnabled(true);

        leftB.setIcon(rockI);
        rightB.setIcon(scissorsI);

        gameCondition.setText("");

        midP.add(midB);
        win.add(midP);
        win.repaint();
    }
    private static JButton getButton(ImageIcon image) {
        JButton button = new JButton();
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
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

    private static void addAction(JButton button )
    {

        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            win.remove(midP);
            win.repaint();

            if (button.equals(leftB))
            {
                choice = new Rock();
            }
            else if(button.equals(midB))
            {
                choice = new Paper();
            }
            else choice = new Scissors();

            leftB.setEnabled(false);
            midB.setEnabled(false);
            rightB.setEnabled(false);

            choice.gameResult(botChoice);
            ImageIcon leftImage , rightImage;

            leftImage = configImage(choice);
            rightImage = configImage(botChoice);

            leftB.setIcon(leftImage);
            leftB.setDisabledIcon(leftImage);

            rightB.setIcon(rightImage);
            rightB.setDisabledIcon(rightImage);

            }
        };

        button.addActionListener(action);
    }

    private static ImageIcon configImage(Choice choice)

    {
        if (choice instanceof Rock) return rockI;
        if (choice instanceof Paper) return paperI;
        if (choice instanceof Scissors) return scissorsI;
        return null;
    }
}
