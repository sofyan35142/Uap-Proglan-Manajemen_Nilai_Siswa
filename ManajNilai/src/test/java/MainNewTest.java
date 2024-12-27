import Main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainNewTest {

    private MainNew mainApp;

    @BeforeEach
    public void setUp() {
        mainApp = new MainNew();
    }

    @Test
    public void testAddSiswa() {
        // Test adding a student
        mainApp.addStudent("John Doe", "123456", "10A");

        // Check if the student was added
        assertEquals(1, mainApp.getManajemen().getDaftarSiswa().size());
    }

    @Test
    public void testEditSiswa() {
        // Add a student first
        mainApp.addStudent("John Doe", "123456", "10A");

        // Edit the student's details
        mainApp.editStudent(1, "Jane Doe", "654321", "10B");

        // Verify the student's updated details
        SiswaNew siswa = mainApp.getManajemen().getDaftarSiswa().get(0);
        assertEquals("Jane Doe", siswa.getNama());
        assertEquals("654321", siswa.getNis());
        assertEquals("10B", siswa.getKelas());
    }

    @Test
    public void testDeleteSiswa() {
        // Add a student first
        mainApp.addStudent("John Doe", "123456", "10A");

        // Delete the student
        mainApp.deleteStudent(1);

        // Check if no students remain
        assertTrue(mainApp.getManajemen().getDaftarSiswa().isEmpty());
    }

    @Test
    public void testAddGrades() {
        // Add a student and grades
        mainApp.addStudent("John Doe", "123456", "10A");
        mainApp.addGrades(1, 85.5, 90.0, 78.5);

        // Verify the grades
        SiswaNew siswa = mainApp.getManajemen().getDaftarSiswa().get(0);
        assertEquals(85.5, siswa.getNilai1());
        assertEquals(90.0, siswa.getNilai2());
        assertEquals(78.5, siswa.getNilai3());
    }

    @Test
    public void testEditGrades() {
        // Add a student and grades
        mainApp.addStudent("John Doe", "123456", "10A");
        mainApp.addGrades(1, 85.5, 90.0, 78.5);

        // Edit the grades
        mainApp.editGrades(1, 88.0, 92.5, 80.0);

        // Verify the grades were updated
        SiswaNew siswa = mainApp.getManajemen().getDaftarSiswa().get(0);
        assertEquals(88.0, siswa.getNilai1());
        assertEquals(92.5, siswa.getNilai2());
        assertEquals(80.0, siswa.getNilai3());
    }
}