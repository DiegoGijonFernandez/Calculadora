package healthcalc;

    public class HealthCalculator implements HealthCalc {
    
        // Gender constants
        public static final char MALE = 'm';
        public static final char FEMALE = 'f';
    
        // Age constants
        private static final int MIN_AGE = 1;
        private static final int MAX_AGE = 150;
    
        // Weight constants
        private static final float MIN_WEIGHT = 1.0f;
        private static final float MAX_WEIGHT = 1000.0f;
    
        // Height constants
        private static final int MIN_HEIGHT = 1;
        private static final int MAX_HEIGHT = 300;
    
        @Override
        public float idealWeight(int height, char gender) throws IllegalArgumentException {
            if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
                throw new IllegalArgumentException("Height must be between " + MIN_HEIGHT + " and " + MAX_HEIGHT + " cm.");
            }
    
            if (gender != MALE && gender != FEMALE) {
                throw new IllegalArgumentException("Invalid gender. Please use MALE or FEMALE constants.");
            }
    
            float idealWeight;
            if (gender == MALE) {
                idealWeight = height - 100 - (height - 150) / 4f;
            } else {
                idealWeight = height - 100 - (height - 150) / 2.5f;
            }
            return idealWeight;
        }
    
        @Override
        public float basalMetabolicRate(float weight, int height, char gender, int age) throws IllegalArgumentException {
            if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
                throw new IllegalArgumentException("Weight must be between " + MIN_WEIGHT + " and " + MAX_WEIGHT + " kg.");
            }
    
            if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
                throw new IllegalArgumentException("Height must be between " + MIN_HEIGHT + " and " + MAX_HEIGHT + " cm.");
            }
    
            if (age < MIN_AGE || age > MAX_AGE) {
                throw new IllegalArgumentException("Age must be between " + MIN_AGE + " and " + MAX_AGE + " years.");
            }
    
            if (gender != MALE && gender != FEMALE) {
                throw new IllegalArgumentException("Invalid gender. Please use MALE or FEMALE constants.");
            }
    
            float bmr;
            if (gender == MALE) {
                bmr = 10 * weight + 6.25f * height - 5 * age + 5;
            } else {
                bmr = 10 * weight + 6.25f * height - 5 * age - 161;
            }
            return bmr;
        }
    }
    


