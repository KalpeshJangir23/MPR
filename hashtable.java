import java.util.*;

import javax.print.attribute.IntegerSyntax;

public class hashtable {
    private Hashnode[] bukects;
    private int numofbuckets;
    private int size;

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
        Hashnode head = bukects[bucketindex];
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
        table.put(01, 26);
        table.put(02, 42);
        table.put(03, 5);
        table.put(04, 44);
        table.put(05, 92);
        System.out.println(table.size());
    }

}
