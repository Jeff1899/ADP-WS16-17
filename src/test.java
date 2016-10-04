
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Puffer puffer = new Puffer();
		
		puffer.push("aaaa");
		puffer.push("vgh");
		System.out.println(puffer.pop());
		puffer.push("BBB");
		puffer.push("blk");
		System.out.println(puffer.peek());
		System.out.println(puffer.size());
//		System.out.println(puffer.size());

	}

}
