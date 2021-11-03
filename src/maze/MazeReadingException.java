package maze;

public class MazeReadingException extends Exception{
	
	private String name;
	
	public MazeReadingException(String fileName, int lineNumber, String errorMessage) {
		
		super("Maze reading error at line "+ lineNumber + " : "+ errorMessage);
	}
	
}
