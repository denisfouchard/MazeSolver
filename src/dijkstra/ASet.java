package dijkstra;
import java.util.HashSet;

public class ASet implements ASetInterface{
	
	private HashSet<VertexInterface> A; 

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
		A.contains(u);
		return false;
	}

}
