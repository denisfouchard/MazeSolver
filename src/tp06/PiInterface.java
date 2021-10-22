package tp06;

public interface PiInterface {
	public float getDistance(VertexInterface u);
	public void setDistance(VertexInterface u, float d);
	public VertexInterface getClosest(VertexInterface u);
}
