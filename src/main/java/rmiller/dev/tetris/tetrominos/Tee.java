package rmiller.dev.tetris.tetrominos;

import rmiller.dev.math.Vec2i;
import rmiller.dev.tetris.Brick;

public class Tee extends Tetromino {

    int rotation = 1;

    public Tee(Vec2i position) {
        super(position);
        super.bricks = new Brick[4];
        super.bricks[0] = new Brick(new Vec2i(1 + position.x, 0 + position.y), Brick.brickColor.purple);
        super.bricks[1] = new Brick(new Vec2i(0 + position.x, 1 + position.y), Brick.brickColor.purple);
        super.bricks[2] = new Brick(new Vec2i(1 + position.x, 1 + position.y), Brick.brickColor.purple);
        super.bricks[3] = new Brick(new Vec2i(2 + position.x, 1 + position.y), Brick.brickColor.purple);
    }


    @Override
    public boolean spin(Brick[][] grid) {
        if (rotation == 1) {
            if( bricks[1].canMove(new Vec2i(1, 1), grid) ) {
                bricks[1].move(new Vec2i(1, 1), grid);
                rotation++;
                return true;
            }
        } else if (rotation == 2){
            if( bricks[0].canMove(new Vec2i(-1, 1), grid)) {
                bricks[0].move(new Vec2i(-1, 1), grid);
                rotation++;
                return true;
            }
        } else if (rotation == 3){
            if( bricks[3].canMove(new Vec2i(-1, -1), grid)) {
                bricks[3].move(new Vec2i(-1, -1), grid);
                rotation++;
                return true;
            }
        } else {
            if( bricks[1].canMove(new Vec2i(1, -1), grid)) {
                bricks[3].move(new Vec2i(1, 1), grid);
                bricks[0].move(new Vec2i(1, -1), grid);
                bricks[1].move(new Vec2i(-1, -1), grid);
                rotation = 1;
                return true;
            }
        }
        return false;
    }

}
