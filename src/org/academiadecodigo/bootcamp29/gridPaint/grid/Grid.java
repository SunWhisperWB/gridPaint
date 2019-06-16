package org.academiadecodigo.bootcamp29.gridPaint.grid;

import org.academiadecodigo.bootcamp29.gridPaint.grid.position.Cursor;
import org.academiadecodigo.bootcamp29.gridPaint.grid.position.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.HashMap;

public class Grid {

    public static final int PADDING = 10;

    private int cellSize = 25;
    private int cols;
    private int rows;
    private HashMap<Integer, Cell> cellMap;

    private Rectangle cell;
    private Cursor cursor;

    public Grid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
    }

    public void init() {
        for (int i = 0 ; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.cell = new Rectangle(PADDING +(cellSize* i), PADDING+ (cellSize * j), cellSize, cellSize);
                this.cell.draw();
                //cellMap.put(j i, new Cell(j, i, this));

            }
        }

        cursor = new Cursor(this);
        Position cursorPos = cursor.getPos();
        cursorPos.getRectangle().fill();

    }

    public int getCellSize() {
        return cellSize;
    }

    public void moveCursor() {

            cursor.move();

    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }
}
