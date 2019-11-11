package rmiller.dev.math;

public class Vec2 {

    public Double x;
    public Double y;

    public Vec2(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public  Vec2(Vec2 vec2) {
        this.x = vec2.x;
        this.y = vec2.y;
    }

    public void add(Vec2 vec2) {
        this.x += vec2.x;
        this.y += vec2.y;
    }

    public void add(Double x, Double y) {
        this.x += x;
        this.y += y;
    }

    public void scale(Double scalar) {
        this.x *= scalar;
        this.y *= scalar;
    }

}
