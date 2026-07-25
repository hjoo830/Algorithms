class Solution {
    static int[] candi;
    static int tg;
    static List<List<Integer>> result;
    static int n;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        candi = candidates;
        tg = target;
        n = candidates.length;
        result = new ArrayList<>();
        bt(new ArrayList<>(), 0);
        return result;
    }

    static void bt(List<Integer> path, int start) {
        int sum = getSum(path);
        
        if (sum > tg) return;
        if (sum == tg) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < n; i++) {
            path.add(candi[i]);
            bt(path, i);
            path.remove(path.size() - 1);
        }
    }

    static int getSum(List<Integer> arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
}