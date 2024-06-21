const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const firstLine = input[0].split(" ");
let N = parseInt(firstLine[0]);
let M = parseInt(firstLine[1]);

let arr = Array.from({ length: N }, () => []);
for (let i = 0; i < N; i++) {
  for (let j = 0; j < M; j++) {
    arr[i].push(
      parseInt(input[i + 1].split(" ")[j]) +
        parseInt(input[i + N + 1].split(" ")[j])
    );
  }
}

let result = "";

for (let i = 0; i < N; i++) {
  for (let j = 0; j < M; j++) {
    result += arr[i][j] + " ";
  }
  console.log(result);
  result = "";
}