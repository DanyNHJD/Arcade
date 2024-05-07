package Jeopardy;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class JeopardyLayout extends JFrame implements ActionListener {

    private JButton[][] buttons = new JButton[5][4];
    private String[] money = {"$100", "$200", "$300", "$400", "$500"};
    private String[] categories = {"", "", "", ""};
    private int score = 0;
    private JLabel scoreLabel;


    public JeopardyLayout() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 600);
        setTitle("Jeopardy Game");
        setLayout(new GridLayout(6, 4, 10, 10));
        scoreLabel = new JLabel("Score: $" + score, SwingConstants.CENTER);
        add(scoreLabel);

        for (String category : categories) {
            add(new JLabel(category, SwingConstants.CENTER));
        }

        for (int row = 0; row < money.length; row++) {
            for (int col = 0; col < categories.length; col++) {
                JButton button = new JButton(money[row]);
                button.addActionListener(this);
                button.setFocusable(false);
                add(button);
                buttons[row][col] = button;
            }
        }
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < money.length; i++) {
            for (int j = 0; j < categories.length; j++) {
                if (e.getSource() == buttons[i][j]) {
                    fetchQuestionAndDisplay(categories[j], money[i]);
                    buttons[i][j].setEnabled(false);  // Disable the button after it is clicked
                    return;
                }
            }
        }
    }

    private void fetchQuestionAndDisplay(String category, String value) {
        SwingWorker<List<String>, Void> worker = new SwingWorker<>() {
            protected List<String> doInBackground() throws Exception {
                TriviaAPI api = new TriviaAPI();
                return api.fetchData();
            }

            protected void done() {
                try {
                    List<String> data = get();
                    if (data != null && !data.isEmpty()) {
                        new JeopardyQuestions(JeopardyLayout.this, category, value, (ArrayList<String>) data);
                    } else {
                        JOptionPane.showMessageDialog(null, "No data fetched.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Failed to fetch question.");
                }
            }
        };
        worker.execute();
    }

    void updateScore(int value) {
        score += value;
        scoreLabel.setText("Score: $" + score);
    }
}
