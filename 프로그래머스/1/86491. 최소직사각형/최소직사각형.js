function solution(sizes) {
    let maxW = 0;
    let maxH = 0;

    for (let s of sizes) {
        if (s[0] < s[1]) [s[0], s[1]] = [s[1], s[0]]
        if (s[0] > maxW) maxW = s[0]
        if (s[1] > maxH) maxH = s[1]
    }
    
    return maxW * maxH;
}