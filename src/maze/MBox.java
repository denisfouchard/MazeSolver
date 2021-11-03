package maze;

public abstract class MBox {
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
	
}
