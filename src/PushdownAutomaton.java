import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class PushdownAutomaton {
	private HashMap<String, State> allStates;
	private Alphabet sigma;
	private Alphabet tau;
	private String startingState;
	private String firstStackElement;
	private ArrayList<String> finalStates;
	private Stack<String> stack;
	private HashMap<String, ArrayList<Delta>> allDelta;	
	private State currentState;
	Input inputString;
	Integer inputIndex;
	
	
	public PushdownAutomaton(HashMap<String,State> allStates, Alphabet sigma, Alphabet tau,
			String startingState, String firstStackElement,	ArrayList<String> finalStates,
			Stack<String> stack, HashMap<String, ArrayList<Delta>> allDelta){
		setAllStates(allStates);
		setSigma(sigma);
		setTau(tau);
		setStartingState(startingState);
		setFirstStackElement(firstStackElement);
		setFinalStates(finalStates);
		setStack(stack);
		setAllDelta(allDelta);
		setCurrentState(getAllStates().get(getStartingState()));
		setInputIndex(0);		
	}
	/**
	 * 
	 * @return a boolean which determines if a move was possible, in case it wasn't it means the PDA stops for lack of movements.
	 */
	public boolean nextMove(){
		ArrayList<Delta> transitionArray = new ArrayList<Delta>(getAllDelta().get(currentState.getId()));
		boolean hasMoved = false;
		for (int i = 0; i <  transitionArray.size(); i++) {
			if ((getInputString().getElement(getInputIndex()).equals(transitionArray.get(i).getExpectedInputString()) ||
					transitionArray.get(i).getExpectedInputString().equals("#"))
					&& (stack.peek().equals(transitionArray.get(i).getExpectedStackString()) || stack.peek().equals("#")) 
					&& hasMoved == false) {
				stack.pop();
				for (int j = transitionArray.get(i).getNextElementToPushStack().size() - 1; j >= 0; --j) {
					if (!transitionArray.get(i).getNextElementToPushStack().get(j).equals("#")) {
						stack.push(transitionArray.get(i).getNextElementToPushStack().get(j));
					}
				}
				if (!transitionArray.get(i).getExpectedInputString().equals("#")) {
					setInputIndex(getInputIndex() + 1);
				}
				currentState = getAllStates().get(transitionArray.get(i).getNextState());
				hasMoved = true;
				return hasMoved;
			}
		}
		return hasMoved;
	}
	
	public boolean run(Input inputString){
		boolean watcher = true;
		setInputString(inputString);
		while(!getInputString().inputString.isEmpty() && watcher != false){
			watcher = nextMove();
		}
		if (getFinalStates().get(0).equals("")) {
			if (getInputString().getSize()-1 == getInputIndex() && getStack().isEmpty()) {
				System.out.println("Cadena aceptada");
				return true;
			}
			System.out.println("Cadena no aceptada");
			return false;
		}
		if (getInputString().getSize()-1 == getInputIndex() && getCurrentState().isFinalState()) {
			System.out.println("Cadena aceptada");
			return true;
		}
		System.out.println("Cadena no aceptada");
		return false;
	}
	

	
	public Alphabet getSigma() {
		return sigma;
	}

	public void setSigma(Alphabet sigma) {
		this.sigma = sigma;
	}

	public Alphabet getTau() {
		return tau;
	}

	public void setTau(Alphabet tau) {
		this.tau = tau;
	}

	public String getStartingState() {
		return startingState;
	}

	public void setStartingState(String startingState) {
		this.startingState = startingState;
	}

	public String getFirstStackElement() {
		return firstStackElement;
	}

	public void setFirstStackElement(String firstStackElement) {
		this.firstStackElement = firstStackElement;
	}

	public ArrayList<String> getFinalStates() {
		return finalStates;
	}

	public void setFinalStates(ArrayList<String> finalStates) {
		this.finalStates = finalStates;
	}

	public void setAllStates(HashMap<String, State> allStates) {
		this.allStates = allStates;
	}

	public Stack<String> getStack() {
		return stack;
	}

	public void setStack(Stack<String> stack) {
		this.stack = stack;
	}

	public HashMap<String, ArrayList<Delta>> getAllDelta() {
		return allDelta;
	}

	public void setAllDelta(HashMap<String, ArrayList<Delta>> allDelta2) {
		this.allDelta = allDelta2;
	}

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}

	/**
	 * @return the allStates
	 */
	public HashMap<String, State> getAllStates() {
		return allStates;
	}

	/**
	 * @return the inputString
	 */
	public Input getInputString() {
		return inputString;
	}

	/**
	 * @param inputString the inputString to set
	 */
	public void setInputString(Input inputString) {
		this.inputString = inputString;
	}

	/**
	 * @return the inputIndex
	 */
	public Integer getInputIndex() {
		return inputIndex;
	}

	/**
	 * @param inputIndex the inputIndex to set
	 */
	public void setInputIndex(Integer inputIndex) {
		this.inputIndex = inputIndex;
	}


}
