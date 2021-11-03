package graph;

public class Dijkstra {
	private PreviousInterface dijkstra(GraphInterface g, VertexInterface r, ASetInterface a, PiInterface pi, PreviousInterface previous) {

		a.addA(r);
		VertexInterface pivot = r;
		pi.setDistance(r, 0);
		for (VertexInterface x : g.getVertices()) {
			if (x != r) {
				pi.setDistance(x, Float.POSITIVE_INFINITY);
			}
		}
		for (int j = 0; j < g.size(); j +=1) {
			
			for (VertexInterface y : pivot.getNeighbours()) {
				if (!a.isIn(y)) {
					if (pi.getDistance(pivot) + g.getWeight(pivot, y) < pi.getDistance(y) ) {
						pi.setDistance(y, pi.getDistance(pivot) + g.getWeight(pivot, y));
						previous.setPrevious(y, pivot);
					}
				}
			}
			VertexInterface closest = null;
			float d = Float.POSITIVE_INFINITY;
			
			for (VertexInterface y : pivot.getNeighbours()) {
				if (!a.isIn(y)) {
					if (pi.getDistance(y) < d) {
						d = pi.getDistance(y);
						closest =  y;
					}
				}
			}
			pivot = closest;
			a.addA(pivot);	
		}
		return previous;
	}
}
