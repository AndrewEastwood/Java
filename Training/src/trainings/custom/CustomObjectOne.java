package trainings.custom;

public class CustomObjectOne implements ICustomObject {

	private String objectName = "";
	
	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	private static CustomObjectOne _inst;
	
	static {
		System.out.println("[CustomObjectOne] Static Init Running;");
		_inst = null;
	}
	
	{
		System.out.println("[CustomObjectOne] Public Init Running;");
	}
	
	private CustomObjectOne () {
		System.out.println("[CustomObjectOne] Constructor Running;");
	}
	
	public static CustomObjectOne getInstance() {
		System.out.println("[CustomObjectOne] getInstance() Running;");
		if (_inst == null)
			_inst = new CustomObjectOne();
		
		return _inst;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((objectName == null) ? 0 : objectName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomObjectOne other = (CustomObjectOne) obj;
		if (objectName == null) {
			if (other.objectName != null)
				return false;
		} else if (!objectName.equals(other.objectName))
			return false;
		return true;
	}
	
	
	
}
