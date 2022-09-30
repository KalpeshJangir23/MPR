import java.util.*;

public class hashtable {
    private Hashnode[] bukects;
    private int numofbuckets;
    private int size;
    private Hashnode head;

    public hashtable() {
        this(11);

    }

    public hashtable(int capacity) {
        this.numofbuckets = capacity;
        bukects = new Hashnode[numofbuckets];
        this.size = 0;

    }

    private class Hashnode {
        private Integer key;
        private Integer value;
        private Hashnode next;

        public Hashnode(Integer key, Integer value) {
            this.key = key;
            this.value = value;

        }
    }

    public int size() {
        return size;
    }

    public void put(Integer key, Integer value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("key or value is null");

        }
        int bucketindex = getBucketIndex(key);
        head = bukects[bucketindex];
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;

            }
            head = head.next;
        }
        size++;
        head = bukects[bucketindex];
        Hashnode node = new Hashnode(key, value);
        node.next = head;
        bukects[bucketindex] = node;

    }

    private int getBucketIndex(Integer key) {
        return key % numofbuckets;
    }

    public static void main(String[] args) {
        hashtable table = new hashtable(11);
        table.put(1, 26);
        table.put(2, 42);
        table.put(3, 5);
        table.put(4, 44);
        table.put(5, 92);
        table.put(6, 59);
        table.put(7, 40);
        table.put(8, 36);
        table.put(9, 12);
        table.put(10, 60);
        table.put(11, 80);

        System.out.println(table.size());

    }

}
