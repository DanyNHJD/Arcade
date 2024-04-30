import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class JeopardyQuestions extends JFrame {
    private ButtonGroup group = new ButtonGroup();
    private String correctAnswer;
    private JeopardyLayout parent;
    private int questionValue;

    private void addRadioButtons(JPanel panel, ArrayList<String> answers) {
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);

        for (String answer : answers) {
            JRadioButton button = new JRadioButton(answer);
            group.add(button);
            panel.add(button, gbc);
        }
    }

    public JeopardyQuestions(JeopardyLayout parent, String category, String value, ArrayList<String> allAnswers) {
        super(category + ", Value: " + value);
        this.parent = parent;
        this.questionValue = Integer.parseInt(value.replace("$", ""));

        String question = allAnswers.remove(0);
        correctAnswer = allAnswers.get(0);

        allAnswers.remove(0);

        Collections.shuffle(allAnswers);
        allAnswers.add(correctAnswer);
        Collections.shuffle(allAnswers);

        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;

        JLabel questionLabel = new JLabel("<html><div style='text-align: center;'>" + question + "</div></html>");
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(questionLabel, gbc);

        JPanel panel = new JPanel();
        addRadioButtons(panel, allAnswers);
        gbc.anchor = GridBagConstraints.CENTER;
        add(panel, gbc);

        JButton confirmButton = new JButton("CONFIRM");
        confirmButton.setPreferredSize(new Dimension(100, 25));
        confirmButton.setFont(new Font("Arial", Font.BOLD, 13));
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
            }
        });
        add(confirmButton, gbc);

        setVisible(true);
    }

    private void checkAnswer() {
        Enumeration<AbstractButton> buttons = group.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                if (button.getText().equals(correctAnswer)) {
                    JOptionPane.showMessageDialog(this, "Correct Answer!", "Result", JOptionPane.INFORMATION_MESSAGE);
                    parent.updateScore(questionValue);
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong Answer!\nCorrect Answer: " + correctAnswer, "Result", JOptionPane.ERROR_MESSAGE);
                }
                dispose();
                break;
            }
        }
    }

}
