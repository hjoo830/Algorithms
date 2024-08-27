function isDivisorEven(n) {
    let divisorCount = 0;
    for (let i = 1; i <= Math.sqrt(n); i++){
        if (n%i === 0) {
            if (i === n/i) { // 완전 제곱수
                divisorCount += 1;
            } else { // i도 n/i도 둘 다 약수
                divisorCount += 2;
            }
        }
    }
    return divisorCount%2 === 0;

}

function solution(left, right) {
    var answer = 0;
    for (let i = left; i <= right; i++){
        if (isDivisorEven(i)){
            answer+=i;
        } else{
            answer-=i;
        }
    }
    return answer;
}