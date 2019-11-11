package rmiller.dev.math;

public class Vec2i {

    public Integer x;
    public Integer y;

    public Vec2i(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public  Vec2i(Vec2i vec2) {
        this.x = vec2.x;
        this.y = vec2.y;
    }

    public Vec2i add(Vec2i v) {
        return new Vec2i(this.x + v.x, this.y + v.y);
    }

    public Vec2i add(Integer x, Integer y) {
        return new Vec2i(this.x + x, this.y + y);
    }

    public void translate(Vec2i v) {
        this.x += v.x;
        this.y += v.y;
    }

    public void translate(Integer x, Integer y) {
        this.x += x;
        this.y += y;
    }

    public void scale(Integer scalar) {
        this.x *= scalar;
        this.y *= scalar;
    }

}
