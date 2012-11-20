package trainings.custom.boxes;

import java.util.LinkedList;

public class BoxContainer<T> implements IBox<T> {

	private LinkedList<T> _content = new LinkedList<T>();

	@Override
	public void putContent(T c) {
		_content.push(c);
	}

	@Override
	public T popContent() {
		if (!_content.isEmpty())
			return _content.pop();
		return null;
	}
	
	public boolean isEmpty() {
		return _content.isEmpty();
	}

	@Override
	public int size() {
		return _content.size();
	}

}
