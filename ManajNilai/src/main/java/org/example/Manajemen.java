package org.example;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.List;
import java.util.ArrayList;


public class Manajemen {
    private ArrayList<Siswa> daftarSiswa;

    public Manajemen() {
        daftarSiswa = new ArrayList<>();
    }

    // Method to add a student
    public void tambahSiswa(String nama, String nis, String kelas, String foto) {
        Siswa siswa = new Siswa(nama, nis, kelas, foto);
        daftarSiswa.add(siswa);
    }

    // Method to get the list of students
    public ArrayList<Siswa> getDaftarSiswa() {
        return daftarSiswa;
    }

    // Method to edit student details
    public void editSiswa(String id, String nama, String nis, String kelas) {
        for (Siswa siswa : daftarSiswa) {
            if (siswa.getId().equals(id)) {
                siswa.setNama(nama);
                siswa.setNis(nis);
                siswa.setKelas(kelas);
            }
        }
    }

    // Method to delete a student
    public void hapusSiswa(String id) {
        daftarSiswa.removeIf(siswa -> siswa.getId().equals(id));
    }

    // Method to input grades
    public void inputNilai(String id, double nilai1, double nilai2, double nilai3) {
        for (Siswa siswa : daftarSiswa) {
            if (siswa.getId().equals(id)) {
                siswa.setNilai1(nilai1);
                siswa.setNilai2(nilai2);
                siswa.setNilai3(nilai3);
            }
        }
    }

    // Method to edit grades
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