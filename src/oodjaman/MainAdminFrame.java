package oodjaman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainAdminFrame extends JFrame {

    private oodjaman2 adminProfileFrame;
    private WorkerProfileGUI salespersonProfileFrame;
    private WorkerProfileGUI officerProfileFrame;

    public MainAdminFrame() {
        setTitle("Admin Main Page");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a JLabel to hold the background image
        JLabel backgroundImageLabel = new JLabel();
        setContentPane(backgroundImageLabel);

        // Load the background image
        ImageIcon backgroundImage = new ImageIcon("/Users/aman/eclipse-workspace/oodjaman/src/oodjaman/pngtree-big-mountain-border-blue-mountains-png-image_6545492.png");
        backgroundImageLabel.setIcon(backgroundImage);

        JButton managePersonalProfileButton = createStyledButton("Manage Personal Profile");
        JButton manageWorkerProfileButton = createStyledButton("Manage Worker Profile");
        JButton generateReportButton = createStyledButton("Generate Report");

        managePersonalProfileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the Administrator Profile frame
                SwingUtilities.invokeLater(() -> {
                    if (adminProfileFrame == null) {
                        adminProfileFrame = new oodjaman2();
                    }
                    adminProfileFrame.setVisible(true);
                });
            }
        });

        manageWorkerProfileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Prompt user to choose worker type
                UserTypeSelectionFrame userTypeSelectionFrame = new UserTypeSelectionFrame();
                userTypeSelectionFrame.setVisible(true);
            }
        });

        generateReportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the SalesReportMain frame
                SwingUtilities.invokeLater(() -> {
                    new SalesReportMain().setVisible(true);
                });
            }
        });

        // Set layout manager to null for the content pane
        setLayout(null);

        // Set bounds for the buttons and background image
        managePersonalProfileButton.setBounds(50, 30, 300, 40);
        manageWorkerProfileButton.setBounds(50, 80, 300, 40);
        generateReportButton.setBounds(50, 130, 300, 40);
        backgroundImageLabel.setBounds(0, 0, getWidth(), getHeight());

        // Add buttons to the content pane
        add(managePersonalProfileButton);
        add(manageWorkerProfileButton);
        add(generateReportButton);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(70, 130, 180)); // Light blue
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainAdminFrame mainAdminFrame = new MainAdminFrame();
            mainAdminFrame.setVisible(true);
        });
    }

}
