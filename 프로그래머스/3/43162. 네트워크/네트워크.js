function bfs(s, v, adj) {
    let q = [s];
    v[s] = true;
    
    while (q.length) {
        let c = q.shift();
        for (let n of adj[c]) {
            if (!v[n]) {
                v[n] = true;
                q.push(n);
            }
        }
    }
}

function solution(n, computers) {    
    let adj = Array.from({length: n}, () => [])
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            if (i === j) continue;
            if (computers[i][j] === 1) adj[i].push(j);
        }
    }
    
    let v = Array.from({length: n}, () => false);
    let count = 0;
    
    for (let com = 0; com < n; com++) {
        if (!v[com]) {
            bfs(com, v, adj);
            count++;
        }
    }
    
    return count;
}