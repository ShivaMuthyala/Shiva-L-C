package ObjectsAndDataStructures;

public class Customer {
	private String firstName;
    private String lastName;
    private Wallet myWallet;

    public Customer(String firstName, String lastName, float initialMoney) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.myWallet = new Wallet(initialMoney);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Wallet getWallet() {
        return myWallet;
    }

    public boolean subtractMoney(float amount) {
        if (myWallet.getTotalMoney() >= amount) {
            myWallet.setTotalMoney(myWallet.getTotalMoney() - amount);
            return true;
        }
        return false;
    }
}
