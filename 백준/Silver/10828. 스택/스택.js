const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let n = input[0];
let stack = [];

for (let i = 1; i <= n; i++) {
  command = input[i].split(' ');
  if (command[0] == 'push') stack.push(command[1]);
  if (command[0] == 'pop') {
    if (stack.length == 0) console.log(-1);
    else {
      c = stack.pop();
      console.log(c);
    }
  }
  if (command[0] == 'size') console.log(stack.length);
  if (command[0] == 'empty') {
    if (stack.length == 0) console.log(1);
    else console.log(0);
  }
  if (command[0] == 'top') {
    if (stack.length == 0) console.log(-1);
    else {
      c = stack.pop();
      console.log(c);
      stack.push(c);
    }
  }
}
