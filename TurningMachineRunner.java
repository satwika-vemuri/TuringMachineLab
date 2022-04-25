import java.util.ArrayList;
import java.util.Arrays;

public class TurningMachineRunner {

    public static void main(String[] args) {

        Tape tape = new Tape("00100", 0);

        State S0 = new State("S0", new ArrayList<Transition>(Arrays.asList(new Transition("0", "S1", "0", 1))), false, 0);
        State S1 = new State("S1", new ArrayList<Transition>(Arrays.asList(new Transition("0", "S2", "0", 1))), false, 1); 
        State S2 = new State("S2", new ArrayList<Transition>(Arrays.asList((new Transition("0", "A", "0", 1)), (new Transition(null, null, null, 0)))), true, 2); 
        State A = new State("A", new ArrayList<Transition>(Arrays.asList()), false, 3);

        ArrayList<State> states = new ArrayList<State>(
            Arrays.asList(S0, S1, S2, A));
        StateMachine stateMachine = new StateMachine(new ArrayList<State>());

        this.runMachine(tape, stateMachine);

    }

    public String runMachine(Tape tape, StateMachine sm) {
        while (!sm.getCurrentState().isTerminal) {
            String input =  tape.read();
            sm.move(input);
        }

    }



}