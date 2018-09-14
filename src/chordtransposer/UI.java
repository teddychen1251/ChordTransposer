package chordtransposer;

import java.util.Scanner;

public class UI {
	
	public static boolean userWantsToContinue = true;
	
	public static void displayWelcome() {
		System.out.println("Welcome to the chord transposer!");
		System.out.println("Enter a chord you'd like to transpose, e.g. C#m.");
	}
	
	public static void displayGoodbye() {
		System.out.println("Understandable. Have a nice day!");
	}
	
	public static void askUserToContinue() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to transpose another chord? (enter \"Yes\" or \"No\")");
		String response = validateYesOrNoResponse(scan.nextLine());
		processYesOrNoResponse(response.toLowerCase());
	}
	
	private static String validateYesOrNoResponse(String input) {
		Scanner scan = new Scanner(System.in);
		while(!isValidYesOrNoResponse(input)) {
			System.out.print("Please enter a valid \"Yes\" or \"No\": ");
			input = scan.nextLine();
		}
		return input;
	}
	
	private static boolean isValidYesOrNoResponse(String input) {
		return input.toLowerCase().equals("yes") || input.toLowerCase().equals("no");
	}
	
	private static void processYesOrNoResponse(String response) {
		switch(response) {
		case "yes":
			userWantsToContinue = true;
			break;
		case "no":
			userWantsToContinue = false;
			break;
		default:
			userWantsToContinue = false;
			break;
		}
	}
}
