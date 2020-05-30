import java.util.*;

public class Numbers {

    public static void main(String[] args) {
        System.out.println(summation(new int[]{1, 6, 8, 5, 9, 4, 7, 2}));
    }

    private static List<Integer> summation(int[] arr) {

        List<Integer> arrList = new ArrayList<>();
        int count = 1;

        int index = 0;
        while (index < arr.length) {
            int sum = 0;
            for (int i = 0; i < count; i++) {
                if (index < arr.length) {
                    sum += arr[index];
                }
                else
                {
                    break;
                }
                index++;
            }
            count++;
            arrList.add(sum);

            if (index >= arr.length) {
                break;
            }
        }

        return arrList;

    }
}
