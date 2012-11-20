package trainings.custom;

public class MyGenericBase<T> {

	private T value;
	
	/**
	 * @return the value
	 */
	public T getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(T value) {
		this.value = value;
	}


	public MyGenericBase() { }
	
	public MyGenericBase(T value) {
		this.value = value;
	}

}
