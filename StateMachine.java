import java.util.ArrayList;

public class StateMachine {
    private ArrayList<State> states;
    private State currentState;

    public StateMachine(ArrayList<State> states, State startingState) {
        this.states = states;
        this.currentState = startingState; 
    } 

    public State getCurrentState() {
        return this.currentState;
    }

    public void move(String input) {
        this.currentState = currentState.getNextState(input);
    }

    
}
