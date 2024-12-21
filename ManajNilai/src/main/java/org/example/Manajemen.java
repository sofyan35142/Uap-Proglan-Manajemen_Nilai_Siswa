package org.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Manajemen {
    private ArrayList<Siswa> daftarSiswa = new ArrayList<>();
    private int idBerikutnya = 1;

    public void tambahSiswa(String nama, String nis, String kelas) {
        daftarSiswa.add(new Siswa(idBerikutnya++, nama, nis, kelas));
        System.out.println("Siswa berhasil ditambahkan!");
    }

    public void editSiswa(int id, String namaBaru, String nisBaru, String kelasBaru) {
        for (Siswa siswa : daftarSiswa) {
            if (siswa.getId() == id) {
                siswa.setNama(namaBaru);
                siswa.setNis(nisBaru);
                siswa.setKelas(kelasBaru);
                System.out.println("Data siswa berhasil diubah!");
                return;
            }
        }
        System.out.println("Siswa dengan ID tersebut tidak ditemukan.");
    }

    public void inputNilai(int id, String mataPelajaran, double nilai) {
        for (Siswa siswa : daftarSiswa) {
            if (siswa.getId() == id) {
                siswa.tambahNilai(mataPelajaran, nilai);
                System.out.println("Nilai untuk mata pelajaran '" + mataPelajaran + "' berhasil diinput!");
                return;
            }
        }
        System.out.println("Siswa dengan ID tersebut tidak ditemukan.");
    }

    public void editNilai(int id) {
        for (Siswa siswa : daftarSiswa) {
            if (siswa.getId() == id) {
                // Tampilkan nama siswa dan daftar nilai
                System.out.println("\nNama Siswa: " + siswa.getNama());
                HashMap<String, Double> nilaiMap = siswa.getNilaiMap();
                if (nilaiMap.isEmpty()) {
                    System.out.println("Belum ada nilai yang diinput.");
                } else {
                    System.out.println("Daftar Nilai Siswa:");
                    for (Map.Entry<String, Double> entry : nilaiMap.entrySet()) {
                        System.out.println("  - " + entry.getKey() + ": " + entry.getValue());
                    }
                }

                // Sekarang minta untuk edit nilai
                System.out.print("\nMasukkan nama mata pelajaran yang ingin diedit: ");
                Scanner scanner = new Scanner(System.in);  // Membuat objek scanner
                String mataPelajaran = scanner.nextLine();  // Membaca input mata pelajaran
                if (nilaiMap.containsKey(mataPelajaran)) {
                    System.out.print("Masukkan nilai baru: ");
                    double nilaiBaru = scanner.nextDouble();  // Membaca input nilai baru
                    nilaiMap.put(mataPelajaran, nilaiBaru);  // Mengupdate nilai
                    System.out.println("Nilai untuk mata pelajaran '" + mataPelajaran + "' berhasil diubah!");
                } else {
                    System.out.println("Mata pelajaran '" + mataPelajaran + "' tidak ditemukan.");
                }
                return;
            }
        }
        System.out.println("Siswa dengan ID tersebut tidak ditemukan.");
    }

    public void tampilkanSemuaSiswa() {
        if (daftarSiswa.isEmpty()) {
            System.out.println("Belum ada siswa yang terdaftar.");
            return;
        }
        for (Siswa siswa : daftarSiswa) {
            System.out.println(siswa);
        }
    }

    public void tampilkanSiswaTerdaftar() {
        if (daftarSiswa.isEmpty()) {
            System.out.println("Belum ada siswa yang terdaftar.");
        } else {
            System.out.println("\n=== Daftar Siswa Terdaftar ===");
            for (Siswa siswa : daftarSiswa) {
                System.out.println("ID: " + siswa.getId() + ", Nama: " + siswa.getNama() + ", NIS: " + siswa.getNis() + ", Kelas: " + siswa.getKelas());
            }
        }
    }

    public ArrayList<Siswa> getDaftarSiswa() {
        return daftarSiswa;
    }
}
