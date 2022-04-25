import java.util.ArrayList;

public class State {
    public String name;
    public ArrayList<Transition> transitions;
    public boolean isTerminal;
    public int statesIndex;

    public State(String name, ArrayList<Transition> transitions, boolean isTerminal, int statesListIndex) {
        this.name = name;
        this.transitions = transitions;
        this.isTerminal = isTerminal;
        this.statesIndex = statesListIndex;

    }

    public State getNextState(String input) {
        // Assumes legal transition
        for (Transition t : transitions) {
            if (t.getRead().equals(input)) {
                return t.getNextState();
            }
        }
        
        return null;
    }


}