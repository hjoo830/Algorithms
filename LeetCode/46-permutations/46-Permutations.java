class Solution {
    static List<List<Integer>> result;
    static boolean[] v;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        v = new boolean[nums.length];
        bt(new ArrayList<>(), nums);
        return result;
    }

    static void bt(List<Integer> path, int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (v[i]) continue;
            v[i] = true;
            path.add(nums[i]);
            bt(path, nums);
            v[i] = false;
            path.remove(path.size() - 1);
        }
    }
}