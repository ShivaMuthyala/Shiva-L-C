package ObjectsAndDataStructures;

public class Wallet {
	 private float value;

	    public Wallet(float initialMoney) {
	        this.value = initialMoney;
	    }

	    public float getTotalMoney() {
	        return value;
	    }

	    public void setTotalMoney(float newValue) {
	        this.value = newValue;
	    }

	    public void addMoney(float deposit) {
	        value += deposit;
	    }
	}

