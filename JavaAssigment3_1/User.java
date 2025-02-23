package JavaAssignment3_1;

import java.util.Scanner;

public class User {
	String name;
	static int age;
	int salary;
	double salaryInDouble;
	static final int taxRatePercentage = 5;

	public void userDetails() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your name");
		this.name = scanner.nextLine();
		System.out.println("Please enter your age");
		while (!(scanner.hasNextInt())) {
			System.out.println("Please enter in a correct format");
			scanner.next();
		}
		this.age = scanner.nextInt();
		System.out.println("Please enter your salary");
		while (!(scanner.hasNextInt())) {
			System.out.println("Please enter in a correct format");
			scanner.next();
		}
		this.salaryInDouble = scanner.nextInt();
		this.salary = (int) salaryInDouble;
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
		System.out.println("Name : " + name + "\nAge: " + age + "\nSalary: " + salary);
	}

	public void calculateSalaryAfterTax() {
		double totalTax = (taxRatePercentage / 100.0) * salary;
		double remainingTax = totalTax;
		double netSalary = salary;
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
		if ((this.age > 21) && (this.salary > 50000)) {
			System.out.println("You are eligible for loan");
		} else {
			System.out.println("You are not eligible for loan");
			if (this.age < 21) {
				System.out.println("Due to age restriction");
			} else {
				System.out.println("The salary is too low for the eligibility");
			}
		}
		if ((salary > 0) && (salary <= 250000)) {
			System.out.println("You belong to Basic Exemption Bracket");
		} else if ((salary > 250000) && (salary <= 500000)) {
			System.out.println("You belong to Lower Income Bracket");
		} else if ((salary > 500000) && (salary <= 1000000)) {
			System.out.println("You belong to Middle Income Bracket");
		} else {
			System.out.println("You belong to Higher Income Bracket");
		}
	}
}
