public class State {
    public String name;
    public Transition[] transitions;
    public boolean isTerminal;
    public int statesIndex;

    public State(String name, Transition[] transitions, boolean isTerminal, int statesListIndex) {
        this.name = name;
        this.transitions = transitions;
        this.isTerminal = isTerminal;
        this.statesIndex = statesListIndex;

    }


    public Transition getTransition(String input) {
        // Assumes legal transition
        for (Transition t : transitions) {
            if (t.getRead().equals(input)) {
                return t;
            }
        }
        
        return null;
    }


}