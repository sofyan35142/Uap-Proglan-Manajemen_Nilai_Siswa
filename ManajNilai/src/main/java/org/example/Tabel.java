package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class Tabel {

    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Table with Images");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);

        // Table column names
        String[] columnNames = {"ID", "NIS", "Nama", "Kelas", "Foto", "Nilai 1", "Nilai 2", "Nilai 3"};

        // Table data
        Object[][] data = {
                {1, "11111111", "Sofyann", "12", new ImageIcon("path/to/image1.jpg"), 0.0, 0.0, 0.0},
                {2, "11111112", "Rahmat", "12", new ImageIcon("path/to/image2.jpg"), 0.0, 0.0, 0.0},
        };

        // Create table model
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 4) { // The "Foto" column
                    return ImageIcon.class; // Use ImageIcon for the "Foto" column
                }
                return super.getColumnClass(columnIndex);
            }
        };

        // Create table
        JTable table = new JTable(model);

        // Set custom renderer for the "Foto" column
        table.getColumn("Foto").setCellRenderer(new ImageRenderer());

        // Add table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        // Make frame visible
        frame.setVisible(true);
    }

    // Custom renderer for rendering ImageIcon in the table
    static class ImageRenderer implements TableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof ImageIcon) {
                JLabel label = new JLabel();
                label.setIcon((ImageIcon) value);
                label.setHorizontalAlignment(JLabel.CENTER);
                return label;
            }
            return new JLabel(value == null ? "" : value.toString());
        }
    }
}
