package starts.other;
import java.util.List;
import java.util.ArrayList;

public class otherFns {


	public otherFns() {}
	public otherFns(int s) {
		this.initList(s);
	}
	
	private List<Integer> _lsOne;
	
	/**
	 * @return the _lsOne
	 */
	public List<Integer> get_lsOne() {
		return _lsOne;
	}

	/**
	 * @param _lsOne the _lsOne to set
	 */
	public void set_lsOne(List<Integer> _lsOne) {
		this._lsOne = _lsOne;
	}

	public boolean initList (int size) {
		this._lsOne = new ArrayList<Integer>(size);
		
		for (int i = 0 ; i < size; i++)
			this._lsOne.add(i);
		
		
		/*for (Integer elem: this._lsOne){
			elem = 12345;
		}*/
		
		
		return false;
	}
	
	public void printAll () {
		for (int i = 0; i<this.get_lsOne().size();i++)
			System.out.println("List value = " + this.get_lsOne().get(i));
	}
	

	
}
