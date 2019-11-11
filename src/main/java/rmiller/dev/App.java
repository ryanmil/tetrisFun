package rmiller.dev;

import rmiller.dev.ui.TetrisCanvas;
import rmiller.dev.ui.TetrisWindow;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        TetrisCanvas canvas = new TetrisCanvas();
        TetrisWindow window = new TetrisWindow(canvas);
        canvas.run();
    }
}
