int compare1(const void* a, const void* b){

    const char* str1 = *(const char**)a;
    const char* str2 = *(const char**)b;

    int cmpResult;

    // Find the first word of each String
    const char* word1 = strchr(str1, ' ') + 1;
    const char* word2 = strchr(str2, ' ') + 1;

    // Check whether isLetter or digit
    int isLetter1 = isalpha(word1[0]);
    int isLetter2 = isalpha(word2[0]);


    if (isLetter1 && isLetter2){
        // Check the first word to determine which is first
        cmpResult = strcmp(word1, word2);
        if (cmpResult == 0){ // Check entire string
            return strcmp(str1, str2);
        } else {
            return cmpResult;
        }

    } else if (isLetter1){ // Second string is a digit string
        return -1;
    } else if (isLetter2){ // First string is a digit string
        return 1;
    } else // Both digits so no change
        return 0;
 }

char** reorderLogFiles(char** logs, int logsSize, int* returnSize) {
    *returnSize = logsSize;
    qsort(logs, logsSize, sizeof(char*), compare1);
    return logs;
}
