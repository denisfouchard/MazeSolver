package maze;

public class Maze {
	private MBox[][] maze;
	private DBox departure;
	private ABox arrival;
	
	public Maze(int i, int j) {
		maze = new MBox[i][j];
	}
	
	public Maze(int i, int j, MBox[] box_list) {
		maze = new MBox[i][j];
		for (MBox box : box_list) {
			maze[box.getX()][box.getY()] = box;
		}
	}

	public DBox getDeparture() {
		return departure;
	}

	public void setDeparture(DBox departure) {
		this.departure = departure;
	}

	public ABox getArrival() {
		return arrival;
	}

	public void setArrival(ABox arrival) {
		this.arrival = arrival;
	}
	
	
}
