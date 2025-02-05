bool areAlmostEqual(char* s1, char* s2) {

    if (strlen(s1) != strlen(s2)) return false;
    int check = 2;
    int index = 0;
    for (int i = 0; i < strlen(s1); i++) {

        if(s1[i] != s2[i] && check == 2) {
            check = 1;
            index = i;
        } else if(s1[i] != s2[i] && check == 1) {
            if(s1[index] != s2[i] || s1[i] != s2[index]) {
                return false;
            }
            check = 0;
        } else if (s1[i] != s2[i] && check == 0) {
            return false;
        }
    }
    return (check == 1) ? false : true;
}
