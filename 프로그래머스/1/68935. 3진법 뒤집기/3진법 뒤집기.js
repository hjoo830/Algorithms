function solution(n) {
    let three = n.toString(3)
    let size = three.toString().length;
    let threeReverse = ''
    for (let i=size-1; i>=0; i--) {
        threeReverse += three[i]
    }
    return parseInt(threeReverse, 3);
}