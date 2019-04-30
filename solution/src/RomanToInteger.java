class RomanToInteger {
    public int romanToInt(String s) {
        String[] romanStr = s.split("");
        int sum = 0;
        for (int i = 0; i < romanStr.length; i++) {
            int current = r2i(romanStr[i]);
            if (i < romanStr.length - 1) {
                int next = r2i(romanStr[i+1]);
                if (next > current) {
                    sum += next - current;
                    i++;
                } else {
                    sum += current;
                }
            } else {
                sum += current;
            }
        }
        return sum;
    }
    
    private int r2i(String str) {
        List<String> romans = Arrays.asList("I", "V", "X", "L", "C", "D", "M");
        List<Integer> integers = Arrays.asList(1, 5, 10, 50, 100, 500, 1000);
        return integers.get(romans.indexOf(str));
    }
}
