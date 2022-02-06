package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import dijkstra.ASet;
import dijkstra.ASetInterface;
import dijkstra.Dijkstra;
import dijkstra.GraphInterface;
import dijkstra.Pi;
import dijkstra.Previous;
import dijkstra.VertexInterface;
import maze.MazeReadingException;

public class DrawingGrid extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int rows;
    private int cols;
    private DrawingApp app;
    private CaseBox[][] grid;
    private ImageLoader imageLoader;
    private boolean dijkstraSuccesful;

    public DrawingGrid(DrawingApp app) {
        super();
        this.rows = app.getMaze().getRows();
        this.cols = app.getMaze().getCols();
        this.grid = new CaseBox[cols][rows];

        this.app = app;
        this.imageLoader = new ImageLoader(app.getMaze().getCols());
        setPreferredSize(new Dimension(600, 600));
        setupGrid();


    }


    public void setupGrid() {

        // Couleurs du labyrinthe


        // Dimensions du labyrinthe


        //Remplir la grille avec les données du Labyrinthe

        this.setLayout(new GridLayout(rows, cols));
        initGrid();
        repaintGrid();

    }


    public void initGrid() {

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new CaseBox(this.app, imageLoader, app.getMaze(), i, j);
                this.add(grid[i][j]);
            }
        }


    }


    public void repaintGrid() {

        Color arrivalColor = Color.RED;
        Color departureColor = Color.BLUE;


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                try {
                    switch (app.getMaze().maze[i][j].getType()) {

                        case 'A':
                            grid[i][j].setBackground(arrivalColor);
                            break;

                        case 'D':
                            grid[i][j].setBackground(departureColor);
                            break;

                        case 'E':
                            grid[i][j].setBackground(Color.WHITE);
                            break;

                        case 'W':
                            grid[i][j].setBackground(Color.BLACK);
                            break;

                        default:
                            throw new MazeReadingException(app.getMaze().getFileName(), i, "NotAMaze");
                    }

                } catch (MazeReadingException e) {
                    System.out.println(e.getMessage());
                }
            }
        }


        if (dijkstraSuccesful) {
            for (CaseBox pathCase : pathCases) {
                pathCase.setBackground(Color.GREEN);
            }
        }


        app.repaint();
    }

    private final ArrayList<CaseBox> pathCases = new ArrayList<>();

    public void computePath() {


        GraphInterface g = (GraphInterface) app.getMaze();
        VertexInterface dep = (VertexInterface) app.getMaze().getDeparture();
        VertexInterface arr = (VertexInterface) app.getMaze().getArrival();

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
        dijkstraSuccesful = (v == dep);

    }

}


