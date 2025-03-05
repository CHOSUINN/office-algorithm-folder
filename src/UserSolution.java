import java.util.LinkedList;

class UserSolution {
    static final int MAX_HASH = 1 << 20;
    int[] stringCounts;

    LinkedList<Character> word = new LinkedList<>();
    boolean reversed;

    void init(char mStr[]) {
        word.clear();
        reversed = false;

        stringCounts = new int[MAX_HASH];

        for (char c : mStr) {
            if (c == '\0')
                break;
            word.add(c);
            updateRightHash(true);
        }
    }

    void updateRightHash(boolean add) {
        int hash = 0, power = 1;
        for (int i = word.size() - 1; i >= Math.max(word.size() - 4, 0); i--) {
            hash += power * (word.get(i) - 'a' + 1);
            power <<= 5;
            if (add)
                stringCounts[hash]++;
            else
                stringCounts[hash]--;
        }
    }

    void updateLeftHash(boolean add) {
        int hash = 0;
        for (int i = 0; i < Math.min(word.size(), 4); i++) {
            hash = (hash << 5) + (word.get(i) - 'a' + 1);
            if (add)
                stringCounts[hash]++;
            else
                stringCounts[hash]--;
        }


    }

    void appendWord(char mWord[]) {
        for (char c : mWord) {
            if (c == '\0')
                break;
            if (reversed) {
                word.addFirst(c);
                updateLeftHash(true);
            } else {
                word.addLast(c);
                updateRightHash(true);
            }
        }
    }

    void cut(int k) {
        if (!reversed) {
            for (int i = 0; i < k; i++) {
                updateRightHash(false);
                word.removeLast();
            }
        } else {
            for (int i = 0; i < k; i++) {
                updateLeftHash(false);
                word.removeFirst();
            }
        }
    }

    void reverse() {
        if (!reversed)
            reversed = true;
        else
            reversed = false;
    }

    int countOccurrence(char mWord[]) {
        int hash = 0;

        if (!reversed) {
            for (char c : mWord) {
                if (c == '\0')
                    break;
                hash = (hash << 5) + (c - 'a' + 1);
            }
        } else {
            int power = 1;
            for (char c : mWord) {
                if (c == '\0')
                    break;
                hash += power * (c - 'a' + 1);
                power <<= 5;
            }
        }

        return stringCounts[hash];
    }
}