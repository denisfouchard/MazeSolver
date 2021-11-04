package dijkstra;

public interface PreviousInterface {
	public VertexInterface getPrevious(VertexInterface u);
	public void setPrevious(VertexInterface u, VertexInterface v);
}
