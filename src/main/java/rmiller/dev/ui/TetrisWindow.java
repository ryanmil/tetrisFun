package rmiller.dev.ui;

import rmiller.dev.ui.TetrisCanvas;

import javax.swing.*;
import java.awt.*;

public class TetrisWindow {

    public static final int HEIGHT = 500;
    public static final int WIDTH = 500;
    public static final Keyboard KEYBOARD = new Keyboard();
    private JFrame window;

    public TetrisWindow(TetrisCanvas canvas) {
        window = new JFrame("Tetris");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(WIDTH, HEIGHT);
        window.setResizable(false);
        window.setBackground(Color.BLACK);
        window.setVisible(true);
        window.setFocusable(true);
        window.requestFocus();
        window.addKeyListener(KEYBOARD);

        window.add(canvas);
    }


}
