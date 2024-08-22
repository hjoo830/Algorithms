function solution(babbling) {
    var answer = 0;
    let words = ["aya", "ye", "woo", "ma"];
    for (let i = 0; i < babbling.length; i++) {
        for (let j = 0; j < words.length; j++) {
            if (babbling[i].includes(words[j])) {
                babbling[i] = babbling[i].replace(words[j], " ");
            }
        }
        if (babbling[i].trim() === ""){
            answer += 1;
        }
    }
    return answer;
}