function solution(n, results) {
    let answer = 0;
    let players = Array.from({length: n}, (_, i) => i + 1);
    let chart = Array.from({length: n + 1}, () => Array(n + 1).fill(false));
    
    results.forEach((result) => {
        const [win, lose] = result;
        chart[win][lose] = 1;
        chart[lose][win] = -1;
        chart[win][win] = 0;
        chart[lose][lose] = 0;
        
    })
    
    for(let m of players) {
        for(let s of players){
            for(let e of players){
                if (chart[s][m] === 1 && chart[m][e] === 1) chart[s][e] = 1;
                if (chart[s][m] === -1 && chart[m][e] === -1) chart[s][e] = -1;
                
            }
        }
    }
    chart.forEach((player) => {
        player.slice(1).every(p => p!== false) && answer++
    })

    return answer;
}