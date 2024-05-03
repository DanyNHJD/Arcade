//Jacob Bemus
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;

@SuppressWarnings("unused")
public class Ball{
    private Random rn = new Random();
    private int x;
    private int y;
    private int w;
    private int h;
    private int dx; // Horizontal velocity
    private int dy; // Vertical velocity
    private JFrame frame;
    private player paddle;

    boolean movingLeft = true;

    private static int SCALE = 5;

    //default constructing the same ball every time
    public Ball(JFrame frame, player p){
        x = 100;
        y = 100;
        w = 50;
        h = 50;
        // Set initial velocities to random values between -SCALE and SCALE
        dx = SCALE;
        dy = rn.nextInt(2 * SCALE + 1) - SCALE;
        if(dy == 0){
            dy = 1;
        }
        this.frame = frame;
        paddle = p;
    }

    public void move() {
        x += dx;
        y += dy;
    }

    //the ball needs to know how to draw itself
    public void draw(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillOval(x, y, w, h);
    }
    // Method to handle collision with walls
    public void checkWallCollision(int screenWidth, int screenHeight) {
        if (x <= 0 || x + w >= screenWidth-70) {
            if(dx < 0){
                dx = SCALE;
            } else{
                dx = -SCALE;
            }
            //dx = -dx;// Reverse horizontal velocity
        }
        int titleBarHeight = frame.getInsets().top;
        int panelHeight = screenHeight - titleBarHeight;
        if (y <= 0 || y + h >= panelHeight) {
            dy = -dy; // Reverse vertical velocity
            y = Math.min(y, panelHeight - h);
            dy += addVarience();
        }
    }
    // Method to handle collision with paddles
    public boolean checkPaddleCollision(player pPaddle, player p2Paddle, computer cPaddle, int width) {   
        // Check collision with the first player's paddle
        if (x <= 0 && (y <= pPaddle.getY() || y >= pPaddle.getY() + pPaddle.getHeight())) {
        dx = SCALE; // Reverse horizontal velocity
        dy += addVarience(); // Adjust vertical velocity
        return true;
        }
        // Check collision with the second player's paddle if it exists (two-player mode)
        if (p2Paddle != null && x >= width - w && (y <= p2Paddle.getY() || y >= p2Paddle.getY() + p2Paddle.getHeight())) {
        dx = -SCALE; // Reverse horizontal velocity
        dy += addVarience(); // Adjust vertical velocity
        return true;
        }
        return false;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setSpeed(int s){
        SCALE = s;
    }

    //this will be used to add the changes in the balls angle
    public int addVarience(){
        return (rn.nextInt(601) - 300) / 100;
    }
}
