function getPermutation(p, rests, output) {
    if (p.length > 0) output.push(Number(p.join('')));
    if (rests.length === 0) return;
    
    rests.forEach((v, i) =>{
        const rest = [...rests.slice(0, i), ...rests.slice(i + 1)];
        getPermutation([...p, v], rest, output)
    })
}

function isPrime(n) {
    if (n < 2) return false;
    if (n === 2) return true;
    if (n % 2 ===0) return false;
    for (let i = 3; i < Math.sqrt(n) + 1; i++) {
        if (n % i === 0) return false;
    }
    return true;
}

function solution(numbers) {
    let count = 0;
    let numList = []
    getPermutation([], numbers.split(''), numList);
    numList = [...new Set(numList)];
    
    for (let n of numList) {
        if (isPrime(n)) count++;
    }
    return count;
}