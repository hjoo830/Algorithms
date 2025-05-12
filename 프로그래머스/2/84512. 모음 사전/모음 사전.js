function solution(word) {
    const vowels = ['A', 'E', 'I', 'O', 'U'];
    let weights = [];

    let w = 0;
    for (let i = 0; i < 5; i++) {
        w = 0;
        for (let j = i; j < 5; j++) {
            w += Math.pow(5, 4 - j);
        }
        weights.push(w);
    }

    let answer = 0;
    for (let i = 0; i < word.length; i++) {
        const idx = vowels.indexOf(word[i]);
        answer += idx * weights[i] + 1;
    }

    return answer;
}
