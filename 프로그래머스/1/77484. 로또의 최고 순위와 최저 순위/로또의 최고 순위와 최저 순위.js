function solution(lottos, win_nums) {
    var answer = [];
    let count = 0;
    
    lottos.forEach((n) => {
        win_nums.forEach((m) => {
           if (n == m) {
               count += 1
           } 
        });
    });
    
    if (count == 0) count += 1;
    answer.push(7 - count);
    
    lottos.forEach((n) => {
       if (n == 0) {
           count += 1
       } 
    });
    
    if (count == 7) count -= 1;
    answer.push(7 - count)
    
    return answer.sort();
}