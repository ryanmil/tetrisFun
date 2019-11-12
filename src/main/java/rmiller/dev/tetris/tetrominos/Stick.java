package rmiller.dev.tetris.tetrominos;

import rmiller.dev.math.Vec2i;
import rmiller.dev.tetris.Brick;

public class Stick extends Tetromino {

    private boolean vert = true;

    public Stick(Vec2i position) {
        super(position);
        super.bricks = new Brick[4];
        super.bricks[0] = new Brick(new Vec2i(position.x, 0 + position.y), Brick.brickColor.cyan);
        super.bricks[1] = new Brick(new Vec2i(position.x, 1 + position.y), Brick.brickColor.cyan);
        super.bricks[2] = new Brick(new Vec2i(position.x, 2 + position.y), Brick.brickColor.cyan);
        super.bricks[3] = new Brick(new Vec2i(position.x, 3 + position.y), Brick.brickColor.cyan);
    }

    @Override
    public boolean spin(Brick[][] grid) {

        if (vert) {
            if( bricks[0].canMove(new Vec2i(2, 2), grid) &&
                    bricks[1].canMove(new Vec2i(1, 1), grid) &&
                    bricks[3].canMove(new Vec2i(-1, -1), grid)) {

                bricks[0].move(new Vec2i(2, 2), grid);
                bricks[1].move(new Vec2i(1, 1), grid);
                bricks[3].move(new Vec2i(-1, -1), grid);
                vert = false;
                return true;
            }
        } else {
            if( bricks[0].canMove(new Vec2i(-2, -2), grid) &&
                    bricks[1].canMove(new Vec2i(-1, -1), grid) &&
                    bricks[3].canMove(new Vec2i(1, 1), grid)) {

                bricks[0].move(new Vec2i(-2, -2), grid);
                bricks[1].move(new Vec2i(-1, -1), grid);
                bricks[3].move(new Vec2i(1, 1), grid);
                vert = true;
                return true;
            }
        }
        return false;
    }
}
