package huffman;

public abstract class Tree   {
	private int cnt;
	
	public Tree(){
		
	}
	
	public int getCnt(){
		return cnt;
	}

	public void setCnt(int cnt){
//		System.out.println(cnt);
		this.cnt = cnt;
	}
	
}
