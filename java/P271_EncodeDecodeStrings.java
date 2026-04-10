// https://neetcode.io/problems/string-encode-and-decode?list=neetcode150

import java.util.ArrayList;
import java.util.List;

class P271_EncodeDecodeStrings {
    private static char delim = '#';

    public String encode(List<String> strs) {
        if (strs.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            sb.append(strs.get(i).length());
            sb.append(delim);
            sb.append(strs.get(i));
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        int start = 0;
        while (start < str.length()) {
            int end = start;
            // find the next delimiter
            while (str.charAt(end) != delim) {
                end++;
            }

            int length = Integer.parseInt(str.substring(start, end));
            start = end + 1;
            end = start + length;
            String word = str.substring(start, end);
            result.add(word);
            start = end;
        }

        return result;
    }

    public static void main(String[] args) {
        P271_EncodeDecodeStrings sol = new P271_EncodeDecodeStrings();
        List<String> input = List.of("hello", "world");
        String encoded = sol.encode(input);
        System.out.println("Encoded: " + encoded);
        System.out.println("Decoded: " + sol.decode(encoded)); // [hello, world]
    }
}
