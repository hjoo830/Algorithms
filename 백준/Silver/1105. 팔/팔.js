const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split(" ");
let L = input[0].trim();
let R = input[1].trim();

if (L.length !== R.length) {
  console.log(0);
} else {
  let count = 0;
  for (let i = 0; i < L.length; i++) {
    if (L[i] !== R[i]) {
      break;
    }
    if (L[i] === "8") {
      count += 1;
    }
  }
  console.log(count);
}