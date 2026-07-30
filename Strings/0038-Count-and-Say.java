class Solution {
    public String countAndSay(int n) {

        String ans = "1";

        for (int i = 2; i <= n; i++) {

            StringBuilder temp = new StringBuilder();

            int count = 1;

            for (int j = 1; j < ans.length(); j++) {

                if (ans.charAt(j) == ans.charAt(j - 1)) {
                    count++;
                } else {
                    temp.append(count);
                    temp.append(ans.charAt(j - 1));
                    count = 1;
                }
            }

            temp.append(count);
            temp.append(ans.charAt(ans.length() - 1));

            ans = temp.toString();
        }

        return ans;
    }
}
