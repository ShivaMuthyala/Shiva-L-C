package JavaAssignment3_1;

import java.util.Scanner;

public class User {
	private String name;
	private static int age;
	private int roundedSalary;
	private double exactSalary;
	private final int TAX_PER_PERCENTAGE = 5;

	public static int getAge() {
		return age;
	}

	public void setUserDetails() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your name");
		this.name = scanner.nextLine();
		System.out.println("Please enter your age");
		while (!(scanner.hasNextInt())) {
			System.out.println("Please enter in a correct format");
			scanner.next();
		}
		User.age = scanner.nextInt();
		System.out.println("Please enter your salary");
		while (!(scanner.hasNextInt())) {
			System.out.println("Please enter in a correct format");
			scanner.next();
		}
		this.exactSalary = scanner.nextInt();
		this.roundedSalary = (int) exactSalary;
		scanner.close();
		if ((age >= 0 && age <= 12)) {
			System.out.println("Hey Kiddo hope you are doing good");
		} else if ((age >= 13 && age <= 56)) {
			System.out.println("Hey " + name + " hope you are doing good");
		} else {
			System.out.println("Hey Sir, hope you are doing good");
		}
	}

	public void getUserDetails() {
		System.out.println("Please find your details");
		System.out.println("Name : " + name + "\nAge: " + age + "\nSalary: " + exactSalary);
	}

	public void calculateSalaryAfterTax() {
		double totalTax = (TAX_PER_PERCENTAGE / 100.0) * roundedSalary;
		double remainingTax = totalTax;
		double netSalary = roundedSalary;
		System.out.println("\n--- Tax Deduction Process ---");

		do {
			double deduction = Math.min(1000, remainingTax); // Deduct ₹1000 or remaining tax
			netSalary -= deduction;
			remainingTax -= deduction;

			System.out.println(
					"Deducted ₹" + deduction + ", Remaining Tax: ₹" + remainingTax + ", Net Salary: ₹" + netSalary);
		} while (remainingTax > 0);

		System.out.println("\nFinal Net Salary after Tax Deduction: ₹" + netSalary);
	}

	public void checkLoanEligibility() {
		if ((User.age > 21) && (this.roundedSalary > 50000)) {
			System.out.println("You are eligible for loan");
		} else {
			System.out.println("You are not eligible for loan");
			if (User.age < 21) {
				System.out.println("Due to age restriction");
			} else {
				System.out.println("The salary is too low for the eligibility");
			}
		}
		if ((roundedSalary > 0) && (roundedSalary <= 250000)) {
			System.out.println("You belong to Basic Exemption Bracket");
		} else if ((roundedSalary > 250000) && (roundedSalary <= 500000)) {
			System.out.println("You belong to Lower Income Bracket");
		} else if ((roundedSalary > 500000) && (roundedSalary <= 1000000)) {
			System.out.println("You belong to Middle Income Bracket");
		} else {
			System.out.println("You belong to Higher Income Bracket");
		}
	}
}
