package dijkstra;

public interface PiInterface {
	public Integer getDistance(VertexInterface u);
	public void setDistance(VertexInterface u, Integer i);
	public VertexInterface getClosest(VertexInterface u);
}
