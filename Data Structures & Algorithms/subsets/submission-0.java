class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), 0);
        return result;
    }

    void backtrack(int[] nums, List<Integer> state, int idx) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(state));
            return;
        }

        backtrack(nums, state, idx + 1);

        state.add(nums[idx]);
        backtrack(nums, state, idx + 1);

        state.remove(state.size() - 1);
    }
}