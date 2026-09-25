import java.util.*;

abstract class Toy {
    private static int counter = 1000;
    protected final String toyId;
    protected String name;

    public Toy(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Toy name cannot be blank");
        }
        this.toyId = "TOY-" + (++counter);
        this.name = name;
    }

    public abstract String makeSound();

    public String getToyId() {
        return toyId;
    }

    public String getName() {
        return name;
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

public class M1 {
    public static void main(String[] args) {
        System.out.println("=== Class Problem 1: The Talking Toy Box ===");

        ToyCar c = new ToyCar("Speedster");
        System.out.println(c.makeSound());

        ToyRobot r = new ToyRobot("Bolt");
        System.out.println(r.makeSound());

        System.out.println(c.getToyId());
        System.out.println(r.getToyId());
    }
}
