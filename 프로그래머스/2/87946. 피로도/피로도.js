function permutation(p, rests, output) {
    if (rests.length === 0) return output.push(p);
    
    rests.forEach((v, i) => {
        const rest = [...rests.slice(0, i), ...rests.slice(i + 1)];
        permutation([...p, v], rest, output);
    })
}

function solution(k, dungeons) {
    let answer = -1;
    let perm = []
    permutation([], dungeons, perm)
    
    for (let d of perm) {
        let hp = k;
        let count = 0;
        for (let i = 0; i < d.length; i++) {
            if (hp < d[i][0]) continue;
            hp -= d[i][1]
            count++;
        }
        if (count > answer) answer = count;
    }
    return answer;
}