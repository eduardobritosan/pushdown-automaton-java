import java.util.ArrayList;
import java.util.Arrays;

public class Input {
	ArrayList<String> inputString;
	
	public Input(String input) {
		inputString = new ArrayList<String>(Arrays.asList(input.split("")));
		inputString.add("$");
	}

	/**
	 * @return the inputString
	 */
	public ArrayList<String> getInputString() {
		return inputString;
	}

	/**
	 * @param inputString the inputString to set
	 */
	public void setInputString(ArrayList<String> inputString) {
		this.inputString = inputString;
	}
	
	public String getElement(Integer index){
		return inputString.get(index);
	}
	
	public Integer getSize(){
		return (Integer) getInputString().size();
	}

}
