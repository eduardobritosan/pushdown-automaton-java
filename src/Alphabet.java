import java.util.ArrayList;

public class Alphabet {
	private ArrayList<String> alphabet;

	public ArrayList<String> getAlphabet() {
		return alphabet;
	}
	
	public void addElementToAlphabet(String newElement){
		getAlphabet().add(newElement);
	}

	public void setAlphabet(ArrayList<String> alphabet) {
		this.alphabet = alphabet;
	}

	public Alphabet(ArrayList<String> alphabet) {
		super();
		this.alphabet = alphabet;
	}
}
