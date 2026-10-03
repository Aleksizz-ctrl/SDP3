import bridge.Circle;
import bridge.Square;
import bridge.Shape;
import bridge.Renderer;
import bridge.VectorRenderer;
import bridge.RasterRenderer;
import bridge.AsciiRenderer;

public class Main {

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("--demo")) {
            runDemo();
        } else {
            System.out.println("Usage: java -cp out Main --demo");
        }
    }

    private static void runDemo() {
        int passCount = 0;
        final int totalChecks = 7;

        Circle circleForT1 = new Circle(new VectorRenderer());
        String t1Actual = circleForT1.execute();
        String t1Expected = "VECTOR circle radius=2";
        boolean t1Pass = t1Actual.equals(t1Expected);
        printCheck("T1", t1Pass, "Circle + VectorRenderer", t1Actual, t1Expected);
        if (t1Pass) passCount++;

        Circle circleForT2 = new Circle(new RasterRenderer());
        String t2Actual = circleForT2.execute();
        String t2Expected = "RASTER circle radius=2";
        boolean t2Pass = t2Actual.equals(t2Expected) && circleForT2.getRadius() == circleForT1.getRadius();
        printCheck("T2", t2Pass, "Circle + RasterRenderer", t2Actual, t2Expected);
        if (t2Pass) passCount++;

        Square squareForT3 = new Square(new VectorRenderer());
        String t3Actual = squareForT3.execute();
        String t3Expected = "VECTOR square side=3";
        boolean t3Pass = t3Actual.equals(t3Expected);
        printCheck("T3", t3Pass, "Square + VectorRenderer", t3Actual, t3Expected);
        if (t3Pass) passCount++;

        Square squareForT4 = new Square(new RasterRenderer());
        String t4Actual = squareForT4.execute();
        String t4Expected = "RASTER square side=3";
        boolean t4Pass = t4Actual.equals(t4Expected) && squareForT4.getSide() == squareForT3.getSide();
        printCheck("T4", t4Pass, "Square + RasterRenderer", t4Actual, t4Expected);
        if (t4Pass) passCount++;

        Circle switchTarget = new Circle(new VectorRenderer());
        Circle sameReference = switchTarget;
        int idBeforeSwitch = switchTarget.getId();
        double radiusBeforeSwitch = switchTarget.getRadius();
        String resultBeforeSwitch = switchTarget.execute();

        switchTarget.setImplementation(new RasterRenderer());
        String resultAfterSwitch = switchTarget.execute();

        boolean isSameObject = (switchTarget == sameReference);
        boolean idUnchanged = (switchTarget.getId() == idBeforeSwitch);
        boolean dataUnchanged = (switchTarget.getRadius() == radiusBeforeSwitch);
        boolean stateUnchanged = idUnchanged && dataUnchanged;
        boolean t5Pass = isSameObject && stateUnchanged
                && resultBeforeSwitch.equals("VECTOR circle radius=2")
                && resultAfterSwitch.equals("RASTER circle radius=2");

        System.out.println("T5 " + (t5Pass ? "PASS" : "FAIL")
                + " | sameObject=" + isSameObject
                + " | stateUnchanged=" + stateUnchanged
                + " | before=" + resultBeforeSwitch
                + " | after=" + resultAfterSwitch);
        if (t5Pass) passCount++;

        Circle circleForT6 = new Circle(new AsciiRenderer());
        String t6Actual = circleForT6.execute();
        String t6Expected = "ASCII circle radius=2";
        boolean t6Pass = t6Actual.equals(t6Expected);
        printCheck("T6", t6Pass, "Circle + AsciiRenderer", t6Actual, t6Expected);
        if (t6Pass) passCount++;

        Square squareForT7 = new Square(new AsciiRenderer());
        String t7Actual = squareForT7.execute();
        String t7Expected = "ASCII square side=3";
        boolean t7Pass = t7Actual.equals(t7Expected);
        printCheck("T7", t7Pass, "Square + AsciiRenderer", t7Actual, t7Expected);
        if (t7Pass) passCount++;

        System.out.println("SUMMARY: " + passCount + "/" + totalChecks + " PASS");
    }

    private static void printCheck(String checkId, boolean pass, String participants, String actual, String expected) {
        if (pass) {
            System.out.println(checkId + " PASS | " + participants + " | result=" + actual);
        } else {
            System.out.println(checkId + " FAIL | " + participants
                    + " | result=" + actual + " | expected=" + expected);
        }
    }
}
