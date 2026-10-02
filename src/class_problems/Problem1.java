package week7problem1;

abstract class Toy {
    private static int counter = 1000;
    public final String toyId;
    protected String name;

    public Toy(String name) {
        counter++;
        this.toyId = "TOY-" + counter;
        this.name = name;
    }

    public abstract String makeSound();

    String getToyId() {
        return toyId;
    }
}

class ToyCar extends Toy {
    public ToyCar(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return name + ": Vroom vroom!";
    }
}

class ToyRobot extends Toy {
    public ToyRobot(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return name + ": Beep boop!";
    }
}

public class Problem1 {
    public static void main(String[] args) {
        // new Toy("X"); // <-- would NOT compile: Toy is abstract, cannot be instantiated directly

        ToyCar c = new ToyCar("Speedster");
        System.out.println(c.makeSound()); // Speedster: Vroom vroom!

        ToyRobot r = new ToyRobot("Bolt");
        System.out.println(r.makeSound()); // Bolt: Beep boop!

        System.out.println(c.getToyId()); // TOY-1001
        System.out.println(r.getToyId()); // TOY-1002
    }
}