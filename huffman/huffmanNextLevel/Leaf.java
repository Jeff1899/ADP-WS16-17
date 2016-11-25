package huffmanNextLevel;

public class Leaf extends Tree{

	private String content;
	private State state;
	
	public Leaf(double probability,String content,State state){
		this.setProbability(probability);
		this.setContent(content);
		this.setState(state);
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
}
