
public class State {
	private String id;
	private boolean finalState;
	
	public State(String id, boolean finalState) {
		setId(id);
		setFinalState(finalState);
	}
	public State(String id){
		setId(id);
		setFinalState(false);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isFinalState() {
		return finalState;
	}
	public void setFinalState(boolean finalState) {
		this.finalState = finalState;
	}
	
	
}
