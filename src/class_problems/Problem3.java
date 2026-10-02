package week7problem3;

abstract class Instrument {
    public abstract String play();
}

class StringInstrument extends Instrument {
    public StringInstrument() {
        super();
    }

    @Override
    public String play() {
        return "Strumming the strings";
    }
}

class Violin extends StringInstrument {
    public Violin() {
        super();
    }

    @Override
    public String play() {
        return super.play() + ", with a bow drawn across four strings";
    }
}

public class Problem3 {
    public static void main(String[] args) {
        StringInstrument s = new StringInstrument();
        System.out.println(s.play()); // Strumming the strings

        Violin v = new Violin();
        System.out.println(v.play());
        // Strumming the strings, with a bow drawn across four strings
    }
}