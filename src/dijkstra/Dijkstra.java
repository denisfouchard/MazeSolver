package dijkstra;

public class Dijkstra {
	public static PreviousInterface dijkstra(GraphInterface g, VertexInterface r, ASetInterface a, PiInterface pi, PreviousInterface previous) {
		a.addA(r);
		VertexInterface pivot = r;
		pi.setDistance(r, 0);
		for (VertexInterface x : g.getAllVertices()) {
			if (x != r) {
				pi.setDistance(x, Integer.MAX_VALUE);
			}
		}
		
		while (pivot !=null) { //On teste tant que A n'est pas totalement rempli
			
			//System.out.println(g.getSuccessors(pivot).toString());
			
			
			for (VertexInterface y : g.getSuccessors(pivot)) {
				//System.out.println(g.getSuccessors(pivot).size());
				if (!a.isIn(y)) {
					if (pi.getDistance(pivot) + 1 < pi.getDistance(y) ) {
						pi.setDistance(y, pi.getDistance(pivot) + 1);
						previous.setPrevious(y, pivot);
					}
				}
			}
			
			
			VertexInterface closest = null;
			int d = Integer.MAX_VALUE;
			
			//On cherche le voisin le plus proche du pivot actuel (peut être intégré à la première boucle)
			
			for (VertexInterface y : g.getAllVertices()) {
				if (!a.isIn(y)) {
					if (pi.getDistance(y) < d) {
						d = pi.getDistance(y);
						closest =  y;
					}
				}
			}
			pivot = closest;
			a.addA(pivot);
			if (pivot != null) {
				
			//System.out.println(pivot.getType() + pivot.toString());
			}
		}
		return previous;
	}
}
