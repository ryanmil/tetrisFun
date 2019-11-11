package rmiller.dev.tetris.tetrominos;

import rmiller.dev.math.Vec2i;
import rmiller.dev.tetris.Brick;

public class Stick extends Tetromino {

    public Stick(Vec2i position) {
        super(position);
        super.bricks = new Brick[4];
        super.bricks[0] = new Brick(new Vec2i(position.x, 0 + position.y), Brick.brickColor.cyan);
        super.bricks[1] = new Brick(new Vec2i(position.x, 1 + position.y), Brick.brickColor.cyan);
        super.bricks[2] = new Brick(new Vec2i(position.x, 2 + position.y), Brick.brickColor.cyan);
        super.bricks[3] = new Brick(new Vec2i(position.x, 3 + position.y), Brick.brickColor.cyan);
    }


    @Override
    public boolean spin() {
        return false;
    }
}
