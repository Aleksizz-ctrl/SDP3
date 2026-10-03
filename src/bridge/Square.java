package bridge;

public class Square extends Shape {

    private final double side = 3;

    public Square(Renderer renderer) {
        super(renderer);
    }

    public double getSide() {
        return side;
    }

    @Override
    public String execute() {
        return renderer.renderShape("square", "side", side);
    }
}
