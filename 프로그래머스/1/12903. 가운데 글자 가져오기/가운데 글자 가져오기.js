function solution(s) {
    var answer = '';
    if(s.length%2 != 0){
        answer = s.substring(Math.floor(s.length/2), Math.floor(s.length/2)+1);
    }else{
        answer = s.substring((s.length/2)-1, s.length/2+1);
    }
    return answer;
}