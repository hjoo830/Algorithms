function solution(s) {
    var answer = 0;
     while (s.length > 0) {
        first=s[0];
        firstCount=0;
        otherCount=0;
        
        for (let i = 0; i < s.length; i++) {
            if (s[i]==first){
                firstCount++;
            }else{
                otherCount++;
            }
            if(firstCount==otherCount){
                s=s.substring(i+1)
                answer++;
                break;
            }
            if (i === s.length - 1) {
                s = "";  
                answer++;
            }
        }
    }
    return answer;
}