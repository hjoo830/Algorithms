function solution(answers) {
    let answer = [];
    const p1 = [1, 2, 3, 4, 5];
    const p2 = [2, 1, 2, 3, 2, 4, 2, 5];
    const p3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];
    let s1 = 0, s2 = 0, s3 = 0;
    
    for (let i = 0; i < answers.length; i++) {
        if (answers[i] === p1[i % p1.length]) s1++;
        if (answers[i] === p2[i % p2.length]) s2++;
        if (answers[i] === p3[i % p3.length]) s3++;
    }

    if (Math.max(s1, s2, s3) === s1) answer.push(1);
    if (Math.max(s1, s2, s3) === s2) answer.push(2);
    if (Math.max(s1, s2, s3) === s3) answer.push(3);
    
    return answer;
}