package org.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Manajemen {
    private ArrayList<Siswa> daftarSiswa = new ArrayList<>();
    private int idBerikutnya = 1;

    public void tambahSiswa(String nama, String nis, String kelas) {
        if (isNisUnik(nis)) {
            daftarSiswa.add(new Siswa(idBerikutnya++, nama, nis, kelas));
            System.out.println("Siswa berhasil ditambahkan!");
        } else {
            System.out.println("Gagal menambahkan siswa. NIS sudah digunakan oleh siswa lain.");
        }
    }

    public void editSiswa(int id, String namaBaru, String nisBaru, String kelasBaru) {
        for (Siswa siswa : daftarSiswa) {
            if (siswa.getId() == id) {
                if (!siswa.getNis().equals(nisBaru) && !isNisUnik(nisBaru)) {
                    System.out.println("Gagal mengubah data siswa. NIS sudah digunakan oleh siswa lain.");
                    return;
                }
                siswa.setNama(namaBaru);
                siswa.setNis(nisBaru);
                siswa.setKelas(kelasBaru);
                System.out.println("Data siswa berhasil diubah!");
                return;
            }
        }
        System.out.println("Siswa dengan ID tersebut tidak ditemukan.");
    }

    public void hapusSiswa(int id) {
        for (Siswa siswa : daftarSiswa) {
            if (siswa.getId() == id) {
                daftarSiswa.remove(siswa);
                System.out.println("Siswa berhasil dihapus.");
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

                System.out.print("\nMasukkan nama mata pelajaran yang ingin diedit: ");
                Scanner scanner = new Scanner(System.in);
                String mataPelajaran = scanner.nextLine();
                if (nilaiMap.containsKey(mataPelajaran)) {
                    System.out.print("Masukkan nilai baru: ");
                    double nilaiBaru = scanner.nextDouble();
                    nilaiMap.put(mataPelajaran, nilaiBaru);
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

    private boolean isNisUnik(String nis) {
        for (Siswa siswa : daftarSiswa) {
            if (siswa.getNis().equals(nis)) {
                return false;
            }
        }
        return true;
    }
}

