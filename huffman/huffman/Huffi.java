package huffman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Huffi{
	private Map<String,Integer> halbByte = new HashMap<String, Integer>();
	private List<Leaf> leafList = new ArrayList<Leaf>();
	private static final int PERMUTATION = 8;
	
	private List<Tree> treeList = new ArrayList<Tree>();
	private String input;
	
	private Map<String,String> kompirMap = new HashMap<String, String>();
	
	public Huffi(){
		initLeafList();
		prepareHuffman();	
		Node node = buildTree();
		String decodiert = komprimiere(node);
		
		dekomprimieren(node,decodiert);
	}
	
	private void dekomprimieren(Node node, String decodiert) {
		// TODO Auto-generated method stub
		String encoder = "";
		String input = "";
		int idx = 0;
		String temp = "";
		for(int i = 1; i <= decodiert.length(); i ++){
			input = decodiert.substring(idx, i);
			if(kompirMap.containsKey(input)){
//				System.out.println(input + " to " + kompirMap.get(input));
//				System.out.println(input);
				encoder = encoder + kompirMap.get(input);
				idx = i;
				temp = temp + input;
				input = "";
				
			}
		}
		encoder = encoder + input;
		System.out.println("DEKOMPRIMIERT");
		System.out.println(encoder);
		
	}

	private String komprimiere(Tree node) {
		String decoder = "";
		String value = "";
		System.out.println("INPUT");
		System.out.println(input);
		String sub = input;
		Node start = (Node) node;
		while(sub.length() > 0){
			if(sub.substring(0, 1).equals("1")){
				node = ((Node)node).getLeftLeaf();
				value = value + "1";
			}
			else{
				node = ((Node)node).getRightLeaf();
				value = value + "0";
			}
			sub = sub.substring(1);
			
			if(node instanceof Leaf){
				kompirMap.put(((Leaf)node).getContent(), value );
				
				decoder = decoder + (((Leaf)node).getContent());
				value = "";
				node = start;
			}
		}
		decoder = decoder + value;
		System.out.println("KOMPRIMIERT");
		System.out.println(decoder);
		return decoder;
	}

	private Node buildTree(){
		// TODO Das geht bestimmt besser!
		while(!leafList.isEmpty() || (treeList.size() > 1)){
			Tree t1 = null;
			Tree t2 = null;
			if(!treeList.isEmpty()){
				// Holt kleinste Blätter aus LeafList
				if(leafList.size() > 1  && leafList.get(1).getCnt() <= treeList.get(0).getCnt()){
					t1 = leafList.remove(0);
					t2 = leafList.remove(0);
				}
				// Holt Nodes aus treeList
				else if(!leafList.isEmpty() && treeList.size() >= 2 && treeList.get(1).getCnt() < leafList.get(0).getCnt()){
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
			
			Node node = new Node(t1.getCnt() + t2.getCnt(), t1, t2);
			treeList.add(node);
		}
		
		return (Node) treeList.get(0);

	}
	
	private void prepareHuffman() {
		FileReader fr;
		try {
			fr = new FileReader("C:/Users/Jeff/Desktop/Projekte/Studium/Praktika_WS_16-17/AD-WS16-17/doc/hufman/data16384.txt");
			BufferedReader br = new BufferedReader(fr);
			String zeile = null; 
            while ((zeile = br.readLine()) != null) { 
            	input= zeile;
            } 
            String temp = null;
            String sub = input;
            while(sub.length() > 0){
            	temp = sub.substring(0, PERMUTATION);
            	sub = sub.substring(PERMUTATION);
            	halbByte.put(temp, halbByte.get(temp) + 1);
            }
            
            
            for (Entry<String, Integer> entry : halbByte.entrySet())
            {
                leafList.add(new Leaf(entry.getValue(), entry.getKey()));
            }
            sortTreeList();
            
		} catch (IOException e) {

			e.printStackTrace();
		}		
	}

	private void initLeafList(){
		for(int i = 0; i < (Math.pow(2, PERMUTATION)) ;i++){
			halbByte.put( String.format("%"+PERMUTATION+"s", Integer.toBinaryString(i)).replace(' ', '0'), 0);
		}
	}
	
	private void sortTreeList(){
		Collections.sort(leafList, new Comparator<Tree>() {

			 @Override
			    public int compare(Tree z1, Tree z2) {
			        if (z1.getCnt() > z2.getCnt())
			            return 1;
			        if (z1.getCnt() < z2.getCnt())
			            return -1;
			        return 0;
			    }
		});
	}
}
