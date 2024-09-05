function solution(s) {
    var answer = [];
    let left = [];
    let index = 0;
    for (let ch of s) {
        if (left.includes(ch)) {
            let previousIndex = s.lastIndexOf(ch, index - 1);
            answer.push(index - previousIndex);
        } else {
            answer.push(-1);
            left.push(ch);
        }
        index++;
    }
    return answer;
}