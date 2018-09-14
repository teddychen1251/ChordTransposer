package chordutils;

import chords.Chord;

public class ChordCreator {

	public static Chord createChord(String chordText) {
		String note = extractNote(chordText);
		String accidental = extractAccidental(chordText);
		String modifier = extractChordModifier(chordText);
		return new Chord(note, accidental, modifier);
	}
	
	private static String extractNote(String chordText) {
		return Character.toString(chordText.charAt(0));
	}
	
	private static String extractAccidental(String chordText) {
		if(ChordValidator.hasValidAccidental(chordText)) {
			return Character.toString(chordText.charAt(1));
		}
		return "";
	}
	
	private static String extractChordModifier(String chordText) {
		if(ChordValidator.hasValidAccidental(chordText)) {
			return chordText.substring(2);
		}
		return chordText.substring(1);
	}
}
