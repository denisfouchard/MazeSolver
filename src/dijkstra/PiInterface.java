package dijkstra;

public interface PiInterface {
	public Float getDistance(VertexInterface u);
	public void setDistance(VertexInterface u, Float i);
	public VertexInterface getClosest(VertexInterface u);
}
