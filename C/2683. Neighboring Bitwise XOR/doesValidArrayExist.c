bool doesValidArrayExist(int* derived, int derivedSize) {
    
    int sum = 0;

    for (int i = 0; i < derivedSize; i++){
        sum = derived[i] ^ sum;
    }

    if (sum == 0) return true;
    else return false;
}