package UnitTest;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DivisorCounter divisorCounter = new DivisorCounter();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the number of test cases:");
        int testCaseCount = scanner.nextInt();

        int[] numbers = new int[testCaseCount];
        System.out.println("Please enter " + testCaseCount + " numbers:");
        for (int i = 0; i < testCaseCount; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int i = 0; i < testCaseCount; i++) {
            System.out.println(divisorCounter.getValidDivisorCount(numbers[i]));
        }

        scanner.close();
    }
}
