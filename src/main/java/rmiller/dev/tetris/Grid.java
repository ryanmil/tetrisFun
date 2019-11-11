package rmiller.dev.tetris;

import rmiller.dev.math.Vec2i;
import rmiller.dev.tetris.Brick;
import rmiller.dev.tetris.tetrominos.*;
import rmiller.dev.ui.TetrisWindow;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Grid {
    private Brick[][] grid;
    private Tetromino activeTetro;

    public Grid() {
        grid = new Brick[10][20];
        activeTetro = new RightGun(new Vec2i(4, 0));
        activeTetro.addToGrid(grid);
    }

    public void update() {
        updateActiveBrick();
        handleInput();
    }

    private void updateActiveBrick() {
        if(!activeTetro.move(new Vec2i(0, 1), grid)) {
            genTetro();
        }
    }

    private static int colorCode = 0;
    private void genTetro() {
        Tetromino newTetro = new Square(new Vec2i(4, 0));
        switch (colorCode) {
            case 0: newTetro = new Square(new Vec2i(7, 0)); break;
            case 1: newTetro = new Stick(new Vec2i(7, 0)); break;
            case 2: newTetro = new Tee(new Vec2i(7, 0)); break;
            case 3: newTetro = new Skew(new Vec2i(7, 0)); break;
            case 4: newTetro = new InvSkew(new Vec2i(7, 0)); break;
            case 5: newTetro = new Gamma(new Vec2i(7, 0)); break;
            case 6: newTetro = new RightGun(new Vec2i(7, 0)); break;
        }
        activeTetro = newTetro;
        activeTetro.addToGrid(grid);

        colorCode++;
        if (colorCode > 6) colorCode = 0;
    }


    private void handleInput() {
        if (TetrisWindow.KEYBOARD.wasTyped(KeyEvent.VK_W)) {
            System.out.println("W");
        }
        if (TetrisWindow.KEYBOARD.wasTyped(KeyEvent.VK_S) || TetrisWindow.KEYBOARD.isPressed(KeyEvent.VK_S)) {
            activeTetro.move(new Vec2i(0, 1), grid);
        }
        if (TetrisWindow.KEYBOARD.wasTyped(KeyEvent.VK_D) || TetrisWindow.KEYBOARD.isPressed(KeyEvent.VK_D)) {
            activeTetro.move(new Vec2i(1, 0), grid);
        }
        if (TetrisWindow.KEYBOARD.wasTyped(KeyEvent.VK_A) || TetrisWindow.KEYBOARD.isPressed(KeyEvent.VK_A)) {
            activeTetro.move(new Vec2i(-1, 0), grid);
        }
    }



    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //  Graphics/Rendering //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void paint(Graphics g) {
        paintGrid(g);
        paintBricks(g);
    }

    private void paintBricks(Graphics g) {
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {

                if (grid[j][i] != null) {
                    g.setColor(grid[j][i].getColor());
                    g.fillRect(j * Brick.SIZE, i * Brick.SIZE, Brick.SIZE, Brick.SIZE);
                }
            }
        }
    }

    private void paintGrid(Graphics g) {
        g.setColor(Color.BLUE);
        for (int i = 0; i <= grid.length; i++) {
            g.drawLine(i * Brick.SIZE, 0, i * Brick.SIZE, Brick.SIZE * grid[0].length);
        }
        for (int i = 0; i <= grid[0].length; i++) {
            g.drawLine(0, i * Brick.SIZE, Brick.SIZE * grid.length, i * Brick.SIZE);
        }
    }
}
