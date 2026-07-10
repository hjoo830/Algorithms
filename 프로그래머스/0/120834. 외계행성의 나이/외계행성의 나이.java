class Solution {
    public String solution(int age) {
        String answer = "";
        char[] map = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        String str = age + "";
        for (int i = 0; i < str.length(); i++) {
            answer += map[str.charAt(i) - '0'];
        }
        return answer;
    }
}