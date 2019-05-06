package linear_table_and_matrix;

//有序数组的二分查找
public class BinarySearch {

    public static void main(String[] args) {

        int[] arr={1,2,3,4,5,5,5,6,7,8,9};

        System.out.println(lowerBound(arr,0,arr.length,5));
        System.out.println(upperBound(arr,0,arr.length,5));

    }

    //查找v出现的第一个位置
    public static int lowerBound(int[] nums, int l, int r, int v) {
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= v)
                r = m;// 因为是寻找下界，不考虑右边还有没有元素
            else if (nums[m] < v)
                l = m + 1;
            if(l==r&&nums[l]!=v)//查找的数不存在，返回该数插入仍使数组有序的位置
                return -(m+1);
        }
        return l;
    }

    //查找v出现的最后一个位置
    public static int upperBound(int[] nums, int l, int r, int v) {
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] <= v)
                l = m + 1;
            else if (nums[m] > v)
                r = m;
            if(l==r&&nums[m]!=v)
                return -(m+1);
        }
        return l;
    }
}
