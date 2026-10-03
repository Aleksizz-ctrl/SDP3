package bridge;

public class RasterRenderer implements Renderer {

    @Override
    public String renderShape(String shapeName, String dimensionLabel, double dimensionValue) {
        return "RASTER " + shapeName + " " + dimensionLabel + "=" + Renderer.formatDimension(dimensionValue);
    }
}
