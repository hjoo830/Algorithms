import java.util.*;

class Solution {
    private static final String[] MAP = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        bt(digits, 0, new StringBuilder(), answer);
        return answer;
    }

    private void bt(String digits, int idx, StringBuilder current, List<String> answer) {
        if (idx == digits.length()) {
            answer.add(current.toString());
            return;
        }

        int digit = digits.charAt(idx) - '0';
        for (char candidate : MAP[digit].toCharArray()) {
            current.append(candidate);
            bt(digits, idx + 1, current, answer);
            current.deleteCharAt(current.length() - 1);
        }
    }
}