import java.util.ArrayList;
import java.util.Arrays;

import javax.annotation.processing.RoundEnvironment;

public class TurningMachineRunner {

    public static void main(String[] args) {

        String input = "#000000#";
        Tape tape = new Tape(input, input.length()-2);

        Transition[] startTransitions = {(new Transition("1", "0", "carry", 0)), (new Transition("0", "1", "add", 0))};    
        Transition[] carryTransitions = {(new Transition("1", "0", "carry", 0)), (new Transition("#", "#", "done", 0)), (new Transition("0", "1", "add", 0))};
        Transition[] doneTransitions = {};    
        Transition[] addTransitions = {(new Transition("1", "1", "add", 0)), (new Transition("0", "0", "add", 0)), (new Transition("#", "#", "leftHash", 0))};
        Transition[] leftHashTransitions = {(new Transition("1", "1", "leftHash", 0)), (new Transition("0", "1", "toLeftHash", 0))};
        Transition[] toLeftHashTransitions = {(new Transition("1", "1", "toLeftHash", 1)), (new Transition("0", "1", "L1", 0))};
        Transition[] L1Transitions = {(new Transition("0", "1", "L2", 0))};
        Transition[] L2Transitions = {(new Transition("0", "1", "L3", 0))};
        Transition[] L3Transitions =  {(new Transition("0", "1", "L4", 0))};;
        Transition[] L4Transitions = {(new Transition("0", "1", "toLeftHash", 0))};
        Transition[] toRightHashTransitions = {(new Transition("1", "1", "toRightHash", 1)), (new Transition("0", "0", "toRightHash", 1)), (new Transition("#", "#", "moveRight", 1))};    
        Transition[] moveRightTransitions = {(new Transition("1", "1", "moveRight", 1 )), (new Transition("0", "1", "R1", 1))};
        Transition[] R1Transitions =  {(new Transition("0", "1", "R2", 1))};
        Transition[] R2Transitions =  {(new Transition("0", "1", "R3", 1))};
        Transition[] R3Transitions = {(new Transition("0", "1", "R4", 1))};
        Transition[] R4Transitions = {(new Transition("0", "1", "backToRightHash", 0))};
        Transition[] backToRightHashTransitions = {(new Transition("1", "1", "backToRightHash", 0)), (new Transition("#", "#", "S0", 0))};    

        
        State S0 = new State("S0", startTransitions, false, 0);
        State add = new State("add", addTransitions, false, 1); 
        State carry = new State("carry", carryTransitions, false, 2);
        State leftHash = new State("leftHash", leftHashTransitions, false, 3);
        State toLeftHash = new State("toLeftHash", toLeftHashTransitions, false, 4);
        State L1 = new State("L1", L1Transitions , false, 5);
        State L2 = new State ("L2", L2Transitions, false, 6); 
        State L3 = new State ("L3", L3Transitions, false, 7); 
        State L4 = new State ("L4", L4Transitions, false, 8); 
        State toRightHash = new State("toRightHash", toRightHashTransitions, false, 9);
        State moveRight = new State("moveRight", moveRightTransitions, false, 10);
        State R1 = new State ("R1", R1Transitions, false, 11); 
        State R2 = new State ("R2", R2Transitions, false, 12); 
        State R3 = new State ("R3", R3Transitions, false, 13); 
        State R4 = new State ("R1", R4Transitions, false, 14); 
        State backToRightHash = new State("backToRightHash", backToRightHashTransitions, false, 15);
        State done = new State("done", doneTransitions, true, 16);


        ArrayList<State> states = new ArrayList<State>(
            Arrays.asList(S0, add, carry, leftHash, toLeftHash, L1, L2, L3, L4, toRightHash, moveRight, R1, R2, R3, R4, backToRightHash, done));
        StateMachine stateMachine = new StateMachine(states);
        int ones = runMachine(tape, stateMachine);
        System.out.printf("Final one count: %d\n", ones);
        System.out.printf("Final score: %.5f", (ones / (17 + 3 + input.length())));
    }

    public static int runMachine(Tape tape, StateMachine sm) {
        while (!sm.getCurrentState().isTerminal) {
            String input =  tape.read();
            Transition transition = sm.move(input);
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