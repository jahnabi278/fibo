<h2><b>Fibonacci Heap</b></h2>- A Fibonacci heap is defined as the collection of rooted-tree in which all the trees must hold the property of Min-heap. That is, for all the nodes, the key value of the parent node should be greater than the key value of the parent node.

<h2><b><u>Properties of Fibonacci Heap:</u></b></h2>

-> It can have multiple trees of equal degrees, and each tree doesn't need to have 2^k nodes.
-> All the trees in the Fibonacci Heap are rooted but not ordered.
-> All the roots and siblings are stored in a separated circular-doubly-linked list.
-> The degree of a node is the number of its children. Node X -> degree = Number of X's children.
-> Each node has a mark-attribute in which it is marked TRUE or FALSE. The FALSE indicates the node has not any of its children. The TRUE represents that the node has lost one child. The newly created node is marked FALSE.
-> The potential function of the Fibonacci heap is F(FH) = t[FH] + 2 * m[FH]
-> The Fibonacci Heap (FH) has some important technicalities listed below:
-> min[FH] - Pointer points to the minimum node in the Fibonacci Heap
-> n[FH] - Determines the number of nodes
-> t[FH] - Determines the number of rooted trees
-> m[FH] - Determines the number of marked nodes
-> F(FH) - Potential Function.
The time complexities of different operations performed on a Fibonacci heap are listed below in the table:

1. Find Min Q (1) Binary and Binomial heaps have the same time complexity.
2.Extract Min O(D(n)) = O(log n) Binary and Binomial heaps have the same time complexity.
3.Delete a Node Q (1) Binary takes O(logn) and Binomial takes Q (1)
4.Decrease Key Q (1) Binary and Binomial both take O(logn)
5.Union Q (1) Binarytakese O(m logn) or O(m+n) and Binomial takes O(logn).
