package exercise04;

import java.util.ArrayList;
import java.util.Scanner;

class BrowserHistory {
	ArrayList<String> history = new ArrayList<>();
	int visitCount = 1;

	public void visitPage(String url) {
		visitCount = 1;
        for(String page : history) {
            if (page.startsWith(url)) {
                int countIndex = url.length() + 4; 
                visitCount = Integer.parseInt(page.substring(countIndex)) + 1;
                history.remove(page);
                break;
            }
        }
        history.add(url + " ## " + visitCount);

	}

	public void displayHistory() {
		for (String page : history) {
			System.out.println(page);
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
