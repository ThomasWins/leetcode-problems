int* findMissingAndRepeatedValues(int** grid, int gridSize, int* gridColSize, int* returnSize) {
    int* map = (int*)calloc(gridSize * gridSize, sizeof(int));
    int* ans = (int*)malloc(2 * sizeof(int));
    *returnSize = 2;

    // count occurences
    for(int i = 0 ;i < gridSize; i++){
        for(int j = 0; j < gridSize; j++){
            map[grid[i][j] - 1]++;
        }
    }

    for(int i = 0 ; i < gridSize * gridSize; i++){
        if(map[i] == 2) ans[0] = i+1; // repeated value
        if(map[i] == 0) ans[1] = i+1; // missing value
    }

    return ans;
}
