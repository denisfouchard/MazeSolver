package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


import maze.Maze;


public class DrawingApp extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JPanel gridPanel;
    private DrawingGrid drawingGrid;
    private Maze maze;
    private int autoComputeStatus = 0;


    public DrawingApp(Maze maze) {
        super("Maze solver");
        this.maze = maze;
        drawingGrid = new DrawingGrid(this);
        setupUI(maze);
    }


    public void setupUI(Maze maze) {

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
        setupComputeButton(maze);
        pack();
        setVisible(true);
    }


    public void setupComputeButton(Maze maze) {
        ComputeButton compute = new ComputeButton(this);
        buttonPanel = new JPanel();
        buttonPanel.add(compute, BorderLayout.SOUTH);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        JCheckBox autoCompute = new JCheckBox("Auto-compute (not fully working...)");

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

    public DrawingGrid getDrawingGrid() {
        return drawingGrid;
    }

    public void refreshGrid() {
        drawingGrid.repaintGrid();
        revalidate();

        //gridPanel.revalidate();
        //mainPanel.revalidate();
        //this.revalidate();
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
}