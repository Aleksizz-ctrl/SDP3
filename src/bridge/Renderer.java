package bridge;

public interface Renderer {

    String renderShape(String shapeName, String dimensionLabel, double dimensionValue);

    static String formatDimension(double value) {
        if (value == Math.floor(value) && !Double.isInfinite(value)) {
            return String.valueOf((long) value);
        }
        return String.valueOf(value);
    }
}
