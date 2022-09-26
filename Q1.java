import java.util.*;
import java.util.Iterator;

public class Q1 {
    public static void main(String[] args) {
        Hashtable<String, Integer> hat = new Hashtable<>();
        hat.put("a", 26);
        hat.put("b", 42);
        hat.put("c", 5);
        hat.put("d", 44);
        hat.put("e", 92);
        hat.put("f", 59);
        hat.put("g", 40);
        hat.put("h", 36);
        hat.put("i", 12);
        hat.put("j", 60);
        hat.put("k", 80);
        Iterator<String> it = hat.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            int mapValue = hat.get(key);
            // System.out.println(key +" "+ mapValue +" "+ key.hashCode());
            int hash = 0;
            for (int i = 0; i < 11; i++) {
                hash = mapValue % 11;

            }

            System.out.println(key + "  " + mapValue + "  " + key.hashCode() + "  " + hash);

        }

    }
}