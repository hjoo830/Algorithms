function getCombinations(arr, selectNumber) {
    const results = [];
    if (selectNumber === 1) return arr.map(el => [el]);

    arr.forEach((fixed, index, origin) => {
        const rest = origin.slice(index + 1);
        const combinations = getCombinations(rest, selectNumber - 1);
        const attached = combinations.map(combination => [fixed, ...combination]);
        results.push(...attached);
    });

    return results;
}

function solution(number) {
    let answer = 0;
    
    const combinations = getCombinations(number, 3);
    combinations.forEach(combination => {
        const sum = combination.reduce((acc, curr) => acc + curr, 0);
        if (sum === 0) {
            answer++;
        }
    });
    
    return answer;
}
