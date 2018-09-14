package chordutils;

import java.util.Scanner;

public class ChordValidator {

	public static final String[] CHORD_MODS = { "", "m", " Major", " major", "maj7", "maj9", "maj11", "maj13", "maj9#11",
			"maj13#11", "6", "add9", "6add9", "maj7b5", "maj7#5", " Minor", " minor", "m7", "m9", "m11", "m13", "m6", "madd9",
			"m6add9", "mmaj7", "mmaj9", "m7b5", "m7#5", "7", "9", "11", "13", "7sus4", "7b5", "7#5", "7b9", "7#9",
			"7(b5,b9)", "7(b5,#9)", "7(#5,b9)", "7(#5,#9)", "9b5", "9#5", "13#11", "13b9", "11b9", "aug", "dim", "dim7",
			"5", "sus4", "sus2", "sus2sus4", "-5" }; //if typing wrong mod, maybe display these to help user
	
	public static String validateChordText(String input) { //TODO: specific error msgs for each invalid chord component(wrong note, accidental, mod)
		Scanner scan = new Scanner(System.in);
		while (!isValidChordText(input)) {
			System.out.print("Please enter a valid chord: ");
			input = scan.nextLine();
		}
		return input;
	}
	
	private static boolean isValidChordText(String input) {
		if(input.isEmpty()) return false;
		if (!hasValidNote(input)) return false;
		if (hasValidAccidental(input)) {
			return hasValidChordModifier(input, true);
		} else {
			return hasValidChordModifier(input, false);
		}
	}
	
	private static boolean hasValidNote(String input) {
		if(!Character.isLetter(input.charAt(0))) return false;
		if(input.charAt(0) > 'G' || input.charAt(0) < 'A') return false;
		return true;
	}
	
	static boolean hasValidAccidental(String input) { //default access modifier so ChordCreator can access
		if (input.length() > 1 && (input.charAt(1) == '#' || input.charAt(1) == 'b')) {
			return true;
		}
		return false;
	}
	
	private static boolean hasValidChordModifier(String input, boolean hasAccidental) {
		String modifier = input.substring(hasAccidental ? 2 : 1);
		for(String mod : CHORD_MODS) {
			if(modifier.length() == mod.length() && modifier.equals(mod)) return true;
		}
		return false;
	}
	
}
