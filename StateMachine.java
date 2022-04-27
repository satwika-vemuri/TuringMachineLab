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

    public State getStateFromName(String name){
        for(State state : states){
            if(state.name.equals(name)){
                return state;
            }
        }
        System.out.println("ERROR IN GETTING STATE");
        return null;
    }

    public Transition move(String input) {
        Transition t = this.getCurrentState().getTransition(input);
        System.out.println(t.getNextState());
        this.currentPosition = this.getStateFromName(t.getNextState()).statesIndex;
        return t;
    }

    
}
