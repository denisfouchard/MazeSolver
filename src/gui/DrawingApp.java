package gui;

import maze.Maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;


public class DrawingApp extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JPanel gridPanel;
    private DrawingGrid drawingGrid;
    private Maze maze;
    private int autoComputeStatus = 0;
    private String mode;


    public DrawingApp(Maze maze) {
        super("Maze solver");
        this.maze = maze;
        drawingGrid = new DrawingGrid(this);
        setupUI();
    }

    /**
     * Initialise l'interface de la fenêtre
     */
    public void setupUI() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        gridPanel = new JPanel();
        gridPanel.setLayout(new BoxLayout(gridPanel, BoxLayout.Y_AXIS));
        this.add(mainPanel);

        setPreferredSize(new Dimension(600, 700));
        setResizable(false);
        setJMenuBar(new DrawingMenuBar(this));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel.add(gridPanel);

        addGrid();
        setButtonLayout();
        pack();
        setVisible(true);
    }

    /**
     * Met en place le layout des boutons (compute, setArrival, setDeparture)
     */
    public void setButtonLayout() {
        ComputeButton compute = new ComputeButton(this);
        SetDepartureButton setDepartureButton = new SetDepartureButton(this);
        SetArrivalButton setArrivalButton = new SetArrivalButton(this);
        buttonPanel = new JPanel();
        buttonPanel.add(compute, BorderLayout.SOUTH);
        buttonPanel.add(setDepartureButton, BorderLayout.EAST);
        buttonPanel.add(setArrivalButton, BorderLayout.EAST);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        JCheckBox autoCompute = new JCheckBox("Auto-compute");

        autoCompute.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                autoComputeStatus = 1 - autoComputeStatus;


            }
        });
        buttonPanel.add(autoCompute);
        mainPanel.add(buttonPanel);
    }


    public void addGrid() {
        gridPanel.add(drawingGrid);
        mainPanel.revalidate();
    }

    public void updateUI(Maze newMaze) {
        this.maze = newMaze;
        gridPanel.remove(drawingGrid);
        this.revalidate();
        drawingGrid = new DrawingGrid(this);
        addGrid();
    }


    public void computePath() {
        drawingGrid.computePath();
    }

    public void saveMazeToTextFile(String fileName) throws FileNotFoundException {

        try {
            maze.saveToTextFile(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public int getAutoComputeStatus() {
        return this.autoComputeStatus;
    }

    public Maze getMaze() {
        return maze;
    }

    public void repaintGrid() {
        drawingGrid.repaintGrid();
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
    public String getMode(){
        return mode;
    }

    public void resetMode() {
        mode = "normal";
    }
}