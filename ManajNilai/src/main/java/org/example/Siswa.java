package org.example;
import java.util.HashMap;

public class Siswa {
    private String nama;
    private String nis;
    private String kelas;
    private int id;
    private HashMap<String, Double> nilaiMap;

    public Siswa(int id, String nama, String nis, String kelas) {
        this.id = id;
        this.nama = nama;
        this.nis = nis;
        this.kelas = kelas;
        this.nilaiMap = new HashMap<>();
    }

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

    public HashMap<String, Double> getNilaiMap() {
        return nilaiMap;
    }

    public void tambahNilai(String mataPelajaran, double nilai) {
        nilaiMap.put(mataPelajaran, nilai);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id)
                .append(", Nama: ").append(nama)
                .append(", NIS: ").append(nis)
                .append(", Kelas: ").append(kelas)
                .append("\nNilai: ");
        if (nilaiMap.isEmpty()) {
            sb.append("Belum ada nilai yang diinput.");
        } else {
            for (String mapel : nilaiMap.keySet()) {
                sb.append("\n  - ").append(mapel).append(": ").append(nilaiMap.get(mapel));
            }
        }
        return sb.toString();
    }
}