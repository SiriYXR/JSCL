package linear_table_and_matrix;

public class NetherlandsFlag {

    public static void main(String[] args) {

        int[] arr={3,6,9,5,2,4,6,8,3,1,7,2};
        partition(arr,0,arr.length-1,3);

        for(int i:arr)
            System.out.print(i+" ");
        System.out.println();

    }

    public static int[] partition(int[] arr, int L, int R, int num) {
        int less = L - 1;
        int more = R + 1;
        while (L < more) {
            if (arr[L] < num)
                swap(arr, ++less, L++);
            else if (arr[L] > num)
                swap(arr, --more, L);
            else
                L++;
        }
        return new int[]{less + 1, more - 1};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
