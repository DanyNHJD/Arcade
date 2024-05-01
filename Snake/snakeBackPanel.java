package Snake;
import javax.swing.*;
import java.awt.*;

public class snakeBackPanel extends JPanel{
    public snakeBackPanel(){
        setBackground(Color.GREEN);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawLine(0,0,0,60);
        g.drawLine(0,0,60,0);
        g.drawLine(0,60,60,60);
        g.drawLine(60,0,60,60);
    }
}