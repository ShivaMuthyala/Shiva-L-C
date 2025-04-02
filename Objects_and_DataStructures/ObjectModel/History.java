package ObjectModel;

import java.util.Stack;

public class History {
	private Stack<Double> history = new Stack<>();

    public void addToHistory(double result) {
        history.push(result);
    }

    public Double undo() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }

    public void printHistory() {
        System.out.println("History: " + history);
    }
}
