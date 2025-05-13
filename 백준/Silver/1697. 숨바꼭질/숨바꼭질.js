const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split(" ");

const n = parseInt(input[0]);
const k = parseInt(input[1]);

function bfs(s, e) {
  let q = [s];
  let v = Array.from({ length: 200001 }, () => 0);
  v[s] = 1;

  while (q.length) {
    let c = q.shift();

    if (c === e) return v[e] - 1;

    for (let n of [c - 1, c + 1, c * 2]) {
      if (0 <= n && n <= 200000 && v[n] === 0) {
        q.push(n);
        v[n] = v[c] + 1;
      }
    }
  }
}

let answer = bfs(n, k);
console.log(answer);
