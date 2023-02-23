package telran.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.util.StackInt;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class StandardCollectionTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Disabled
	void SubListtest() {
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,70,-20));
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
		String [] strings = {"lmn", "abc", "abc", "lmn", "a", "lmn"};
		Arrays.stream(strings)
				.collect(Collectors.groupingBy(s -> s,Collectors.counting()))
				.entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
				.forEach(e -> System.out.printf("%s: %d\n", e.getKey(), e.getValue()));
	}
	@Test
	void displayDigitStatistics() {
		
	   // IntStream.range(0, 10).boxed().sorted((d1, d2) -> -(new Random().ints(1, Integer.MAX_VALUE)
		Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).sorted((d1, d2) -> -(new Random().ints(1, Integer.MAX_VALUE)
	    		.limit(1_000_000).flatMap(n -> String.valueOf(n).chars()).filter(c -> c == (char)(d1 + '0'))
	    	    .toArray().length - new Random().ints(1, Integer.MAX_VALUE).limit(1_000_000)
	    	    .flatMap(n -> String.valueOf(n).chars()).filter(c -> c == (char)(d2 + '0')).toArray().length))
	            .forEach(d -> System.out.printf("%d: %d\n", d, new Random().ints(1, Integer.MAX_VALUE)
	            .limit(1_000_000).flatMap(n -> String.valueOf(n).chars()).filter(c -> c == (char)(d + '0')).toArray().length));
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
	        //stack.push(1);
	     //   assertEquals(1, stack.getMax());
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
	}
