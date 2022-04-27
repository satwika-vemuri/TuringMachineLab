import java.util.ArrayList;
import java.util.Arrays;

public class TurningMachineRunner {

    public static void main(String[] args) {

        Tape tape = new Tape("#000000#", 3);

        Transition[] startTransitions = {(new Transition("1", "0", "carry", 0)), (new Transition("0", "1", "add", 0))};    
        Transition[] carryTransitions = {(new Transition("1", "0", "carry", 0)), (new Transition("#", "#", "done", 0)), (new Transition("0", "1", "add", 0))};
        Transition[] doneTransitions = {};    
        Transition[] addTransitions = {(new Transition("1", "1", "add", 0)), (new Transition("0", "0", "add", 0)), (new Transition("#", "#", "leftHash", 0))};
        Transition[] leftHashTransitions = {(new Transition("1", "1", "leftHash", 0)), (new Transition("0", "1", "toLeftHash", 1))};
        Transition[] toLeftHashTransitions = {(new Transition("1", "1", "toLeftHash", 1)), (new Transition("#", "#", "toRightHash", 1))};
        Transition[] toRightHashTransitions = {(new Transition("1", "1", "toRightHash", 1)), (new Transition("0", "0", "toRightHash", 1)), (new Transition("#", "#", "moveRight", 1))};    
        Transition[] moveRightTransitions = {(new Transition("1", "1", "moveRight", 1 )), (new Transition("0", "1", "backToRightHash", 0))};
        Transition[] backToRightHashTransitions = {(new Transition("1", "1", "backToRightHash", 0)), (new Transition("#", "#", "S0", 0))};    

        
        State S0 = new State("S0", startTransitions, false, 0);
        State add = new State("add", addTransitions, false, 1); 
        State carry = new State("carry", carryTransitions, false, 2);
        State leftHash = new State("leftHash", leftHashTransitions, false, 3);
        State toLeftHash = new State("toLeftHash", toLeftHashTransitions, false, 4);
        State toRightHash = new State("toRightHash", toRightHashTransitions, false, 5);
        State moveRight = new State("moveRight", moveRightTransitions, false, 6);
        State backToRightHash = new State("backToRightHash", backToRightHashTransitions, false, 7);
        State done = new State("done", doneTransitions, true, 8);


        ArrayList<State> states = new ArrayList<State>(
            Arrays.asList(S0, add, carry, leftHash, toLeftHash, toRightHash, moveRight, backToRightHash, done));
        StateMachine stateMachine = new StateMachine(states);

        System.out.println(runMachine(tape, stateMachine));

    }

    public static int runMachine(Tape tape, StateMachine sm) {
        while (!sm.getCurrentState().isTerminal) {
            System.out.println(sm.getCurrentState().name);
            String input =  tape.read();
            System.out.println("Input: " + input);
            Transition transition = sm.move(input);
            System.out.println(transition.getDirection());
            tape.write(transition.getWrite());
            if (transition.getDirection() == 0) {
                tape.left();
            } else {
                tape.right();
            }
        }

        return tape.oneCount();

    }



}

/**
 * import java.util.ArrayList;
import java.util.Arrays;

public class TurningMachineRunner {

    public static void main(String[] args) {

        Tape tape = new Tape("000", 0);

        State S0 = new State("S0", new ArrayList<Transition>(Arrays.asList(new Transition("0", "S1", "0", 1))), false, 0);
        State S1 = new State("S1", new ArrayList<Transition>(Arrays.asList(new Transition("0", "S2", "0", 1))), false, 1); 
        State S2 = new State("S2", new ArrayList<Transition>(Arrays.asList((new Transition("0", "A", "0", 1)), (new Transition(null, null, null, 0)))), false, 2); 
        State A = new State("A", new ArrayList<Transition>(Arrays.asList()), true, 3);

        ArrayList<State> states = new ArrayList<State>(
            Arrays.asList(S0, S1, S2, A));
        StateMachine stateMachine = new StateMachine(states);

        System.out.println(runMachine(tape, stateMachine));

    }

    public static ArrayList<String> runMachine(Tape tape, StateMachine sm) {
        while (!sm.getCurrentState().isTerminal) {
            System.out.println(sm.getCurrentState().name);
            String input =  tape.read();
            System.out.println("Input: " + input);
            Transition transition = sm.move(input);
            tape.write(transition.getWrite());
            if (transition.getDirection() == 0) {
                tape.left();
            } else {
                tape.right();
            }
        }

        return tape.input;

    }



}
 * 
 */