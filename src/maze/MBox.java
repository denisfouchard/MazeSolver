package maze;

import java.util.ArrayList;

import dijkstra.VertexInterface;

public abstract class MBox implements VertexInterface {
	private int x;
	private int y;
	public char type;
	
	public MBox(int x0, int y0, char t) {
		x = x0;
		y = y0;
		type = t;
	}
	
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}



	@Override
	public void addNeighbour() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public boolean hasNeighbours() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public ArrayList<VertexInterface> getNeighbours() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
