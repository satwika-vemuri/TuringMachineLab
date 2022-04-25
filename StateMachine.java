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
    public void move(String input) {
        this.currentPosition = this.getCurrentState().getNextState(input).statesIndex;
    }

    
}
