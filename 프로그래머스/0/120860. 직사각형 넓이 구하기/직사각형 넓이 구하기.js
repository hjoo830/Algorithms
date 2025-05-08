function solution(dots) {
    var answer = 0;
    let w = 0;
    let h = 0;
    
    for (let i = 0; i < 2; i++) {
        for (let j = 3; j > 1; j--) {
            if (dots[i][0] !== dots[j][0]) {
                w = dots[i][0] - dots[j][0];
            }
        }
    }
    
    for (let i = 0; i < 2; i++) {
        for (let j = 3; j > 1; j--) {
            if (dots[i][1] !== dots[j][1]) {
                h = dots[i][1] - dots[j][1];
            }
        }
    }
    answer = w * h > 0 ? w * h : -w * h;
    
    return answer;
}