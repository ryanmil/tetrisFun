package rmiller.dev.ui;

import rmiller.dev.tetris.Grid;

import java.awt.*;

public class TetrisCanvas extends Canvas {

    private Grid grid;

    public TetrisCanvas() {
        super();
        setSize(TetrisWindow.WIDTH, TetrisWindow.HEIGHT);
        grid = new Grid();
    }

    public void run() {
        while (true) {

            try { Thread.sleep(300); }
            catch (InterruptedException e) {
                System.out.println("I was interrupted!");
                e.printStackTrace();
            }

            grid.update();
            repaint();
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, TetrisWindow.WIDTH, TetrisWindow.HEIGHT);

        g.translate(140, 50);
        grid.paint(g);
    }

}
