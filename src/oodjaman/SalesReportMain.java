package oodjaman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalesReportMain extends JFrame {

    private JButton goBackButton;

    public SalesReportMain() {
        setTitle("Sales Report Generator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set up gradient background
        setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(135, 206, 250); // Light blue
                Color color2 = new Color(255, 255, 255); // White
                GradientPaint gp = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        });

        JButton closedSaleReportButton = createStyledButton("Closed Sale Report");
        JButton workDoneReportButton = createStyledButton("Work Done Report");
        goBackButton = createStyledButton("Go Back");

        closedSaleReportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open Closed Sale Report frame
                SwingUtilities.invokeLater(() -> {
                    new ClosedSaleReport("/Users/aman/Downloads/zip (1)/SalesQuotation.txt").setVisible(true);
                    dispose(); // Close the main frame
                });
            }
        });

        workDoneReportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open Work Done Report frame
                SwingUtilities.invokeLater(() -> {
                    new WorkDoneReport("/Users/aman/Downloads/zip (1)/SalesQuotation.txt").setVisible(true);
                    dispose(); // Close the main frame
                });
            }
        });

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> new MainAdminFrame().setVisible(true));
                dispose(); // Close the current frame
            }
        });

        // Layout setup

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(closedSaleReportButton)
                        .addComponent(workDoneReportButton)
                        .addComponent(goBackButton))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(closedSaleReportButton)
                .addComponent(workDoneReportButton)
                .addComponent(goBackButton)
        );
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
        SwingUtilities.invokeLater(() -> new SalesReportMain().setVisible(true));
    }
}
