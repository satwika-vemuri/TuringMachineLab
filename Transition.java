public class Transition {

    public String input;
    public String tapeSymbol;
    public State nextState;
    public String write;
    public int direction;

    public Transition(String input, String tapeSymbol, State nextState, String write, int direction) {
        this.input = input;
        this.tapeSymbol = tapeSymbol;
        this.nextState = nextState;
        this.write = write;
        this.direction = direction;

    }

    public String getRequiredInput() {
        return input;
    }

    public State getNextState() {
        return nextState;
    }

}