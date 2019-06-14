package org.academiadecodigo.bootcamp29.gridPaint.grid.Position;

import org.academiadecodigo.bootcamp29.gridPaint.grid.Grid;
import org.academiadecodigo.bootcamp29.gridPaint.grid.GridDirection;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Cursor implements KeyboardHandler {

    private Position pos;
    public Keyboard keyboard;
    private Grid grid;
    private GridDirection direction;

    public Cursor(Grid grid){

        this.grid = grid;
        pos = new Position(grid,0, 0);
        keyboard = new Keyboard(this);
        init();

    }

        private void init() {
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

            KeyboardEvent paint = new KeyboardEvent();
            paint.setKey(KeyboardEvent.KEY_SPACE);
            paint.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

            KeyboardEvent stopDown = new KeyboardEvent();
            stopDown.setKey(KeyboardEvent.KEY_DOWN);
            stopDown.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

            KeyboardEvent stopUp = new KeyboardEvent();
            stopUp.setKey(KeyboardEvent.KEY_UP);
            stopUp.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

            KeyboardEvent stopLeft = new KeyboardEvent();
            stopLeft.setKey(KeyboardEvent.KEY_LEFT);
            stopLeft.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

            KeyboardEvent stopRight = new KeyboardEvent();
            stopRight.setKey(KeyboardEvent.KEY_RIGHT);
            stopRight.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);


            keyboard.addEventListener(left);
            keyboard.addEventListener(right);
            keyboard.addEventListener(up);
            keyboard.addEventListener(down);
            keyboard.addEventListener(paint);
            keyboard.addEventListener(stopLeft);
            keyboard.addEventListener(stopRight);
            keyboard.addEventListener(stopDown);
            keyboard.addEventListener(stopUp);
        }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {


        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            pos.show();
            return ;
        }

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                direction = GridDirection.LEFT;
                break;
            case KeyboardEvent.KEY_RIGHT:
                direction = GridDirection.RIGHT;
                break;
            case KeyboardEvent.KEY_UP:
                direction = GridDirection.UP;
                break;
            case KeyboardEvent.KEY_DOWN:
                direction = GridDirection.DOWN;
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                direction = null;
                break;
            case KeyboardEvent.KEY_RIGHT:
                direction = null;
                break;
            case KeyboardEvent.KEY_UP:
                direction = null;
                break;
            case KeyboardEvent.KEY_DOWN:
                direction = null;
                break;
        }

    }


    public Position getPos() {
        return pos;
    }

    public void move(){

        if(direction==null){
            return;
        }
        pos.move(direction);

    }


}
