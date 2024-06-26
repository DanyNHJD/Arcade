import javax.swing.*;
import java.awt.event.*;
import java.awt.*; 

public class pingPong extends JFrame {
    private JPanel left, mid, right;
    private int score = 0;
    private int speedUpTimer = 1;
    private int speed = 7;
    private Ball ball;
    private final int w = 600;
    private final int h = 300;
    private computer c;
    private player p;
    private player p2;
    private boolean loss = false;
    private boolean isOnePlayerModeActive;

    public pingPong() {
        left = new JPanel();
        mid = new JPanel();
        right = new JPanel();
        setVisible(true);
        setTitle("Ping-Pong");
        setSize(w, h);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        left.setBounds(0,0,30,300);
        mid.setBounds(30,0,530,300);
        right.setBounds(560,0,40,300);

        left.setLayout(null);
        mid.setLayout(null);
        right.setLayout(null);

        left.setBackground(Color.BLACK);
        mid.setBackground(Color.BLACK);
        right.setBackground(Color.BLACK);

        add(left);
        add(mid);
        add(right);
        p = new player(10,50);
        playerIcon play = new playerIcon(this, p);
        JLabel playerLabel = new JLabel(play);
        playerLabel.setBounds(0, 0, 100, h); // Set bounds for player label
        left.add(playerLabel);

        ball = new Ball(this, p); // Assign the local variable b to the field ball
        BallIcon ballIcon = new BallIcon(this, ball);
        JLabel ballLabel = new JLabel(ballIcon);
        ballLabel.setBounds(0, 0, w, h); // Set bounds for ball label
        mid.add(ballLabel);

        addKeyListener(p);
        
        // Add menu for player selection
        Object[] options = {"One Player", "Two Players"};
        int choice = JOptionPane.showOptionDialog(null, "Select number of players:", "Player Selection", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (choice == JOptionPane.YES_OPTION) {
            // One player mode
            isOnePlayerModeActive = true;
            c = new computer(ball,0,50);
            computerIcon comp = new computerIcon(this, c);
            JLabel computerLabel = new JLabel(comp);
            computerLabel.setBounds(0, 0, 100, h); // Set bounds for computer label
            right.add(computerLabel);
        } else {
            // Two players mode
            isOnePlayerModeActive = false;
            right.revalidate(); // Revalidate the panel to reflect the changes
            right.repaint(); // Repaint the panel to ensure proper rendering
            p2 = new player(0, 50); // Initialize the second player
            playerIcon play2 = new playerIcon(this, p2);
            JLabel player2Label = new JLabel(play2);
            player2Label.setBounds(0, 0, 100, h); // Set bounds for player 2 label
            right.add(player2Label);
        
            addKeyListener(new Player2KeyListener());
        }

        Timer t = new Timer(100, new ActionListener(){
            public void actionPerformed(ActionEvent e){
            if (!loss) {
            update();
            repaint();
            speedUpTimer++;
                if (speedUpTimer % 10 == 0) {
                speedUpTimer = 1;
                speed += 0.1;
                ball.setSpeed(speed);
                score++;
            }
            setTitle("Ping-Pong\t\t\t\t\t\t score: " + score);
            } else {
                if (isOnePlayerModeActive) {
                setTitle("Game Over \t\t\t\t\t Your Score Was: " + score);
            }   else {
                    if (p.getY() > p2.getY()) {
                    setTitle("Player Two Loses \t\t\t\t\t The Score Was: " + score);
                }   else {
                    setTitle("Player One Loses \t\t\t\t\t The Score Was: " + score);
                }
            }
            }
        }
    });
        t.start();
        revalidate();
    }

    class Player2KeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int k = e.getKeyCode();

            // Move player 2 paddle up
            if (k == KeyEvent.VK_UP) {
                int newY = p2.getY() - 5; // Adjust the paddle's movement speed as needed
                if (newY >= 0) {
                    p2.setY(newY);
                }
            }
            // Move player 2 paddle down
            else if (k == KeyEvent.VK_DOWN) {
                int newY = p2.getY() + 5; // Adjust the paddle's movement speed as needed
                if (newY + p2.getHeight() <= h) {
                    p2.setY(newY);
                }
            }
        }
    }
    
    private void update() {
        ball.move();
        ball.checkWallCollision(w, h);

        if (isOnePlayerModeActive) {
            loss = ball.checkPaddleCollision(p, null, c, mid.getWidth()); // Pass only player paddle and computer paddle
            c.computerMove(); // Move the computer paddle
        } else {
            loss = ball.checkPaddleCollision(p, p2, null, mid.getWidth()); // Pass both player paddles
        }
    }
}
