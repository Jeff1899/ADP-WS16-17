package huffmanNextLevel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Huffi{
	
	private String input = "1000011010";
//	private String input = "01010101010101010101";
	private State startState;
	
	private Map<String,String> kompirMap = new HashMap<String, String>();
	
	public Huffi(){
		prepareHuffman();
		String output = komprimiere(startState);
		dekomprimieren(startState, output);
//		String decodiert = komprimiere(node);
//		
//		dekomprimieren(node,decodiert);
	}
	
	private void dekomprimieren(State startState, String input) {
		// TODO Auto-generated method stub
		System.out.println();
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
		
		System.out.println("DEKOMPRIMIER " + encoder);
		
	}

	private String komprimiere(State startState) {
		String decoder = "";
		String value = "";
		
		System.out.println("INPUT " + input);
		Tree node = startState.getNode();
		while(input.length() > 0){
			String str = input.substring(0,2);
			input = input.substring(2);
			
			decoder = decoder + getDecodeStr(str,(Node)node);
		}
		
		System.out.println("KOMPRIMIERT " + decoder);
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
