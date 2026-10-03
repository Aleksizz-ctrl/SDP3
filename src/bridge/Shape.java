package bridge;

public abstract class Shape {

    private static int nextId = 1;

    private final int id;
    protected Renderer renderer;

    protected Shape(Renderer renderer) {
        this.id = nextId++;
        this.renderer = renderer;
    }

    public void setImplementation(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract String execute();

    public int getId() {
        return id;
    }
}
