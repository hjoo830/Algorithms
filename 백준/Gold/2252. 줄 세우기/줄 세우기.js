const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const [n, m] = input[0].split(" ").map(Number);
let graph = Array.from({ length: n + 1 }, () => []);

for (let i = 1; i <= m; i++) {
  const [a, b] = input[i].split(" ").map(Number);
  graph[a].push(b);
}

let indegree = Array(n + 1).fill(0);
graph.forEach((edges) => {
  edges.forEach((e) => {
    indegree[e] += 1;
  });
});

let q = [];
let result = [];

for (let i = 0; i <= n; i++) {
  if (indegree[i] === 0) q.push(i);
}

while (q.length) {
  let node = q.shift();
  result.push(node);

  let connected = graph[node];
  connected.forEach((c) => {
    indegree[c] -= 1;
    if (indegree[c] === 0) q.push(c);
  });
}
console.log(...result.slice(1));