package ObjectsAndDataStructures;

public class ClintCode {

	public static void main(String[] args) {
		float payment = 200;
		Customer myCustomer = new Customer("John", "Doe", 1000);
		Wallet theWallet = myCustomer.getWallet();


		if (myCustomer.subtractMoney(payment)) {  // ✅ Use Customer's subtractMoney method
		    System.out.println("Payment successful!");
		} else {
		    System.out.println("Come back later for payment.");
		}


		// Adding money to the wallet
		theWallet.addMoney(50);
		System.out.println("Money added. New balance: " + theWallet.getTotalMoney());


	}

}
