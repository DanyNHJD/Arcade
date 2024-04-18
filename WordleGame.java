import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class WordleGame implements ActionListener{
    private char[] charGuess = new char[5];
    public int allowedGuesses = 5;

    JFrame win = new JFrame("Wordle");
    JPanel P1, P2;
    JTextField tf = new JTextField();
    Button [] button = new Button[allowedGuesses * 5];


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

    public void createGrid() {
        P2 = new JPanel();
        P2.setLayout (new GridLayout(5, allowedGuesses));
        for(int i = 0; i < allowedGuesses * 5; ++i){
            button[i] = new Button();
            button[i].setEnabled(false);      
        }

        for(int i = 0; i < allowedGuesses * 5; ++i) {
            P2.add(button[i]);
        }
        

        win.add(P2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((tf.getText().length() > 5) || (tf.getText().length() < 5)) {
            JOptionPane.showMessageDialog(null, "Your guess can only be 5 letters!", "Wordle",
            JOptionPane.INFORMATION_MESSAGE);
            tf.setText("");
        }

        String s1 = tf.getText().toUpperCase();
        
        // Make sure an empty string wont go through the guess() funciton.
        if (s1.isEmpty() != true) {
            charGuess = s1.toCharArray();
            Wordle.guess(charGuess);
        }
        tf.setText("");
    }

    public static void main(String[] args) {
        Wordle.resetGame();
        new WordleGame();
    }
}
