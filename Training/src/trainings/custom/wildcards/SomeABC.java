package trainings.custom.wildcards;

public class SomeABC<T> extends SomeAB<T> {
	protected String _propC = "Some Class C";

	/* (non-Javadoc)
	 * @see trainings.custom.wildcards.AbstractSomeBase#getObjectInfo()
	 */
	@Override
	public String getObjectInfo() {
		// TODO Auto-generated method stub
		return this._propC;
	}
}
