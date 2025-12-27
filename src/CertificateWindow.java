
import models.HomeData;
import javax.swing.*;
import java.awt.*;

public class CertificateWindow {

    public static void show(HomeData data, String grade, String recommendations) {

        JFrame frame = new JFrame("Energy Performance Certificate");
        frame.setSize(650, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);

        // Background
        JPanel bg = new JPanel(new BorderLayout());
        bg.setBackground(Color.WHITE);
        bg.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Main card with blue border
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(30, 120, 200), 4),
                BorderFactory.createEmptyBorder(25, 35, 25, 35)
        ));

        // Header
        JLabel title = new JLabel("ENERGY PERFORMANCE CERTIFICATE", JLabel.CENTER);
        title.setForeground(new Color(15, 35, 70));   // dark navy header
        title.setFont(new Font("Serif", Font.BOLD, 24));
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));

        // Info panel
        JPanel info = new JPanel();
        info.setBackground(Color.WHITE);
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));

        Font infoFont = new Font("Segoe UI", Font.PLAIN, 16);

        JLabel houseType = new JLabel("House Type: " + data.houseType);
        houseType.setFont(infoFont);
        houseType.setForeground(Color.BLACK);

        JLabel gradeLabel = new JLabel("Final Grade: " + grade);
        gradeLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        gradeLabel.setForeground(new Color(0, 110, 0));  // dark green

        info.add(houseType);
        info.add(Box.createVerticalStrut(20));
        info.add(gradeLabel);
        info.add(Box.createVerticalStrut(25));

        JLabel hint = new JLabel("Click the button below to view detailed recommendations.");
        hint.setFont(new Font("Segoe UI", Font.ITALIC, 13));
        hint.setForeground(Color.DARK_GRAY);
        info.add(hint);
        info.add(Box.createVerticalStrut(20));

        // Button
        JButton button = new JButton("Show Recommendations");
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setFocusPainted(false);
        button.setBackground(new Color(30, 120, 200));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        button.addActionListener(e -> {
            RecommendationWindow.show(data, recommendations);
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(button);

        // Add components
        card.add(title, BorderLayout.NORTH);
        card.add(info, BorderLayout.CENTER);
        card.add(buttonPanel, BorderLayout.SOUTH);

        bg.add(card, BorderLayout.CENTER);
        frame.add(bg);
        frame.setVisible(true);
    }
}
