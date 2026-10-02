abstract class GardenTool {
    public GardenTool() {
    }

    public abstract String use();
}

class CuttingTool extends GardenTool {
    public CuttingTool() {
        super();
    }

    @Override
    public String use() {
        return "Using the tool in the garden, blade sharpened first";
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

public class Assignment3 {
    public static void main(String[] args) {
        CuttingTool c = new CuttingTool();
        System.out.println(c.use());
        // "Using the tool in the garden, blade sharpened first"

        Pruner p = new Pruner();
        System.out.println(p.use());
        // "Using the tool in the garden, blade sharpened first, then trimming branches precisely"
    }
}