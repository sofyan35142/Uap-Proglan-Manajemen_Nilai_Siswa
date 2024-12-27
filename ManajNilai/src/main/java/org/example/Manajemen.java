package org.example;

import java.util.ArrayList;
import java.util.List;

public class Manajemen {
    private List<Siswa> daftarSiswa;

    public Manajemen() {
        daftarSiswa = new ArrayList<>();
    }

    // Metode untuk menambahkan siswa baru
    public void tambahSiswa(String nama, String nis, String kelas) {
        Siswa siswa = new Siswa(nama, nis, kelas);
        daftarSiswa.add(siswa);
    }

    // Metode untuk mengedit data siswa berdasarkan ID
    public void editSiswa(int id, String nama, String nis, String kelas) {
        for (Siswa siswa : daftarSiswa) {
            if (siswa.getId() == id) {
                siswa.setNama(nama);
                siswa.setNis(nis);
                siswa.setKelas(kelas);
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

    // Metode untuk mencetak daftar siswa (untuk debugging atau konsol)
    public void printDaftarSiswa() {
        if (daftarSiswa.isEmpty()) {
            System.out.println("Tidak ada siswa yang terdaftar.");
        } else {
            for (Siswa siswa : daftarSiswa) {
                System.out.println(String.format(
                        "ID: %d, Nama: %s, NIS: %s, Kelas: %s, Nilai: %s",
                        siswa.getId(), siswa.getNama(), siswa.getNis(), siswa.getKelas(), siswa.getNilai()
                ));
            }
        }
    }
}
