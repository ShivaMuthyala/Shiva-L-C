package UnitTest;

public class DivisorCounter {

    public int getValidDivisorCount(int number) {
        if (number < 1) {
            return 0;
        }

        int validDivisorsCount = 0;
        for (int currentNumber = 2; currentNumber < number; currentNumber++) {
            if (divisorCount(currentNumber) == divisorCount(currentNumber + 1)) {
                validDivisorsCount++;
            }
        }
        return validDivisorsCount;
    }

    private int divisorCount(int number) {
        int divisorCount = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                divisorCount++;
            }
        }
        return divisorCount;
    }
}
