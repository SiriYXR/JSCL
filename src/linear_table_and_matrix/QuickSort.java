package linear_table_and_matrix;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr={3,6,9,5,2,4,6,8,3,1,7,2};

        quickSort(arr,0,arr.length-1);

        for(int i:arr)
            System.out.print(i+" ");
        System.out.println();

    }

    public static void quickSort(int[] num, int left, int right) {
        if (left < right) {
            int l = left;
            int r = right;
            int temp = num[left];
            while (l != r) {
                while (num[r] >= temp && l < r) r--;
                while (num[l] <= temp && l < r) l++;
                if (l < r) {
                    int t;
                    t = num[l];
                    num[l] = num[r];
                    num[r] = t;
                }
            }
            num[left] = num[l];
            num[l] = temp;
            quickSort(num, left, l - 1);
            quickSort(num, l + 1, right);
        }
    }
}
