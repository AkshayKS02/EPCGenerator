import java.awt.*;
import javax.swing.*;
import models.HomeData;
import ui.RecommendationWindow;
import ui.CertificateWindow;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("EPC");
        frame.setSize(420, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel formPanel = new JPanel(new GridLayout(0, 2, 10, 10));

        // ---- DROPDOWNS WITH PLACEHOLDERS ----
        JComboBox<String> houseType = new JComboBox<>(new String[]{
                "Select House Type", "Apartment", "Independent", "Commercial"
        });

        JComboBox<String> wallType = new JComboBox<>(new String[]{
                "Select Wall Type", "Brick", "Concrete", "Glass"
        });

        JComboBox<String> roofType = new JComboBox<>(new String[]{
                "Select Roof Type", "Concrete", "Tiled", "Metal"
        });

        JComboBox<String> windows = new JComboBox<>(new String[]{
                "Select Window Type", "Single Glazed", "Double Glazed"
        });

        JComboBox<String> lighting = new JComboBox<>(new String[]{
                "Select Lighting", "LED", "CFL", "Incandescent"
        });

        JComboBox<String> ventilationSystem = new JComboBox<>(new String[]{
                "Select Ventilation", "Natural", "Exhaust Fan", "Centralized HVAC"
        });

        JComboBox<String> cooling = new JComboBox<>(new String[]{
                "Select Cooling", "AC", "Old AC", "Fan", "None"
        });

        JComboBox<String> heating = new JComboBox<>(new String[]{
                "Select Heating", "Heater", "None"
        });

        JTextField applianceAge = new JTextField("");

        // ---- FORM ----
        formPanel.add(new JLabel("House Type:")); formPanel.add(houseType);
        formPanel.add(new JLabel("Wall Type:")); formPanel.add(wallType);
        formPanel.add(new JLabel("Roof Type:")); formPanel.add(roofType);
        formPanel.add(new JLabel("Windows:")); formPanel.add(windows);
        formPanel.add(new JLabel("Lighting:")); formPanel.add(lighting);
        formPanel.add(new JLabel("Ventilation System:")); formPanel.add(ventilationSystem);
        formPanel.add(new JLabel("Cooling:")); formPanel.add(cooling);
        formPanel.add(new JLabel("Heating:")); formPanel.add(heating);
        formPanel.add(new JLabel("Appliance Age:")); formPanel.add(applianceAge);

        JButton certBtn = new JButton("Get Certificate");
        JButton recBtn = new JButton("Get Recommendations");

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.add(certBtn);
        buttonPanel.add(recBtn);

        // ---- CERTIFICATE ACTION ----
        certBtn.addActionListener(e -> {
            try {
                HomeData home = validateAndCollect(
                        houseType, wallType, roofType, windows,
                        lighting, ventilationSystem, cooling,
                        heating, applianceAge
                );

                new CertificateWindow(home);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            }
        });

        // ---- RECOMMENDATION ACTION ----
        recBtn.addActionListener(e -> {
            try {
                HomeData home = validateAndCollect(
                        houseType, wallType, roofType, windows,
                        lighting, ventilationSystem, cooling,
                        heating, applianceAge
                );

                new RecommendationWindow(home);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            }
        });


        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    // ---- VALIDATION + DATA COLLECTION ----
    private static HomeData validateAndCollect(
            JComboBox<String> houseType,
            JComboBox<String> wallType,
            JComboBox<String> roofType,
            JComboBox<String> windows,
            JComboBox<String> lighting,
            JComboBox<String> ventilationSystem,
            JComboBox<String> cooling,
            JComboBox<String> heating,
            JTextField applianceAge) throws Exception {

        if (houseType.getSelectedIndex() == 0 ||
            wallType.getSelectedIndex() == 0 ||
            roofType.getSelectedIndex() == 0 ||
            windows.getSelectedIndex() == 0 ||
            lighting.getSelectedIndex() == 0 ||
            ventilationSystem.getSelectedIndex() == 0 ||
            cooling.getSelectedIndex() == 0 ||
            heating.getSelectedIndex() == 0 ||
            applianceAge.getText().isEmpty()) {

            throw new Exception("Please select ALL fields before proceeding.");
        }

        int age = Integer.parseInt(applianceAge.getText());

        return new HomeData(
                houseType.getSelectedItem().toString(),
                wallType.getSelectedItem().toString(),
                windows.getSelectedItem().toString(),
                lighting.getSelectedItem().toString(),
                cooling.getSelectedItem().toString(),
                heating.getSelectedItem().toString(),
                age,
                ventilationSystem.getSelectedItem().toString(),
                roofType.getSelectedItem().toString()
        );
    }
}
