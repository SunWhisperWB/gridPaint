package bootcamp.utils;

import org.academiadecodigo.bootcamp.MapEditor;
import org.academiadecodigo.bootcamp.grid.Cursor;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardController implements KeyboardHandler {

    private MapEditor mapEditor;

    public KeyboardController(MapEditor mapEditor) {

        this.mapEditor = mapEditor;
        initKeyboard();

    }

    private void initKeyboard() {

        Keyboard keyboard = new Keyboard(this);

        addEvent(KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_PRESSED, keyboard);
        addEvent(KeyboardEvent.KEY_LEFT, KeyboardEventType.KEY_PRESSED, keyboard);
        addEvent(KeyboardEvent.KEY_UP, KeyboardEventType.KEY_PRESSED, keyboard);
        addEvent(KeyboardEvent.KEY_DOWN, KeyboardEventType.KEY_PRESSED, keyboard);
        addEvent(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED, keyboard);
        addEvent(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_RELEASED, keyboard);
        addEvent(KeyboardEvent.KEY_S, KeyboardEventType.KEY_PRESSED, keyboard);
        addEvent(KeyboardEvent.KEY_L, KeyboardEventType.KEY_PRESSED, keyboard);
        addEvent(KeyboardEvent.KEY_C, KeyboardEventType.KEY_PRESSED, keyboard);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                mapEditor.moveCursor(Cursor.Direction.RIGHT);
                break;
            case KeyboardEvent.KEY_LEFT:
                mapEditor.moveCursor(Cursor.Direction.LEFT);
                break;
            case KeyboardEvent.KEY_UP:
                mapEditor.moveCursor(Cursor.Direction.UP);
                break;
            case KeyboardEvent.KEY_DOWN:
                mapEditor.moveCursor(Cursor.Direction.DOWN);
                break;
            case KeyboardEvent.KEY_SPACE:
                mapEditor.setPainting(true);
                mapEditor.paintCell();
                break;
            case KeyboardEvent.KEY_C:
                mapEditor.clear();
                break;
            case KeyboardEvent.KEY_S:
                mapEditor.save();
                break;
            case KeyboardEvent.KEY_L:
                mapEditor.load();
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            mapEditor.setPainting(false);
        }

    }

    public void addEvent(int key, KeyboardEventType type, Keyboard keyboard){
        KeyboardEvent e = new KeyboardEvent();
        e.setKey(key);
        e.setKeyboardEventType(type);
        keyboard.addEventListener(e);
    }
}
