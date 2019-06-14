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

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void show(){

        rectangle.delete();
        rectangle.fill();
    }

    public void move(GridDirection direction){


        switch (direction) {

            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
        }

        System.out.println("x: "+x+ "y:"+y);

    }

    private void moveRight() {
        x = x + grid.getCellSize();
        this.rectangle.translate(grid.getCellSize(), 0);
    }

    private void moveLeft() {
        x = x - grid.getCellSize();
        this.rectangle.translate(-grid.getCellSize(), 0);
    }

    private void moveDown() {
        y = y + grid.getCellSize();
        this.rectangle.translate(0,grid.getCellSize());
    }

    private void moveUp() {
        y = y - grid.getCellSize();
        this.rectangle.translate(0, -grid.getCellSize());
    }

    public void setPainted(boolean painted) {
        this.painted = painted;
    }
}
