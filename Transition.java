public class Transition {

    private String read;
    private String nextState;
    private String write;
    private int direction;

    public Transition(String read, String nextState, String write, int direction) {
        this.read = read;
        this.write = write;
        this.nextState = nextState;
        this.direction = direction;

    }

    public String getRead() { // returns the input/read
        return this.read;
    }

    public String getWrite() { // returns what the State said to write
        return this.write;
    }

    public String getNextState() { // returns the next state given the instructions on the previous state
        return this.nextState;
    }

    public Integer direction() { //returns 0 for left, 1 for right
        return this.direction;
    }

}