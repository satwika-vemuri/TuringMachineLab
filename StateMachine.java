import java.util.ArrayList;

public class StateMachine {
    public ArrayList<State> states;
    public int currentPosition;

    public StateMachine(ArrayList<State> states) {
        this.states = states;
        this.currentPosition = 0; 
    } 

    public State getCurrentState() {
        return states.get(currentPosition);
    
    }
    public Transition move(String input) {
        Transition t = this.getCurrentState().getTransition(input);
        this.currentPosition = t.getNextState().statesIndex;
        this.current
    }

    
}
