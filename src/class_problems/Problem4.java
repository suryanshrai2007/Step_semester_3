package week7problem4;

abstract class KitchenTool {
    private int speedLevel;

    public abstract String prepare();

    int getSpeedLevel() {
        return speedLevel;
    }

    void setSpeedLevel(int speedLevel) {
        if (speedLevel >= 1 && speedLevel <= 5) {
            this.speedLevel = speedLevel;
        }
        // else: rejected silently, value stays unchanged
    }
}

interface Washable {
    String clean();
}

class Blender extends KitchenTool implements Washable {
    public Blender() {
    }

    @Override
    public String prepare() {
        return "Blending at speed " + getSpeedLevel();
    }

    @Override
    public String clean() {
        return "Blender rinsed and dried";
    }
}

public class Problem4 {
    public static void main(String[] args) {
        Blender b = new Blender();
        b.setSpeedLevel(3);
        System.out.println(b.getSpeedLevel()); // 3

        b.setSpeedLevel(9); // rejected
        System.out.println(b.getSpeedLevel()); // still 3

        System.out.println(b.prepare()); // Blending at speed 3
        System.out.println(b.clean());   // Blender rinsed and dried
    }
}