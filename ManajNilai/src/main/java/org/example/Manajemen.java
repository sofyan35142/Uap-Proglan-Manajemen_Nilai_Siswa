package org.example;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Image;
//import java.awt.ImageIcon;
import java.util.List;
import java.util.ArrayList; // Import ArrayList untuk daftar siswa


public class Manajemen {
    private List<Siswa> daftarSiswa;

    public Manajemen() {
        daftarSiswa = new ArrayList<>();
    }

    // Metode untuk menambahkan siswa baru
    public void tambahSiswa(String nama, String nis, String kelas) {
        tambahSiswa(nama, nis, kelas, null); // Calling the overloaded method
    }

    public void tambahSiswa(String nama, String nis, String kelas, String fotoPath) {
        Siswa siswa = new Siswa(nama, nis, kelas, fotoPath);
        daftarSiswa.add(siswa);
    }

    // Metode untuk mengedit data siswa berdasarkan ID
    public void editSiswa(int id, String nama, String nis, String kelas) {
        editSiswa(id, nama, nis, kelas, null); // Memanggil method editSiswa dengan fotoPath null
    }

    public void editSiswa(int id, String nama, String nis, String kelas, String fotoPath) {
        for (Siswa siswa : daftarSiswa) {
            if (siswa.getId() == id) {
                siswa.setNama(nama);
                siswa.setNis(nis);
                siswa.setKelas(kelas);
                siswa.setFoto(fotoPath); // Update foto siswa
                return; // Keluar dari loop setelah menemukan siswa
            }
        }
        throw new IllegalArgumentException("Siswa dengan ID " + id + " tidak ditemukan.");
    }

    // Metode untuk menghapus siswa berdasarkan ID
    public void hapusSiswa(int id) {
        boolean removed = daftarSiswa.removeIf(siswa -> siswa.getId() == id);
        if (!removed) {
            throw new IllegalArgumentException("Siswa dengan ID " + id + " tidak ditemukan.");
        }
    }

    // Metode untuk memasukkan nilai (3 mata pelajaran) berdasarkan ID siswa
    public void inputNilai(int id, double nilai1, double nilai2, double nilai3) {
        for (Siswa siswa : daftarSiswa) {
            if (siswa.getId() == id) {
                siswa.setNilai(nilai1, nilai2, nilai3); // Menyimpan nilai di objek siswa
                return;
            }
        }
        throw new IllegalArgumentException("Siswa dengan ID " + id + " tidak ditemukan.");
    }

    // Metode untuk mengedit nilai siswa berdasarkan ID
    public void editNilai(int id, double nilai1, double nilai2, double nilai3) {
        for (Siswa siswa : daftarSiswa) {
            if (siswa.getId() == id) {
                siswa.setNilai(nilai1, nilai2, nilai3); // Mengupdate nilai siswa
                return;
            }
        }
        throw new IllegalArgumentException("Siswa dengan ID " + id + " tidak ditemukan.");
    }

    // Metode untuk mendapatkan daftar siswa
    public List<Siswa> getDaftarSiswa() {
        return daftarSiswa;
    }

    // Metode untuk mendapatkan data siswa berdasarkan ID
    public Siswa getSiswaById(int id) {
        for (Siswa siswa : daftarSiswa) {
            if (siswa.getId() == id) {
                return siswa;
            }
        }
        throw new IllegalArgumentException("Siswa dengan ID " + id + " tidak ditemukan.");
    }

    // Metode untuk mencetak daftar siswa beserta gambar preview
    public void printDaftarSiswa() {
        if (daftarSiswa.isEmpty()) {
            System.out.println("Tidak ada siswa yang terdaftar.");
        } else {
            for (Siswa siswa : daftarSiswa) {
                String fotoPreview = (siswa.getImageIcon() != null) ? "Foto Tersedia" : "Foto Tidak Tersedia";
                System.out.println(String.format(
                        "ID: %d, Nama: %s, NIS: %s, Kelas: %s, %s, Nilai: %s",
                        siswa.getId(), siswa.getNama(), siswa.getNis(), siswa.getKelas(), fotoPreview, siswa.getNilai()
                ));
            }
        }
    }

    // Metode untuk menampilkan panel siswa dengan preview foto
    public JPanel getSiswaPreviewPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 4)); // GridLayout untuk menampilkan siswa dalam bentuk grid

        for (Siswa siswa : daftarSiswa) {
            JPanel siswaPanel = new JPanel();
            ImageIcon icon = siswa.getImageIcon(); // Ambil ImageIcon
            JLabel fotoLabel = new JLabel();
            if (icon != null) {
                Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Resize foto
                fotoLabel.setIcon(new ImageIcon(image)); // Set icon dengan ukuran tertentu
            } else {
                fotoLabel.setText("Foto Tidak Tersedia");
            }
            fotoLabel.setHorizontalAlignment(SwingConstants.CENTER);

            siswaPanel.add(fotoLabel);
            siswaPanel.add(new JLabel("ID: " + siswa.getId()));
            siswaPanel.add(new JLabel("Nama: " + siswa.getNama()));
            siswaPanel.add(new JLabel("NIS: " + siswa.getNis()));
            siswaPanel.add(new JLabel("Kelas: " + siswa.getKelas()));
            siswaPanel.add(new JLabel("Nilai: " + siswa.getNilai()));

            panel.add(siswaPanel);
        }

        return panel;
    }
}
