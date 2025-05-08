function solution(s) {
    let count = 0;
    let zero = 0;
    while ( s !== '1') {
        count += 1;
        let temp = s.replaceAll('0','');
        zero += s.length - temp.length;
        s = temp.length.toString(2);
    }
    return [count, zero];
}