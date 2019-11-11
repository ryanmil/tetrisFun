package rmiller.dev.tetris.tetrominos;

import rmiller.dev.math.Vec2i;
import rmiller.dev.tetris.Brick;

public class Square extends Tetromino {

    public Square(Vec2i position) {
        super(position);

        super.bricks = new Brick[4];
        super.bricks[0] = new Brick(new Vec2i(0 + position.x, 0 + position.y), Brick.brickColor.yellow);
        super.bricks[1] = new Brick(new Vec2i(1 + position.x, 0 + position.y), Brick.brickColor.yellow);
        super.bricks[2] = new Brick(new Vec2i(0 + position.x, 1 + position.y), Brick.brickColor.yellow);
        super.bricks[3] = new Brick(new Vec2i(1 + position.x, 1 + position.y), Brick.brickColor.yellow);
    }


    @Override
    public boolean spin() {
        return false;
    }

    private boolean moveDown(Vec2i delta, Brick[][] grid) {
        if (bricks[2].canMove(delta, grid) && bricks[3].canMove(delta, grid)) {
            bricks[2].move(delta, grid);
            bricks[3].move(delta, grid);
            bricks[0].move(delta,grid);
            bricks[1].move(delta, grid);
            return true;
        } else {
            return false;
        }
    }

    private boolean moveRight(Vec2i delta, Brick[][] grid) {
        if (bricks[1].canMove(delta, grid) && bricks[3].canMove(delta, grid)) {
            bricks[1].move(delta, grid);
            bricks[3].move(delta, grid);
            bricks[2].move(delta,grid);
            bricks[0].move(delta, grid);
            return true;
        } else {
            return false;
        }
    }

    private boolean moveLeft(Vec2i delta, Brick[][] grid) {
        if (bricks[0].canMove(delta, grid) && bricks[2].canMove(delta, grid)) {
            bricks[0].move(delta, grid);
            bricks[2].move(delta, grid);
            bricks[1].move(delta,grid);
            bricks[3].move(delta, grid);
            return true;
        } else {
            return false;
        }
    }
}
