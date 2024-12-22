package moodleassignment_2;

public class TypeCastingAndTypeConversions {

    public static void main(String[] args) {

        // Initializing an integer value
        int integerValue = 120;

        // Implicit type casting: from smaller type (int) to larger type (double)
        double doubleValue = integerValue;

        // Displaying the values
        System.out.println("Integer Value: " + integerValue);
        System.out.println("The double value of integerValue is: " + doubleValue);

        // Initializing a double value
        double decimalValue = 18.72;

        // Explicit type casting: from larger type (double) to smaller type (int)
        int truncatedValue = (int) decimalValue;

        // Displaying the values
        System.out.println("Double Value: " + decimalValue);
        System.out.println("Truncated value of decimalValue: " + truncatedValue);
    }
}
