package trainings.custom.boxes;

public interface IBox<T> {

	public void putContent(T c);
	public T popContent();
	public int size();
	public boolean isEmpty();
	
}
