const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const n = parseInt(input[0]);
const m = parseInt(input[1]);

let adj = Array.from({ length: n + 1 }, () => []);
for (let i = 2; i < 2 + m; i++) {
  const [s, e] = input[i].split(" ").map(Number);
  adj[s].push(e);
  adj[e].push(s);
}

function bfs(s) {
  let v = new Array(n + 1).fill(false);
  let q = [s];
  v[s] = true;
  let count = 0;

  while (q.length) {
    let c = q.shift();
    for (let n of adj[c]) {
      if (!v[n]) {
        v[n] = true;
        q.push(n);
        count++;
      }
    }
  }
  return count;
}

count = bfs(1);
console.log(count);