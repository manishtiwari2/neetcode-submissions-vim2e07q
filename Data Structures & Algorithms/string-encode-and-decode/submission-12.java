class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            int l = s.length();

            sb.append(l);
            sb.append('*');
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int left = 0;

        while(left < str.length()) {
            int right = left;

            while(str.charAt(right) != '*') {
                right++;
            }
            int length = Integer.parseInt(str.substring(left,right));

            left = right + 1;
            right = left + length;

            ans.add(str.substring(left, right));

            left = right;
        }
        return ans;
    }
}
