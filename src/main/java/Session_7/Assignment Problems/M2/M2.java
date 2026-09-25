import java.util.*;

abstract class ArtPiece {
    private static int counter = 1000;
    private final String pieceId;
    protected String title;

    public ArtPiece(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("title cannot be blank");
        }
        this.pieceId = "ART-" + (++counter);
        this.title = title;
    }

    public abstract String describe();

    public String getPieceId() {
        return pieceId;
    }

    public String getTitle() {
        return title;
    }
}

class Painting extends ArtPiece {
    public Painting(String title) {
        super(title);
    }

    @Override
    public String describe() {
        return "Painting: " + title + ", framed on canvas";
    }
}

class Sculpture extends ArtPiece {
    public Sculpture(String title) {
        super(title);
    }

    @Override
    public String describe() {
        return "Sculpture: " + title + ", carved from stone";
    }
}

public class M2 {
    public static void main(String[] args) {
        System.out.println("=== Assignment Problem 2: Gallery Description Cards ===");

        Painting p = new Painting("Sunset Fields");
        System.out.println(p.describe());

        Sculpture s = new Sculpture("The Thinker II");
        System.out.println(s.describe());
    }
}
