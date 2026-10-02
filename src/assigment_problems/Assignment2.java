abstract class ArtPiece {
    private static int counter = 0;
    private final int pieceId;

    public ArtPiece() {
        counter++;
        this.pieceId = counter;
    }

    public abstract String describe();

    String getPieceId() {
        return String.valueOf(pieceId);
    }
}

class Painting extends ArtPiece {
    private String title;

    public Painting(String title) {
        super();
        this.title = title;
    }

    @Override
    public String describe() {
        return "Painting: " + title + ", framed on canvas";
    }
}

class Sculpture extends ArtPiece {
    private String title;

    public Sculpture(String title) {
        super();
        this.title = title;
    }

    @Override
    public String describe() {
        return "Sculpture: " + title + ", carved from stone";
    }
}

public class Assignment2 {
    public static void main(String[] args) {
        Painting p = new Painting("Sunset Fields");
        System.out.println(p.describe());
        // "Painting: Sunset Fields, framed on canvas"

        Sculpture s = new Sculpture("The Thinker II");
        System.out.println(s.describe());
        // "Sculpture: The Thinker II, carved from stone"
    }
}