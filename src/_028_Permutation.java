import java.util.*;

public class _028_Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> strs = new ArrayList<String>();
        if (str == null || str.length() == 0) {
            return strs;
        }
        char[] s = str.toCharArray();
        Arrays.sort(s);
//        Set<String> strSet = new TreeSet<>();
        Permutation(s, strs, 0);
//        strs.addAll(strSet);
        Collections.sort(strs);
        return strs;
    }

    private void Permutation(char[] s, ArrayList<String> strs, int i) {
        for (int j = i; j < s.length; j++) {
            swap(s, i, j);
            if (!strs.contains(new String(s))) {
                strs.add(new String(s));
            }
            Permutation(s, strs, i + 1);
            swap(s, i, j);
        }
    }

    private void swap(char[] s, int i, int j) {
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
    }
}
