package maze;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ErrorMessageWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel mainPanel;
	
	public ErrorMessageWindow (String fileName, int lineNumber){
		super("Error");
		
		setupUI(fileName, lineNumber);
		setupOKButton();
		pack();
		toFront();
		requestFocus();
		setVisible(true);


	}
	
	
	public void setupUI(String fileName, int lineNumber) {
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		
		JTextField errorMessage = new JTextField();
		
		if (fileName != null) {
		
			if (lineNumber >= 0) {
				errorMessage.setText("An error has occured at line " + lineNumber + " : " + fileName + " is not a correct Maze File." );
			} else {
				errorMessage.setText("An error has occured : " + fileName + " is not a correct Maze File." );
		} 
			}else {
				errorMessage.setText("An error has occured during file reading.");
		}
			
		
		
		mainPanel.add(errorMessage);
		
		this.add(mainPanel);
		setPreferredSize(new Dimension(300, 100));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setupOKButton() {
		
		JPanel buttonPanel;
		JButton okButton = new JButton("Ok");
		buttonPanel = new JPanel();
		
		
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
        });
		
		
		buttonPanel.add(okButton, BorderLayout.SOUTH);
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		mainPanel.add(buttonPanel);
		
		
	}
	

}