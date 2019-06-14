package org.academiadecodigo.bootcamp29.gridPaint.grid.Position.keyboard;


import org.academiadecodigo.bootcamp29.gridPaint.grid.Position.Cursor;
import org.academiadecodigo.bootcamp29.gridPaint.grid.Position.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;



public class CursorKeyboardHandler implements KeyboardHandler {

    private Position cursor;
    private Keyboard keyboard;

    public CursorKeyboardHandler(Position cursor){

        this.cursor = cursor;
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


        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                cursor.translate(-10, 0);
                break;

            case KeyboardEvent.KEY_RIGHT:
                cursor.translate(10, 0);
                break;

            case KeyboardEvent.KEY_UP:
                cursor.translate(0,  -10);
                break;

            case KeyboardEvent.KEY_DOWN:
                cursor.translate(0, 10);
                break;

        }

    }




    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
