package trainings.custom.wildcards;

public class SomeBase<T> extends AbstractSomeBase<T> {

	@Override
	public T getName() {
		return this.name;
	}

	@Override
	public void setName(T name) {
		this.name = name;
	}

	@Override
	public String getObjectInfo() {
		// TODO Auto-generated method stub
		return "Base Object";
	}

}
