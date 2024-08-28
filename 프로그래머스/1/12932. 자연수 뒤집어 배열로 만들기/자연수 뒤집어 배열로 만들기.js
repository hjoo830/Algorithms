function solution(n) {
    var answer = [];
    n = n.toString()
    let size = n.length;
    for (let i=size-1; i>=0; i--) {
        answer.push(parseInt(n[i]))
    }
    return answer;
}