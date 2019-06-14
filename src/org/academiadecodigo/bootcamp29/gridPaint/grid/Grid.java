package org.academiadecodigo.bootcamp29.gridPaint.grid;

import org.academiadecodigo.bootcamp29.gridPaint.grid.Position.Cursor;
import org.academiadecodigo.bootcamp29.gridPaint.grid.Position.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    public static final int PADDING = 10;

    private int cellSize = 25;
    private int cols;
    private int rows;

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
            }
        }

        cursor = new Cursor(this);
        Position cursorPos = cursor.getPos();
        cursorPos.show();

    }

    public int getCellSize() {
        return cellSize;
    }

    public void moveCursor() {

            cursor.move();
            cursor.getPos().show();

    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }
}
