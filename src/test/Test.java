package test;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] output = reverseArr(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(output)); // --> [3, 2, 1]

    }

    public static int[] reverseArr(int[] arr) {
        if(arr.length == 0) return new int[]{};

        int[] firstElement = new int[]{arr[arr.length - 1]};
        int[] e = reverseArr(Arrays.copyOfRange(arr, 0, arr.length-1));
        int[] result = new int[firstElement.length + e.length];

        System.arraycopy(firstElement,0, result, 0, 1);
        System.arraycopy(e,0, result, 1, e.length);

        return result;
    }

    /**
     * 1,2,3,4,5
     * 1,2,3,4 (5)
     * 1,2,3 (4)
     * 1,2 (3)
     * 1 (2)
     * [] (1)
     * error
     */

}