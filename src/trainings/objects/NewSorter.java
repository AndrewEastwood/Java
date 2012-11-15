package trainings.objects;

import java.text.Collator;
import java.text.CollationKey;
import java.util.Locale;

import sun.misc.Compare;

public class NewSorter {

	public static interface Comparer {
		// if a == b return 0
		// if a > b return 1
		// if a < b return -1
		public int compare(Object a, Object b);
	}

	public static interface Comparable {
		// if a == b return 0
		// if a > b return 1
		// if a < b return -1
		public int compareTo(Object other);
	}

	private static Comparer ascii_comparer = new Comparer() {

		@Override
		public int compare(Object a, Object b) {
			// TODO Auto-generated method stub
			return ((String) a).compareTo((String) b);
		}
	};

	private static Comparer comparable_comparer = new Comparer() {

		@Override
		public int compare(Object a, Object b) {
			// TODO Auto-generated method stub
			return ((Comparable) a).compareTo(b);
		}
	};

	public static void sortAscii(String[] a) {
		sort(a, null, 0, a.length - 1, true, ascii_comparer);

	}

	public static void sort(String[] a, int from, int to, boolean up,
			boolean ignoreCase, Locale locale) {

		if (a == null || a.length < 2)
			return;
		Collator c;
		if (locale == null)
			c = Collator.getInstance();
		else
			c = Collator.getInstance(locale);

		if (ignoreCase)
			c.setStrength(Collator.SECONDARY);
		
		CollationKey[] b = new CollationKey[a.length];
		for (int i = 0; i< a.length; i++)
			b[i] = c.getCollationKey(a[i]);
		
		Comparer comp = new Comparer() {
			
			@Override
			public int compare(Object a, Object b) {
				// TODO Auto-generated method stub
				return ((CollationKey)a).compareTo((CollationKey)b);
			}
		};
		
		sort(a, b, from, to, up, comp);
	}

	// general method
	public static void sort(Object[] a, Object[] b, int from, int to,
			boolean up, Comparer c) {
		if (a == null || a.length < 2)
			return;

		int i = from;
		int j = to;
		Object center = a[(from + to) / 2];
		// main loop
		do {
			// ascending mode
			// 1,2,3,4 ...
			if (up) {
				while (i < to && c.compare(center, a[i]) > 0)
					i++;
				while (j > from && c.compare(center, a[j]) < 0)
					j--;
			} else {
				// descending mode
				// ... 4.3.2.1
				while (i < to && c.compare(center, a[i]) < 0)
					i++;
				while (j > from && c.compare(center, a[j]) > 0)
					j--;
			}
			if (i < j) {
				Object tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
				if (b != null) {
					tmp = b[i];
					b[i] = b[j];
					b[j] = tmp;
				}
			}
			if (i <= j) {
				i++;
				j--;
			}

		} while (i <= j);

		// sort te rests
		if (from < j)
			sort(a, b, from, j, up, c);
		if (i < to)
			sort(a, b, i, to, up, c);

	}

}
