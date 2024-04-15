import jdk.jfr.Category;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jeopardy extends JFrame implements ActionListener {



    private JButton[][] buttons = new JButton[5][4];

    private String[] categories = {"Food", "Guinea Pigs", "Product Names", "Identities"};
    private String[] Money = {"$100", "$200", "$300", "$400", "$500",};


    Jeopardy() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(800, 600);
        setTitle("Jeopardy Game");


        for(int i = 0; i <= 3; i++) {
                JLabel label = new JLabel("" + categories[i], JLabel.CENTER);
                label.setBounds(i * 150, 50, 200, 50);
                add(label);
        }

        for (int i = 0; i < Money.length; i++) {
            for (int j = 0; j < categories.length; j++) {
                JButton button = new JButton("" + Money[i]);
                button.setBounds(50 + j * 150, 100 + i * 50, 100, 40);
                button.addActionListener(this);
                button.setFocusable(false);
                add(button);
                buttons[i][j] = button;
            }
        }
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < categories.length; i++) {
            for (int j = 0; j < 5; j++) {
                if (e.getSource() == buttons[j][i]) {
                    System.out.println(categories[i] + " button at row " + (j + 1) + " clicked.");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Jeopardy();
    }
}
