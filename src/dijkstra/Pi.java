package dijkstra;

import java.util.Hashtable;
import java.lang.Float;

public class Pi implements PiInterface {
	private  Hashtable<VertexInterface, Float> pi = new Hashtable<VertexInterface, Float>();
	
	public Pi(GraphInterface g) {
		for (VertexInterface u: g.getAllVertices()) {
			pi.put(u, Float.POSITIVE_INFINITY);
		}
	}

	@Override
	public Float getDistance(VertexInterface u) {
		return pi.get(u);
	}

	@Override
	public void setDistance(VertexInterface u, Float d) {
		pi.put(u, d);
		
	}

	@Override
	public VertexInterface getClosest(VertexInterface u) {
		
		return null;
	}
	
}
