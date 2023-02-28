package telran.structure;

import java.util.Set;

public interface MultiCounters {

	//O[logN]
	public Integer addItem (Object item); 
	
	//O[1]
	public Integer getValue(Object item);
	
	//O[logN]
	public boolean remove(Object item);

//	* @return set of items with maximal counters
	//O[logN]
	public Set<Object> getMaxItems();

}
