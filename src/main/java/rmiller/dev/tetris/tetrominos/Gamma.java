package rmiller.dev.tetris.tetrominos;

import rmiller.dev.math.Vec2i;
import rmiller.dev.tetris.Brick;

public class Gamma extends Tetromino {

    public Gamma(Vec2i position) {
        super(position);
        super.bricks = new Brick[4];
        super.bricks[0] = new Brick(new Vec2i(0 + position.x, 0 + position.y), Brick.brickColor.blue);
        super.bricks[1] = new Brick(new Vec2i(0 + position.x, 1 + position.y), Brick.brickColor.blue);
        super.bricks[2] = new Brick(new Vec2i(1 + position.x, 1 + position.y), Brick.brickColor.blue);
        super.bricks[3] = new Brick(new Vec2i(2 + position.x, 1 + position.y), Brick.brickColor.blue);
    }


    @Override
    public boolean spin(Brick[][] grid) {
        return false;
    }

}
