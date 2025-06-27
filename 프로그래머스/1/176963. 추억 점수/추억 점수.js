function solution(name, yearning, photo) {
    const answer = [];
    const map = new Map();
    let score = 0;
    for (let i = 0; i < name.length; i++) {
        map.set(name[i], yearning[i]);
    }
    
    photo.forEach((p) => {
        p.forEach((e) => {
            if (map.has(e)) {
                score += map.get(e);
            }    
        })
        answer.push(score);
        score = 0;
    })
    return answer;
}