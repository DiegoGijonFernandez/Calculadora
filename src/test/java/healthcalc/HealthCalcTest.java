package healthcalc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Tests for the health calculator.")
public class HealthCalcTest {

    @Test
    @DisplayName("Calculating ideal weight for a male with height 170 cm.")
    public void testIdealWeightForMale() {
        HealthCalculator calculator = new HealthCalculator();
        try {
            float maleIdealWeight = calculator.idealWeight(170, HealthCalculator.MALE);
            assertEquals(65.0f, maleIdealWeight, 0.01f); 
        } catch (IllegalArgumentException e) {
            fail("An exception was thrown: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Calculating ideal weight for a female with height 160 cm.")
    public void testIdealWeightForFemale() {
        HealthCalculator calculator = new HealthCalculator();
        try {
            float femaleIdealWeight = calculator.idealWeight(160, HealthCalculator.FEMALE);
            assertEquals(56f, femaleIdealWeight, 0.01f); 
        } catch (IllegalArgumentException e) {
            fail("An exception was thrown: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Calculating basal metabolic rate (BMR) for a 30-year-old male with weight 70 kg and height 180 cm.")
    public void testBasalMetabolicRateForMale() {
        HealthCalculator calculator = new HealthCalculator();
        try {
            float maleBMR = calculator.basalMetabolicRate(70, 180, HealthCalculator.MALE, 30);
            assertEquals(1680f, maleBMR, 0.01f);
        } catch (IllegalArgumentException e) {
            fail("An exception was thrown: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Calculating basal metabolic rate (BMR) for a 25-year-old female with weight 60 kg and height 160 cm.")
    public void testBasalMetabolicRateForFemale() {
        HealthCalculator calculator = new HealthCalculator();
        try {
            float femaleBMR = calculator.basalMetabolicRate(60, 160, HealthCalculator.FEMALE, 25);
            assertEquals(1314f, femaleBMR, 0.01f); 
        } catch (IllegalArgumentException e) {
            fail("An exception was thrown: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Calculating basal metabolic rate (BMR) for a male with minimum weight and maximum height.")
    public void testBasalMetabolicRateForMaleWithMinWeightMaxHeight() {
        HealthCalculator calculator = new HealthCalculator();
        try {
            float maleBMR = calculator.basalMetabolicRate(1, 300, HealthCalculator.MALE, 30);
            assertEquals(1740f, maleBMR, 0.01f);
        } catch (IllegalArgumentException e) {
            fail("An exception was thrown: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Calculating basal metabolic rate (BMR) for a female with maximum weight and minimum height.")
    public void testBasalMetabolicRateForFemaleWithMaxWeightMinHeight() {
        HealthCalculator calculator = new HealthCalculator();
        try {
            float femaleBMR = calculator.basalMetabolicRate(1000, 1, HealthCalculator.FEMALE, 25);
            assertEquals(9720.25f, femaleBMR, 0.01f);
        } catch (IllegalArgumentException e) {
            fail("An exception was thrown: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Calculating basal metabolic rate (BMR) for a one-year-old male.")
    public void testBasalMetabolicRateForOneYearOldMale() {
        HealthCalculator calculator = new HealthCalculator();
        try {
            float maleBMR = calculator.basalMetabolicRate(10, 50, HealthCalculator.MALE, 1);
            assertEquals(412.5f, maleBMR, 0.01f);
        } catch (IllegalArgumentException e) {
            fail("An exception was thrown: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Calculating basal metabolic rate (BMR) for a 100-year-old female.")
    public void testBasalMetabolicRateForHundredYearOldFemale() {
        HealthCalculator calculator = new HealthCalculator();
        try {
            float femaleBMR = calculator.basalMetabolicRate(40, 150, HealthCalculator.FEMALE, 100);
            assertEquals(676.5f, femaleBMR, 0.01f);
        } catch (IllegalArgumentException e) {
            fail("An exception was thrown: " + e.getMessage());
        }
    }
}

