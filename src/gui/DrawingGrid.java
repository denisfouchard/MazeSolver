package gui;

import dijkstra.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawingGrid extends JPanel {


    private static final long serialVersionUID = 1L;
    private int rows;
    private int cols;
    private DrawingApp app;
    private CaseBox[][] grid;
    private ImageLoader imageLoader;
    private boolean DijkstraSuccessful;
    private ColorMap colorMap = new ColorMap();
    private final ArrayList<CaseBox> pathCases = new ArrayList<>();

    /**
     * Draw the grid on the screen according to the data provided.
     *
     * @param app the application JFrame.
     */
    public DrawingGrid(DrawingApp app) {
        super();
        this.rows = app.getMaze().getRows();
        this.cols = app.getMaze().getCols();
        this.grid = new CaseBox[rows][cols];
        this.app = app;
        int width = (app.getMaze().getCols()* 50);
        int height = (app.getMaze().getRows()* 50);
        this.imageLoader = new ImageLoader(app.getMaze().getCols());
        setMinimumSize(new Dimension(300, 300));
        setMaximumSize(new Dimension(1200, 1200));
        setPreferredSize(new Dimension(width, height));
        setupGrid();
    }

    /**
     * Setup the layout for the grid.
     */
    public void setupGrid() {

        this.setLayout(new GridLayout(rows, cols));
        initGrid();
        repaintGrid();

    }


    /**
     * Initiate an empty grid with the given dimensions.
     */
    public void initGrid() {

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new CaseBox(this.app, imageLoader, app.getMaze(), i, j);
                this.add(grid[i][j]);
            }
        }
    }


    /**
     * Update and refresh the grid layout with the new information stored.
     */
    public void repaintGrid() {
        //pp.getMaze().printMaze();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char type = app.getMaze().maze[i][j].getType();

                try {
                    Color caseColor = colorMap.get(type);
                    grid[i][j].setBackground(caseColor);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        app.repaint();
    }


    /**
     * Compute the shortest path using Dijkstra's algorithm and paint corresponding cases if
     * the computation succeeds.
     */

    public void computePath() {
        GraphInterface g = app.getMaze();
        VertexInterface dep = app.getMaze().getDeparture();
        VertexInterface arr = app.getMaze().getArrival();

        //On exécute Dijkstra pour récuperer le chemin
        ASetInterface a = new ASet(g);
        Previous prev = new Previous(app.getMaze());
        Pi pi = new Pi(app.getMaze());
        prev = (Previous) Dijkstra.dijkstra(g, dep, a, pi, prev);

        pathCases.clear();

        VertexInterface v = prev.getPrevious(arr);
        while (v != dep && prev.getPrevious(v) != v) {
            int i = v.getX();
            int j = v.getY();
            CaseBox pathCase = grid[i][j];

            pathCases.add(pathCase);
            v = prev.getPrevious(v);

        }
        //On ne colorie les cases que si Dijkstra a réussi
        DijkstraSuccessful = (v == dep);
        if (DijkstraSuccessful) {
            for (CaseBox pathCase : pathCases) {
                pathCase.setBackground(Color.GREEN);
            }
        }

    }

}


