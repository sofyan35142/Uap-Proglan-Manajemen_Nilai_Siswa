package org.example;
import java.util.Scanner;

public class Main {
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
            scanner.nextLine(); // Konsumsi newline

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
                    manajemen.tambahSiswa(nama, nis, kelas);
                    break;
                case 2:
//                    manajemen.tampilkanSiswaTerdaftar();
                    System.out.print("Masukkan ID siswa yang ingin diubah: ");
                    int idEdit = scanner.nextInt();
                    scanner.nextLine();
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
                    manajemen.editSiswa(idEdit, namaBaru, nisBaru, kelasBaru);
                    break;
                case 3:
//                    manajemen.tampilkanSiswaTerdaftar();
//                    System.out.print("Masukkan ID siswa yang ingin dihapus: ");
                    int idHapus = scanner.nextInt();
                    manajemen.hapusSiswa(idHapus);
                    break;
                case 4:
//                    manajemen.tampilkanSiswaTerdaftar();
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
//                        manajemen.inputNilai(idNilai, mataPelajaran, nilai);
                    }
                    break;
                case 5:
//                    manajemen.tampilkanSiswaTerdaftar();
                    System.out.print("Masukkan ID siswa yang ingin diedit nilainya: ");
                    int idEditNilai = scanner.nextInt();
//                    manajemen.editNilai(idEditNilai);
                    break;
                case 6:
//                    manajemen.tampilkanSemuaSiswa();
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

