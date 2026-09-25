import java.util.*;

abstract class GardenTool {
    public String use() {
        return "Using the tool in the garden";
    }
}

class CuttingTool extends GardenTool {
    public CuttingTool() {
        super();
    }

    @Override
    public String use() {
        return super.use() + ", blade sharpened first";
    }
}

class Pruner extends CuttingTool {
    public Pruner() {
        super();
    }

    @Override
    public String use() {
        return super.use() + ", then trimming branches precisely";
    }
}

public class M3 {
    public static void main(String[] args) {
        System.out.println("=== Assignment Problem 3: Backyard Toolshed Routine ===");

        CuttingTool c = new CuttingTool();
        System.out.println(c.use());

        Pruner p = new Pruner();
        System.out.println(p.use());
    }
}
