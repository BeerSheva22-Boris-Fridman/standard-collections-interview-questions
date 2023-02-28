package telran.structure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MultiCounters_TreeSet implements MultiCounters {

	Map<Object, Integer> hashMap = new HashMap<Object, Integer>();
	Map<Integer, Set<Object>> treeMap = new TreeMap<>();

	@Override
	public Integer addItem(Object item) {
		Set<Object> hashSet = new HashSet<>();
		int newAmount;
		if (!hashMap.containsKey(item)) {
			hashMap.put(item, 1);
			newAmount = 1;
			hashSet.add(item);
		} else {

			newAmount = hashMap.get(item) + 1;
			hashMap.put(item, newAmount);
		
		}
		int a =	hashMap.get(item);
		if (treeMap.containsKey(newAmount)) {
			Set <Object> tmp = treeMap.get(newAmount);
			treeMap.remove(newAmount);
			tmp.add(item);
			treeMap.put(newAmount, tmp);
		} 
		
		else {
			treeMap.put(hashMap.get(item), hashSet);

		}
		Set <Object> v = treeMap.get(1);
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
		// TODO Auto-generated method stub
		return null;
	}
}
