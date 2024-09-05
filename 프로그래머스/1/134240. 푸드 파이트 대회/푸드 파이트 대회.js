function solution(food) {
    let player = '';
    for (let i = 1; i < food.length; i++) {
        for (let j = 0; j < Math.floor(food[i] / 2); j++) {
            player += (i);
        }
    }
    let answer = player;
    answer += 0;
    for (let i = player.length - 1; i >= 0; i--) {
        answer += player[i];
    }
    return answer;
}