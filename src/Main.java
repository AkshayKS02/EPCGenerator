import java.awt.*; // Only imports your own data structure
import javax.swing.*;
import models.HomeData;

public class Main {

    public static void main(String[] args) {
        // 1. Create the Main Window
        JFrame frame = new JFrame("EPC");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // 2. Create Layout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 3. Create Inputs (YOUR JOB)
        JPanel formPanel = new JPanel(new GridLayout(0, 2, 10, 10));

        JComboBox<String> houseType = new JComboBox<>(new String[]{"Apartment", "Independent"});
        JComboBox<String> roofType = new JComboBox<>(new String[]{"Concrete", "Tiled", "Metal"});
        JComboBox<String> insulation = new JComboBox<>(new String[]{"Poor", "Medium", "Good"});
        JComboBox<String> windows = new JComboBox<>(new String[]{"Single Glazed", "Double Glazed"});
        JComboBox<String> lighting = new JComboBox<>(new String[]{"LED", "CFL", "Incandescent"});
        JComboBox<String> ventilation = new JComboBox<>(new String[]{"Poor", "Average", "Good"});
        JComboBox<String> cooling = new JComboBox<>(new String[]{"AC", "Old AC", "Fan", "None"});
        JComboBox<String> heating = new JComboBox<>(new String[]{"Heater", "None"});
        JTextField applianceAge = new JTextField("5");

        formPanel.add(new JLabel("House Type:")); formPanel.add(houseType);
        formPanel.add(new JLabel("Roof Type:"));  formPanel.add(roofType);
        formPanel.add(new JLabel("Insulation:")); formPanel.add(insulation);
        formPanel.add(new JLabel("Windows:"));    formPanel.add(windows);
        formPanel.add(new JLabel("Lighting:"));   formPanel.add(lighting);
        formPanel.add(new JLabel("Ventilation:"));formPanel.add(ventilation);
        formPanel.add(new JLabel("Cooling:"));    formPanel.add(cooling);
        formPanel.add(new JLabel("Heating:"));    formPanel.add(heating);
        formPanel.add(new JLabel("Appliance Age:")); formPanel.add(applianceAge);

        // 4. Create Buttons
        JButton certBtn = new JButton("Get Certificate");
        JButton recBtn = new JButton("Get Recommendations");
        
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.add(certBtn);
        buttonPanel.add(recBtn);

        // --- PLACEHOLDER LOGIC (So you don't do other people's work) ---
        
        certBtn.addActionListener(e -> {
            try {
                // You test if YOUR data gathering works
                HomeData home = gatherData(houseType, insulation, windows, lighting, cooling, heating, applianceAge, ventilation, roofType);
                
                // Placeholder for Member 4
                JOptionPane.showMessageDialog(frame, 
                    "Data collected successfully!\n\nWaiting for Member 4 (Certificate Engine) to integrate.", 
                    "Member 4 Task", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) { 
                JOptionPane.showMessageDialog(frame, "Invalid Input: " + ex.getMessage()); 
            }
        });

        recBtn.addActionListener(e -> {
             try {
                // You test if YOUR data gathering works
                HomeData home = gatherData(houseType, insulation, windows, lighting, cooling, heating, applianceAge, ventilation, roofType);
                
                // Placeholder for Member 3
                JOptionPane.showMessageDialog(frame, 
                    "Data collected successfully!\n\nWaiting for Member 3 (Recommendation Engine) to integrate.", 
                    "Member 3 Task", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) { 
                JOptionPane.showMessageDialog(frame, "Invalid Input: " + ex.getMessage()); 
            }
        });

        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    // Your helper to ensure HomeData is created correctly
    private static HomeData gatherData(JComboBox t1, JComboBox t2, JComboBox t3, JComboBox t4, JComboBox t5, JComboBox t6, JTextField t7, JComboBox t8, JComboBox t9) {
        return new HomeData(
            t1.getSelectedItem().toString(), t2.getSelectedItem().toString(),
            t3.getSelectedItem().toString(), t4.getSelectedItem().toString(),
            t5.getSelectedItem().toString(), t6.getSelectedItem().toString(),
            Integer.parseInt(t7.getText()), t8.getSelectedItem().toString(),
            t9.getSelectedItem().toString()
        );
    }
}