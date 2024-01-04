package sort;

public class BubbleSort {

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
    public static void selectSort(int[] arr) {
        if (arr.length >= 2){
            for (int i = 0; i < arr.length - 1 ; i++) {
                int min = i;
                for (int j = i; j <arr.length ; j++) {
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


    public static void main(String[] args) {
        int[] test = new int[]{1,8,3,6,7,2,9,0};
        selectSort(test);
        System.out.println(test);
    }
}
