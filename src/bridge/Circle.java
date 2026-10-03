package bridge;

public class Circle extends Shape {

    private final double radius = 2;

    public Circle(Renderer renderer) {
        super(renderer);
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String execute() {
        return renderer.renderShape("circle", "radius", radius);
    }
}
