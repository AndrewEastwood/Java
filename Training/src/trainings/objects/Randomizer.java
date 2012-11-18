package trainings.objects;

public class Randomizer {

	static final int m = 233280;
	static final int a = 9301;
	static final int c = 49297;
	
	int seed = 1;
	
	public Randomizer (int seed) {this.seed = seed;}
	
	public float randomFloat () {
		seed = (seed * m + a ) % c;
		return (float)Math.abs((float)seed/(float)m);
	}
	
	public int randomInt (int max) {
		return Math.round(max * randomFloat());
	}
	
	// test class
	public static class Test {
		public static void main (String[] args){
			Randomizer rnd = new Randomizer((int)new java.util.Date().getTime());
			for (int i = 0; i < 10; i++) {
				System.out.println(rnd.randomInt(100));
			}
		}
	}
}
