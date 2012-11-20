package trainings.custom.wildcards;

/**
 * @author admin1
 *
 */
public class SomeAB<T> extends SomeA<T> {
	
	protected String _propB = "Some Class B";

	/* (non-Javadoc)
	 * @see trainings.custom.wildcards.AbstractSomeBase#getObjectInfo()
	 */
	@Override
	public String getObjectInfo() {
		// TODO Auto-generated method stub
		return this._propB;
	}

}
