import java.util.ArrayList;

public class State {
    public String name;
    public ArrayList<Transition> transitions;
    public boolean isTerminal;

    public State(String name, ArrayList<Transition> transitions, boolean isTerminal) {
        this.name = name;
        this.transitions = transitions;
        this.isTerminal = isTerminal;

    }

    public State nextState(Transition t) {


    }


}