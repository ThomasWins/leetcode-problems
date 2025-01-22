struct graph {
    int row;
    int column;
};

int** highestPeak(int** isWater, int isWaterSize, int* isWaterColSize, int* returnSize, int** returnColumnSizes) {
    
    int** array = malloc(sizeof(int *) * isWaterSize);
    for(int i = 0; i < isWaterSize; i++) {
        array[i] = malloc(sizeof(int) * isWaterColSize[i]);
    }

    struct graph* queue = malloc(sizeof(struct graph *) * isWaterSize * (*isWaterColSize));
    int front = 0;
    int rear = 0;

    for(int i = 0; i < isWaterSize; i++) {
        for(int j = 0; j < isWaterColSize[i]; j++) {
            if (isWater[i][j] == 1) {
                array[i][j] = 0;
                queue[rear++] = (struct graph) {i, j};
            } else {
                array[i][j] = -1;
            }
        }
    }

    int direction[4][2] = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}};

    while (front < rear) {

        struct graph current = queue[front++];

        for(int i = 0; i < 4; i++) {
            int newRow = current.row + direction[i][0];
            int newColumn = current.column + direction[i][1];

            if (newRow >= 0 && newRow < isWaterSize && newColumn >= 0 && newColumn < isWaterColSize[newRow] && array[newRow][newColumn] == -1) {
                array[newRow][newColumn] = array[current.row][current.column] + 1;
                queue[rear++] = (struct graph) {newRow, newColumn};
            }
        }
    }

    *returnSize = isWaterSize; 
    *returnColumnSizes = malloc(sizeof(int) * isWaterSize);

    for(int i = 0; i < isWaterSize; i++) {
        (*returnColumnSizes)[i] = isWaterColSize[i];
    }

    return array; 
}