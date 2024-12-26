package org.example.Gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class ManajemenGui extends JFrame {
    private JPanel sidebar;
    private JPanel mainContent;
    private JButton activeButton;

    public ManajemenGui() {
        // Frame setup
        setTitle("Manajemen Nilai Siswa");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main container panel
        JPanel contentPanel = new JPanel(new BorderLayout());

        // Header
        JPanel header = createGradientPanel(new Color(41, 128, 185), new Color(52, 152, 219), 70);
        JLabel titleLabel = new JLabel("Manajemen Nilai Siswa", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.WHITE);
        header.add(titleLabel);

        // Sidebar
        sidebar = new JPanel();
        sidebar.setBackground(new Color(44, 62, 80));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setPreferredSize(new Dimension(300, 0));
        sidebar.setBorder(new EmptyBorder(20, 10, 20, 10));

        String[] menuItems = {"Tambah Siswa", "Edit Siswa", "Hapus Siswa", "Input Nilai", "Edit Nilai", "Lihat Nilai"};
        for (String menuItem : menuItems) {
            JButton menuButton = createSidebarButton(menuItem);
            sidebar.add(Box.createVerticalStrut(10));
            sidebar.add(menuButton);
        }

        // Main content area
        mainContent = new JPanel(new BorderLayout());
        mainContent.setBackground(new Color(245, 245, 245));
        mainContent.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Footer
        JPanel footer = createGradientPanel(new Color(41, 128, 185), new Color(52, 152, 219), 40);
        JLabel footerLabel = new JLabel("\u00A9 Sofyan", JLabel.CENTER);
        footerLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        footerLabel.setForeground(Color.WHITE);
        footer.add(footerLabel);

        // Layout
        contentPanel.add(header, BorderLayout.NORTH);
        contentPanel.add(sidebar, BorderLayout.WEST);
        contentPanel.add(mainContent, BorderLayout.CENTER);
        contentPanel.add(footer, BorderLayout.SOUTH);

        // Add content panel to frame
        add(contentPanel);
        setVisible(true);
    }

    // Helper method to create a gradient panel
    private JPanel createGradientPanel(Color start, Color end, int height) {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, start, getWidth(), 0, end);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setPreferredSize(new Dimension(getWidth(), height));
        panel.setLayout(new BorderLayout());
        return panel;
    }

    // Create Sidebar Button
    private JButton createSidebarButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        button.setBackground(new Color(52, 73, 94));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (button != activeButton) {
                    button.setBackground(new Color(41, 128, 185));
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (button != activeButton) {
                    button.setBackground(new Color(52, 73, 94));
                }
            }
        });

        // Active button effect
        button.addActionListener(e -> {
            if (activeButton != null) {
                activeButton.setBackground(new Color(52, 73, 94));
            }
            activeButton = button;
            button.setBackground(new Color(22, 160, 133)); // Active color
            showForm(text);
        });

        return button;
    }

    // Show corresponding form based on menu selection
    private void showForm(String menuItem) {
        mainContent.removeAll();
        mainContent.add(new JLabel("Form: " + menuItem, JLabel.CENTER), BorderLayout.CENTER);
        mainContent.revalidate();
        mainContent.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ManajemenGui::new);
    }
}
