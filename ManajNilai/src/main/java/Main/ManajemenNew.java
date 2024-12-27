package Main;

import Main.SiswaNew;
import java.util.List;
import java.util.ArrayList;

public class ManajemenNew {
    private ArrayList<SiswaNew> daftarSiswa;

    public ManajemenNew() {
        daftarSiswa = new ArrayList<>();
    }

    // Getter for daftarSiswa
    public List<SiswaNew> getDaftarSiswa() {
        return daftarSiswa;
    }

    // Method to add a student
    public void tambahSiswa(String nama, String nis, String kelas) {
        SiswaNew siswa = new SiswaNew(nama, nis, kelas);
        daftarSiswa.add(siswa);
        System.out.println("Siswa berhasil ditambahkan!");
    }

    // Method to display all students
    public void tampilkanSiswaTerdaftar() {
        if (daftarSiswa.isEmpty()) {
            System.out.println("Tidak ada siswa terdaftar.");
        } else {
            System.out.println("Daftar Siswa:");
            for (SiswaNew siswa : daftarSiswa) {
                System.out.println("ID: " + siswa.getId() + ", Nama: " + siswa.getNama() + ", NIS: " + siswa.getNis() + ", Kelas: " + siswa.getKelas());
            }
        }
    }

    // Method to edit student details
    public void editSiswa(int id, String nama, String nis, String kelas) {
        for (SiswaNew siswa : daftarSiswa) {
            if (siswa.getId().equals(String.valueOf(id))) {
                siswa.setNama(nama);
                siswa.setNis(nis);
                siswa.setKelas(kelas);
                System.out.println("Data siswa berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Siswa dengan ID " + id + " tidak ditemukan.");
    }

    // Method to delete a student
    public void hapusSiswa(int id) {
        for (SiswaNew siswa : daftarSiswa) {
            if (siswa.getId().equals(String.valueOf(id))) {
                daftarSiswa.remove(siswa);
                System.out.println("Siswa berhasil dihapus!");
                return;
            }
        }
        System.out.println("Siswa dengan ID " + id + " tidak ditemukan.");
    }

    // Method to input grades
    public void inputNilai(int id, double nilai1, double nilai2, double nilai3) {
        for (SiswaNew siswa : daftarSiswa) {
            if (siswa.getId().equals(String.valueOf(id))) {
                siswa.setNilai1(nilai1);
                siswa.setNilai2(nilai2);
                siswa.setNilai3(nilai3);
                System.out.println("Nilai berhasil diinput!");
                return;
            }
        }
        System.out.println("Siswa dengan ID " + id + " tidak ditemukan.");
    }

    // Method to edit grades
    public void editNilai(int id, double nilai1, double nilai2, double nilai3) {
        for (SiswaNew siswa : daftarSiswa) {
            if (siswa.getId().equals(String.valueOf(id))) {
                siswa.setNilai1(nilai1);
                siswa.setNilai2(nilai2);
                siswa.setNilai3(nilai3);
                System.out.println("Nilai berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Siswa dengan ID " + id + " tidak ditemukan.");
    }
}