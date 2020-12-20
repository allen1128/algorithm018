public class LongestPalindromicSubstring_5 {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            String ans = palindrome(s, i, i);
            if (ans.length() > answer.length()) {
                answer = ans;
            }
            ans = palindrome(s, i - 1, i);
            if (ans.length() > answer.length()){
                answer = ans;
            }
        }

        return answer;
    }

    public String palindrome(String s, int i, int j) {
        for (; i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j); i--, j++) ;

        if (j - 1 - i > 0 && i + 1 >= 0 && j - 1 < s.length()) {
            return s.substring(i + 1, j);
        }

        return "";
    }
}

