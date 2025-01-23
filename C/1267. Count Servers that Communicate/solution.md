## Intuition
My first thoughts were to brute force this problem- after sorting through the grid and finding the first computer, I would call another nested for loop to loop through the current row and col. After realizing the pattern I noticed that I can achieve the same solution with 2 arrays holding all values for the current row and col.

## Approach
Began iterating through the grid and filled my `rowCount` and `colCount` with computerss that were connected. After all computers were accounted for, iterate through the grid one more time and find any computers that were in `colCount` or `rowCount` that were **> 1**

### Complexity
Time complexity:
`O(m * n)`

### Space complexity:
`O(m + n)`
