package bridge;

public class AsciiRenderer implements Renderer {

    @Override
    public String renderShape(String shapeName, String dimensionLabel, double dimensionValue) {
        return "ASCII " + shapeName + " " + dimensionLabel + "=" + Renderer.formatDimension(dimensionValue);
    }
}
