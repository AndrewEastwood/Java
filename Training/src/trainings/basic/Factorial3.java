package trainings.basic;

public class Factorial3 {
	/**
	 * @throws Exception ***/

	static long[] table = new long[21];
	static {table[0] = 1;};
	static int last = 0;
	public long factorial (int x) throws Exception {
		if (x > 20) 
			throw new Exception("too large X value");
		if (x < 0)
			throw new Exception("too low X value");
		
		while(last < x) {
			table[last + 1] = table[last] * (last + 1);
			last++;
		}
		
		return table[x];
	}
}
