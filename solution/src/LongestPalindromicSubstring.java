public class LongestPalindromicSubstring {

    private int begin, maxLen;

    public  String longestPalindrome(String s) {
        int[] res = new int[2];
        for (int i = 0; i < s.length(); i++) {
            helper(s, i - 1, i + 1, res);
            helper(s, i, i + 1, res);
        }
        return s.substring(res[1], res[1] + res[0]);
    }

    private void helper(String s, int left, int right, int[] res) {
        for ( ; left >= 0 && right < s.length(); left--, right++) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
        }
        int len = --right - ++left + 1;
        if (len > res[0]) {
            res[0] = len;
            res[1] = left;
        }
    }

    public String longestPalindrome2(String s) {
        int len = s.length();

        if (len == 0) {
            return s;
        }

        boolean[][] f = new boolean[len][len];

        int index = 0;
        int max = 1;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j < 2 || f[j + 1][i - 1])) {
                    f[j][i] = true;

                    if (i - j + 1 > max) {
                        max = i - j + 1;
                        index = j;
                    }
                }
            }
        }

        return s.substring(index, index + max);
    }
}
