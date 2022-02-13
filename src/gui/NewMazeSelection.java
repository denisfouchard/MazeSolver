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

import maze.Maze;


public class NewMazeSelection extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private String[] optionsToChoose = {"10x10", "20x20", "30x30", "40x40"};
	private int dim;
	private DrawingApp app;
	private JComboBox<String> selection;

	public NewMazeSelection (DrawingApp drawingApp){
		super("Create a new maze");
		this.app=drawingApp;
		setupUI();
		setupOKButton();
		pack();
		setVisible(true);
	}
	
	public void setupMenu() {
		selection = new JComboBox<>(optionsToChoose);
		selection.setBounds(80, 50, 140, 20);
		mainPanel.add(selection);
	}
	
	public void setupUI() {
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		// Ajout du texte de consignes
		JTextField inputMessage = new JTextField();
		inputMessage.setEditable(false);
		inputMessage.setText("Please selection the dimensions of the new maze" );
		mainPanel.add(inputMessage);
		
		setupMenu();
		
		this.add(mainPanel);
		setPreferredSize(new Dimension(400, 150));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setupOKButton() {
		
		JPanel buttonPanel;
		JButton okButton = new JButton("Ok");
		
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// On récupère la taille séléctionnée
				int[] dimensions = {10, 20, 30, 40};
				int s = selection.getSelectedIndex();
				dim = dimensions[s];

				// On crée un Empty Maze que l'on ajoute à la grille
				Maze newMaze = new Maze(dim, dim);
				newMaze.initEmptyMaze();
				app.updateUI(newMaze);

				// On ferme la fenêtre de dialogue
				dispose();
			}
        });
		
		buttonPanel = new JPanel();
		buttonPanel.add(okButton, BorderLayout.SOUTH);
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		mainPanel.add(buttonPanel);
		
		
	}

	

}
