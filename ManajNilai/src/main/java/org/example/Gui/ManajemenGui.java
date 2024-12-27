package org.example.Gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import org.example.Manajemen;
import org.example.Siswa;

public class ManajemenGui extends JFrame {
    private JPanel sidebar;
    private JPanel mainContent;
    private JButton activeButton;
    private Manajemen manajemen;

    public ManajemenGui() {
        manajemen = new Manajemen();
        setTitle("Manajemen Nilai Siswa");
        setSize(800, 600); // Set a smaller size for the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

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
        sidebar.setPreferredSize(new Dimension(250, 0)); // Smaller sidebar width
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

        switch (menuItem) {
            case "Tambah Siswa":
                mainContent.add(createTambahSiswaForm(), BorderLayout.CENTER);
                break;
            case "Edit Siswa":
                mainContent.add(createEditSiswaForm(), BorderLayout.CENTER);
                break;
            case "Hapus Siswa":
                mainContent.add(createHapusSiswaForm(), BorderLayout.CENTER);
                break;
            case "Input Nilai":
                mainContent.add(createInputNilaiForm(), BorderLayout.CENTER);
                break;
            case "Edit Nilai":
                mainContent.add(createEditNilaiForm(), BorderLayout.CENTER);
                break;
            case "Lihat Nilai":
                mainContent.add(createLihatNilaiForm(), BorderLayout.CENTER);
                break;
            default:
                mainContent.add(new JLabel("Form: " + menuItem, JLabel.CENTER), BorderLayout.CENTER);
        }

        mainContent.revalidate();
        mainContent.repaint();
    }

    // Create Form for "Tambah Siswa"
    private JPanel createTambahSiswaForm() {
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBackground(Color.WHITE);

        JLabel labelNama = new JLabel("Nama Siswa:");
        JTextField inputNama = new JTextField();

        JLabel labelNis = new JLabel("NIS Siswa:");
        JTextField inputNis = new JTextField();

        JLabel labelKelas = new JLabel("Kelas Siswa:");
        JTextField inputKelas = new JTextField();

        JButton submitButton = new JButton("Tambah Siswa");
        submitButton.addActionListener(e -> {
            String nama = inputNama.getText();
            String nis = inputNis.getText();
            String kelas = inputKelas.getText();
            manajemen.tambahSiswa(nama, nis, kelas);
            JOptionPane.showMessageDialog(this, "Siswa berhasil ditambahkan!");
            inputNama.setText("");
            inputNis.setText("");
            inputKelas.setText("");
        });

        formPanel.add(labelNama);
        formPanel.add(inputNama);
        formPanel.add(labelNis);
        formPanel.add(inputNis);
        formPanel.add(labelKelas);
        formPanel.add(inputKelas);
        formPanel.add(submitButton);

        return formPanel;
    }

    // Create Form for "Edit Siswa"
    private JPanel createEditSiswaForm() {
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBackground(Color.WHITE);

        JLabel labelSelect = new JLabel("Pilih ID Siswa untuk Diedit:");
        JComboBox<String> siswaComboBox = new JComboBox<>();
        for (Siswa siswa : manajemen.getDaftarSiswa()) {
            siswaComboBox.addItem("ID: " + siswa.getId() + ", " + siswa.getNama());
        }

        JLabel labelNama = new JLabel("Nama Baru:");
        JTextField inputNama = new JTextField();

        JLabel labelNis = new JLabel("NIS Baru:");
        JTextField inputNis = new JTextField();

        JLabel labelKelas = new JLabel("Kelas Baru:");
        JTextField inputKelas = new JTextField();

        JButton submitButton = new JButton("Edit Siswa");
        submitButton.addActionListener(e -> {
            int selectedIndex = siswaComboBox.getSelectedIndex();
            if (selectedIndex >= 0) {
                Siswa siswa = manajemen.getDaftarSiswa().get(selectedIndex);
                String nama = inputNama.getText();
                String nis = inputNis.getText();
                String kelas = inputKelas.getText();
                manajemen.editSiswa(siswa.getId(), nama, nis, kelas);
                JOptionPane.showMessageDialog(this, "Siswa berhasil diubah!");
                inputNama.setText("");
                inputNis.setText("");
                inputKelas.setText("");
            }
        });

        formPanel.add(labelSelect);
        formPanel.add(siswaComboBox);
        formPanel.add(labelNama);
        formPanel.add(inputNama);
        formPanel.add(labelNis);
        formPanel.add(inputNis);
        formPanel.add(labelKelas);
        formPanel.add(inputKelas);
        formPanel.add(submitButton);

        return formPanel;
    }

    // Create Form for "Hapus Siswa"
    private JPanel createHapusSiswaForm() {
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        formPanel.setBackground(Color.WHITE);

        JLabel labelSelect = new JLabel("Pilih ID Siswa untuk Dihapus:");
        JComboBox<String> siswaComboBox = new JComboBox<>();
        for (Siswa siswa : manajemen.getDaftarSiswa()) {
            siswaComboBox.addItem("ID: " + siswa.getId() + ", " + siswa.getNama());
        }

        JButton submitButton = new JButton("Hapus Siswa");
        submitButton.addActionListener(e -> {
            int selectedIndex = siswaComboBox.getSelectedIndex();
            if (selectedIndex >= 0) {
                Siswa siswa = manajemen.getDaftarSiswa().get(selectedIndex);
                manajemen.hapusSiswa(siswa.getId());
                JOptionPane.showMessageDialog(this, "Siswa berhasil dihapus!");
            }
        });

        formPanel.add(labelSelect);
        formPanel.add(siswaComboBox);
        formPanel.add(submitButton);

        return formPanel;
    }

    // Create Form for "Input Nilai"
    private JPanel createInputNilaiForm() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS)); // Set vertical layout
        formPanel.setBackground(Color.WHITE);

        // Create a JComboBox for selecting the student
        JLabel labelSelect = new JLabel("Pilih Siswa:");
        JComboBox<String> siswaComboBox = new JComboBox<>();

        // Add students to the combo box
        for (Siswa siswa : manajemen.getDaftarSiswa()) {
            siswaComboBox.addItem("ID: " + siswa.getId() + ", " + siswa.getNama());
        }

        // Add components for Mata Pelajaran and Nilai
        formPanel.add(labelSelect);
        formPanel.add(siswaComboBox);

        // Create and add Mata Pelajaran and Nilai pairs
        formPanel.add(createMataPelajaranAndNilai("Mata Pelajaran 1:", "Nilai 1:"));
        formPanel.add(createMataPelajaranAndNilai("Mata Pelajaran 2:", "Nilai 2:"));
        formPanel.add(createMataPelajaranAndNilai("Mata Pelajaran 3:", "Nilai 3:"));

        // Create Submit button to save the grades
        JButton submitButton = new JButton("Input Nilai");
        submitButton.addActionListener(e -> {
            int selectedIndex = siswaComboBox.getSelectedIndex();
            if (selectedIndex >= 0) {
                Siswa siswa = manajemen.getDaftarSiswa().get(selectedIndex);
                double nilai1 = Double.parseDouble(((JTextField) ((JPanel) formPanel.getComponent(2)).getComponent(1)).getText());
                double nilai2 = Double.parseDouble(((JTextField) ((JPanel) formPanel.getComponent(3)).getComponent(1)).getText());
                double nilai3 = Double.parseDouble(((JTextField) ((JPanel) formPanel.getComponent(4)).getComponent(1)).getText());

                // Save nilai for 3 subjects
                manajemen.inputNilai(siswa.getId(), nilai1, nilai2, nilai3);
                JOptionPane.showMessageDialog(this, "Nilai berhasil dimasukkan!");
                // Clear the input fields
                ((JTextField) ((JPanel) formPanel.getComponent(2)).getComponent(1)).setText("");
                ((JTextField) ((JPanel) formPanel.getComponent(3)).getComponent(1)).setText("");
                ((JTextField) ((JPanel) formPanel.getComponent(4)).getComponent(1)).setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Silakan pilih siswa terlebih dahulu.");
            }
        });

        // Add the submit button
        formPanel.add(submitButton);

        return formPanel;
    }

    // Helper method to create Mata Pelajaran and Nilai pair
    private JPanel createMataPelajaranAndNilai(String mataPelajaranLabel, String nilaiLabel) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Set vertical layout for each pair

        JLabel labelMataPelajaran = new JLabel(mataPelajaranLabel);
        JTextField inputNilai = new JTextField(10); // TextField for inputting grade

        JLabel labelNilai = new JLabel(nilaiLabel);

        // Add the Mata Pelajaran label and Nilai input field to the panel
        panel.add(labelMataPelajaran);
        panel.add(inputNilai);
        panel.add(labelNilai);

        return panel;
    }

    // Helper method to create a panel for each Mata Pelajaran with a label and input field
    private JPanel createMataPelajaranPanel(String mataPelajaranLabel, String nilaiLabel) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JLabel labelMataPelajaran = new JLabel(mataPelajaranLabel);
        JTextField inputNilai = new JTextField(10);

        panel.add(labelMataPelajaran);
        panel.add(Box.createHorizontalStrut(10)); // Space between label and text field
        panel.add(inputNilai);

        return panel;
    }

    // Create Form for "Edit Nilai"
    private JPanel createEditNilaiForm() {
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBackground(Color.WHITE);

        JLabel labelSelect = new JLabel("Pilih ID Siswa:");
        JComboBox<String> siswaComboBox = new JComboBox<>();
        for (Siswa siswa : manajemen.getDaftarSiswa()) {
            siswaComboBox.addItem("ID: " + siswa.getId() + ", " + siswa.getNama());
        }

        JLabel labelMataPelajaran1 = new JLabel("Nilai Mata Pelajaran 1:");
        JTextField inputNilai1 = new JTextField();

        JLabel labelMataPelajaran2 = new JLabel("Nilai Mata Pelajaran 2:");
        JTextField inputNilai2 = new JTextField();

        JLabel labelMataPelajaran3 = new JLabel("Nilai Mata Pelajaran 3:");
        JTextField inputNilai3 = new JTextField();

        JButton submitButton = new JButton("Edit Nilai");
        submitButton.addActionListener(e -> {
            int selectedIndex = siswaComboBox.getSelectedIndex();
            if (selectedIndex >= 0) {
                Siswa siswa = manajemen.getDaftarSiswa().get(selectedIndex);
                double nilai1 = Double.parseDouble(inputNilai1.getText());
                double nilai2 = Double.parseDouble(inputNilai2.getText());
                double nilai3 = Double.parseDouble(inputNilai3.getText());

                manajemen.editNilai(siswa.getId(), nilai1, nilai2, nilai3);
                JOptionPane.showMessageDialog(this, "Nilai berhasil diubah!");
                inputNilai1.setText("");
                inputNilai2.setText("");
                inputNilai3.setText("");
            }
        });

        formPanel.add(labelSelect);
        formPanel.add(siswaComboBox);
        formPanel.add(labelMataPelajaran1);
        formPanel.add(inputNilai1);
        formPanel.add(labelMataPelajaran2);
        formPanel.add(inputNilai2);
        formPanel.add(labelMataPelajaran3);
        formPanel.add(inputNilai3);
        formPanel.add(submitButton);

        return formPanel;
    }

    // Create Form for "Lihat Nilai"
    private JPanel createLihatNilaiForm() {
        JPanel formPanel = new JPanel();
        formPanel.setBackground(Color.WHITE);
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

        for (Siswa siswa : manajemen.getDaftarSiswa()) {
            JTextArea textArea = new JTextArea("ID: " + siswa.getId() + " | Nama: " + siswa.getNama() +
                    " | Nilai: " + siswa.getNilai());
            textArea.setEditable(false);
            formPanel.add(textArea);
        }

        return formPanel;
    }

    public static void main(String[] args) {
        new ManajemenGui();
    }
}
