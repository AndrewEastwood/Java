package trainings.custom.one;

import java.util.ArrayList;

public class ObjectOne <T extends BaseObject> {

	private ArrayList<T> _list = new ArrayList<T>();

	public void addEntry (T sender) {
		this._list.add(sender);
	}
	
	public void printAll () {
		for(int i = 0;i<_list.size();i++)
			System.out.println("[ObjectOne] ID: (" + _list.get(i).printID() + "), VAL: \"" + _list.get(i).printValue() + "\"");
	}
	
}
