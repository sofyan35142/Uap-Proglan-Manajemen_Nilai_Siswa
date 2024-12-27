package org.example.Gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;
import org.example.Manajemen;
import org.example.Siswa;
import java.io.File;  // Import File
import javax.swing.filechooser.FileNameExtensionFilter;
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
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBackground(Color.WHITE);

        JLabel labelNama = new JLabel("Nama Siswa:");
        JTextField inputNama = new JTextField();

        JLabel labelNis = new JLabel("NIS Siswa:");
        JTextField inputNis = new JTextField();

        JLabel labelKelas = new JLabel("Kelas Siswa:");
        JTextField inputKelas = new JTextField();

        JLabel labelFoto = new JLabel("Upload Foto:");
        JButton uploadFotoButton = new JButton("Pilih Foto...");
        uploadFotoButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Pilih Foto Siswa");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg"));

            int returnValue = fileChooser.showOpenDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String fotoPath = selectedFile.getAbsolutePath(); // Get absolute path
                JOptionPane.showMessageDialog(this, "Foto berhasil dipilih: " + selectedFile.getName());
                // You can now handle `fotoPath` as needed (e.g., storing the path in the `manajemen` object)
            }
        });

        JButton submitButton = new JButton("Tambah Siswa");
        submitButton.addActionListener(e -> {
            String nama = inputNama.getText();
            String nis = inputNis.getText();
            String kelas = inputKelas.getText();

            if (!nis.matches("\\d{8,}")) {
                JOptionPane.showMessageDialog(this, "NIS harus berupa angka dan minimal 8 karakter!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Handle the uploaded photo path
            // Example: Assuming you store the file path or image in the `Manajemen` class.
            // String fotoPath = selectedFile.getAbsolutePath();

            manajemen.tambahSiswa(nama, nis, kelas); // Add photo handling logic here
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
        formPanel.add(labelFoto);
        formPanel.add(uploadFotoButton);
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

                if (!nis.matches("\\d{8,}")) {
                    JOptionPane.showMessageDialog(this, "NIS harus berupa angka dan minimal 8 karakter!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

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
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        formPanel.setBackground(Color.WHITE);

        JLabel labelSelect = new JLabel("Pilih Siswa:");
        JComboBox<String> siswaComboBox = new JComboBox<>();
        for (Siswa siswa : manajemen.getDaftarSiswa()) {
            siswaComboBox.addItem("ID: " + siswa.getId() + ", " + siswa.getNama());
        }

        JLabel labelNilai1 = new JLabel("Nilai Mata Pelajaran 1 (0-100):");
        JTextField inputNilai1 = new JTextField();

        JLabel labelNilai2 = new JLabel("Nilai Mata Pelajaran 2 (0-100):");
        JTextField inputNilai2 = new JTextField();

        JLabel labelNilai3 = new JLabel("Nilai Mata Pelajaran 3 (0-100):");
        JTextField inputNilai3 = new JTextField();

        JButton submitButton = new JButton("Input Nilai");
        submitButton.addActionListener(e -> {
            int selectedIndex = siswaComboBox.getSelectedIndex();
            if (selectedIndex >= 0) {
                Siswa siswa = manajemen.getDaftarSiswa().get(selectedIndex);
                try {
                    double nilai1 = Double.parseDouble(inputNilai1.getText());
                    double nilai2 = Double.parseDouble(inputNilai2.getText());
                    double nilai3 = Double.parseDouble(inputNilai3.getText());

                    if (nilai1 < 0 || nilai1 > 100 || nilai2 < 0 || nilai2 > 100 || nilai3 < 0 || nilai3 > 100) {
                        JOptionPane.showMessageDialog(this, "Nilai harus berada dalam rentang 0-100!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    manajemen.inputNilai(siswa.getId(), nilai1, nilai2, nilai3);
                    JOptionPane.showMessageDialog(this, "Nilai berhasil dimasukkan!");

                    // Clear input fields after successful submission
                    inputNilai1.setText("");
                    inputNilai2.setText("");
                    inputNilai3.setText("");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Input nilai harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add components to formPanel
        formPanel.add(labelSelect);
        formPanel.add(siswaComboBox);
        formPanel.add(labelNilai1);
        formPanel.add(inputNilai1);
        formPanel.add(labelNilai2);
        formPanel.add(inputNilai2);
        formPanel.add(labelNilai3);
        formPanel.add(inputNilai3);
        formPanel.add(submitButton);

        return formPanel;
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

        if (manajemen.getDaftarSiswa().isEmpty()) {
            formPanel.add(new JLabel("Tidak ada data siswa.", JLabel.CENTER));
        } else {
            // Column names for the table
            String[] columnNames = {"ID", "NIS", "Nama", "Kelas", "Foto", "Nilai 1", "Nilai 2", "Nilai 3"};

            // Data for the table
            ArrayList<Object[]> combinedData = new ArrayList<>();
            for (Siswa siswa : manajemen.getDaftarSiswa()) {
                String fotoPath = siswa.getFoto();  // Assuming Siswa has a method getFoto()
                ImageIcon imageIcon = null;

                if (fotoPath != null && !fotoPath.isEmpty()) {
                    try {
                        File fotoFile = new File(fotoPath); // Create a File object to check if it exists
                        if (fotoFile.exists()) {
                            // Try to create an ImageIcon from the file path and scale it to fit row height
                            Image image = new ImageIcon(fotoPath).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                            imageIcon = new ImageIcon(image);
                        } else {
                            System.out.println("File not found at path: " + fotoPath);
                            imageIcon = new ImageIcon(); // Empty image if the file is not found
                        }
                    } catch (Exception e) {
                        // Handle error if the image cannot be loaded
                        System.out.println("Error loading image from path: " + fotoPath);
                        imageIcon = new ImageIcon(); // Set empty image if error occurs
                    }
                }

                // Add the student's data to combinedData
                combinedData.add(new Object[] {
                        siswa.getId(),
                        siswa.getNis(),        // NIS column
                        siswa.getNama(),
                        siswa.getKelas(),
                        imageIcon != null ? imageIcon : new ImageIcon(), // Ensure imageIcon is not null
                        siswa.getNilai1(),     // Nilai mata pelajaran 1
                        siswa.getNilai2(),     // Nilai mata pelajaran 2
                        siswa.getNilai3()      // Nilai mata pelajaran 3
                });
            }

            // Create the table with the combined data
            JTable siswaTable = new JTable(combinedData.toArray(new Object[0][0]), columnNames) {
                @Override
                public Class<?> getColumnClass(int column) {
                    if (column == 4) { // Foto column
                        return ImageIcon.class;
                    }
                    return Object.class;
                }
            };

            // Set row height to display the image properly
            siswaTable.setRowHeight(60);  // Increase this value to fit your images properly

            // Make the table scrollable
            JScrollPane scrollPane = new JScrollPane(siswaTable);
            siswaTable.setFillsViewportHeight(true);

            formPanel.add(scrollPane); // Add the table inside a scroll pane
        }

        return formPanel;
    }

    public static void main(String[] args) {
        new ManajemenGui();
    }
}

