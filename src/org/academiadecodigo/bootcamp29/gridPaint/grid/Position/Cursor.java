package org.academiadecodigo.bootcamp29.gridPaint.grid.Position;

import org.academiadecodigo.bootcamp29.gridPaint.grid.Grid;
import org.academiadecodigo.bootcamp29.gridPaint.grid.Position.keyboard.CursorKeyboardHandler;


public class Cursor {

    private Position pos;
    private Grid grid;

    public Cursor(Grid grid){

        this.grid = grid;
        pos = new Position(grid,0, 0);

    }

    public Position getPos() {
        return pos;
    }

    public void move(){

            new CursorKeyboardHandler(this.getPos());

    }

}
