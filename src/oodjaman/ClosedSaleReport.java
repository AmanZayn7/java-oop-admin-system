package oodjaman;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClosedSaleReport extends JFrame {

    private JButton goBackButton;

    public ClosedSaleReport(String filePath) {
        setTitle("Closed Sale Report");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        // Set up gradient background
        setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(135, 206, 250); // Light orange
                Color color2 = new Color(255, 255, 255); // Coral
                GradientPaint gp = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        });

        List<String[]> approvedSales = getApprovedSales(filePath);

        // Create table model
        String[] columnNames = {"Item ID", "Item Name", "Category", "Price", "Order Date", "Status"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public Class<?> getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };

        // Add approved sales to table model
        for (String[] sale : approvedSales) {
            tableModel.addRow(sale);
        }

        JTable reportTable = new JTable(tableModel) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component comp = super.prepareRenderer(renderer, row, column);

                // Handle selection state
                if (isRowSelected(row)) {
                    comp.setBackground(new Color(70, 130, 180)); // Light blue for selected row
                } else {
                    comp.setBackground(row % 2 == 0 ? Color.WHITE : new Color(255, 255, 255)); // Alternating row colors
                }

                return comp;
            }
        };


        reportTable.setFillsViewportHeight(false);
        JScrollPane scrollPane = new JScrollPane(reportTable);

        // Create "Go Back" button
        goBackButton = new JButton("Go Back");
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current frame
                SwingUtilities.invokeLater(() -> new SalesReportMain().setVisible(true));
            }
        });

        // Use GridBagLayout to center the table and add the "Go Back" button
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(10, 10, 10, 10);
        getContentPane().add(scrollPane, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.insets = new Insets(10, 10, 10, 10);
        getContentPane().add(goBackButton, constraints);

        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    private List<String[]> getApprovedSales(String filePath) {
        List<String[]> approvedSales = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t"); // Assuming tab-separated values

                if (parts.length >= 6) {
                    String status = parts[5].trim().toLowerCase();

                    // Check if the sale is approved
                    if (status.equals("approved")) {
                        approvedSales.add(parts);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }

        return approvedSales;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ClosedSaleReport("/Users/aman/Downloads/zip (1)/SalesQuotation.txt");
        });
    }
}
