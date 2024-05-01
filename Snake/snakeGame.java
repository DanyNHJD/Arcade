package Snake;
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.util.Random;

public class snakeGame extends JFrame{
    private JPanel[] backdrop = new JPanel[101];
    private int[] fruitLocations = {42,37,71,23,89};
    private boolean loss = false;
    private boolean win = false;
    private snake s;
    private Random rn = new Random();
    private boolean updatedWFruit = false;

    public snakeGame(){
        setVisible(true);
        setTitle("snake");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(10,10));

        s = new snake(this);
        addKeyListener(s);

        for(int i=0; i<100; i++){
            backdrop[i] = new snakeBackPanel();
            add(backdrop[i]);
        }
        backdrop[100] = new snakeBackPanel();

        Timer t = new Timer(500, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!loss && !win){
                    updatedWFruit = false;
                    for(int i=0;i<5;i++){
                        if(fruitLocations[i] == s.getHead() && !updatedWFruit){
                            updateFruit();
                            updatedWFruit = true;
                        }
                    }
                    if(!updatedWFruit){
                        updateNoFruit();
                    } else {
                        updatedWFruit = false;
                    }
                    repaint();
                } else {
                    if(win){
                        setTitle("YOU WIN");
                        for(int i=0;i<s.getBodyLength();i++){
                            backdrop[s.body[i]].setBackground(Color.WHITE);
                        }
                        backdrop[s.body[0]].setBackground(Color.YELLOW);
                    } else{
                        setTitle("YOU LOSE");
                        for(int i=0;i<s.getBodyLength();i++){
                            backdrop[s.body[i]].setBackground(Color.BLACK);
                        }
                    }
                }
            }
        });
        t.start();
        revalidate();
    }

    private int addFruit(){
        boolean occupied = true;
        boolean bodyOverlap;
        boolean fruitOverlap;
        int location = 0;
        while(occupied){
            location = rn.nextInt(100);
            bodyOverlap = false;
            for(int i=0; i<s.getBodyLength(); i++){
                if(s.body[i] == location){
                    bodyOverlap = true;
                }
            }
            if(bodyOverlap){
                occupied = true;
            } else{
                fruitOverlap = false;
                for(int i=0; i<5; i++){
                    if(fruitLocations[i] == location){
                        fruitOverlap = true;
                    }
                }
                if(fruitOverlap){
                    occupied = true;
                } else{
                    occupied = false;
                }
            }
        }
        return location;
    }

    private void updateNoFruit() {
        s.move(false);
        s.checkBodyCollision();
        loss = s.getDeath();
        win = s.getWin();
        redraw();
    }

    private void updateFruit() {
        for(int i=0;i<5;i++){
            if(fruitLocations[i] == s.getHead()){
                if(s.getBodyLength()<96){
                    fruitLocations[i] = addFruit();
                } else{
                    fruitLocations[i] = 100;
                }
            }
        }
        s.move(true);
        s.checkBodyCollision();
        loss = s.getDeath();
        win = s.getWin();
        redraw();
    }

    public void redraw(){
        for(int i=0;i<100;i++){
            backdrop[i].setBackground(Color.GREEN);
        }
        for(int i=0;i<5;i++){
            backdrop[fruitLocations[i]].setBackground(Color.RED);
        }
        for(int i=0;i<s.getBodyLength();i++){
            backdrop[s.body[i]].setBackground(Color.GRAY);
        }
        backdrop[s.body[0]].setBackground(Color.LIGHT_GRAY);
    }

    public static void main(String[] args){
        new snakeGame();
    }
}