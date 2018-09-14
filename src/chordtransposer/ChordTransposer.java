package chordtransposer;

import java.util.Scanner;
import chords.Chord;
import chordutils.*;
import transposerutils.TranspositionValidator;

public class ChordTransposer {
		
	public static void main(String[] args) {
		UI.displayWelcome();
		do {
			Chord chord = receiveChord();
			int transposition = receiveTransposition();
			chord.transpose(transposition);
			System.out.println("Your transposed chord is " + chord); //make UI method
			UI.askUserToContinue();
		} while(UI.userWantsToContinue);
		UI.displayGoodbye();
	}
	
	public static Chord receiveChord() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter chord: ");
		String chordText = ChordValidator.validateChordText(scan.nextLine());
		return ChordCreator.createChord(chordText);
	}
	
	public static int receiveTransposition() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter transposition in halfsteps (e.g. +3 or -1): " );
		int transposition = TranspositionValidator.validateTransposition(scan.nextLine());
		return transposition;
	}
	
}