package dijkstra;
import java.util.HashSet;

public class ASet implements ASetInterface{
	
	
	
	private HashSet<VertexInterface> A; 
	
	public ASet(GraphInterface g) {
		A = new HashSet<VertexInterface>(g.size());
		};

	@Override
	public void addA(VertexInterface u) {
		A.add(u);
		
	}

	@Override
	public void rmA(VertexInterface u) {
		A.remove(u);
	}

	@Override
	public boolean isIn(VertexInterface u) {
		return A.contains(u);
		
	}

}
