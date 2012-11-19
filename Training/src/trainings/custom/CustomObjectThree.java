package trainings.custom;

public class CustomObjectThree implements ICustomObject {
	
	private String objectName = "DEMO THREE";
	private final int objectID;

	public CustomObjectThree() {
		this.objectID = (int) Math.round(Math.random() * 100 + 1);
	}
	
	public CustomObjectThree(String objectName) {
		this();
		this.objectName = objectName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + objectID;
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
		if (!(obj instanceof CustomObjectThree))
			return false;
		CustomObjectThree other = (CustomObjectThree) obj;
		if (objectID != other.objectID)
			return false;
		if (objectName == null) {
			if (other.objectName != null)
				return false;
		} else if (!objectName.equals(other.objectName))
			return false;
		return true;
	}

	@Override
	public String getObjectName() {
		return objectName;
	}

	@Override
	public void setObjectName(String objectName) {
		this.objectName = objectName;

	}

}
