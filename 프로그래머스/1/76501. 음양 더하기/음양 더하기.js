function solution(absolutes, signs) {
    var answer = 0;
    absolutes.forEach((value, i)=>{
        if (signs[i]){
            answer+=value;
        }else{
            answer-=value;
        }
    });
    return answer;
}