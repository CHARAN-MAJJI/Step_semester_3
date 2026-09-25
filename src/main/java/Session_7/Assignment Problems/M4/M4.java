import java.util.*;

abstract class ClassroomDevice {
    protected String assetTag;

    public ClassroomDevice(String assetTag) {
        if (assetTag == null || assetTag.trim().isEmpty()) {
            throw new IllegalArgumentException("assetTag cannot be blank");
        }
        this.assetTag = assetTag;
    }

    public abstract String operate();
}

interface Chargeable {
    String charge();
    String charge(int minutes);
}

class Tablet extends ClassroomDevice implements Chargeable {
    public Tablet(String assetTag) {
        super(assetTag);
    }

    @Override
    public String operate() {
        return "Tablet " + assetTag + " displaying lesson";
    }

    @Override
    public String charge() {
        return assetTag + " charging";
    }

    @Override
    public String charge(int minutes) {
        return assetTag + " charging for " + minutes + " minutes";
    }
}

public class M4 {
    public static void main(String[] args) {
        System.out.println("=== Assignment Problem 4: Digital Classroom Setup ===");

        Tablet t = new Tablet("TAB-5");
        System.out.println(t.operate());

        System.out.println(t.charge());

        System.out.println(t.charge(30));
    }
}
