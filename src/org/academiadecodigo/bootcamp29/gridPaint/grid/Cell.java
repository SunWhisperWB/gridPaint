package org.academiadecodigo.bootcamp29.gridPaint.grid;

import org.academiadecodigo.bootcamp29.gridPaint.grid.position.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Cell {

    private Position pos;
    private boolean isPainted;
    private Rectangle rectangle;
    private Grid grid;

    public Cell(int x, int y, Grid grid){

        this.grid = grid;
        rectangle = new Rectangle(x, y, grid.getCellSize(), grid.getCellSize());
        pos = new Position(grid, x, y);

    }

    public void paint(){
        rectangle.fill();
        isPainted = true;
    }

    public void removePaint(){
        rectangle.delete();
        isPainted = false;
    }
}
