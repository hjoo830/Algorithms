const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split(" ");

const n = parseInt(input[0]);
const k = parseInt(input[1]);

function bfs(s, e) {
  let v = Array(200001).fill(false);
  let path = Array(200001).fill(-1);

  let q = [s];
  v[s] = true;

  while (q.length) {
    let c = q.shift();

    if (c === e) break;

    for (let n of [c - 1, c + 1, c * 2]) {
      if (0 <= n && n <= 200000 && !v[n]) {
        q.push(n);
        v[n] = true;
        path[n] = c;
      }
    }
  }

  let result = [];
  let c = e;
  while (c !== -1) {
    result.push(c);
    c = path[c];
  }
  result.reverse();
  return result;
}

let path = bfs(n, k);
console.log(path.length - 1);
console.log(...path);