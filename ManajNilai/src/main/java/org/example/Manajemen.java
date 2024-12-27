package org.example;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.List;
import java.util.ArrayList;

/**
 * Kelas untuk mengelola data siswa, termasuk menambah, mengedit, menghapus, dan mengelola nilai siswa.
 */
public class Manajemen {

    private ArrayList<Siswa> daftarSiswa;

    /**
     * Konstruktor untuk membuat objek Manajemen dan inisialisasi daftar siswa.
     */
    public Manajemen() {
        daftarSiswa = new ArrayList<>();
    }

    /**
     * Menambahkan siswa baru ke dalam daftar siswa.
     *
     * @param nama  Nama siswa.
     * @param nis   Nomor Induk Siswa.
     * @param kelas Kelas siswa.
     * @param foto  Foto siswa (bisa berupa path atau URL).
     */
    public void tambahSiswa(String nama, String nis, String kelas, String foto) {
        Siswa siswa = new Siswa(nama, nis, kelas, foto);
        daftarSiswa.add(siswa);
    }

    /**
     * Mengembalikan daftar semua siswa yang terdaftar.
     *
     * @return Daftar siswa.
     */
    public ArrayList<Siswa> getDaftarSiswa() {
        return daftarSiswa;
    }

    /**
     * Mengedit data siswa berdasarkan ID siswa.
     *
     * @param id    ID siswa yang ingin diubah.
     * @param nama  Nama siswa yang baru.
     * @param nis   NIS siswa yang baru.
     * @param kelas Kelas siswa yang baru.
     */
    public void editSiswa(String id, String nama, String nis, String kelas) {
        for (Siswa siswa : daftarSiswa) {
            if (siswa.getId().equals(id)) {
                siswa.setNama(nama);
                siswa.setNis(nis);
                siswa.setKelas(kelas);
            }
        }
    }

    /**
     * Menghapus siswa berdasarkan ID.
     *
     * @param id ID siswa yang ingin dihapus.
     */
    public void hapusSiswa(String id) {
        daftarSiswa.removeIf(siswa -> siswa.getId().equals(id));
    }

    /**
     * Menginput nilai untuk siswa berdasarkan ID siswa.
     *
     * @param id     ID siswa yang nilainya ingin diinput.
     * @param nilai1 Nilai untuk mata pelajaran pertama.
     * @param nilai2 Nilai untuk mata pelajaran kedua.
     * @param nilai3 Nilai untuk mata pelajaran ketiga.
     */
    public void inputNilai(String id, double nilai1, double nilai2, double nilai3) {
        for (Siswa siswa : daftarSiswa) {
            if (siswa.getId().equals(id)) {
                siswa.setNilai1(nilai1);
                siswa.setNilai2(nilai2);
                siswa.setNilai3(nilai3);
            }
        }
    }

    /**
     * Mengedit nilai siswa berdasarkan ID siswa.
     *
     * @param id     ID siswa yang nilainya ingin diedit.
     * @param nilai1 Nilai untuk mata pelajaran pertama yang baru.
     * @param nilai2 Nilai untuk mata pelajaran kedua yang baru.
     * @param nilai3 Nilai untuk mata pelajaran ketiga yang baru.
     */
    public void editNilai(String id, double nilai1, double nilai2, double nilai3) {
        for (Siswa siswa : daftarSiswa) {
            if (siswa.getId().equals(id)) {
                siswa.setNilai1(nilai1);
                siswa.setNilai2(nilai2);
                siswa.setNilai3(nilai3);
            }
        }
    }
}
