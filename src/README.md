# Java Play Ground — Learning Map

This source tree is organised as small, runnable lessons. Each Java file has a
`main` method so it can be run independently after compilation.

## Suggested learning order

1. **basics** — variables, methods, validation, conditions, loops, and scope.
2. **oop** — class design and encapsulation, inheritance, abstraction, and polymorphism.
3. **data_structures** — how common structures manage data and their primary operations.
4. **algorithms** — sorting, searching, and dynamic-programming patterns.

## Important habits demonstrated

- Keep state private; expose a small public API with clear method names.
- Validate public inputs early and fail with meaningful exceptions.
- State mutation explicitly. The sorting examples return copies so the caller's
  input remains unchanged.
- Use the standard library in real applications (`Arrays.sort`, `ArrayDeque`,
  collection classes). The custom implementations here teach the mechanics.
- Learn the preconditions. For example, binary search requires sorted input.

## Complexity quick reference

| Topic | Typical operation | Time complexity |
| --- | --- | --- |
| Array | indexed access | O(1) |
| Singly linked list | find by index | O(n) |
| Stack / queue | add or remove at end/front | O(1) |
| Binary search tree | search / insert | O(h) |
| Graph traversal | BFS / DFS | O(V + E) |
| Merge sort | sort | O(n log n) |
| Binary search | find in sorted array | O(log n) |
| Dynamic programming | depends on state table | commonly O(number of states) |

## Running a lesson

From the `src` directory, compile source files into a separate output folder,
then run a fully qualified class name. For example, after compiling:

```text
java -cp ../bin basics.Functions
java -cp ../bin algorithms.Sorting.Sorting
java -cp ../bin data_structures.Graphs.Graphs
```
