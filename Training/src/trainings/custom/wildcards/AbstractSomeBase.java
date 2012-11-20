package trainings.custom.wildcards;

public abstract class AbstractSomeBase<T> implements ISomeBase<T> {

	protected T name;

	public abstract String getObjectInfo();
	
}
