function solution(arr) {
    let min=100000000;
    let minIndex=0;
    arr.forEach((value, i)=>{
        if(value<min){
            min=value;
            minIndex=i
        }
    });
    arr.splice(minIndex,1);
    if(arr.length==0){
        arr.push(-1);
    }
    return arr;
}