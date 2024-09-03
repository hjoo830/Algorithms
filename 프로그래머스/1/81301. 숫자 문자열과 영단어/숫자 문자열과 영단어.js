function solution(s) {
    let nums = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine'];
    nums.forEach((n, i) => (s = s.replaceAll(n, i)));
    return parseInt(s);
}