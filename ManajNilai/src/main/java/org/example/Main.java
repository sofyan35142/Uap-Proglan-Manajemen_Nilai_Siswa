package org.example;

import java.util.Scanner;

/**
 * Aplikasi utama untuk mengelola data siswa dan nilai mereka.
 * Menyediakan menu untuk menambah, mengedit, menghapus siswa, dan mengelola nilai mereka.
 */
public class Main {

    /**
     * Metode utama untuk menjalankan aplikasi manajemen nilai siswa.
     * Menyediakan menu interaktif untuk pengguna dan memproses input pengguna.
     *
     * @param args Argumen yang diberikan ke aplikasi (tidak digunakan dalam aplikasi ini).
     */
    public static void main(String[] args) {
        Manajemen manajemen = new Manajemen();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Aplikasi Manajemen Nilai Siswa ===");
            System.out.println("1. Tambah Siswa");
            System.out.println("2. Edit Siswa");
            System.out.println("3. Hapus Siswa");
            System.out.println("4. Input Nilai Siswa");
            System.out.println("5. Edit Nilai Siswa");
            System.out.println("6. Lihat Semua Nilai Siswa");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu (1/2/3/4/5/6/7): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama siswa: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan NIS siswa: ");
                    String nis = scanner.nextLine();
                    while (!nis.matches("\\d+")) {
                        System.out.print("NIS harus berupa angka. Masukkan NIS siswa: ");
                        nis = scanner.nextLine();
                    }
                    System.out.print("Masukkan kelas siswa: ");
                    String kelas = scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Masukkan ID siswa yang ingin diubah: ");
                    int idEdit = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Masukkan nama baru: ");
                    String namaBaru = scanner.nextLine();
                    System.out.print("Masukkan NIS baru: ");
                    String nisBaru = scanner.nextLine();
                    while (!nisBaru.matches("\\d+")) {
                        System.out.print("NIS harus berupa angka. Masukkan NIS baru: ");
                        nisBaru = scanner.nextLine();
                    }
                    System.out.print("Masukkan kelas baru: ");
                    String kelasBaru = scanner.nextLine();
                    break;
                case 3:
                    System.out.print("Masukkan ID siswa yang ingin dihapus: ");
                    int idHapus = scanner.nextInt();
                    break;
                case 4:
                    System.out.print("Masukkan ID siswa yang ingin diinput nilainya: ");
                    int idNilai = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Masukkan nilai mata pelajaran 1: ");
                    double nilai1 = scanner.nextDouble();
                    System.out.print("Masukkan nilai mata pelajaran 2: ");
                    double nilai2 = scanner.nextDouble();
                    System.out.print("Masukkan nilai mata pelajaran 3: ");
                    double nilai3 = scanner.nextDouble();
                    break;
                case 5:
                    System.out.print("Masukkan ID siswa yang ingin diedit nilainya: ");
                    int idEditNilai = scanner.nextInt();
                    System.out.print("Masukkan nilai baru mata pelajaran 1: ");
                    double nilai1Edit = scanner.nextDouble();
                    System.out.print("Masukkan nilai baru mata pelajaran 2: ");
                    double nilai2Edit = scanner.nextDouble();
                    System.out.print("Masukkan nilai baru mata pelajaran 3: ");
                    double nilai3Edit = scanner.nextDouble();
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Keluar dari aplikasi. Terima kasih!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
