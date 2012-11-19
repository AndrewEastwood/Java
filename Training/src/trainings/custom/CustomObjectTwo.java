package trainings.custom;

public class CustomObjectTwo implements ICustomObject  {

	private String objectName = "";
	
	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	private static CustomObjectTwo _inst;
	
	static {
		System.out.println("[CustomObjectTwo] Static Init Running;");
		_inst = null;
	}
	
	{
		System.out.println("[CustomObjectTwo] Public Init Running;");
	}
	
	private CustomObjectTwo () {
		System.out.println("[CustomObjectTwo] Constructor Running;");
	}
	
	public static CustomObjectTwo getInstance() {
		System.out.println("[CustomObjectTwo] getInstance() Running;");
		if (_inst == null)
			_inst = new CustomObjectTwo();
		
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
		CustomObjectTwo other = (CustomObjectTwo) obj;
		if (objectName == null) {
			if (other.objectName != null)
				return false;
		} else if (!objectName.equals(other.objectName))
			return false;
		return true;
	}

}
