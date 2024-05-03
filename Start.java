import javax.swing.*;
import Wordle.Wordle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Start extends JFrame implements ActionListener {

    // Buttons and Icons
    JButton wordle = new JButton();
    ImageIcon wordleIcon = new ImageIcon("Title/Wordle.png");

    JButton pong = new JButton();
    ImageIcon pongIcon = new ImageIcon("Title/Pong.png");

    Start(){
        // Pong
        pong.setBounds(300,350,200,100);
        pong.addActionListener(this);
        pong.setFocusable(false);
        pong.setHorizontalTextPosition(JButton.CENTER);
        pong.setIcon(pongIcon);
        this.add(pong);

        //Wordle
        wordle.setBounds(50,350,200,100);
        wordle.addActionListener(this);
        wordle.setFocusable(false);
        wordle.setHorizontalTextPosition(JButton.CENTER);
        wordle.setIcon(wordleIcon);
        this.add(wordle);

        // Panel setup
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(600,600);
        this.setVisible(true);
 }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pong){
            new pingPong();
        }

        if(e.getSource() == wordle){
            Wordle.resetGame();
        }
    }

    public static void main(String[] args) {
        new Start();
    }
}
