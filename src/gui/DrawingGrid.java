package gui;

import java.awt.*;
import javax.swing.*;

public class DrawingGrid extends JFrame {
	  int width, height;
	  int rows;
	  int cols;

	  DrawingGrid(int width, int height, int rows, int cols) {
	    setSize(width, height);
	    this.rows = rows;
	    this.cols = cols;
	  }

	  public void paint(Graphics g) {
	    int i;
	    width = getSize().width;
	    height = getSize().height;

	    // draw the rows
	    int rowHt = height / rows;
	    for (i = 0; i < rows; i++)
	      g.drawLine(0, i * rowHt, width, i * rowHt);

	    // draw the columns
	    int rowWid = width / (cols);
	    for (i = 0; i < cols; i++)
	      g.drawLine(i * rowWid, 0, i * rowWid, height);
	  }
} 

