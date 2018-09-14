package transposerutils;

import java.util.Scanner;

public class TranspositionValidator {

	public static int validateTransposition(String input) {
		Scanner scan = new Scanner(System.in);
		while (!isValidTransposition(input)) {
			System.out.print("Please enter a valid transposition (e.g. +3 or -1): ");
			input = scan.nextLine();
		}
		return Integer.parseInt(input);
	}
	
	private static boolean isValidTransposition(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
