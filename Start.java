import javax.swing.*;

import Wordle.Wordle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Start extends JFrame implements ActionListener {

    JButton button1;
    JButton button;



    Start(){

       //pong
        button = new JButton();
        ImageIcon icon = new ImageIcon("Title/Pong26.png");
        ImageIcon icon1 = new ImageIcon("Title/Wordle.png");

        button.setBounds(300,350,200,100);
        button.addActionListener(this);
        button.setFocusable(false);
        button.setIcon(icon);
        button.setHorizontalTextPosition(JButton.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(600,600);
        this.setVisible(true);
        this.add(button);


        //Wordle
        button1 = new JButton();
        button1.setBounds(50,350,200,100);
        button1.addActionListener(this);
        button1.setFocusable(false);
        button1.setIcon(icon);
        button1.setHorizontalTextPosition(JButton.CENTER);
        button1.setIcon(icon1);
        this.add(button1);




 }

    @Override
    public void actionPerformed(ActionEvent e) {

     //so the button starts doing things

        if(e.getSource() == button){
            
        }

        if(e.getSource() == button1){
            Wordle.resetGame();
        }
    }

    public static void main(String[] args) {
        new Start();
    }
}
