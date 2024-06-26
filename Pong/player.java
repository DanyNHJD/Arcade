import java.awt.*;
import java.awt.event.*;

public class player extends KeyAdapter{    
    private int x;
    private int y;
    final private int w = 20;
    final private int h = 75;
    final private int dy = 5;
    
    public player(int startX, int startY){
        x = startX;
        y = startY;
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        int k = e.getKeyCode();
        
        if(k == KeyEvent.VK_W){
            if(y > 0){
                y -= dy;
            }
        } else if(k == KeyEvent.VK_S){
            if(y < 190){
                y += dy;
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
