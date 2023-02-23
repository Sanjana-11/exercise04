package exercise04;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

class BrowserHistory {
	private HashMap<String, Integer> history = new HashMap<>();

	public void visitPage(String url) {
		if (history.containsKey(url)) {
			int visitCount = history.get(url);
			history.put(url, visitCount + 1);
		} else {
			history.put(url, 1);
		}
	}

	public void displayHistory() {
		for (Entry<String, Integer> object : history.entrySet()) {
			System.out.println(object.getKey() + " ## " + object.getValue());
		}
	}

}

public class Main {
	public static void main(String[] args) {
		String choice;
		BrowserHistory browser = new BrowserHistory();
		do {
			System.out.println("Enter url");
			Scanner sc = new Scanner(System.in);
			String url = sc.nextLine();
			browser.visitPage(url);
			browser.displayHistory();
			System.out.println("Do you wish to continue? (Yes/No)");
			choice = sc.nextLine();
		} while (choice.equalsIgnoreCase("Yes"));
	}
}
