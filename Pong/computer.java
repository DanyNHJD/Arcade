import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("unused")
public class computer{
    private Ball ball;

    private int x;
    private int y;
    final private int w = 20;
    final private int h = 75;
    final private int dy = 5;

    public computer(Ball b, int startX, int startY){
        ball = b;
        x = startX;
        y = startY;
    }

    public void computerMove(){
        if(y != ball.getY()){
            if(ball.getY() < 190){
                y = ball.getY();
            } else{
                y = 190;
            }
        }
    }

    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(x,y,w,h);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return w;
    }

    public int getHeight() {
        return h;
    }

    public void setY(int inY){
        y = inY;
    }
}