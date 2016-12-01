package huffmanNextLevel;

public class Node extends Tree{
	private Tree leftLeaf;

	private Tree rightLeaf;
	
	public Node(double probability, Tree leftLeaf, Tree rightLeaf){
//		setCnt(cnt);
		this.setProbability(probability);
		this.leftLeaf  = leftLeaf;
		this.setRightLeaf(rightLeaf);
	}
	
	public Tree getLeftLeaf() {
		return leftLeaf;
	}

	public void setLeftLeaf(Tree leftLeaf) {
		this.leftLeaf = leftLeaf;
	}

	public Tree getRightLeaf() {
		return rightLeaf;
	}

	public void setRightLeaf(Tree rightLeaf) {
		this.rightLeaf = rightLeaf;
	}


}
