typedef struct Heap {
    int * arr;
    int size;
    int capacity;
} Heap;

Heap * createHeap(int capacity) {
    Heap * heap = malloc(sizeof(Heap));
    heap->arr = (int*)malloc(sizeof(int) * capacity);
    heap->size = 0;
    heap->capacity = capacity;
    return heap;
}

void swap(int* x, int* y) {
    *x ^= *y;
    *y ^= *x;
    *x ^= *y;
}

void heapify(Heap* heap, int i) {
    int lowest = i;
    int left = i * 2 + 1;
    int right = i * 2 + 2;

    if(left < heap->size && heap->arr[left] < heap->arr[lowest]) {
        lowest = left;
    }

    if(right < heap->size && heap->arr[right] < heap->arr[lowest]) {
        lowest = right;
    }

    if(lowest != i) {
        swap(&heap->arr[i], &heap->arr[lowest]);
        heapify(heap, lowest);
    }
}

int heappop(Heap* heap) {
    if(heap->size == 0) return INT_MAX;

    if(heap->size == 1) {
        heap->size--;
        return heap->arr[0];
    }

    int root = heap->arr[0];
    heap->arr[0] = heap->arr[heap->size - 1];
    heap->size--;
    heapify(heap, 0);

    return root;
}

int heappush(Heap* heap, int val) {
    if(heap->size == heap->capacity) {
        return -1;
    }

    heap->size++;
    int i = heap->size - 1;
    heap->arr[i] = val;

    while(i != 0 && heap->arr[(i - 1) / 2] > heap->arr[i]) {
        swap(&heap->arr[(i - 1) / 2], &heap->arr[i]);
        i = (i - 1) / 2;
    }

    return 0;
}

int minOperations(int* nums, int numsSize, int k) {
    // Init heap
    Heap* heap = createHeap(numsSize);
    int count = 0;

    for(int i = 0; i < numsSize; i++) {
        heappush(heap, nums[i]);
    }

    for (int i = 0; i < numsSize; i++) {
        int minVal = heappop(heap);
        if (minVal >= k) break;

        int maxVal = heappop(heap);
        
        if (k - maxVal > minVal && k - maxVal - minVal > minVal){
            heappush(heap, minVal * 2 + maxVal);
        }
            
        count++;
    }

    free(heap->arr);
    free(heap);
    return count;
}
