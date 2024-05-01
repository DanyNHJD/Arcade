//Justin Stevens

import javax.swing.*;
import java.awt.*;

public class backPanel extends JPanel{
    private String score;

    public void setScore(int x){
        score = "" + x / 10;
    }

    public backPanel(){
        setBackground(Color.BLACK);
        score = "0";
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        new Font("Serif", Font.BOLD, 32);

        g.drawString(score, 565, 20);
    }
}