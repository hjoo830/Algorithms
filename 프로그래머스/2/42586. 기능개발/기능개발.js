function solution(progresses, speeds) {
    let answer = [];
    let period = [];
    
    for (let i = 0; i < progresses.length; i++) {
        let day = 1;
        while (progresses[i] + speeds[i] < 100) {
            day += 1;
            progresses[i] += speeds[i];
        }
        period.push(day)
    }

    let day = period[0]
    let count = 1;
    for (let i = 1; i < period.length; i++) {
        if (day >= period[i]) {
            count++;
        } else {
            answer.push(count);
            day = period[i];
            count = 1;
        }        
    }
    answer.push(count);
    return answer;
}