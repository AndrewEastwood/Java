package trainings.custom.wildcards;

public class SomeA<T> extends SomeBase<T> {

	protected String _propA = "Some Class A";

	/* (non-Javadoc)
	 * @see trainings.custom.wildcards.AbstractSomeBase#getObjectInfo()
	 */
	@Override
	public String getObjectInfo() {
		// TODO Auto-generated method stub
		return this._propA;
	}
	
}
