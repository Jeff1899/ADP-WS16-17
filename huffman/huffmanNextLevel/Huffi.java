package huffmanNextLevel;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Huffi{
	
//	private String input = "0001000011";
//	private String input = "10110100100010111010110001100101100101010101111110110000100010101100111011010100010001100101010010011110100100011001000010000101";
//	private String input =  "01101111010011010101100110001011100110001011101110011110111101011000010101001110010000100101011100001011001011001000111010111011";
		private String input = "01101100011011000110110001101100011011000110110001101100011011000110110001101100011011000110110001101100011011000110110001101100011011000110110001101100011011000110110001101100011011000110110001101100011011000110110001101100011011000110110001101100011011000110110001101100011011000110110001101100011011000110110001101100";
//	private String input = "01010101010101010101";
	private State startState;
	
	public Huffi(){
		prepareHuffman();
		String output = komprimiere(startState);
		String res = dekomprimieren(startState, output);
		System.out.println("Algorithmus erfolgreich ? " + input.equals(res));
//		String decodiert = komprimiere(node);
//		
//		dekomprimieren(node,decodiert);
	}
	
	private String dekomprimieren(State startState, String input) {
		// TODO Auto-generated method stub
		String encoder = "";
		Node  node = (Node)startState.getNode();
		while(input.length() > 0){
			if (input.substring(0, 1).equals("1")){
				if(node.getLeftLeaf() instanceof Leaf){
					Leaf l = (Leaf)node.getLeftLeaf();
					encoder = encoder + l.getContent();
					node = l.getState().getNode();
				}
				else{
					node = (Node)node.getLeftLeaf();
				}
				input = input.substring(1);
			}
			else
			{
				if(node.getRightLeaf() instanceof Leaf){
					Leaf l = (Leaf)node.getRightLeaf();
					encoder = encoder + l.getContent();
					node = l.getState().getNode();
				}else{
					node = (Node)node.getRightLeaf();
				}
				input = input.substring(1);
			}
		}
		
		System.out.println("DEK	: " + encoder);
		return encoder;
	}

	private String komprimiere(State startState) {
		String decoder = "";
		String value = "";
		String inp = input;
		System.out.println("INP	: " + inp);
		Tree startNode = startState.getNode();
		Node node = (Node)startNode;
		while(inp.length() > 0){
			String str = inp.substring(0,2);
			inp = inp.substring(2);
			
//			decoder = decoder + getDecodeStr(str,(Node)node);
			
			Leaf l = (Leaf)node.getRightLeaf();
			// Left Leaf
			if(str.equals(l.getContent())){
				decoder = decoder + "0";
				node = l.getState().getNode();
				continue;
			}
			node = (Node) node.getLeftLeaf();
			
			//Right Node
			if(node.getRightLeaf() instanceof Node){
				l = (Leaf)node.getLeftLeaf();
				if(str.equals(l.getContent())){
					decoder = decoder + "11";
					node = l.getState().getNode();
					continue;
					
				}
				node = (Node) node.getRightLeaf();
				
				l = (Leaf)node.getLeftLeaf();
				if(str.equals(l.getContent())){
					decoder = decoder + "101";
					node = l.getState().getNode();
					continue;
				}
				l = (Leaf)node.getRightLeaf();
				if(str.equals(l.getContent())){
					
					node = l.getState().getNode();
					decoder = decoder + "100";
					continue;
				}
			}
			else{
				l = (Leaf)node.getRightLeaf();
				if(str.equals(l.getContent())){
					decoder = decoder + "10";
					node = l.getState().getNode();
					continue;
				}
				node = (Node) node.getLeftLeaf();
				l = (Leaf)node.getLeftLeaf();
				
				if(str.equals(l.getContent())){
					decoder = decoder + "111";
					node = l.getState().getNode();
					continue;
				}
				l = (Leaf)node.getRightLeaf();
				if(str.equals(l.getContent())){
					decoder = decoder + "110";
					node = l.getState().getNode();
					continue;
				}
			}
			
			
			
		}
		
		System.out.println("KOM	: " + decoder);
		return decoder;
	}

	private String getDecodeStr(String str, Node node) {
		String res = null;
		Leaf l = (Leaf)node.getRightLeaf();
		// Left Leaf
		if(str.equals(l.getContent())){
			return "0";
		}
		node = (Node) node.getLeftLeaf();
		
		//Right Node
		if(node.getRightLeaf() instanceof Node){
			l = (Leaf)node.getLeftLeaf();
			if(str.equals(l.getContent())){
				return "11";
			}
			node = (Node) node.getRightLeaf();
			
			l = (Leaf)node.getLeftLeaf();
			if(str.equals(l.getContent())){
				return "101";
			}
			l = (Leaf)node.getRightLeaf();
			if(str.equals(l.getContent())){
				
				node = l.getState().getNode();
				return "100";
			}
		}
		else{
			l = (Leaf)node.getRightLeaf();
			if(str.equals(l.getContent())){
				return "10";
			}
			node = (Node) node.getLeftLeaf();
			l = (Leaf)node.getLeftLeaf();
			
			if(str.equals(l.getContent())){
				return "111";
			}
			l = (Leaf)node.getRightLeaf();
			if(str.equals(l.getContent())){
				return "110";
			}
		}
		
		return res;
	}

	private Node buildTree(ArrayList<Leaf> leafList){
		// TODO Das geht bestimmt besser!
		ArrayList<Tree> treeList = new ArrayList<Tree>();
		while(!leafList.isEmpty() || (treeList.size() > 1)){
			Tree t1 = null;
			Tree t2 = null;
			if(!treeList.isEmpty()){
				// Holt kleinste Bl�tter aus LeafList
				if(leafList.size() > 1  && leafList.get(1).getProbability() <= treeList.get(0).getProbability()){
					t1 = leafList.remove(0);
					t2 = leafList.remove(0);
				}
				// Holt Nodes aus treeList
				else if(!leafList.isEmpty() && treeList.size() >= 2 && treeList.get(1).getProbability() < leafList.get(0).getProbability()){
					t1 = treeList.remove(0);
					t2 = treeList.remove(0);	
				}
//				 Holt aus beiden Listen das kleinste Element
				else if(!leafList.isEmpty()){
					t1 = leafList.remove(0);
					t2 = treeList.remove(0);
				}
				else{
					t1 = treeList.remove(0);
					t2 = treeList.remove(0);
				}
			}
			else{
				t1 = leafList.remove(0);
				t2 = leafList.remove(0);
			}
			Node node = null;
			if(t1.getProbability() > t2.getProbability()){
				 node = new Node(t1.getProbability() + t2.getProbability(), t2, t1);
			}else{
				 node = new Node(t1.getProbability() + t2.getProbability(), t1, t2);
			}
			treeList.add(node);
		}
		
		return (Node) treeList.get(0);

	}
	
	private void prepareHuffman() {

		// Erstelle Zustände
		State q0 = new State();
		startState = q0;
		State q1 = new State();
		State q2 = new State();
		State q3 = new State();
		
		ArrayList<Leaf> q0LeafList = new ArrayList<Leaf>();
		q0LeafList.add(new Leaf(0.05, "00", q0));
		q0LeafList.add(new Leaf(0.85, "01", q1));
		q0LeafList.add(new Leaf(0.05, "10", q2));
		q0LeafList.add(new Leaf(0.05, "11", q3));
		q0.setNode(buildTree(sortTreeList(q0LeafList)));
		
		ArrayList<Leaf> q1LeafList = new ArrayList<Leaf>();
		q1LeafList.add(new Leaf(0.05, "00", q0));
		q1LeafList.add(new Leaf(0.20, "01", q1));
		q1LeafList.add(new Leaf(0.70, "10", q2));
		q1LeafList.add(new Leaf(0.05, "11", q3));
		q1.setNode(buildTree(sortTreeList(q1LeafList)));
		
		ArrayList<Leaf> q2LeafList = new ArrayList<Leaf>();
		q2LeafList.add(new Leaf(0.10, "00", q0));
		q2LeafList.add(new Leaf(0.10, "01", q1));
		q2LeafList.add(new Leaf(0.10, "10", q2));
		q2LeafList.add(new Leaf(0.70, "11", q3));
		q2.setNode(buildTree(sortTreeList(q2LeafList)));
		
		ArrayList<Leaf> q3LeafList = new ArrayList<Leaf>();
		q3LeafList.add(new Leaf(0.65, "00", q0));
		q3LeafList.add(new Leaf(0.15, "01", q1));
		q3LeafList.add(new Leaf(0.15, "10", q2));
		q3LeafList.add(new Leaf(0.05, "11", q3));
		q3.setNode(buildTree(sortTreeList(q3LeafList)));
		
		
//            double matrix[][] = {
//            		 { 0.05, 0.85, 0.05, 0.05 }, 
//            		 { 0.05, 0.20, 0.70, 0.05 }, 
//            		 { 0.10, 0.10, 0.10, 0.70 }, 
//            		 { 0.65, 0.15, 0.15, 0.05 }
//            	     };
//            
//            for(int i = 0; i < matrix.length ; i++){
//            	System.out.println(Arrays.toString(matrix[i]));
//            }
	}

//	private void initLeafList(){
//		for(int i = 0; i < (Math.pow(2, PERMUTATION)) ;i++){
//			halbByte.put( String.format("%"+PERMUTATION+"s", Integer.toBinaryString(i)).replace(' ', '0'), 0);
//		}
//	}
	
	private ArrayList<Leaf> sortTreeList(ArrayList<Leaf> leafList){
		Collections.sort(leafList, new Comparator<Tree>() {

			 @Override
			    public int compare(Tree z1, Tree z2) {
			        if (z1.getProbability() > z2.getProbability())
			            return 1;
			        if (z1.getProbability() < z2.getProbability())
			            return -1;
			        return 0;
			    }
		});
		return leafList;
	}
}
