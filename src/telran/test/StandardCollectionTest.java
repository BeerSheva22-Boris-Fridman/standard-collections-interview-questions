package telran.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.structure.MultiCounters_TreeSet;
import telran.structure.MultiCounters_programm;
import telran.util.StackInt;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StandardCollectionTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Disabled
	void SubListtest() {
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 70, -20));
		list.add(5);
		List<Integer> listSub = list.subList(6, 9);

		System.out.println(listSub);
		listSub.add(1, -2);
		listSub.sort(Integer::compare);
		listSub.clear();
		System.out.println(list);

	}

	@Test
	@Disabled
	void displayOccurrencesCount() {
		String[] strings = { "lmn", "abc", "abc", "lmn", "a", "lmn" };
		Arrays.stream(strings).collect(Collectors.groupingBy(s -> s, Collectors.counting())).entrySet().stream()
				.sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
				.forEach(e -> System.out.printf("%s: %d\n", e.getKey(), e.getValue()));
	}

	@Test
	void displayDigitStatistics() {

		// IntStream.range(0, 10).boxed().sorted((d1, d2) -> -(new Random().ints(1,
		// Integer.MAX_VALUE)
//		Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).sorted((d1, d2) -> -(new Random().ints(1, Integer.MAX_VALUE)
//	    		.limit(1_000_000).flatMap(n -> String.valueOf(n).chars()).filter(c -> c == (char)(d1 + '0'))
//	    	    .toArray().length - new Random().ints(1, Integer.MAX_VALUE).limit(1_000_000)
//	    	    .flatMap(n -> String.valueOf(n).chars()).filter(c -> c == (char)(d2 + '0')).toArray().length))
//	            .forEach(d -> System.out.printf("%d: %d\n", d, new Random().ints(1, Integer.MAX_VALUE)
//	            .limit(1_000_000).flatMap(n -> String.valueOf(n).chars()).filter(c -> c == (char)(d + '0')).toArray().length));
		new Random().ints(1_000_000, 1, Integer.MAX_VALUE).flatMap(n -> Integer.toString(n).chars()).boxed()
				.collect(Collectors.groupingBy(digit -> digit, Collectors.counting())).entrySet().stream()
				.sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
				.forEach(e -> System.out.printf("%d: %d\n", e.getKey() - '0', e.getValue()));
		;
	}

	@Test
	void testPush() {
		StackInt stack = new StackInt();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		assertFalse(stack.isEmpty());
	}

	@Test
	void testPop() {
		StackInt stack = new StackInt();
		assertThrows(NoSuchElementException.class, stack::pop);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		assertEquals(3, stack.pop());
		assertEquals(2, stack.pop());
		assertEquals(1, stack.pop());
		assertThrows(NoSuchElementException.class, stack::pop);
	}

	@Test
	void testIsEmpty() {
		StackInt stack = new StackInt();
		assertTrue(stack.isEmpty());
		stack.push(1);
		assertFalse(stack.isEmpty());
		stack.pop();
		assertTrue(stack.isEmpty());
	}

	@Test
	void testGetMax() {
		StackInt stack = new StackInt();
		assertThrows(NoSuchElementException.class, stack::getMax);
		// stack.push(1);
		// assertEquals(1, stack.getMax());
		stack.push(2);
		assertEquals(2, stack.getMax());
		stack.push(1);
		assertEquals(2, stack.getMax());
		stack.pop();
		assertEquals(2, stack.getMax());
		stack.pop();
		assertEquals(1, stack.getMax());
		stack.pop();
		assertThrows(NoSuchElementException.class, stack::getMax);
	}

	@Test
	void maxNumberWithNegativeImageTest() {
		int ar[] = { 100000, 3, -2, -200, 200, -3, 2 };
		int ar1[] = { 100000, 1, -2, 200, -3, 2 };
		assertEquals(200, maxNumberWithNegativeImage1(ar));
		assertEquals(-1, maxNumberWithNegativeImage1(ar1));
	}

	private Integer maxNumberWithNegativeImage1(int[] ar) {
		int max = 0;
		for (int i = 1; i < ar.length; i++) {
			if (ar[i] > max) {
				max = ar[i];
			}
		}
		for (int i = 1; i < ar.length; i++) {
			if (ar[i] + max == 0) {
				return max;
			}
		}

		return -1;
	}
	int maxNumberWithNegativeImage(int[] ar) {
		Set<Integer> set = new HashSet<>();
		int res = -1;
		boolean add = true;
		
		for (int i = 0; i < ar.length; i++) {
		
			if (ar[i] > 0) {
				add = set.add(ar[i]);
				if(!add) {
					if (ar[i]>res) {
						res = ar[i];
					}
				}
			}
			if (ar[i] < 0) {
				add = set.add(-ar[i]);
				if (!add) {
					if(-ar[i] > res) {
					res = -ar[i];
					}
				}
			}
		}
		
		return res;
	}
	@Test
	void addMultiCountersTest() {
		MultiCounters_TreeSet test = new MultiCounters_TreeSet();
		String item = "Vasja";
		String item1= "Vasja1";
		String item2= "Vasja2";
		test.addItem(item2);
		int res = test.addItem(item2);
		assertEquals(1, test.addItem(item));
		assertEquals(1, test.addItem(item1));
		assertEquals(2, res);
		}
	
	@Test
	void addMultiCountersTest1() {
		MultiCounters_TreeSet test = new MultiCounters_TreeSet();
		test.addItem("Vasja");
		test.addItem("Vasja");
		test.addItem("Vasja");
		test.addItem("Petja");
		test.addItem("Petja");
		test.addItem("Masha");
		test.addItem("Kolja");
		test.addItem("Kolja");
	
		}
	
	
	@Test
	void setMaxMultiCountersTest() {
		MultiCounters_programm test = new MultiCounters_programm();
		String Vasja= "Vasja";
		String Dima= "Dima";
		String Petya= "Petya";
		String Kolja= "Kolja";
		test.addItem(Vasja);
		test.addItem(Vasja);
		test.addItem(Vasja);
		test.addItem(Dima);
		test.addItem(Dima);
		test.addItem(Dima);
		test.addItem(Petya);
		test.addItem(Kolja);
		Set <Object> test1 = new HashSet<>();
		test1.add(Vasja);
		test1.add(Dima);
		assertEquals(test1, test.getMaxItems());
			}
	
	@Test
	void treeIteratingTest() {
		Integer[] array = {1, 11, 111, 32, 9, 1234, 99, 992};
		TreeSet<Integer> tree = createAndIterateTreeInOrder(array);
		Integer[] result = tree.toArray(new Integer[] {});
		assertArrayEquals(array, result);
	}
	private TreeSet<Integer> createAndIterateTreeInOrder(Integer[] array) {

//		TreeSet<Integer> tree = new TreeSet<Integer>(new digirSummComparator());
		TreeSet<Integer> tree = new TreeSet<Integer>((a,b) -> {return digitsSum(a) - digitsSum(b);});
		for (Integer num : array) {
			tree.add(num);
		}
		return tree;
	}
//	public class digirSummComparator implements Comparator<Integer> {
//
//		@Override
//		public int compare(Integer o1, Integer o2) {
//			
//			return digitsSum(o1) -digitsSum(o2);
//		}
//
//	}
	private int digitsSum(int number) {
		int result = 0;
		do {
			result += number % 10;
			number /= 10;
		} while (number != 0);
		return result;
	}
}
