package j.javacodingproblems.mycodingtests;

public class PermutationsHeapMethod {

    public static void main(String[] args) {
//        int[] array = new int[]{1, 2, 3, 5};
        int[] array = new int[]{1, 2, 3};
        permute(array, array.length, array.length);
    }

    private static void permute(int[] permutation, int size, int n) {
        if (size == 1) {
            printArr(permutation, n);
        }
        for (int i = 0; i < size; i++) {
            permute(permutation, size - 1, n);
            // if size is odd, swap 0th i.e (first) and (size-1)th - (last) element
            if (size % 2 == 1) {
                int temp = permutation[0];
                permutation[0] = permutation[size - 1];
                permutation[size - 1] = temp;
            }
            // If size is even, swap ith and (size-1)th - last element
            else {
                int temp = permutation[i];
                permutation[i] = permutation[size - 1];
                permutation[size - 1] = temp;
            }
        }
    }

    private static void printArr(int[] permutation, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(permutation[i]);// + " ");
        }
        System.out.println();
    }
}
