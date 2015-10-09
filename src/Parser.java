import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Parser {
	
	private ArrayList<String> states;
	private ArrayList<String> sigma;
	private ArrayList<String> tau;
	private String startState;
	private String stackBase;
	private ArrayList<String> finalState;
	private ArrayList<String> delta;
	
	public Parser(String filename) {
		File file = new File(filename);
		states = new ArrayList<String>();
		sigma = new ArrayList<String>();
		tau = new ArrayList<String>();
		delta = new ArrayList<String>();
		finalState = new ArrayList<String>();
		
		try {
			Scanner inputStream = new Scanner(file);
			
			Collections.addAll(states, inputStream.nextLine().split(" "));
			Collections.addAll(sigma, inputStream.nextLine().split(" "));
			Collections.addAll(tau, inputStream.nextLine().split(" "));
			startState = inputStream.nextLine();
			stackBase = inputStream.nextLine();
			Collections.addAll(finalState, inputStream.nextLine().split(" "));
			
			while(inputStream.hasNext()){
				Collections.addAll(delta, inputStream.nextLine());
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
			e.printStackTrace();
		}
	}
	/**
	 * @return the states
	 */
	public ArrayList<String> getStates() {
		return states;
	}
	/**
	 * @param states the states to set
	 */
	public void setStates(ArrayList<String> states) {
		this.states = states;
	}
	/**
	 * @return the sigma
	 */
	public ArrayList<String> getSigma() {
		return sigma;
	}
	/**
	 * @param sigma the sigma to set
	 */
	public void setSigma(ArrayList<String> sigma) {
		this.sigma = sigma;
	}
	/**
	 * @return the tau
	 */
	public ArrayList<String> getTau() {
		return tau;
	}
	/**
	 * @param tau the tau to set
	 */
	public void setTau(ArrayList<String> tau) {
		this.tau = tau;
	}
	/**
	 * @return the startState
	 */
	public String getStartState() {
		return startState;
	}
	/**
	 * @param startState the startState to set
	 */
	public void setStartState(String startState) {
		this.startState = startState;
	}
	/**
	 * @return the stackBase
	 */
	public String getStackBase() {
		return stackBase;
	}
	/**
	 * @param stackBase the stackBase to set
	 */
	public void setStackBase(String stackBase) {
		this.stackBase = stackBase;
	}
	/**
	 * @return the finalState
	 */
	public ArrayList<String> getFinalState() {
		return finalState;
	}
	/**
	 * @param finalState the finalState to set
	 */
	public void setFinalState(ArrayList<String> finalState) {
		this.finalState = finalState;
	}
	/**
	 * @return the delta
	 */
	public ArrayList<String> getDelta() {
		return delta;
	}
	/**
	 * @param delta the delta to set
	 */
	public void setDelta(ArrayList<String> delta) {
		this.delta = delta;
	}
	
	

}
