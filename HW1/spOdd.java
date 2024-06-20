import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class spOdd {

    public static List<Integer> SpOdd(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int num : arr) {
            if (num % 2 != 0) {
                result.add(num);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] originalArray = {3, 9, 7, 4, 5, 1, 8, 5, 7, 1, 9, 2};

        System.out.println("Original Array: " + Arrays.toString(originalArray));

        List<Integer> oddElements = SpOdd(originalArray);
        System.out.println("Odd elements in the array: " + oddElements.toString());
    }
}
