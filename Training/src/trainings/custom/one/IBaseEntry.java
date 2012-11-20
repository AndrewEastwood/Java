package trainings.custom.one;

public interface IBaseEntry<V, ID> {

	public void setupValue(V value);
	
	public V printValue();
	
	public void setupID(ID id);
	
	public ID printID();
	
}
