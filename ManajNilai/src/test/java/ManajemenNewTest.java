import Main.ManajemenNew;
import Main.SiswaNew;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class ManajemenNewTest {

    private ManajemenNew manajemenNeww;

    @BeforeEach
    public void setUp() {
        // Initialize ManajemenNew before each test
        manajemenNeww = new ManajemenNew();
    }

    @Test
    public void testTambahSiswa() {
        // Add a student
        manajemenNeww.tambahSiswa("John Doe", "123456", "10A");

        // Verify that the student is added
        List<SiswaNew> daftarSiswa = manajemenNeww.getDaftarSiswa();
        assertEquals(1, daftarSiswa.size());
        assertEquals("John Doe", daftarSiswa.get(0).getNama());
    }

    @Test
    public void testEditSiswa() {
        // Add a student
        manajemenNeww.tambahSiswa("John Doe", "123456", "10A");

        // Edit the student
        manajemenNeww.editSiswa(1, "Jane Doe", "654321", "10B");

        // Verify the student details are updated
        SiswaNew siswa = manajemenNeww.getDaftarSiswa().get(0);
        assertEquals("Jane Doe", siswa.getNama());
        assertEquals("654321", siswa.getNis());
        assertEquals("10B", siswa.getKelas());
    }

    @Test
    public void testHapusSiswa() {
        // Add a student
        manajemenNeww.tambahSiswa("John Doe", "123456", "10A");

        // Delete the student
        manajemenNeww.hapusSiswa(1);

        // Verify that no students remain
        assertTrue(manajemenNeww.getDaftarSiswa().isEmpty());
    }

    @Test
    public void testInputNilai() {
        // Add a student
        manajemenNeww.tambahSiswa("John Doe", "123456", "10A");

        // Input grades for the student
        manajemenNeww.inputNilai(1, 85.5, 90.0, 78.5);

        // Verify the grades are set correctly
        SiswaNew siswa = manajemenNeww.getDaftarSiswa().get(0);
        assertEquals(85.5, siswa.getNilai1());
        assertEquals(90.0, siswa.getNilai2());
        assertEquals(78.5, siswa.getNilai3());
    }

    @Test
    public void testEditNilai() {
        // Add a student
        manajemenNeww.tambahSiswa("John Doe", "123456", "10A");

        // Input initial grades
        manajemenNeww.inputNilai(1, 85.5, 90.0, 78.5);

        // Edit the student's grades
        manajemenNeww.editNilai(1, 88.0, 92.5, 80.0);

        // Verify the grades are updated correctly
        SiswaNew siswa = manajemenNeww.getDaftarSiswa().get(0);
        assertEquals(88.0, siswa.getNilai1());
        assertEquals(92.5, siswa.getNilai2());
        assertEquals(80.0, siswa.getNilai3());
    }
}
