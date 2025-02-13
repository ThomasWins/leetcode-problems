## Approach
The problem requires us to repeatedly combine the smallest elements until we exceed k. This naturally suggests using a min-heap (priority queue), as it allows efficient retrieval and updating of the smallest elements.
The heap structure enables **O(log n)** insertions and deletions, making it optimal for this type of problem.
## Complexity
- Time Complexity:
`O(nlogn)`

- Space Complexity:
`O(n)`
