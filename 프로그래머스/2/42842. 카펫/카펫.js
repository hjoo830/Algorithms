function solution(brown, yellow) {
    // brown = 2w + 2(h - 2) -> w = b / 2 - h + 2
    // yellow = (w - 2) * (h - 2) -> w = y / (h - 2) + 2

    let h = 0;
    while (brown / 2 - h !== yellow / (h - 2)) h++;
    return [brown / 2 - h + 2, h];
}