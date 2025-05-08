function solution(s) {
    let answer = [];
    let words = s.split(' ');

    for (let word of words) {
        let result = ''
        for (let i = 0; i < word.length; i++) {
            result += i % 2 === 0 ? word[i].toUpperCase() : word[i].toLowerCase();
        }
        answer.push(result)
    }
    return answer.join(' ');
}