package org.example;

import javax.swing.ImageIcon;
import java.util.Map;
import java.util.HashMap;

/**
 * Kelas untuk menyimpan informasi tentang siswa, termasuk ID, nama, NIS, kelas, foto, dan nilai.
 */
public class Siswa {
    private static int idCounter = 1;
    private String id;
    private String nama;
    private String nis;
    private String kelas;
    private String foto;
    private double nilai1;
    private double nilai2;
    private double nilai3;

    /**
     * Konstruktor untuk membuat objek Siswa dengan informasi nama, NIS, kelas, dan foto.
     *
     * @param nama  Nama siswa.
     * @param nis   Nomor Induk Siswa.
     * @param kelas Kelas siswa.
     * @param foto  Foto siswa (bisa berupa path atau URL).
     */
    public Siswa(String nama, String nis, String kelas, String foto) {
        this.id = String.valueOf(idCounter++);
        this.nama = nama;
        this.nis = nis;
        this.kelas = kelas;
        this.foto = foto;
    }

    // Getter dan setter untuk atribut siswa

    public String getId() {
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public double getNilai1() {
        return nilai1;
    }

    public void setNilai1(double nilai1) {
        this.nilai1 = nilai1;
    }

    public double getNilai2() {
        return nilai2;
    }

    public void setNilai2(double nilai2) {
        this.nilai2 = nilai2;
    }

    public double getNilai3() {
        return nilai3;
    }

    public void setNilai3(double nilai3) {
        this.nilai3 = nilai3;
    }
}
