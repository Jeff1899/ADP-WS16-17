import java.util.LinkedList;
import java.util.List;

public class PufferLinkedList extends PufferAbstract {
	
	List<String> pufferList = new LinkedList<String>();

	@Override
	protected boolean private_push(String value) {
		if(pufferList.size() < MAX_PUFFER){
			pufferList.add(value);
			return true;
		}
		return false;
	}

	@Override
	protected String private_pop() {
		String value = pufferList.get(0);
		pufferList.remove(0);
		return value;
	}

	@Override
	protected String private_peek() {
		return pufferList.get(0);
	}

	@Override
	protected boolean private_contains(String value) {
		return pufferList.contains(value);
	}

	@Override
	protected int private_size() {
		return pufferList.size();
	}

	@Override
	protected boolean private_isEmpty() {
		return pufferList.isEmpty();
	}
	

}
