package huffmanNextLevel;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Huffi{
	
//	private String input = "0001000011";
//	private String input = "10110100100010111010110001100101100101010101111110110000100010101100111011010100010001100101010010011110100100011001000010000101";
	private String input =  "01101111010011010101100110001011100110001011101110011110111101011000010101001110010000100101011100001011001011001000111010111011";
//	private String input = "01101100011011000110110001101100011011000110110001101100011011000110110001101100011011000110110001101100011011000110110001101100011011000110110001101100011011000110110001101100011011000110110001101100011011000110110001101100011011000110110001101100011011000110110001101100011011000110110001101100011011000110110001101100";
//	private String input = "01010101010101010101";
	private State startState;
	
	public Huffi(){
		int[][] probabilitys = analyseHuffman();
		prepareHuffman(probabilitys);
		String output = komprimiere(startState);
//		String res = dekomprimieren(startState, output);
//		System.out.println("Algorithmus erfolgreich -> " + input.equals(res));
//		System.out.println("Kompressionsrate -> " + berechneKompressionsrate(input, output) + " %");
	}

	private int berechneKompressionsrate(String in, String out) {
		return (out.length()*100) / in.length();
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
	
	private void prepareHuffman(int[][] probs) {
		// Erstelle Zustände
		State q0 = new State();
		startState = q0;
		State q1 = new State();
		State q2 = new State();
		State q3 = new State();

		ArrayList<Leaf> q0LeafList = new ArrayList<Leaf>();
		q0LeafList.add(new Leaf(probs[0][0]/100, "00", q0));
		q0LeafList.add(new Leaf(probs[0][1]/100, "01", q1));
		q0LeafList.add(new Leaf(probs[0][2]/100, "10", q2));
		q0LeafList.add(new Leaf(probs[0][3]/100, "11", q3));
		q0.setNode(buildTree(sortTreeList(q0LeafList)));

		ArrayList<Leaf> q1LeafList = new ArrayList<Leaf>();
		q1LeafList.add(new Leaf(probs[1][0]/100, "00", q0));
		q1LeafList.add(new Leaf(probs[1][1]/100, "01", q1));
		q1LeafList.add(new Leaf(probs[1][2]/100, "10", q2));
		q1LeafList.add(new Leaf(probs[1][3]/100, "11", q3));
		q1.setNode(buildTree(sortTreeList(q1LeafList)));

		ArrayList<Leaf> q2LeafList = new ArrayList<Leaf>();
		q2LeafList.add(new Leaf(probs[2][0]/100, "00", q0));
		q2LeafList.add(new Leaf(probs[2][1]/100, "01", q1));
		q2LeafList.add(new Leaf(probs[2][2]/100, "10", q2));
		q2LeafList.add(new Leaf(probs[2][3]/100, "11", q3));
		q2.setNode(buildTree(sortTreeList(q2LeafList)));

		ArrayList<Leaf> q3LeafList = new ArrayList<Leaf>();
		q3LeafList.add(new Leaf(probs[3][0]/100, "00", q0));
		q3LeafList.add(new Leaf(probs[3][1]/100, "01", q1));
		q3LeafList.add(new Leaf(probs[3][2]/100, "10", q2));
		q3LeafList.add(new Leaf(probs[3][3]/100, "11", q3));
		q3.setNode(buildTree(sortTreeList(q3LeafList)));
	}

	private int[][] analyseHuffman() {
		ArrayList<ArrayList<String>> wordsFromQ0 = gebeWoerterAbZustand(0);
		ArrayList<ArrayList<String>> wordsFromQ1 = gebeWoerterAbZustand(1);
		ArrayList<ArrayList<String>> wordsFromQ2 = gebeWoerterAbZustand(2);
		ArrayList<ArrayList<String>> wordsFromQ3 = gebeWoerterAbZustand(3);

		int[][] probabilitys = new int[4][4];

		probabilitys[0] = getProbabilityOf(wordsFromQ0);
		probabilitys[1] = getProbabilityOf(wordsFromQ1);
		probabilitys[2] = getProbabilityOf(wordsFromQ2);
		probabilitys[3] = getProbabilityOf(wordsFromQ3);

		return probabilitys;
	}

	private int[] getProbabilityOf(ArrayList<ArrayList<String>> wordsFromQ) {
		int[] probability = new int[4];
		int q0 = 1;
		int q1 = 1;
		int q2 = 1;
		int q3 = 1;
		for(ArrayList<String> word : wordsFromQ){
			if(word.get(0).equals("00")){
				q0++;
			} else if (word.get(0).equals("01")){
				q1++;
			} else if (word.get(0).equals("10")){
				q2++;
			} else if (word.get(0).equals("11")){
				q3++;
			}
		}
		int total = q0 + q1 + q2 + q3;

		probability[0] = (100 * q0) / total;
		probability[1] = (100 * q1) / total;
		probability[2] = (100 * q2) / total;
		probability[3] = (100 * q3) / total;

		while ((probability[0] + probability[1] + probability[2] + probability[3]) < 100){
			probability[0]++;
		}
		while ((probability[0] + probability[1] + probability[2] + probability[3]) > 100){
			probability[0]--;
		}

		System.out.println(probability[0] +" " + probability[1] +" " + probability[2] +" " + probability[3]);

		return probability;
	}

	private ArrayList<ArrayList<String>> gebeWoerterAbZustand(int q){
		String signOfQ = "";
		switch (q){
			case 0:
				signOfQ = "00";
				break;
			case 1:
				signOfQ = "01";
				break;
			case 2:
				signOfQ = "10";
				break;
			case 3:
				signOfQ = "11";
				break;

		}

		String inputA = input;
		ArrayList<ArrayList<String>> in = new ArrayList<>();
		for (int i = 0 ; i+2 < inputA.length(); i=i+2){
			if (inputA.substring(i,i+2).equals(signOfQ)){
				ArrayList<String> word = new ArrayList<>();
				for(int j = 0; j<i+1 ; j=j+2){
					word.add(inputA.substring(j,j+2));
				}
				in.add(word);
				inputA = inputA.substring(i+2, inputA.length());
				i = 0;
				System.out.println(word.toString());
			}
		}
		if (!in.isEmpty())
			in.remove(0);
		return in;
	}
	
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
