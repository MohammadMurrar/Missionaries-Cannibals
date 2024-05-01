# Missionaries Cannibals
## COMP338 (AI) project
Solves the missionaries and cannibals problem with iterative deepening search algorithms.
1. Breadth First Search.
2. Depth First Search.

The problem is as follows:
Three missionaries and three cannibals are on one side of a river, along with a boat that can hold one or two people.
![image](https://github.com/MohammadMurrar/Missionaries-Cannibals/assets/147532846/74c62262-3478-4d7a-b2dd-78d5c4a095c0)

Find a way to get everyone to the other side, without ever leaving a group of missionaries on one side outnumbered by the cannibals.
The current state is represented with a list [a, b, c]. This list represents the number of missionaries on the wrong side, cannibals on the wrong side, and whether the boat is on the wrong side. Initially all the missionaries, cannibals, and the boat are on the wrong side of the river. The list representing the initial state is [3, 3, 1], while the list representing the goal state is [0, 0, 0].

# Output
. BFS 
![image](https://github.com/MohammadMurrar/Missionaries-Cannibals/assets/147532846/bd17c13b-50f1-4a53-9565-e63e6e5b765a)

. DFS
![image](https://github.com/MohammadMurrar/Missionaries-Cannibals/assets/147532846/af883d09-839a-4166-af73-06a4971ec589)



