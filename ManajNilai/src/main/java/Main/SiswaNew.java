package Main;
import javax.swing.ImageIcon;
import java.util.Map;
import java.util.HashMap;

public class SiswaNew {
    private static int idCounter = 1;
    private String id;
    private String nama;
    private String nis;
    private String kelas;
    private double nilai1;
    private double nilai2;
    private double nilai3;

    public SiswaNew(String nama, String nis, String kelas) {
        this.id = String.valueOf(idCounter++);
        this.nama = nama;
        this.nis = nis;
        this.kelas = kelas;
    }

    // Getters and Setters
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