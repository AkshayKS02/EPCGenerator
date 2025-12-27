package ui;
import engine.RecommendationEngine;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import models.HomeData;

public class RecommendationWindow {

    public RecommendationWindow(HomeData home) {

        RecommendationEngine engine = new RecommendationEngine();
        List<String> recs = engine.generateRecommendations(home);

        JFrame frame = new JFrame("Energy Recommendations");
        frame.setSize(550, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);

        JPanel bg = new JPanel(new BorderLayout());
        bg.setBackground(Color.WHITE);
        bg.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(30, 120, 200), 3),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        JLabel title = new JLabel("RECOMMENDATIONS", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 22));
        title.setForeground(new Color(15, 35, 70));
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));

        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        textArea.setEditable(false);
        textArea.setForeground(Color.BLACK);
        textArea.setBackground(Color.WHITE);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        StringBuilder sb = new StringBuilder();
        for (String r : recs) {
            sb.append("• ").append(r).append("\n\n");
        }  
        textArea.setText(sb.toString());

        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setBorder(BorderFactory.createEmptyBorder());

        card.add(title, BorderLayout.NORTH);
        card.add(scroll, BorderLayout.CENTER);

        bg.add(card, BorderLayout.CENTER);
        frame.add(bg);

        frame.setVisible(true);
    }
}
