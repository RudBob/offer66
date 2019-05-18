import java.util.*;

public class _035_FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        char[] ch = str.toCharArray();
        Map<Character, Integer> countChar = new HashMap<>();
        for (char c : ch) {
            Integer count = countChar.get(c);
            if (count == null) {
                countChar.put(c, 1);
            } else {
                countChar.put(c, count + 1);
            }
        }

        for (int i = 0; i < ch.length; i++) {
            if (countChar.get(ch[i]).equals(1)) {
                return i;
            }
        }
        return -1;
    }

    private int byMyBooleans(String str) {
        char[] ch = str.toCharArray();
        boolean[] repeated = new boolean[ch.length];
        for (int i = 0; i < ch.length; i++) {
            if (repeated[i]) {
                continue;
            }
            int countRepeat = 0;
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[j] == ch[i]) {
                    countRepeat++;
                    repeated[j] = true;
                }
            }
            if (countRepeat == 0) {
                return i;
            }
        }
        return -1;
    }
}