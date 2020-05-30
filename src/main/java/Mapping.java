import java.util.*;

public class Mapping {

    public static void main(String[] args) {
        System.out.println(getMapping("abbbcddddeffabbbbbb"));
    }

    private static Map<String, Integer> getMapping(String str) {

        char[] arr = str.toCharArray();

        Map<String, Integer> map = new HashMap<>();
        if (arr == null || arr.length <= 1) {
            return map;
        }

        char prevChar = arr[0];
        boolean consi = false;

        for (int i = 1; i < arr.length; i++) {

            char pre = arr[i];
            if (prevChar == pre) {

                consi = true;

            } else {

                if (consi) {

                    String letter = "" + prevChar;
                    if (map.containsKey(letter)) {
                        int val = map.get(letter);
                        val++;
                        map.put(letter, val);
                    } else {
                        map.put(letter, 1);
                    }
                }

                consi = false;
            }
            prevChar = pre;
        }

        if (consi) {

            String letter = "" + prevChar;
            if (map.containsKey(letter)) {
                int val = map.get(letter);
                val++;
                map.put(letter, val);
            } else {
                map.put(letter, 1);
            }
        }

        return map;
    }
}















