import javax.swing.*;
import Wordle.Wordle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Start extends JFrame implements ActionListener {

    JButton wordleButton = new JButton();
    JButton pongButton = new JButton();



    Start(){
        //pong
        ImageIcon pongIcon = new ImageIcon("Title/Pong26.png");
        ImageIcon wordleIcon = new ImageIcon("Title/Wordle.png");

        pongButton.setBounds(300,350,200,100);
        pongButton.addActionListener(this);
        pongButton.setFocusable(false);
        pongButton.setIcon(pongIcon);
        pongButton.setHorizontalTextPosition(JButton.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(600,600);
        this.setVisible(true);
        this.add(pongButton);


        //Wordle
        wordleButton.setBounds(50,350,200,100);
        wordleButton.addActionListener(this);
        wordleButton.setFocusable(false);
        wordleButton.setHorizontalTextPosition(JButton.CENTER);
        wordleButton.setIcon(wordleIcon);
        this.add(wordleButton);




 }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pongButton){
            
        }

        if(e.getSource() == wordleButton){
            Wordle.resetGame();
        }
    }

    public static void main(String[] args) {
        new Start();
    }
}
