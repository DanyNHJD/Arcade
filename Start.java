import javax.swing.*;
import Checkers.checkers;
import Jeopardy.JeopardyLayout;
import Snake.snakeGame;
import Wordle.Wordle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Start extends JFrame implements ActionListener {

    // Buttons and Icons
    JButton checkers = new JButton();
    ImageIcon checkersIcon = new ImageIcon(getClass().getResource("Title/Checkers.png"));

    JButton jeopardy = new JButton();
    ImageIcon jeopardyIcon = new ImageIcon(getClass().getResource("Title/Jeopardy.png"));

    JButton pong = new JButton();
    ImageIcon pongIcon = new ImageIcon(getClass().getResource("Title/Pong.png"));

    JButton snake = new JButton();
    ImageIcon snakeIcon = new ImageIcon(getClass().getResource("Title/Snake.png"));

    JButton wordle = new JButton();
    ImageIcon wordleIcon = new ImageIcon(getClass().getResource("Title/Wordle.png"));

    Start(){
        // Checkers
        checkers.setBounds(75,100,200,100);
        checkers.addActionListener(this);
        checkers.setFocusable(false);
        checkers.setHorizontalTextPosition(JButton.CENTER);
        checkers.setIcon(checkersIcon);
        this.add(checkers);

        // Jeopardy
        jeopardy.setBounds(300,100,200,100);
        jeopardy.addActionListener(this);
        jeopardy.setFocusable(false);
        jeopardy.setHorizontalTextPosition(JButton.CENTER);
        jeopardy.setIcon(jeopardyIcon);
        this.add(jeopardy);

        // Pong
        pong.setBounds(75,250,200,100);
        pong.addActionListener(this);
        pong.setFocusable(false);
        pong.setHorizontalTextPosition(JButton.CENTER);
        pong.setIcon(pongIcon);
        this.add(pong);

        // Snake
        snake.setBounds(300,250,200,100);
        snake.addActionListener(this);
        snake.setFocusable(false);
        snake.setHorizontalTextPosition(JButton.CENTER);
        snake.setIcon(snakeIcon);
        this.add(snake);

        // Wordle
        wordle.setBounds(190,400,200,100);
        wordle.addActionListener(this);
        wordle.setFocusable(false);
        wordle.setHorizontalTextPosition(JButton.CENTER);
        wordle.setIcon(wordleIcon);
        this.add(wordle);

        // Panel setup
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("Arcade");
        this.setSize(600,600);
        this.setVisible(true);
 }

    @Override
    public void actionPerformed(ActionEvent e) {
        // When user presses a button
        if(e.getSource() == checkers){
            new checkers(); 
        }
        if(e.getSource() == jeopardy){
            new JeopardyLayout();
        }
        if(e.getSource() == pong){
            new pingPong();
        }
        if(e.getSource() == snake){
            new snakeGame();
        }
        if(e.getSource() == wordle){
            Wordle.resetGame();
        }
    }

    public static void main(String[] args) {
        new Start();
    }
}
