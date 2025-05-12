function getPermutation(permu, rests, output) {
    if (permu.length > 0) output.push(Number(permu.join('')));
    if (rests.length === 0) return;
    
    rests.forEach((v, i) => {
        const rest = [...rests.slice(0, i), ...rests.slice(i + 1)]
        getPermutation([...permu, v], rest, output);
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
    let perm = []
    getPermutation([], numbers.split(''), perm);
    perm = [...new Set(perm)];
    
    for (let p of perm) {
        if (isPrime(p)) count++;
    }
    return count;
}