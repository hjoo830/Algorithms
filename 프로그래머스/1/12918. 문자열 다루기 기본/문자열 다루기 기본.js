function solution(s) {
    const regex = /^[0-9]*$/;
    if (regex.test(s) && (s.length == 4 || s.length == 6)) return true;
    return false;
}