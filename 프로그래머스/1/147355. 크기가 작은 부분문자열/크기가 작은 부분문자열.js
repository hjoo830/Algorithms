function solution(t, p) {
  var answer = 0;
  let sub = [];
  for (let i = 0; i < t.length - p.length + 1; i++) {
    sub.push(t.substr(i, p.length));
  }

  sub.forEach((n) => {
    if (parseInt(n) <= parseInt(p)) {
      answer++;
    }
  });
  return answer;
}
