// TYPE SELECTION GUI
package oodjaman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserTypeSelectionFrame extends JFrame {
    public UserTypeSelectionFrame() {
        setTitle("User Type Selection");
        setSize(350, 175);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create buttons for Salesperson and Officer
        JButton salespersonButton = new JButton("Salesperson");
        JButton officerButton = new JButton("Officer");

        // Add action listeners to the buttons
        salespersonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = WorkerProfileManager.getFilePath("SALESPERSON");
                openWorkerProfileGUI("Salesperson", filePath);
            }
        });

        officerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = WorkerProfileManager.getFilePath("OFFICER");
                openWorkerProfileGUI("Salesperson", filePath);
            }
        });

        // Create a panel and add buttons to it
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                // Set blue gradient background
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(135, 206, 250);  // LightSkyBlue
                Color color2 = new Color(70, 130, 180);   // SteelBlue
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        panel.setLayout(new FlowLayout());
        panel.add(salespersonButton);
        panel.add(officerButton);

        // Add the panel to the frame
        add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void openWorkerProfileGUI(String userType, String filePath) {
        // Pass the selected worker type and file path to WorkerProfileManager
        WorkerProfileGUI workerProfileGUI = new WorkerProfileGUI(userType, filePath);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                workerProfileGUI.setVisible(true);
                dispose();  // Close the current frame after opening WorkerProfileGUI
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UserTypeSelectionFrame();
            }
        });
    }
}
