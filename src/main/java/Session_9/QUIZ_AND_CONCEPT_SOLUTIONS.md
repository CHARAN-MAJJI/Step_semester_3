# Session 9: Quiz Questions & Concept Questions Solutions

---

## Part B: Quiz Questions (Multiple-Choice Solutions)

### Question 1
**Scenario:** What is the time complexity for accessing an element at a known index in a one-dimensional (1D) array?
- **Correct Option:** `B. O(1)`
- **Explanation:** Arrays support constant-time random access because the memory address of an element at index `i` is directly calculated via pointer arithmetic: `address = base_address + (i * element_size)`. Accessing any index takes \(O(1)\) time regardless of array size.

---

### Question 2
**Scenario:** The operation of adding a new element to a data structure is known as what?
- **Correct Option:** `C. Insertion`
- **Explanation:** Adding or inserting a new element into a data structure is called insertion. Traversal refers to visiting all nodes, deletion means removing an element, and searching means finding an element.

---

### Question 3
**Scenario:** When choosing an appropriate data structure for a given problem, what is the most crucial step?
- **Correct Option:** `C. Matching the required operations and constraints to the strengths of different data structures`
- **Explanation:** Selecting an optimal data structure requires evaluating the specific operations (e.g., frequent lookups vs. rapid insertions/deletions) and performance/space constraints of the application against the time/space complexities of candidate structures.

---

### Question 4
**Scenario:** A software system stores frequently accessed calculations in a cache (extra memory) to avoid recomputing them, thereby speeding up future queries. This scenario best illustrates what concept?
- **Correct Option:** `C. Time vs space trade-offs`
- **Explanation:** Caching utilizes additional memory space to preserve calculated results, eliminating redundant computation time for subsequent queries—a classic example of trading space for time efficiency.

---

### Question 5
**Scenario:** A function has two distinct loops. The first loop iterates `m` times over one input, and the second loop (not nested) iterates `n` times over a different input. What is the overall time complexity?
- **Correct Option:** `B. O(m + n)`
- **Explanation:** Sequentially executed, non-nested loops add their individual complexities together: \(O(m) + O(n) = O(m + n)\).

---

### Question 6
**Scenario:** In which type of data structure are elements arranged sequentially, where each element (except the first/last) has exactly one predecessor and one successor?
- **Correct Option:** `C. Linear data structure`
- **Explanation:** Linear data structures (such as arrays, linked lists, stacks, and queues) arrange elements in a sequential order where every interior element has exactly one predecessor and one successor.

---

### Question 7
**Scenario:** An algorithm performs a number of operations proportional to `2n + 5`. According to the rules of Big-O notation, what is its simplified time complexity?
- **Correct Option:** `C. O(n)`
- **Explanation:** In asymptotic analysis, constant coefficients (such as 2) and lower-order terms (such as 5) are dropped, leaving the dominant linear term \(O(n)\).

---

### Question 8
**Scenario:** Which of the following is an example of a non-primitive data structure?
- **Correct Option:** `D. Linked list`
- **Explanation:** Primitive types (`int`, `char`, `boolean`) are basic built-in data types provided by programming languages. Non-primitive data structures (like Linked Lists, Trees, Graphs) are complex structures built by organizing primitive elements.

---

### Question 9
**Scenario:** For a two-dimensional (2D) array with `m` rows and `n` columns, what is the time complexity of visiting every element exactly once?
- **Correct Option:** `B. O(m × n)`
- **Explanation:** A 2D grid contains \(m \times n\) total cells. Visiting every single element exactly once requires traversing all \(m\) rows and \(n\) columns, resulting in \(O(m \times n)\) time complexity.

---

### Question 10
**Scenario:** What is the fundamental purpose of a data structure?
- **Correct Option:** `C. To organize, store, and access data efficiently for specific operations`
- **Explanation:** The primary goal of a data structure is to organize and store data in memory in a way that allows efficient access, insertion, deletion, and manipulation tailored to application needs.

---

## Part C: Concept Questions Solutions

### Question 1: Unsorted vs. Sorted Array Search Efficiency
- **Search Complexities:**
  - **Unsorted Array:** Linear Search requires **\(O(n)\)** time complexity.
  - **Sorted Array:** Binary Search achieves **\(O(\log n)\)** time complexity.
- **Fundamental Reason for Difference:**
  - In an **unsorted array**, elements have no spatial order. Comparing a target with an element at index `i` provides no information about where the target might be in the rest of the array. Thus, in the worst case, every element must be checked.
  - In a **sorted array**, monotonic order allows Binary Search to compare the target with the middle element. If the target is smaller, the entire right half is eliminated; if larger, the left half is eliminated. Halving the search space at each step reduces the search time exponentially from \(O(n)\) to \(O(\log n)\).

---

### Question 2: Dropping Constant Multipliers in Big-O Notation
- **Purpose of Big-O:** Big-O notation characterizes the **asymptotic growth rate** of an algorithm's running time as the input size \(n\) approaches infinity (\(n \to \infty\)), rather than calculating exact operational counts or hardware execution times.
- **Formally:** A function \(f(n)\) is in \(O(g(n))\) if there exist positive constants \(c\) and \(n_0\) such that \(f(n) \le c \cdot g(n)\) for all \(n \ge n_0\).
  - For \(f(n) = 2n\), taking \(c = 2\) and \(g(n) = n\) gives \(2n \le 2n\), which proves \(2n \in O(n)\).
- **Practical Significance:** Doubling input size for an \(O(n)\) algorithm doubles execution time, and for \(O(2n)\) it also doubles execution time. The multiplicative factor 2 scales absolute execution time by a constant factor, but does not alter how the algorithm scales as \(n\) grows extremely large.

---

### Question 3: Traversal Strategies: Linear vs. Non-Linear Data Structures
- **Structural Relationship:**
  - **Linear Structures (e.g., Arrays, Linked Lists):** Elements have a 1-to-1 sequential relationship (each element has at most 1 predecessor and 1 successor).
  - **Non-Linear Structures (e.g., Trees, Graphs):** Elements have 1-to-many (hierarchical) or many-to-many relationships (a node can have multiple children or neighboring edges).
- **Traversal Strategy Differences:**
  - **Linear Traversal:** Follows a single linear path from start to end (e.g., iterating index `0` to `n-1` or following `.next` pointers). It requires \(O(1)\) memory and has a single deterministic path.
  - **Non-Linear Traversal:** At each step, multiple branching choices exist. To ensure every node is visited without getting lost or repeating, traversal algorithms must manage state explicitly using auxiliary data structures:
    - **Depth-First Traversal (DFS - Preorder/Inorder/Postorder):** Uses a call stack or explicit `Stack` to explore deep down a branch before backtracking.
    - **Breadth-First Traversal (BFS - Level-Order):** Uses a `Queue` to process nodes level-by-level across all branches.
