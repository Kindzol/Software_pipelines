import org.example.HRCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HRCalculatorTest {
    @Test
    public void testValidMaxHR(){
        var result = HRCalculator.calculateMaxHR(25);
        assertEquals(195, result);
    }

    @Test
    public void testInvalidMinHR_ageTooHigh() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.calculateMaxHR(500));
    }

    @Test
    public void testInvalidMinHR_ageTooLow() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.calculateMaxHR(-1));
    }

    @Test
    public void testZoneRecovery(){
        assertEquals("Recovery", HRCalculator.getWorkoutZone(40, 100)); // 100/180=0.55
    }

    @Test
    public void testZoneFatBurn(){
        assertEquals("Fat burn", HRCalculator.getWorkoutZone(40, 115)); // ~0.64
    }

    @Test
    public void testZoneCardio(){
        assertEquals("Cardio", HRCalculator.getWorkoutZone(40, 130)); // ~0.72
    }

    @Test
    public void testZoneAnaerobic(){
        assertEquals("Anaerobic", HRCalculator.getWorkoutZone(40, 150)); // ~0.83
    }

    @Test
    public void testZoneVO2(){
        assertEquals("VO2 max", HRCalculator.getWorkoutZone(40, 172)); // ~0.95
    }

    @Test
    public void testBpmTooHigh(){
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.getWorkoutZone(40, 999));
    }

    @Test
    public void testBpmNegative(){
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.getWorkoutZone(40, -5));
    }
}
