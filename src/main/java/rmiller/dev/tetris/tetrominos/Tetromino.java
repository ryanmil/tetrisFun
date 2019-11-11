package rmiller.dev.tetris.tetrominos;

import rmiller.dev.math.Vec2i;
import rmiller.dev.tetris.Brick;

public abstract class Tetromino {

    Vec2i position;
    Brick[] bricks;


    public Tetromino(Vec2i position) {
        this.position = position;
    }

    public boolean addToGrid(Brick[][] grid) {
        for (Brick b : bricks) {
            if (!b.canAdd(grid)) {
                return false;
            }
        }
        for (Brick b : bricks) {
            b.addToGrid(grid);
        }
        return true;
    }

    public boolean move(Vec2i delta, Brick[][] grid) {
        for (Brick b : bricks) {
            b.removeFromGrid(grid);
        }
        for (Brick b : bricks) {
            if (!b.canMove(delta, grid)) {
                for (Brick b2 : bricks) {
                    b2.addToGrid(grid);
                }
                return false;
            }
        }
        for (Brick b : bricks) {
            b.move(delta);
            b.addToGrid(grid);
        }
        return true;
    }

    public abstract boolean spin();

}
