package rmiller.dev.ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class Keyboard implements KeyListener {

    private HashMap<Integer, Boolean> pressedKeys;
    private HashMap<Integer, Boolean> typedKeys;

    public Keyboard() {
        pressedKeys = new HashMap<>();
        typedKeys = new HashMap<>();
    }

    public Boolean isPressed(Integer code) {
        if(pressedKeys.containsKey(code)) {
            return pressedKeys.get(code);
        } else {
            return false;
        }
    }

    public Boolean wasTyped(Integer code) {
        if(typedKeys.containsKey(code)) {
            boolean typed = typedKeys.get(code);
            typedKeys.put(code, false);
            return typed;
        } else {
            return false;
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressedKeys.put(e.getKeyCode(), true);
        typedKeys.put(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys.put(e.getKeyCode(), false);
    }
}
