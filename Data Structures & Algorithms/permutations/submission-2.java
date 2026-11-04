class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];

        backtrack(nums, new ArrayList<>(), vis);

        return result;
    }

    void backtrack(int[] nums, List<Integer> state, boolean[] vis) {

        if (state.size() == nums.length) {
            result.add(new ArrayList<>(state));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (vis[i]) {
                continue;
            }

            state.add(nums[i]);
            vis[i] = true;

            backtrack(nums, state, vis);
            state.remove(state.size() - 1);
            vis[i] = false;
        }
    }
}