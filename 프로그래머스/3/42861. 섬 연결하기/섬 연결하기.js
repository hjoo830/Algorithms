function find(parent, x) {
    if (parent[x] !== x) {
        parent[x] = find(parent, parent[x]);
    }
    return parent[x];
}

function union(parent, a, b) {
    let pA = find(parent, a);
    let pB = find(parent, b);
    
    if (pA < pB) parent[pB] = pA;
    else parent[pA] = pB;   
}

function solution(n, costs) {
    costs.sort((a, b) => a[2] - b[2]);
    
    let parent = Array.from({length: n}, (_, i) => i);
    let total = 0;
    
    costs.forEach((cost) => {
        if (find(parent, cost[0]) !== find(parent, cost[1])) {
            union(parent, cost[0], cost[1]);
            total += cost[2];
        }
    })
    
    return total;
}