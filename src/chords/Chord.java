package chords;

import java.util.TreeMap;

public class Chord {
	
	public static final int SCALE_LIMIT = 6;
	public static final double MIN_STEP = .5;
	
	private static final TreeMap<String, Double> noteSteps = new TreeMap<String, Double>();
	static {
		noteSteps.put("A", 0.0);
		noteSteps.put("B", 1.0);
		noteSteps.put("C", 1.5);
		noteSteps.put("D", 2.5);
		noteSteps.put("E", 3.5);
		noteSteps.put("F", 4.0);
		noteSteps.put("G", 5.0);
	}
	
	private String note;
	private String accidental;
	private String chordModifier;
	private double step;
	
	public Chord(String n, String a, String cM) {
		this.note = n;
		this.accidental = a;
		this.chordModifier = cM;
		for(String noteKey : noteSteps.keySet()) { //TODO: Helper method
			if(noteKey.equals(this.note)) {
				this.step = noteSteps.get(noteKey);
			}
		}
		switch(this.accidental) { //TODO: Helper method
		case "#":
			this.step += .5;
			break;
		case "b":
			this.step -= .5;
			break;
		default:
			break;
		}
	}
	
	public void transpose(int transposition) {
		if(transposition % 12 == 0) return;
		this.step += (double)transposition / 2;
		step %= SCALE_LIMIT;
		if(step < 0) step += SCALE_LIMIT;
		matchNoteToStep(transposition > 0);
	}

	private void matchNoteToStep(boolean transposedUp) {
		matchNaturalNoteToStep();
		if(noteMatchesStep()) return;
		matchAccidentalNoteToStep(transposedUp);
	}
	
	private void matchNaturalNoteToStep() {
		for(String noteKey : noteSteps.keySet()) {
			if(step == noteSteps.get(noteKey)) {
				note = noteKey;
				accidental = "";
				return;
			}
		}
	}
	
	private void matchAccidentalNoteToStep(boolean transposedUp) {
		double offsetStep = (step + (transposedUp ? -MIN_STEP : MIN_STEP)) % SCALE_LIMIT;
		for(String noteKey : noteSteps.keySet()) {
			if(offsetStep == noteSteps.get(noteKey)) {
				note = noteKey;
				accidental = transposedUp ? "#" : "b";
				return;
			}
		}
	}
	
	private boolean noteMatchesStep() {
		return noteSteps.get(note) == step;
	}
	
	public String toString() {
		return note + accidental + chordModifier;
	}
}
