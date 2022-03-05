package maze;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.*;

public class ErrorMessageWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel mainPanel;

	/**
	 * Crée et ouvre une fenêtre d'erreur avec l'erreur renseignée en message.
	 * @param fileName le fichier d'ou vient l'erreur
	 * @param lineNumber la ligne ou se trouve l'erreur (ou -1 si non pertinent)
	 * @param givenErrorMessage le message d'erreur à afficher
	 */
	public ErrorMessageWindow (String fileName, int lineNumber, String givenErrorMessage){
		super("Error");
		
		setupUI(fileName, lineNumber, givenErrorMessage);
		setupOKButton();
		pack();
		toFront();
		requestFocus();
		setVisible(true);


	}

	/**
	 * Crée l'interface de la fenêtre d'erreur
	 * @param fileName
	 * @param lineNumber
	 * @param givenErrorMessage
	 */
	public void setupUI(String fileName, int lineNumber, String givenErrorMessage) {
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		
		JTextArea errorMessage = new JTextArea();
		errorMessage.setEditable(false);
		errorMessage.setBounds(20,20, 300, 300);
		errorMessage.setWrapStyleWord(true);
		errorMessage.setLineWrap(true);
		errorMessage.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		if (fileName != null) {
		
			if (lineNumber >= 0) {
				errorMessage.setText("An error has occurred at line " + lineNumber + " with " + fileName + " : " + givenErrorMessage );
			} else {
				errorMessage.setText("An error has occurred with " + fileName + " : " + givenErrorMessage );
		} 
			}else {
				errorMessage.setText("An error has occurred during file reading.");
		}
			
		
		
		mainPanel.add(errorMessage);
		
		this.add(mainPanel);
		setPreferredSize(new Dimension(350, 250));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Crée le bouton OK de confirmation qui ferme la fenêtre
	 */
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
		
		
		buttonPanel.add(okButton);
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		mainPanel.add(buttonPanel);
		
		
	}
	

}