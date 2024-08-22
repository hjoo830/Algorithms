function solution(quiz) {
    var answer = [];
    for (let i = 0; i < quiz.length; i++) {
        let [x, operator, y, equal, z] = quiz[i].split(" ");        
        x = parseInt(x);
        y = parseInt(y);
        z = parseInt(z);

        let result;
        if (operator === "+") {
            result = x + y;
        } else if (operator === "-") {
            result = x - y;
        }
        
        if (result === z) {
            answer.push("O");
        } else {
            answer.push("X");
        }
    }
    return answer;
}
