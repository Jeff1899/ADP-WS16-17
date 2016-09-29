/**
 * 
 * @author Patrick & Jeffrey
 *
 */
public class PufferTestObject extends PufferAbstract {

	@Override
	protected boolean private_push(String value) {
		return false;
	}

	@Override
	protected String private_pop() {
		return null;
	}

	@Override
	protected String private_peek() {
		return null;
	}

	@Override
	protected boolean private_contains(String value) {
		return false;
	}

	@Override
	protected int private_size() {
		return 0;
	}

	@Override
	protected boolean private_isEmpty() {

		return false;
	}

}
