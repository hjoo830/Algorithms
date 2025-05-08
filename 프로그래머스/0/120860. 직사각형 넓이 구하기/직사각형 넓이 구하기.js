function solution(dots) {
    let answer = 0;
    let x = []
    let y = []
    
    dots.forEach((p) => {
        x.push(p[0])
        y.push(p[1])
    })
    
    answer = (Math.max(...x) - Math.min(...x)) * (Math.max(...y) - Math.min(...y)) 
    return answer;
}