import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Introduzca la cadena de entrada");
		String input = keyboard.nextLine();
		keyboard.close();
		
		HashMap<String, State> statesHash = new HashMap<String, State>();
		HashMap<String, ArrayList<Delta>> deltaHash = new HashMap<String, ArrayList<Delta>>();
		Parser parser = new Parser("pdautomaton.txt");
		Stack<String> stack = new Stack<String>();
		ArrayList<Delta> deltaArray = new ArrayList<Delta>();
			
		for (int i = 0; i < parser.getStates().size(); i++) {
			State state = new State(parser.getStates().get(i));
			if (parser.getFinalState().contains(parser.getStates().get(i))) {
				state.setFinalState(true);
			}
			statesHash.put(state.getId(), state);
			state = null;
		}
		stack.push(parser.getStackBase());
		for (int j = 0; j < parser.getStates().size(); j++) {
			for (int i = 0; i < parser.getDelta().size(); i++) {
				Delta delta = new Delta(parser.getDelta().get(i));
				if (parser.getStates().get(j).equals(delta.getInitialState())) {
					deltaArray.add(delta);
				}
			}
			deltaHash.put(parser.getStates().get(j), deltaArray);
			deltaArray = new ArrayList<Delta>();
		}
		Input inputString = new Input(input);
		
		PushdownAutomaton pda = new PushdownAutomaton(statesHash, new Alphabet(parser.getSigma()), new Alphabet(parser.getTau()),
				parser.getStartState(), parser.getStackBase(), parser.getFinalState(), 
				stack , deltaHash);
		pda.run(inputString);
	}
}
