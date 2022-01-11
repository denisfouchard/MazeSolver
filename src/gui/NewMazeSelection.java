package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewMazeSelection extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel mainPanel;
	private String[] optionsToChoose = {"10x10", "20x20", "40x40", "100x100"};
	private int dim;
	
	public NewMazeSelection (){
		super("Create a new maze");
		
		setupUI();
		
		setupOKButton();
		pack();
		setVisible(true);
	}
	
	public void setupMenu() {
		JComboBox<String> selection = new JComboBox<>(optionsToChoose);
		selection.setBounds(80, 50, 140, 20);
		
		selection.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        switch(selection.getItemAt(selection.getSelectedIndex())) {
		        case "10x10":
		        	dim = 10;
		        
		        case "20x20":
		        	dim = 20;
		        
		        case "40x40":
		        	dim = 40;
		        
		        case "100x100":
		        	dim = 100;
		        
		        default:
		        	dim = 10;
		        }   
		    }
		});
		
		mainPanel.add(selection);
		
		
	}
	
	public void setupUI() {
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		
		JTextField inputMessage = new JTextField();
		inputMessage.setText("Please selection the dimensions of the new maze" );
		mainPanel.add(inputMessage);
		
		setupMenu();
		
		this.add(mainPanel);
		setPreferredSize(new Dimension(400, 300));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setupOKButton() {
		
		JPanel buttonPanel;
		JButton okButton = new JButton("Ok");
		
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		
				dispose();
				
			}
        });
		
		buttonPanel = new JPanel();
		buttonPanel.add(okButton, BorderLayout.SOUTH);
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		mainPanel.add(buttonPanel);
		
		
	}
	
	public int getDim() {
		return dim;
	}
	

}
