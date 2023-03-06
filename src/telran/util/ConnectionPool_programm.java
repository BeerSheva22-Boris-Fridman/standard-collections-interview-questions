package telran.util;
import java.util.*;

public class ConnectionPool_programm implements ConnectionsPool {
	LinkedList<Object> pool = new LinkedList<Object>();
	HashMap<Integer, Object> connections = new HashMap<Integer, Object>();

	private int sizeOfPool;

	@Override
	public boolean addConnection(Connection connection) {
		boolean res = false;
		int id = connection.getId();
		if (!connections.containsKey(id)) {
			pool.addFirst(connection);
			connections.put(id, connection);
			res = true;
		}
		if (pool.size() < sizeOfPool) {
			removeOldestConnectionInPool();
//			pool.removeLast();
//			Object removedID = pool.removeLast();
//			connections.remove(removedID);
		}
		return res;
	}

	private void removeOldestConnectionInPool() {
		Connection con = (Connection) pool.getLast();
		int idLast = con.getId();
		pool.removeLast();
		connections.remove(idLast);

	}

	@Override
	public Connection getConnection(int id) {
		if (connections.containsKey(id)) {
			Connection res = (Connection) connections.get(id);
			pool.remove(res);
			pool.add(res);
			return res;
		}
		return null;
	}
	public Iterator<Object> iterator() {
		
		return pool.iterator();
	}

}
