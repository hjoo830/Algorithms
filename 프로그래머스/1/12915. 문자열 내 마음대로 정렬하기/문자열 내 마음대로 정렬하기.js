function solution(strings, n) {
    return strings.sort((s1, s2) => {
        if (s1[n] === s2[n]) {
            if (s1 < s2) {
                return -1;
            } else {
                return 1;
            }
        } else {
            if (s1[n] < s2[n]) {
                return -1;
            } else {
                return 1;
            }
        }
    });
}
