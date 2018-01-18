public class Sorts {

    public static void selectionSort(int[] arr, int N) {
        //int length = N;
        for (int i = 0; i < N - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < N; j++) {
                if (arr[j] < arr[min_index])
                    min_index = j;
            }
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }

    }

    public static void mergeSort(int[] arr, int N) {
        mergeSort(arr, 0, N - 1);
    }

    private static void mergeSort(int[] arr, int first, int last) {
        if (first < last) {
            int middle = (first + last) / 2;
            mergeSort(arr, first, middle);
            mergeSort(arr, middle + 1, last);
            mergeSortedHalves(arr, first, middle, last);
        }
    }

    private static void mergeSortedHalves(int arr[], int l, int m, int r) {

        int[] temp = new int[r - l + 1];
        int index1 = l;
        int index2 = m+1;
        int index = 0;

        while(index1 < m && index2 < r){
            if(arr[index1] < arr[index2]){
                temp[index++] = arr[index1++];
            } else {
                temp[index++] = arr[index2++];
            }
        }
        int count, max;
        if(index1 < (index2 - m)) {
            count = index1;
            max = m;
        } else {
            count = index2;
            max = r;
        }

        while(count < max){
            System.out.println("\n!!!!!!! " + temp[index] + "Length: " + (r-l+1));
            temp[index++] = arr[count++];
        }

        for(index = 0; index < r - l + 1; index++){
            System.out.println("\n!!!!!!! " + temp[index] + "Length: " + (r-l+1));
            arr[index] = temp[index];
        }

        /*
        for(index = 0; index1 < m && index2 < r; index++){
            if(arr[index1] < arr[index2]){
                temp[index] = arr[index1++];
            } else {
                temp[index] = arr[index2++];
            }
        }
        int count, max;
        if(index1 < index2) {
            count = index1;
            max = m;
        } else {
            count = index2;
            max = r;
        }

        while(count < max){
            temp[index] = arr[count];
        }

        for(index = 0; index < arr.length; index++){
            System.out.println("\n!!!!!!! " + index + "Length: " + arr.length);
            arr[index] = temp[index];
        }
        */
    }
    

    public static void quickSort(int[] list, int N) {
        quicksort(list, 0, N-1);
    }

    private static void quicksort(int[] list, int first, int last){
        if (first < last){
            setPivotToEnd(list, first, last);
            int pivotIndex = splitList(list, first, last);
            quicksort(list, first, pivotIndex-1);
            quicksort(list, pivotIndex+1, last);
        }
    }

    private static void setPivotToEnd(int[] arr, int left, int right){
        int center = (left+right)/2;

        int i = arr[left];
        int j = arr[center];
        int k = arr[right];
        int temp;

        if (i > j){
            temp = j;
            arr[center] = i;
            arr[left] = temp;
        }

        if( i > k) {
            temp = k;
            arr[right] = i;
            arr[left] = temp;
        }

        if ( j < k) {
            temp = j;
            arr[center] = k;
            arr[right] = j;
        }
    }

    private static int splitList(int[] arr, int left, int right) {

        int indexL = left;
        int indexR = right - 1;
        int pivot = arr[right];
        int temp;

        while(indexL < indexR) {
            while (arr[indexL] < pivot) {
                indexL++;
            }

            while (arr[indexR] > pivot) {
                indexR--;
            }
            if(indexL < indexR) {
                temp = arr[indexL];
                arr[indexL] = arr[indexR];
                arr[indexR] = temp;
                indexL++;
                indexR--;
            }
        }

        temp = arr[indexL];
        arr[indexL] = pivot;
        arr[right] = arr[indexL];

        return indexL;
        }
    }
