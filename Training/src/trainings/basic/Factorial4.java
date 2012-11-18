package trainings.basic;
import java.math.BigInteger;
import java.util.ArrayList;

public class Factorial4 {

	protected static ArrayList<BigInteger> _cache = new ArrayList<BigInteger>();
	
	static {
		_cache.add(BigInteger.valueOf(1));
	};
	
	public synchronized BigInteger factorial (int x) throws Exception  {
		if (x < 0)
			throw new Exception("too low X value");
		
		for (int size = _cache.size(); size <= x; size++) {
			BigInteger lastVal = _cache.get(size - 1);
			BigInteger nextVal = lastVal.multiply(BigInteger.valueOf(size));
			_cache.add(nextVal);
		}
		
		return _cache.get(x);
	}
	
	
	
}
