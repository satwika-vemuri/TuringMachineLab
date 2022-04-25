public class Transition {

    private String read;
    private State nextState;
    private String write;
    private int direction;

    public Transition(String read, String write, State nextState, int direction) {
        this.read = read;
        this.write = write;
        this.nextState = nextState;
        this.direction = direction;

    }

    public String getRead() {
        return read;
    }

    public String getWrite() {
        return write;
    }

    public State getNextState() {
        return nextState;
    }

    public int getDirection() {
        return direction;
    }

}