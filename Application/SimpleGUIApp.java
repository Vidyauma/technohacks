import javax.swing.*;
import java.awt.*;

public class SimpleGUIApp extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public SimpleGUIApp() {
        setTitle("Simple GUI Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add pages to the card layout
        mainPanel.add(createFirstPage(), "first");
        mainPanel.add(createSecondPage(), "second");
        mainPanel.add(createThirdPage(), "third");

        add(mainPanel);
    }

    private JPanel createFirstPage() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(255, 240, 245)); // Pastel pink

        JButton clickMeButton = new JButton("Click Me!");
        clickMeButton.setFont(new Font("Arial", Font.BOLD, 16));
        clickMeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        clickMeButton.addActionListener(e -> cardLayout.show(mainPanel, "second"));

        panel.add(Box.createVerticalStrut(150));
        panel.add(clickMeButton);
        panel.add(Box.createVerticalStrut(150));

        return panel;
    }

    private JPanel createSecondPage() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(230, 255, 240)); // Pastel green

        JLabel welcomeLabel = new JLabel("Welcome to the Application!");
        welcomeLabel.setFont(new Font("Algerian", Font.BOLD, 28)); // Algerian font
        welcomeLabel.setForeground(new Color(138, 43, 226)); // Violet color
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton nextButton = new JButton("Next Page");
        nextButton.setFont(new Font("Arial", Font.BOLD, 14));
        nextButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        nextButton.addActionListener(e -> cardLayout.show(mainPanel, "third"));

        JButton backButton = new JButton("Back to First Page");
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "first"));

        panel.add(Box.createVerticalStrut(100));
        panel.add(welcomeLabel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(nextButton);
        panel.add(Box.createVerticalStrut(20));
        panel.add(backButton);

        return panel;
    }

    private JPanel createThirdPage() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(240, 240, 255)); // Pastel blue

        JLabel aboutLabel = new JLabel("About This Application");
        aboutLabel.setFont(new Font("Papyrus", Font.BOLD, 28)); // Papyrus font
        aboutLabel.setForeground(new Color(0, 0, 0)); // Black color
        aboutLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel infoLabel = new JLabel("<html>This is a simple Java GUI application.<br>" +
                "It demonstrates a multipage interface with basic navigation.</html>");
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        infoLabel.setForeground(new Color(50, 50, 100));
        infoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 14));
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.addActionListener(e -> System.exit(0));

        JButton backButton = new JButton("Back to Second Page");
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "second"));

        panel.add(Box.createVerticalStrut(60));
        panel.add(aboutLabel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(infoLabel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(backButton);
        panel.add(Box.createVerticalStrut(20));
        panel.add(exitButton);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleGUIApp app = new SimpleGUIApp();
            app.setVisible(true);
        });
    }
}
