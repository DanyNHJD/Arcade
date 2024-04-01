import javax.swing.*;
import java.awt.event.*;



public class WordleGame implements ActionListener{
    private String userGuess;
    private char[] charGuess = new char[5];
    JTextField tf;
    JButton b;

    public WordleGame() {
        JFrame f = new JFrame("Wordle");  
        tf = new JTextField(); 
        tf.requestFocus();
        tf.setBounds(50,400,310,50);
        b = new JButton("Guess");
        b.setBounds(350,400,100,49);
 
        b.addActionListener(this);
        tf.addActionListener(this);

        f.add(tf);
        f.add(b);
        f.setSize(500,500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if ((tf.getText().length() > 5)) {
            JOptionPane.showMessageDialog(null, "Your guess can only be 5 letters!", "Wordle",
            JOptionPane.INFORMATION_MESSAGE);
            
            tf.setText("");  
        }
        String s1 = tf.getText().toUpperCase();

        tf.setText("");
    }


    public static void main(String[] args) {
        //Wordle.resetGame();
        new WordleGame();
    }
}
