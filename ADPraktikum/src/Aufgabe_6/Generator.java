import java.util.Dictionary;
import java.util.Random;

public class Generator {
	private int keyLimit;
	private double p;
	private double q;

	
	
	public Generator(int keyLimit, double p, double q) {
		this.keyLimit = keyLimit;
		this.p = p;
		this.q = q;
	}
	
	public void create(Dictionary d, int n){
		Random random = new Random();
		
		d.put(random.nextInt(keyLimit) + 1, random.nextInt());
		if(Math.random() > )
	}
}
