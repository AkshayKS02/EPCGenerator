package ui;

import engine.ScoringEngine;
import java.awt.*;
import javax.swing.*;
import models.HomeData;

public class CertificateWindow {

    public CertificateWindow(HomeData home) {

        int score = ScoringEngine.calculateScore(home);
        char grade = ScoringEngine.getGrade(score);

        JFrame frame = new JFrame("Energy Performance Certificate");
        frame.setSize(650, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);

        JPanel bg = new JPanel(new BorderLayout());
        bg.setBackground(Color.WHITE);
        bg.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(30, 120, 200), 4),
                BorderFactory.createEmptyBorder(25, 35, 25, 35)
        ));

        JLabel title = new JLabel("ENERGY PERFORMANCE CERTIFICATE", JLabel.CENTER);
        title.setForeground(new Color(15, 35, 70));
        title.setFont(new Font("Serif", Font.BOLD, 24));
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));

        JPanel info = new JPanel();
        info.setBackground(Color.WHITE);
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));

        Font infoFont = new Font("Segoe UI", Font.PLAIN, 16);

        JLabel houseType = new JLabel("House Type: " + home.houseType);
        houseType.setFont(infoFont);

        JLabel scoreLabel = new JLabel("EPC Score: " + score);
        scoreLabel.setFont(infoFont);

        JLabel gradeLabel = new JLabel("Final Grade: " + grade);
        gradeLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        Color gradeColor;
        if (grade == 'A' || grade == 'B') {
            gradeColor = new Color(0, 140, 0); // green
        } else if (grade == 'C' || grade == 'D') {
            gradeColor = new Color(255, 140, 0); // orange
        } else {
            gradeColor = new Color(180, 0, 0); // red
        }
        gradeLabel.setForeground(gradeColor);

        JLabel gradeHint = new JLabel();
        gradeHint.setFont(new Font("Segoe UI", Font.ITALIC, 13));
        gradeHint.setForeground(Color.DARK_GRAY);

        switch (grade) {
            case 'A':
            case 'B':
                gradeHint.setText("High Energy Efficiency");
                break;
            case 'C':
            case 'D':
                gradeHint.setText("Moderate Energy Efficiency");
                break;
            default:
                gradeHint.setText("Low Energy Efficiency – Improvements Recommended");
        }

        info.add(houseType);
        info.add(Box.createVerticalStrut(15));
        info.add(scoreLabel);
        info.add(Box.createVerticalStrut(15));
        info.add(gradeLabel);
        info.add(Box.createVerticalStrut(10));
        info.add(gradeHint);
        info.add(Box.createVerticalStrut(25));

        JLabel hint = new JLabel("View detailed recommendations below.");
        hint.setFont(new Font("Segoe UI", Font.ITALIC, 13));
        hint.setForeground(Color.DARK_GRAY);
        info.add(hint);

        JButton viewRecBtn = new JButton("View Recommendations");
        viewRecBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        viewRecBtn.setFocusPainted(false);
        viewRecBtn.setBackground(new Color(30, 120, 200));
        viewRecBtn.setForeground(Color.WHITE);
        viewRecBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        viewRecBtn.addActionListener(e -> {
            new RecommendationWindow(home);
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(viewRecBtn);

        card.add(title, BorderLayout.NORTH);
        card.add(info, BorderLayout.CENTER);
        card.add(buttonPanel, BorderLayout.SOUTH);

        bg.add(card, BorderLayout.CENTER);
        frame.add(bg);
        frame.setVisible(true);
    }
}
