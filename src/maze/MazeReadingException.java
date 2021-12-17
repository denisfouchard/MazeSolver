package maze;

public class MazeReadingException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	
	public MazeReadingException(String fileName, int lineNumber, String errorMessage) {
		
		super("Maze reading error at line "+ lineNumber + " : "+ errorMessage);
	}
	
}
