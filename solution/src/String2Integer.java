public class String2Integer {

    public int myAtoi(String str) {
        int i = 0, sign = 1;
        for ( ; i < str.length() && str.charAt(i) == ' '; i++);
        if (i < str.length()) {
            char csign = str.charAt(i);
            if (csign == '-') {
                sign = -1;
                i++;
            } else if (csign == '+') {
                sign = 1;
                i++;
            } else if (csign < '0' || csign > '9') {
                return 0;
            } else {}
        }
        long number = 0;
        for ( ; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                break;
            }
            number = number * 10 + (c - '0');

            if (number * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (number * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) (number * sign);
    }
}
