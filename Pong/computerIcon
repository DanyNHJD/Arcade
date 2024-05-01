import javax.swing.*;
import java.awt.*;

//an Icon that contains a ball object
public class computerIcon implements Icon{
    private JFrame win;
    private int width;
    private int height;
    private computer comp;

    //we construct a ball icon object so it stires a reference to the
    //panel that contains it
    public computerIcon(JFrame window, computer c){
        win = window;
        //width = 800;
        //height = 400;
        width = win.getWidth();
        height = win.getHeight();// technically the wrong height
        //should be less cause this height includes title bar
        comp = c;
    }

    public int getIconWidth(){
        return width;
    }

    public int getIconHeight(){
        return height;
    }

    public void paintIcon(Component c, Graphics g, int x, int y){
        //ask the ball we contain to draw itself using g
        comp.draw(g);

        //have the window refresh its appearence
        win.repaint();
    }
}
