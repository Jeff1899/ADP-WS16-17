import java.util.Arrays;

public class Puffer extends PufferAbstract{

	private String [] pufferArr = new String [MAX_PUFFER];

	protected boolean private_push(String value) {
		for(int i = 0;i < MAX_PUFFER ;i++){
			if(pufferArr[i] == null ){
				pufferArr[i] = value;
				System.out.println(Arrays.toString(pufferArr));
				return true;
			}
		}
		return false;
	}

	@Override
	protected String private_pop() {
		String value = pufferArr[0];
		pufferArr = Arrays.copyOf(Arrays.copyOfRange(pufferArr, 1, MAX_PUFFER), MAX_PUFFER);
		return value;
	}

	@Override
	protected String private_peek() {
		return pufferArr[0];
	}

	@Override
	protected boolean private_contains(String value) {
		for(int i = 0; i < pufferArr.length; i ++){
			if(pufferArr[i].equals(value)){
				return true;
			}
		}
		return false;
	}

	@Override
	protected int private_size() {
		for(int i = 0; i < MAX_PUFFER; i ++){
			if(pufferArr[i] == null){
				return i;
			}
		}
		return MAX_PUFFER;
	}

	@Override
	protected boolean private_isEmpty() {
		if(private_size() == 0){
			return true;
		}
		return false;
	}
}
