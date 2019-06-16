package org.academiadecodigo.bootcamp29.gridPaint;

import org.academiadecodigo.bootcamp29.gridPaint.grid.Grid;

public class Paint {

    private int delay;
    private Grid grid;

    public Paint(int rows, int cols, int delay){
        grid = new Grid(cols, rows);
        this.delay = delay;
    }

    public void init(){
        grid.init();
    }

    public void start() {
            moveCursor();
    }

    private void moveCursor() {
        grid.moveCursor();
    }


}
