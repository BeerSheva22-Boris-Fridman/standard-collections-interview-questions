package telran.structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MultiCounters_programm implements MultiCounters {
	List<Object> list = new ArrayList<Object>();
	Map<Object, Integer> hashMap = new HashMap<Object, Integer>();

	@Override
//	public Integer addItem(Object item) {
//		int count = 0;
//
//		list.add(item);
//
//		for (Object n : list) {
//
//			if (n.equals(item)) {
//				count++;
//			}
//		}
//		return count;
//	}
	public Integer addItem(Object item) {
		if (!hashMap.containsKey(item)) {
			hashMap.put(item, 1);
		} else {
			hashMap.put(item, hashMap.get(item) + 1);
		}
		return hashMap.get(item);
	}

	@Override
	public Integer getValue(Object item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Object> getMaxItems() {
		Set<Object> hashSet = new HashSet<>();
		int maxValue = 0;
		// находим максимальное значение в хешмепе
		// Integer maxValue = hashMap.values().stream().max((a,b) -> a-b).get();
		for (int n : hashMap.values()) {
			if (n > maxValue) {
				maxValue = n;
			}
		}
		for(Object n:hashMap.keySet()) {
			if(hashMap.get(n) == maxValue) {
				hashSet.add(n);
			}
		}
		return hashSet;
	}

		
	}


