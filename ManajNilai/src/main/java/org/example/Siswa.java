package org.example;

public class Siswa {
    private static int counter = 1; // Static counter to generate unique ID for each student
    private int id;
    private String nama;
    private String nis;
    private String kelas;
    private double nilai1;
    private double nilai2;
    private double nilai3;

    public Siswa(String nama, String nis, String kelas) {
        this.id = counter++;
        this.nama = nama;
        this.nis = nis;
        this.kelas = kelas;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    // Getter for Nilai (Grades)
    public double getNilai1() {
        return nilai1;
    }

    public double getNilai2() {
        return nilai2;
    }

    public double getNilai3() {
        return nilai3;
    }

    // Method to set all grades at once
    public void setNilai(double nilai1, double nilai2, double nilai3) {
        this.nilai1 = nilai1;
        this.nilai2 = nilai2;
        this.nilai3 = nilai3;
    }

    // Method to get all grades together
    public String getNilai() {
        return String.format("Nilai 1: %.2f, Nilai 2: %.2f, Nilai 3: %.2f", nilai1, nilai2, nilai3);
    }
}
