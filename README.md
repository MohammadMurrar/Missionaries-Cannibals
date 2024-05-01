# Missionaries Cannibals
## COMP338 (AI) project
Solves the missionaries and cannibals problem with iterative deepening search.

The problem is as follows:

Three missionaries and three cannibals are on one side of a river, along with a boat that can hold one or two people.

initial state

Find a way to get everyone to the other side, without ever leaving a group of missionaries on one side outnumbered by the cannibals.

The current state is represented with a list [a, b, c]. This list represents the number of missionaries on the wrong side, cannibals on the wrong side, and whether the boat is on the wrong side. Initially all the missionaries, cannibals, and the boat are on the wrong side of the river. The list representing the initial state is [3, 3, 1], while the list representing the goal state is [0, 0, 0].

The program outputs the 11 step path to the goal state to the screen.
