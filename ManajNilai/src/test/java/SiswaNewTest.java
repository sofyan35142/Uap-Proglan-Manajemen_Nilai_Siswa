import Main.SiswaNew;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SiswaNewTest {

    @Test
    public void testSiswaNewCreation() {
        // Create a SiswaNew object
        SiswaNew siswa = new SiswaNew("John Doe", "123456", "10A");

        // Test that the student has a valid ID
        assertNotNull(siswa.getId());
        assertEquals("1", siswa.getId()); // Assuming the first student created gets ID 1

        // Test other attributes
        assertEquals("John Doe", siswa.getNama());
        assertEquals("123456", siswa.getNis());
        assertEquals("10A", siswa.getKelas());
    }

    @Test
    public void testSetters() {
        // Create a SiswaNew object
        SiswaNew siswa = new SiswaNew("John Doe", "123456", "10A");

        // Set new values for fields
        siswa.setNama("Jane Doe");
        siswa.setNis("654321");
        siswa.setKelas("10B");

        // Test the setters
        assertEquals("Jane Doe", siswa.getNama());
        assertEquals("654321", siswa.getNis());
        assertEquals("10B", siswa.getKelas());
    }
}
