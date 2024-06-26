package Wordle;
/* To view the word change @line 10 boolean to true
* 
* To start game, Wordle.resetGame();
*/

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class WordleGame implements ActionListener{
    private static boolean debug = false;

    private static int guessPlacement = 0;
    private static char[] charGuess = new char[5];
    public static int allowedGuesses = 5;

    JFrame win = new JFrame("Wordle");
    JPanel P1, P2;
    JTextField tf = new JTextField();
    static Button [] button = new Button[allowedGuesses * 5];

    // Start WordleGame
    public WordleGame() { 
        P1 = new JPanel();
        tf.requestFocus();
        tf.addActionListener(this);
        tf.setPreferredSize(new Dimension(300, 20));
        P1.add(tf);

        createGrid();
        
        win.add(P1,BorderLayout.PAGE_END);
        win.setSize(500,500);
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setResizable(false);
    }

    // Makes the grid for the game.
    public void createGrid() {
        P2 = new JPanel();
        P2.setLayout (new GridLayout(5, allowedGuesses));
        for(int i = 0; i < allowedGuesses * 5; ++i){
            button[i] = new Button();
            button[i].setEnabled(false);
            button[i].setBackground(Color.WHITE);
            button[i].setFont(new Font("Arial", Font.BOLD, 40));
        }

        for(int i = 0; i < allowedGuesses * 5; ++i) {
            P2.add(button[i]);
        }
        
        win.add(P2);
    }

    // When user hits enter.
    @Override
    public void actionPerformed(ActionEvent e) {
        if ((tf.getText().length() > 5) || (tf.getText().length() < 5)) {
            JOptionPane.showMessageDialog(null, 
            "Your guess can only be 5 letters!", "Wordle",
            JOptionPane.INFORMATION_MESSAGE);
            tf.setText("");
        }

        String s1 = tf.getText().toUpperCase();
        
        
        // Make sure an empty string wont go through the guess() funciton.
        if (s1.isEmpty() != true) {
            charGuess = s1.toCharArray();
            Wordle.guess(charGuess);

            guessBoxes();
        }
        tf.setText("");
    }

    // Changes the boxes to green or yellow depending on what the user guessed.
    public static void guessBoxes() {
        boolean[] guessTracker = Wordle.getGuesses();
        boolean[] validLetter = Wordle.getValidLetters();

        for (int i = 0; i < 5; i++) {
            
            
            if (validLetter[i] == true) {
                button[guessPlacement].setBackground(Color.YELLOW);
            }
            if (guessTracker[i] == true) {
                button[guessPlacement].setBackground(Color.GREEN);
            }
            button[guessPlacement].setLabel(charGuess[i] + "");
            guessPlacement += 1;

        }
        Wordle.checkWin();
    }

    public static boolean debugStatus() {
        return debug;
    }

    public static int userGuessAmount() {
        return guessPlacement;
    }

    public static void guessRestart() {
        guessPlacement = 0;
    }
}
