import java.util.*;

public class _055_CharStatistics {
    Queue<Integer> queue = new LinkedList<>();
    int[] appeared = new int[256];

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (appeared[ch] == 0) {
            appeared[ch] = 1;
            queue.add((int) ch);
        } else {
            appeared[ch] = 2;
            int size = queue.size();
            while (size-- != 0) {
                int peek = queue.peek();
                if (appeared[peek] != 1) {
                    queue.remove();
                } else {
                    break;
                }
            }
        }

    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        int size = queue.size();
        if (size == 0) {
            return '#';
        } else {
            return (char) (int) queue.peek();
        }

    }
}
