package LiveClass.기초.linkedList.삽입정렬;

public class LinkedList08삽입정렬 {
    public static void main(String[] args) {
        int[] data = {69, 10, 30, 2, 16, 8, 3, 22};

        for (int i = 1; i < data.length; i++) {
            int j;
            int key = data[i];

            for (j = i - 1; j >= 0 && key < data[j]; j--) {
                data[j + 1] = data[j];
            }

            data[j + 1] = key;
        }
    }
}
