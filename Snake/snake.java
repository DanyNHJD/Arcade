package Snake;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class snake extends KeyAdapter{
    public int[] body = new int[100];
    private JFrame frame;
    private int direction;
    /*
    0 - up
    1 - right
    2 - down
    3 - left
    */
    private int head;
    private boolean died = false;
    private int bodyLength;
    private boolean win = false;


    public snake(JFrame window){
        body[0] = 45;
        body[1] = 46;
        head = body[0];

        direction = 3;
        frame = window;
        bodyLength = 2;
    }

    //also checks wall collision
    //if fruit is true then the snake must have eaten a fruit
    public void move(boolean fruit){
        int temp1;
        int temp2;

        if(fruit){
            bodyLength++;
            if(bodyLength == 100){
                win = true;
            }
        }

        if((head % 10 == 9) && direction == 1){
            died = true;
        } else if((head %10 == 0) && direction == 3){
            died = true;
        } else if((head < 10) && direction == 0){
            died = true;
        } else if((head > 89) && direction == 2){
            died = true;
        } else{
            temp2 = body[0];
            if(direction == 1){
                for(int i=1; i<bodyLength; i++){
                    temp1 = temp2;
                    temp2 = body[i];
                    body[i] =  temp1;
                }
                body[0]++;
                head = body[0];
            } else if(direction == 2){
                for(int i=1; i<bodyLength; i++){
                    temp1 = temp2;
                    temp2 = body[i];
                    body[i] =  temp1;
                }
                body[0]+=10;
                head = body[0];
            } else if(direction == 3){
                for(int i=1; i<bodyLength; i++){
                    temp1 = temp2;
                    temp2 = body[i];
                    body[i] =  temp1;
                }
                body[0]--;
                head = body[0];
            } else{
                for(int i=1; i<bodyLength; i++){
                    temp1 = temp2;
                    temp2 = body[i];
                    body[i] =  temp1;
                }
                body[0]-=10;
                head = body[0];
            }
        }
    }

    public void checkBodyCollision(){
        for(int i=1; i<bodyLength; i++){
            if(head == body[i]){
                died = true;
            }
        }
    }

    public int getHead(){
        return head;
    }

    public boolean getDeath(){
        return died;
    }

    public boolean getWin(){
        return win;
    }

    public int getBodyLength(){
        return bodyLength;
    }

    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 60, 60);
    }

    @Override
    public void keyPressed(KeyEvent e){
        int k = e.getKeyCode();

        if(k == KeyEvent.VK_UP){
            direction = 0;
        } else if(k == KeyEvent.VK_DOWN){
            direction = 2;
        } else if(k == KeyEvent.VK_LEFT){
            direction = 3;
        } else if(k == KeyEvent.VK_RIGHT){
            direction = 1;
        }
    }
}