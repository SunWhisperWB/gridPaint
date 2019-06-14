package org.academiadecodigo.bootcamp29.gridPaint.grid.Position;

import org.academiadecodigo.bootcamp29.gridPaint.grid.Grid;
import org.academiadecodigo.bootcamp29.gridPaint.grid.GridDirection;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Position {

    private int x;
    private int y;
    private Grid grid;
    private boolean painted;
    private Rectangle rectangle;

    public Position(Grid grid, int x, int y){
        this.x = grid.PADDING + (x*grid.getCellSize());
        this.y = grid.PADDING + (y*grid.getCellSize());
        this.grid = grid;
        rectangle = new Rectangle(this.x, this.y, grid.getCellSize(), grid.getCellSize());
    }

    public void translate(int x, int y) {
        rectangle.translate(x, y);
        this.x = this.x+x;
        this.y = this.y+y;
        System.out.println(this.x+ " " + this.y);

    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
