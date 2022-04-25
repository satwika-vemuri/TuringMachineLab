import java.util.ArrayList;
import java.util.Arrays;

public class TurningMachineRunner {

    public static void main(String[] args) {

        Tape tape = new Tape("00100", 0);

        State S0 = new State("S0", new ArrayList<Transition>(Arrays.asList(new Transition("0", "S1", "0", 1))), false);
        State S1 = new State("S1", new ArrayList<Transition>(Arrays.asList(new Transition("0", "S2", "0", 1))), false); 
        State S2 = new State("S2", new ArrayList<Transition>(Arrays.asList((new Transition("0", "A", "0", 1)), (new Transition(null, null, null, 0)))), true); 
        State A = new State("A", new ArrayList<Transition>(Arrays.asList()), false);

        ArrayList<State> states = new ArrayList<State>(
            Arrays.asList(S0, S1, S2, A));
        StateMachine stateMachine = new StateMachine(new ArrayList<State>());





    }

    public String runMachine(Tape tape, ArrayList symbols) {


    }



}
