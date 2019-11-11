package rmiller.dev.tetris;

import rmiller.dev.math.Vec2i;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Brick {

    public static final int SIZE = 18;
    public enum brickColor {red, purple, green, yellow, blue, orange, cyan}

    private Color color;
    private Vec2i position;


    public Brick(Vec2i position, brickColor color) {
        this.position = position;
        this.color = blockColors.get(color);
    }

    public boolean canAdd(Brick[][] grid) {
        boolean xValid = position.x >= 0 && position.x < grid.length;
        boolean yValid = position.y >= 0 && position.y < grid[0].length;

        if(xValid && yValid && grid[position.x][position.y] == null) {
            return true;
        } else {
            return false;
        }
    }

    public void removeFromGrid(Brick[][] grid) {
        grid[position.x][position.y] = null;
    }

    public boolean addToGrid(Brick[][] grid) {
        if(canAdd(grid)) {
            grid[position.x][position.y] = this;
            return true;
        } else {
            return false;
        }
    }

    public void move(Vec2i delta) {
        position.translate(delta);
    }

    public boolean canMove(Vec2i delta, Brick[][] grid) {
        Vec2i newPos = position.add(delta);
        Brick newBrick = new Brick(newPos, null);
        if(newBrick.canAdd(grid)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean move(Vec2i delta, Brick[][] grid) {
        if(canMove(delta, grid)) {
            Vec2i newPos = position.add(delta);
            grid[position.x][position.y] = null;
            position = newPos;
            grid[position.x][position.y] = this;
            return true;
        } else {
            return false;
        }
    }

    public Color getColor() {
        return this.color;
    }


    private static final Map<brickColor, Color> blockColors;
    static {
        blockColors = new HashMap<>();
        blockColors.put(brickColor.red, new Color(230, 0, 0));
        blockColors.put(brickColor.purple, new Color(160, 0, 250));
        blockColors.put(brickColor.green, new Color(0, 230, 0));
        blockColors.put(brickColor.yellow, new Color(250, 230, 0));
        blockColors.put(brickColor.blue, new Color(0, 0, 230));
        blockColors.put(brickColor.orange, new Color(250, 100, 0));
        blockColors.put(brickColor.cyan, new Color(0, 250, 250));
    }
}
