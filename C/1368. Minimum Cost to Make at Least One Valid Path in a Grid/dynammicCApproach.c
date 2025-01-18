int minCost(int** grid, int gridSize, int* ColSize) {

    int gridColSize = ColSize[0];
    int minChanges[gridSize][gridColSize];

    for (int i = 0; i < gridSize; i++){
        for (int j = 0; j < gridColSize; j++){
            minChanges[i][j] = 2147483647; // MAX_INT
        }
    }
    int prev[gridSize][gridColSize];
    minChanges[0][0] = 0;

    while (1 == 1) {
        // Save existed array before changing it
        for (int i = 0; i < gridSize; i++){
            for (int j = 0; j < gridColSize; j++){
                prev[i][j] = minChanges[i][j];
            }
        }
        // Front Pass (Above and Left cells)
        for (int i = 0; i < gridSize; i++){
            for (int j = 0; j < gridColSize; j++){
                // If the cell above is facing into the current cell, Cost would remain 0, if any other direction cost++
                if (i > 0){
                    minChanges[i][j] = fmin(minChanges[i][j], minChanges[i-1][j] + (grid[i-1][j] == 3 ? 0 : 1));
                }

                // If the cell left is facing into the current cell, Cost would remain 0, if any other direction cost++
                if (j > 0) {
                    minChanges[i][j] = fmin(minChanges[i][j], minChanges[i][j-1] + (grid[i][j-1] == 1 ? 0 : 1));
                }
            }
        }
        // Backwards Pass (Bottom and Right cells)
        for (int i = gridSize-1; i >= 0; i--){
            for (int j = gridColSize-1; j >= 0; j--){

                // If the cell below is facing into the current cell, Cost would remain 0, if any other direction cost++
                if (i < gridSize-1){
                    minChanges[i][j] = fmin(minChanges[i][j], minChanges[i+1][j] + (grid[i+1][j] == 4 ? 0 : 1));
                }

                // If the cell right is facing into the current cell, Cost would remain 0, if any other direction cost++
                if (j < gridColSize-1){
                    minChanges[i][j] = fmin(minChanges[i][j], minChanges[i][j+1] + (grid[i][j+1] == 2 ? 0 : 1));
                }
            }
        }

        bool isEqual = true;
        for (int i = 0; i < gridSize; i++){
            for (int j = 0; j < gridColSize; j++){
                if (prev[i][j] != minChanges[i][j]){
                    isEqual = false;
                    i = gridSize;
                    j = gridColSize;
                } 
            }
        }
        if (isEqual) break;
    }
    return minChanges[gridSize-1][gridColSize-1];
}