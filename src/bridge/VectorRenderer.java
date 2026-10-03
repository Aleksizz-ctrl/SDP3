package bridge;

public class VectorRenderer implements Renderer {

    @Override
    public String renderShape(String shapeName, String dimensionLabel, double dimensionValue) {
        return "VECTOR " + shapeName + " " + dimensionLabel + "=" + Renderer.formatDimension(dimensionValue);
    }
}
