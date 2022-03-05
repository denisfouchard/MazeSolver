package dijkstra;

import java.util.Enumeration;
import java.util.Hashtable;

import maze.MBox;

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
	public String toString() {
		String res = "";
		Enumeration<VertexInterface> distances = pi.keys();
		while (distances.hasMoreElements()) {
			MBox u = (MBox)distances.nextElement();
			res = res + "[" + u.getX() + ", " + u.getY() + "] : " + pi.get(u) + " ";
		}
		return res;
	}
	
}
