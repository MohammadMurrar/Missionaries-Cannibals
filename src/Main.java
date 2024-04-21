import java.util.*;

public class Main {
    public static final int ML = 3;
    public static final int CL = 3;
    public static final int INITIAL_BOAT_STATE = 1;
    public static final int MR = 0;
    public static final int CR = 0;
    public static final int MAX_DEPTH = 12;//Max depth for DFS To avoid JVM memory error
    public static final State INITIAL_STATE = new State(ML, CL, INITIAL_BOAT_STATE, MR, CR);
    public static List<State> bfsSolution = BFS(INITIAL_STATE);
    public static List<State> dfsSolution = DFS(INITIAL_STATE, MAX_DEPTH);

    public static void main(String[] args) {
        executing();
    }

    // Method to display the solutions For BFS and DFS
    private static void displaySolution(List<State> solution, String method) {
        if (solution != null) {
            if(method.equals("DFS")){
                System.out.println("******************** Depth-First Search ********************");
            } else if(method.equals("BFS")) {
                System.out.println("******************** Breadth-First Search ********************");
            } else {
                System.out.println("Choose Method");
            }
            System.out.println(method + " Solution : ");
            System.out.println("Steps  : (ML  :  CL  :  Boat  :  MR  :  CR) ");
            for (int i = 0; i < solution.size(); i++) {
                State state = solution.get(i);
                String boatSide = (state.boat == 1) ? "[Left ]" : "[Right]";
                System.out.printf("Step %d : (%d  :  %d  :   %s   :  %d  :  %d)\n",
                        i + 1, state.mLeft, state.cLeft, boatSide, state.mRight, state.cRight);
            }
        } else {
            System.out.println("There is No Solution");
        }
    }

    //Breadth-First Search method to solve the problem
    public static List<State> BFS(State initialState) {
        //BFS method frontier using Queue
        Queue<List<State>> bfsQueue = new LinkedList<>();
        /*
            Adds the created ArrayList to the end of the queue.
            The offer method is used to enqueue an element in the queue.
        */
        bfsQueue.offer(new ArrayList<>(List.of(initialState)));
        //this hash set use to keep track of the states have been visited
        Set<State> visited = new HashSet<>();
        //continue while the Queue not empty
        while (!bfsQueue.isEmpty()) {
            //dequeues the front path from the queue
            List<State> path = bfsQueue.poll();
            //The dequeued path is stored in the variable path
            State currentState = path.get(path.size() - 1);

            //after dequeue if the state not visited
            if (!visited.contains(currentState)) {
                //make it visited
                visited.add(currentState);
                //Checks if the current state is the goal state. If true, returns the path representing the solution
                if (currentState.mLeft == 0 && currentState.cLeft == 0 && currentState.boat == 0
                        && currentState.mRight == 3 && currentState.cRight == 3) {
                    return path;
                }
                //knowing the possible next states from the current state
                for (State nextState : currentState.nextState(currentState)) {
                    //if the state not visited
                    if (!visited.contains(nextState)) {
                        //create path for the possible next states from the current state
                        List<State> newPath = new ArrayList<>(path);
                        newPath.add(nextState);
                        bfsQueue.offer(newPath);
                    }
                }
            }
        }
        return null;
    }

    //DFS method frontier using Stack
    public static List<State> DFS(State initialState, int maxDepth) {
        //this stack contains lists of state that represent the path from initial to current state
        Stack<List<State>> dfsStack = new Stack<>();

        //Set for knowing if the state is visited or not
        Set<State> visited = new HashSet<>();

        //push the initial state in the stack
        dfsStack.push(List.of(initialState));

        //continue while the stack not empty
        while (!dfsStack.isEmpty()) {
            //pop the State from stack
            List<State> path = dfsStack.pop();
            //Retrieves the current state from the last element of the path
            State currentState = path.get(path.size() - 1);

            //Skips the current path if its length exceeds the specified maximum depth to avoid memory error
            if (path.size() > maxDepth) {
                continue;
            }
            //if the state has not been visited
            if (!visited.contains(currentState)) {
                //it is added to the visited to avoid stuck in loop
                visited.add(currentState);

                //Checks if the current state is the goal state. If true, returns the path representing the solution
                if (currentState.mLeft == 0 && currentState.cLeft == 0 && currentState.boat == 0
                        && currentState.mRight == 3 && currentState.cRight == 3) {
                    return path;
                }
                //Iterates over each possible next state
                for (State nextState : currentState.nextState(currentState)) {
                    if (!visited.contains(nextState)) {
                        List<State> newPath = new ArrayList<>(path);
                        newPath.add(nextState);
                        dfsStack.push(newPath);
                    }
                }
            }
        }
        return null;
    }

    // Method to executing the algorithms and to calculate the executing time of each algo.
    private static void executing() {
        long startTime, endTime;
        long bfsTime, dfsTime;

        startTime = System.currentTimeMillis();
        bfsSolution = BFS(INITIAL_STATE);
        endTime = System.currentTimeMillis();
        bfsTime = endTime - startTime;

        startTime = System.currentTimeMillis();
        dfsSolution = DFS(INITIAL_STATE, 12);
        endTime = System.currentTimeMillis();
        dfsTime = endTime - startTime;

        System.out.println();
        displaySolution(bfsSolution, "BFS");
        System.out.println("BFS Execution Time: " + bfsTime + " milliseconds");
        System.out.println();
        displaySolution(dfsSolution, "DFS");
        System.out.println("DFS Execution Time: " + dfsTime + " milliseconds");
    }


}

