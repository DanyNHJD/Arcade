import javax.swing.*;
import java.awt.*;

//an Icon that contains a ball object
public class BallIcon implements Icon{
    private JFrame win;
    private int width;
    private int height;
    private Ball ball;

    //we construct a ball icon object so it stires a reference to the
    //panel that contains it
    public BallIcon(JFrame window, Ball b){
        win = window;
        //width = 800;
        //height = 400;
        width = win.getWidth();
        height = win.getHeight();// technically the wrong height
        //should be less cause this height includes title bar
        ball = b;
    }

    public int getIconWidth(){
        return width;
    }

    public int getIconHeight(){
        return height;
    }

    public void paintIcon(Component c, Graphics g, int x, int y){
        //ask the ball we contain to draw itself using g
        ball.draw(g);

        //have the window refresh its appearence
        win.repaint();
    }
}