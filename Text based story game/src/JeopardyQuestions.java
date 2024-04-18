import javax.swing.*;
import java.awt.*;

public class JeopardyQuestions extends JFrame {
    private ButtonGroup group = new ButtonGroup();
    private String[] labels = {"TRUE", "TRUEe", "TRUEee", "TRUEeee"};

    private void addRadioButtons(JPanel panel) {
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);

        for (String label : labels) {
            JRadioButton button = new JRadioButton(label);
            group.add(button);
            panel.add(button, gbc);
        }
    }

    JeopardyQuestions(String category, String value) {
        super("Category: " + category + ", Value: " + value);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        JLabel label = new JLabel("Category: " + category + ", Value: " + value);
        add(label, gbc);

        JPanel panel = new JPanel();
        addRadioButtons(panel);
        gbc.anchor = GridBagConstraints.CENTER;
        add(panel, gbc);

        setVisible(true);
    }

}
