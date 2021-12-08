package dijkstra;

import java.util.Hashtable;
import java.lang.Float;

public class Pi implements PiInterface {
	private  Hashtable<VertexInterface, Integer> pi = new Hashtable<VertexInterface, Integer>();
	
	public Pi(GraphInterface g) {
		for (VertexInterface u: g.getAllVertices()) {
			pi.put(u, Integer.MAX_VALUE);
		}
	}

	@Override
	public Integer getDistance(VertexInterface u) {
		return pi.get(u);
	}

	@Override
	public void setDistance(VertexInterface u, Integer d) {
		pi.put(u, d);
		
	}

	@Override
	public VertexInterface getClosest(VertexInterface u) {
		return null;
	}
	
	@Override
	public String toString() {
		return pi.toString();
	}
	
}
