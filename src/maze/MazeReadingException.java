package maze;


public class MazeReadingException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String fileName;
	private int lineNumber;
	private String errorMessage;
	

	
	public MazeReadingException(String fileName, int lineNumber, String errorMessage) {
		
		super("Maze reading error at line "+ lineNumber + " : "+ errorMessage);
		this.fileName = fileName;
		this.lineNumber = lineNumber;
		this.errorMessage = errorMessage;
		
		
		
	}
	
	public void errorWindow() {
		
		new ErrorMessageWindow(fileName, lineNumber, errorMessage);
		
	}
	
	
	
}
