package org.example;
import java.util.Scanner;
//DESEMBER D NYA DI KEJAR KEJAR POLISI INISIAL SOFYAN
public class Main {
    public static void main(String[] args) {
        Manajemen manajemen = new Manajemen();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Aplikasi Manajemen Nilai Siswa ===");
            System.out.println("1. Tambah Siswa");
            System.out.println("2. Edit Siswa");
            System.out.println("3. Input Nilai Siswa");
            System.out.println("4. Edit Nilai Siswa");
            System.out.println("5. Lihat Semua Nilai Siswa");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1/2/3/4/5/6): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama siswa: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan NIS siswa: ");
                    String nis = scanner.nextLine();
                    System.out.print("Masukkan kelas siswa: ");
                    String kelas = scanner.nextLine();
                    manajemen.tambahSiswa(nama, nis, kelas);
                    break;
                case 2:
                    manajemen.tampilkanSiswaTerdaftar();
                    System.out.print("Masukkan ID siswa yang ingin diubah: ");
                    int idEdit = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan nama baru: ");
                    String namaBaru = scanner.nextLine();
                    System.out.print("Masukkan NIS baru: ");
                    String nisBaru = scanner.nextLine();
                    System.out.print("Masukkan kelas baru: ");
                    String kelasBaru = scanner.nextLine();
                    manajemen.editSiswa(idEdit, namaBaru, nisBaru, kelasBaru);
                    break;
                case 3:
                    manajemen.tampilkanSiswaTerdaftar();
                    System.out.print("Masukkan ID siswa yang ingin diinput nilainya: ");
                    int idNilai = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Masukkan mata pelajaran dan nilai (ketik 'selesai' untuk mengakhiri):");
                    while (true) {
                        System.out.print("Mata pelajaran: ");
                        String mataPelajaran = scanner.nextLine();
                        if (mataPelajaran.equalsIgnoreCase("selesai")) {
                            break;
                        }
                        System.out.print("Nilai: ");
                        double nilai = scanner.nextDouble();
                        scanner.nextLine();
                        manajemen.inputNilai(idNilai, mataPelajaran, nilai);
                    }
                    break;
                case 4:
                    manajemen.tampilkanSiswaTerdaftar();
                    System.out.print("Masukkan ID siswa yang ingin diedit nilainya: ");
                    int idEditNilai = scanner.nextInt();
                    manajemen.editNilai(idEditNilai);
                    break;
                case 5:
                    manajemen.tampilkanSemuaSiswa();
                    break;
                case 6:
                    System.out.println("Keluar dari aplikasi. Terima kasih!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
