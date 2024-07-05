function solution(s, n) {
    var answer = '';   
    let upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    let lower = "abcdefghijklmnopqrstuvwxyz";
    
    for (let i=0; i<s.length; i++){
        if (s[i]==" ") {
            answer+=" ";
            continue;
        }
        if (upper.includes(s[i])){
            let index = (upper.indexOf(s[i])+n)%26;
            answer += upper[index];
        } else {
            let index = (lower.indexOf(s[i])+n)%26;
            answer += lower[index];
        }
    }
    console.log(answer)
    return answer;
}