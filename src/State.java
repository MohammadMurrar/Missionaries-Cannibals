import java.util.ArrayList;
import java.util.List;

// State class to represent the state of M & C
public class State {
    int mLeft = 3;
    int cLeft = 3;
    int boat;
    int mRight = 0;
    int cRight = 0;
    State parent;

    public State(int mLeft, int cLeft, int boat, int mRight, int cRight) {
        super();
        this.mLeft = mLeft;
        this.cLeft = cLeft;
        this.boat = boat;
        this.mRight = mRight;
        this.cRight = cRight;
    }

    //Method that check if the state is valid or not
    public boolean isValid(State state) {
        return (mLeft == 0 || mLeft >= cLeft) && (mRight == 0 || mRight >= cRight);
    }

    //Method to generate possible next States based on valid moves
    public List<State> nextState(State state){
        // possible moves {M,C}
        int[][] moves = {{0,1},{0,2},{1,0},{1,1},{2,0}};
        // Array List to store the valid next state
        ArrayList<State> nextStates = new ArrayList<>();
        for(int[] move : moves) {
            int dm = move[0], dc = move[1];
            State newState;
            //if boat on the left, move M or C or both to right
            if(boat == 1) {
                newState = new State(mLeft - dm , cLeft - dc , 0 , mRight + dm, cRight + dc);
            }
            //if boat on the right, move M or C or both to left
            else {
                newState = new State(mLeft + dm , cLeft + dc , 1 , mRight - dm, cRight - dc);
            }
            //Check if the state Valid ? "add" : "ignore"
            if(isValid(newState)){
                nextStates.add(newState);
            }
        }
        return nextStates;
    }
    public State getParent() {
        return parent;
    }
}
