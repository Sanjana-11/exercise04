package exercise04;

import java.util.ArrayList;
import java.util.Scanner;

class BrowserHistory {
	ArrayList<String> history = new ArrayList<>();

	public void visitPage(String url) {
		int visitCount = 1;
		int addIndex = 0;

		for (String page : history) {
			if (page.startsWith(url + " ## ")) {
				int countIndex = url.length() + 4;
				visitCount = Integer.parseInt(page.substring(countIndex)) + 1;
				addIndex = history.indexOf(page);
				history.remove(page);
				break;
			}
		}

		history.add(addIndex, (url + " ## " + visitCount));

	}

	public void displayHistory() {
		for (int i = history.size() - 1; i >= 0; i--) {
			System.out.println(history.get(i));
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
