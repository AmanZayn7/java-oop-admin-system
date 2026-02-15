package oodjaman;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class oodjaman2 extends JFrame {

    private AdministratorProfile administratorProfile;

    private JTextField emailField;
    private JTextField phoneNumberField;
    private JTextField addressField;
    private JButton saveButton;
    private JButton goBackButton;

    public oodjaman2() {
        administratorProfile = AdministratorProfileManager.readProfile();

        setTitle("Administrator Profile");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createUI();
    }

    private void createUI() {
        JPanel mainPanel = new BackgroundPanel("/Users/aman/eclipse-workspace/oodjaman/src/oodjaman/pngtree-big-mountain-border-blue-mountains-png-image_6545492.png");
        mainPanel.setLayout(new GridLayout(6, 2, 10, 10));

        mainPanel.add(new JLabel("Name:"));
        mainPanel.add(new JTextField(administratorProfile.getName())).setEnabled(false);
        mainPanel.add(new JLabel("Position:"));
        mainPanel.add(new JTextField(administratorProfile.getPosition())).setEnabled(false);
        mainPanel.add(new JLabel("Email:"));
        emailField = new JTextField(administratorProfile.getEmail());
        mainPanel.add(emailField);
        mainPanel.add(new JLabel("Phone Number:"));
        phoneNumberField = new JTextField(administratorProfile.getPhoneNumber());
        mainPanel.add(phoneNumberField);
        mainPanel.add(new JLabel("Address:"));
        addressField = new JTextField(administratorProfile.getAddress());
        mainPanel.add(addressField);

        saveButton = createStyledButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveChanges();
            }
        });

        // Create "Go Back" button
        goBackButton = createStyledButton("Back");
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current frame
            }
        });

        mainPanel.add(saveButton);
        mainPanel.add(goBackButton);
        setLocationRelativeTo(null);

        getContentPane().add(mainPanel, BorderLayout.CENTER);
    }

    private void saveChanges() {
        administratorProfile.setEmail(emailField.getText());
        administratorProfile.setPhoneNumber(phoneNumberField.getText());
        administratorProfile.setAddress(addressField.getText());

        AdministratorProfileManager.writeProfile(administratorProfile);

        // Create a custom JDialog with a blue gradient background
        JDialog dialog = new JDialog(this, "Success", true);
        dialog.setContentPane(createBlueGradientBackground());
        dialog.setSize(300, 100);
        dialog.setLocationRelativeTo(this);

        // Add a label to the dialog
        JLabel label = new JLabel("Changes saved successfully.");
        label.setForeground(Color.WHITE);
        dialog.add(label, BorderLayout.CENTER);

        // Set a timer to close the dialog after 2 seconds (2000 milliseconds)
        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        timer.setRepeats(false); // Only run the timer once
        timer.start();

        dialog.setVisible(true);
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
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new oodjaman2().setVisible(true);
            }
        });
    }

    // Custom JPanel with background image
    private class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(String imagePath) {
            try {
                backgroundImage = ImageIO.read(new File(imagePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
    private JPanel createBlueGradientBackground() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int w = getWidth();
                int h = getHeight();
                Color color1 = new Color(70, 130, 180); // Light blue
                Color color2 = new Color(30, 60, 90);   // Dark blue
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        return panel;
    }
}
