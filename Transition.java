public class Transition {

    public String input;
    public String tapeSymbol;

    public Transition(String input, String tapeSymbol) {
        this.input = input;
        this.tapeSymbol = tapeSymbol;

    }

    public State moveToNext() {
        return new State("", );

    }

    public String write() {
        return "";

    }

    public String movement() {
        // TODO: tells the tape to move left or right
        return "";

    }

}