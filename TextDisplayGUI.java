import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextDisplayGUI extends JFrame implements ActionListener {
    private JLabel textLabel;
    private JButton moveLeftButton;
    private JButton moveRightButton;
    private JRadioButton redRadioButton;
    private JRadioButton yellowRadioButton;
    private JRadioButton blackRadioButton;
    private JRadioButton orangeRadioButton;
    private JRadioButton greenRadioButton;

    public TextDisplayGUI() {
        setTitle("Text Display");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textLabel = new JLabel("Programming is fun", JLabel.CENTER);
        textLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(textLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        moveLeftButton = new JButton("<=");
        moveLeftButton.addActionListener(this);
        buttonPanel.add(moveLeftButton);

        moveRightButton = new JButton("=>");
        moveRightButton.addActionListener(this);
        buttonPanel.add(moveRightButton);

        add(buttonPanel, BorderLayout.SOUTH);

        JPanel colorPanel = new JPanel();
        colorPanel.setLayout(new GridLayout(1, 5));

        redRadioButton = new JRadioButton("Red");
        redRadioButton.addActionListener(this);
        colorPanel.add(redRadioButton);

        yellowRadioButton = new JRadioButton("Yellow");
        yellowRadioButton.addActionListener(this);
        colorPanel.add(yellowRadioButton);

        blackRadioButton = new JRadioButton("Black");
        blackRadioButton.addActionListener(this);
        colorPanel.add(blackRadioButton);

        orangeRadioButton = new JRadioButton("Orange");
        orangeRadioButton.addActionListener(this);
        colorPanel.add(orangeRadioButton);

        greenRadioButton = new JRadioButton("Green");
        greenRadioButton.addActionListener(this);
        colorPanel.add(greenRadioButton);

        ButtonGroup colorGroup = new ButtonGroup();
        colorGroup.add(redRadioButton);
        colorGroup.add(yellowRadioButton);
        colorGroup.add(blackRadioButton);
        colorGroup.add(orangeRadioButton);
        colorGroup.add(greenRadioButton);

        add(colorPanel, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == moveLeftButton) {
            moveTextLeft();
        } else if (e.getSource() == moveRightButton) {
            moveTextRight();
        } else if (e.getSource() == redRadioButton) {
            changeTextColor(Color.RED);
        } else if (e.getSource() == yellowRadioButton) {
            changeTextColor(Color.YELLOW);
        } else if (e.getSource() == blackRadioButton) {
            changeTextColor(Color.BLACK);
        } else if (e.getSource() == orangeRadioButton) {
            // Menggunakan warna orange yang lebih cerah
            changeTextColor(new Color(255, 165, 0)); 
        } else if (e.getSource() == greenRadioButton) {
            changeTextColor(Color.GREEN);
        }
    }

    private void moveTextLeft() {
        int currentX = textLabel.getLocation().x;
        if (currentX > 0) {
            textLabel.setLocation(currentX - 10, textLabel.getLocation().y);
        }
    }

    private void moveTextRight() {
        int currentX = textLabel.getLocation().x;
        int labelWidth = textLabel.getWidth();
        int frameWidth = getWidth();
        if (currentX + labelWidth < frameWidth - 10) {
            textLabel.setLocation(currentX + 10, textLabel.getLocation().y);
        }
    }

    private void changeTextColor(Color color) {
        textLabel.setForeground(color);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TextDisplayGUI gui = new TextDisplayGUI();
            gui.setVisible(true);
        });
    }
}
