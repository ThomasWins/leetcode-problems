int minimumRecolors(char* blocks, int k) {
    
    int tmp = 0;

    for (int i = 0; i < k; i++){
        if(blocks[i] == 'W') tmp++;
    }

    int count = tmp;
    for (int i = k; i < strlen(blocks); i++){
        if (blocks[i - k] == 'W') tmp--;
        if (blocks[i] == 'W') tmp++;
        if (tmp < count) count = tmp;
    }
    return count;
}
