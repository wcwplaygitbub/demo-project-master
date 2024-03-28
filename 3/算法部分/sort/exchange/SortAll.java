package sort.exchange;


import java.util.ArrayList;

public class SortAll {


    /**
     * 平均时间复杂度 O(n2) best O(n) 最坏 O(n2) 空间 O（1） 稳定
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        if (arr.length >= 2){
            for (int i = 0; i < arr.length - 1; i++) {
                boolean b = false;
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int tmp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = tmp;
                        b = true;
                    }
                }
                // 一次循环结束，如果没有元素发生交换，则证明整体有序，直接跳出循环
                if (!b) {
                    break;
                }
            }
        }
    }

    /**
     * 平均时间复杂度 O(n2) best O(n) 最坏 O(n2) 空间 O（1） 稳定
     * @param arr
     */
    public static void insertSort(int[] arr) {
        if (arr.length >= 2){
            for (int i = 1; i < arr.length ; i++) {
                int temp = arr[i];
                int j = i - 1;
//                for (; j >= 0; j--) {
//                    if (arr[j] > temp) {
//                        arr[j+1] = arr[j];
//                    }else {
//                        break;
//                    }
//                }
//                arr[j + 1] = temp;
                while (j >= 0){
                    if (arr[j] > temp) {
                        arr[j + 1] = arr[j];
                        j --;
                    }else {
                        break;
                    }
                }
                arr[j + 1] = temp;
            }
        }
    }

    /**
     * 平均时间复杂度 O(n2) best O(n2) 最坏 O(n2) 空间 O（1） 不稳定
     * @param arr
     */
    public static void selectSort(int[] arr) {
        if (arr.length >= 2){
            for (int i = 0; i < arr.length - 1 ; i++) {
                int min = i;
                for (int j = i; j < arr.length ; j++) {
                    if (arr[j] < arr[min]) {
                        min = j;
                    }
                }
                // 交换
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;

            }
        }
    }


    /**
     * 希尔排序的基本思想是：先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录"
     * 基本有序"时，再对全体记录进行依次直接插入排序。
     * 平均时间复杂度 O(nlog n) best O(nlog2 n) 最坏 O(nlog2 n) 空间 O（1） 不稳定
     * @param arr
     */

    public static void shellSort(int[] arr) {
        for (int step = arr.length / 2; step >= 1; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                int temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }
    }




    public static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int half = (start + end) / 2;
        // 归并左边
        mergeSort(arr, start, half);
        // 归并右边
        mergeSort(arr, half + 1, end);
        // 合并
        merge(arr, start, half, end);
    }

    public static void merge(int[] arr, int left, int half, int right){
        ArrayList<Integer> tempList = new ArrayList<>();
        int start1 = left;
        int start2 = half + 1;


        while (start1 <= half && start2 <= right){
            if (arr[start1] > arr[start2]){
                tempList.add(arr[start1]);
                start1 ++;
            }else {
                tempList.add(arr[start2]);
                start2 ++;
            }
        }
        // 说明左边结束了  把右边剩余的复制进去
        if (start1 <= half){
            while (start1 <= half){
                tempList.add(arr[start1]);
                start1 ++;
            }
        }

        // 说明右边结束了  把左边剩余的复制进去
        if (start2 <= left){
            while (start2 <= left){
                tempList.add(arr[start2]);
                start2 ++;
            }
        }
        // 复制一把
        for (int k = 0, length = tempList.size(); k < length; k++) {
            arr[left + k] = tempList.get(k);
        }
    }



/**
 * 类功能简述：快速排序
 * 类功能详述：
 * 1.使用了分治的思想，先取一个数作为基数（一般选第一个数），然后将这个数移动到一个合适的位置使左边的都比它小，右边的都比他大
 * 2.递归处理这个数左边的数和右边的数，直到所有的数都有序。
 * 直到所有的数都有序
 * 平均时间复杂度 O(nlog n) best O(nlog2 n) 最坏 O(n2) 空间 O（log n） 不稳定
 */


    private static void fastSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int base = arr[start], i = start + 1, j = end;
        while (i < j) {
            // 在右边找一个比基数小的数,直到i,j相等
            while (arr[j] >= base && j > i) {
                j--;
            }

            // 在左边找一个比基数大的数,直到i,j相等
            while (arr[i] <= base && j > i) {
                i++;
            }
            // 如果ij不相等，交换其值
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i = i + 1;
                j = j - 1 ;
            }
        }
        // 此时i等于j，交换基数和 i/j,使左边的数小于等于基数，右边的数大于等于基数
        if (start != i && arr[i] <= arr[start]) {
            int temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
        }
        if (start != i && arr[i] >= arr[start]) {
            int temp = arr[start];
            arr[start] = arr[i - 1];
            arr[i - 1] = temp;
            i--;
            j--;
        }

        fastSort(arr, start, i - 1);
        fastSort(arr, j + 1, end);
    }

    /**
     * 堆排序
     * @param arr
     */
    private static void heapSort(int[] arr) {
        // 1. 构建一个大/小顶堆
        int len = arr.length;

        buildMaxHeap(arr);

        // 2. 开始排序
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }

    }

    private static void buildMaxHeap(int[] arr){
        int len = arr.length;
        for (int i = (int) Math.floor(len / 2); i >= 0; i--){
            heapify(arr, i, len);
        }
    }

    private static void heapify(int[] arr, int i, int len){
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }







    public static void main(String[] args) {
        int[] test = new int[]{1,8,3,6,7,2,9,0};
//        int[] test = new int[]{1,0,0,0,0,0,0,0};
//        mergeSort(test, 0, test.length - 1);
//        fastSort(test, 0, test.length - 1);
//        shellSort(test);
        heapSort(test);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }
}
