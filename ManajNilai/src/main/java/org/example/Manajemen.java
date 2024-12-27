package org.example;

import java.util.ArrayList;
import java.util.List;

public class Manajemen {
    private List<Siswa> daftarSiswa;

    public Manajemen() {
        daftarSiswa = new ArrayList<>();
    }

    // Method to add a new student
    public void tambahSiswa(String nama, String nis, String kelas) {
        Siswa siswa = new Siswa(nama, nis, kelas);
        daftarSiswa.add(siswa);
    }

    // Method to edit an existing student
    public void editSiswa(int id, String nama, String nis, String kelas) {
        for (Siswa siswa : daftarSiswa) {
            if (siswa.getId() == id) {
                siswa.setNama(nama);
                siswa.setNis(nis);
                siswa.setKelas(kelas);
            }
        }
    }

    // Method to delete a student
    public void hapusSiswa(int id) {
        daftarSiswa.removeIf(siswa -> siswa.getId() == id);
    }

    // Method to input grades (3 subjects)
    public void inputNilai(int id, double nilai1, double nilai2, double nilai3) {
        for (Siswa siswa : daftarSiswa) {
            if (siswa.getId() == id) {
                siswa.setNilai(nilai1, nilai2, nilai3); // Assuming you have a method to set multiple grades
            }
        }
    }

    // Method to edit grades (3 subjects)
    public void editNilai(int id, double nilai1, double nilai2, double nilai3) {
        for (Siswa siswa : daftarSiswa) {
            if (siswa.getId() == id) {
                siswa.setNilai(nilai1, nilai2, nilai3); // Same assumption as inputNilai
            }
        }
    }

    // Getter for daftarSiswa
    public List<Siswa> getDaftarSiswa() {
        return daftarSiswa;
    }
}
