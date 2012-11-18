package trainings.basic;

public class Sorter {

	public static void sortDbl (double[] mas) {
		
		for (int i = 0; i < mas.length; i++) {
			int min = i;
			for (int j = i; j < mas.length; j++)
				if (mas[j] < mas[min]) min = j;
			
			double tmp;
			tmp = mas[i];
			mas[i] = mas[min];
			mas[min] = tmp;
		}
	}
	
	public static void testSortDbl () {
		double[] testMas = new double[10];
		for (int i = 0; i < 10; i++)
			testMas[i] = Math.round((Math.random() * 100));
		sortDbl(testMas);
		for (int i = 0; i < 10; i++)
			System.out.println("["+i+"] = " + testMas[i]);
		
	}
	
	
}
