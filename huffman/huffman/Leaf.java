package huffman;

public class Leaf extends Tree{

	private String content;
	public Leaf(int cnt,String content){
		setCnt(cnt);
		this.setContent(content);
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
