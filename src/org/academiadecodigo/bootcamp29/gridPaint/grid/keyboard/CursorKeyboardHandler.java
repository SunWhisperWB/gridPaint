package org.academiadecodigo.bootcamp29.gridPaint.grid.keyboard;


import org.academiadecodigo.bootcamp29.gridPaint.grid.Grid;
import org.academiadecodigo.bootcamp29.gridPaint.grid.position.Position;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;



public class CursorKeyboardHandler implements KeyboardHandler {

    private Position cursor;
    private Keyboard keyboard;
    private Grid grid;

    public CursorKeyboardHandler(Position cursor, Grid grid){

        this.cursor = cursor;
        this.grid = grid;
        keyboard = new Keyboard(this);
        init();

    }

    public void init() {



        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(space);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                if(cursor.getX()>grid.PADDING) {
                    cursor.translate(-25, 0);
                    break;
                }
                break;

            case KeyboardEvent.KEY_RIGHT:
                if(cursor.getX()<(grid.getCellSize()*(grid.getCols()-1)+grid.PADDING)) {
                    cursor.translate(25, 0);
                    break;
                }
                break;

            case KeyboardEvent.KEY_UP:
                if (cursor.getY()>grid.PADDING) {
                    cursor.translate(0, -25);
                    break;
                }
                break;

            case KeyboardEvent.KEY_DOWN:
                if (cursor.getY()<(grid.getCellSize()*(grid.getRows()-1)+grid.PADDING)) {
                    cursor.translate(0, 25);
                    break;
                }
                break;

            case KeyboardEvent.KEY_SPACE:


                break;
        }

    }




    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
