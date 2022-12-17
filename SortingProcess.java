import java.util.Scanner;

public class SortingProcess {

    private void printArray(int[] arr, String sortinName){
        for(int i= 0;i< arr.length;i++){
            System.out.println(sortinName+"___"+arr[i]+" ");
        }
    }

    private int[] swap(int[] arr, int position1, int position2){
        int temp = arr[position1];
        arr[position1] = arr[position2];
        arr[position2]= temp;
        return  arr;
    }

    public void bubblesort(int[] arr){
        int counter = 1;
        while(counter< arr.length){
            for(int i = 0;i< arr.length-counter;i++){
                if(arr[i]>arr[i+1]){
                    swap(arr, i , i+1);
                }
            }
            counter++;
        }
        printArray(arr,"Bubble sort");


    }

    public void selectionSort(int[] arr){
        for(int i= 0;i<arr.length-1;i++){
            for(int j = i+1;j< arr.length;j++){
                if(arr[j]<arr[i]){
                    swap(arr, i , j);
                }
            }
        }
        printArray(arr,"Selection Sort");
    }

    public void insertionSort(int[] arr){
        /**
         * two logics both are working fine
         **/
        for(int i =0;i< arr.length-1;i++){
            if(arr[i] > arr[i+1]){
                int j = i+1;
                int current = arr[i+1];
                while (j > 0 && arr[j-1] > current  ){
                    arr[j] = arr[j-1];
                    j--;
                }
                arr[j] = current;
            }
        }

//        for(int i = 1; i< arr.length;i++){
//            int current = arr[i];
//            int j = i-1;
//            while(arr[j]>current && j>=0){
//                arr[j+1]=arr[j];
//                j--;
//            }
//            arr[j+1]= current;
//        }

        printArray(arr, "Inserstion Sort");
    }

    /**
     * It gives sum of each subarray for a given array
     * @param arr
     */
    public void sumSubArr(int[] arr){

        for(int i = 0;i< arr.length;i++){
            int sum = 0;
            for(int j = i;j< arr.length;j++){
                sum += arr[j];
                System.out.println(sum);
            }
        }

    }

    private void merge(int[] arr,int low, int mid , int high){
        int[] temp = new int[high-low+1];
        int i = low; int j = mid+1;int k = 0 ;
        while (i<=mid && j<=high){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
            }
        }
        while (i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<=high){
            temp[k++] = arr[j++];
        }
        for(int num=0, num2 = low;num<temp.length;num++,num2++){
            arr[num2] = temp[num];
        }
    }

    public void sort(int[] arr, int low , int high){
        if(low<high){
            int mid = low + ((high - low)/2);
            sort(arr,low, mid);
            sort(arr, mid+1 , high);
            merge(arr, low, mid , high);
        }
    }

    private int partition(int[] arr, int low , int high){
        int i = low-1;
        int pi = arr[high];
        for(int j = low; j<high;j++){
            if(arr[j]<pi){
                i++;
                swap(arr, i , j);
            }
        }
        //swap
        i++;
        swap(arr, i , high);

        return i;
    }
    public void quickSort(int[] arr, int low , int high){
        if(low<high){
            int pivot = partition(arr, low , high);

            quickSort(arr, low , pivot-1);
            quickSort(arr, pivot+1, high);

        }
    }


     public static void main(String arg[]){
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter 5 numbers");
         int[] arr = new int[5];
         for(int i = 0; i<arr.length;i++){
             arr[i] = sc.nextInt();
         }
         System.out.println("Enter 1 for Bubble Sort");
         System.out.println("Enter 2 for Selection Sort");
         System.out.println("Enter 3 for Insertion Sort");
         System.out.println("Enter 4 for Merge sort");
         System.out.println("Enter 5 for Quick sort ");
         System.out.println("Enter 6 for finding the sum of each subarray of an input array");
         SortingProcess process = new SortingProcess();

         int n = sc.nextInt();
         switch (n){
             case 1:
                 System.out.println("Bubble Sort\n" +
                         "Idea: if arr[i] > arr[i+1] swap them. To place the element in their respective position, we have to do the following operation N-1 times. \n" +
                         "Time Complexity: O(N^2)\n");
                 process.bubblesort(arr);
                 break;
             case 2:
                 System.out.println("Selection Sort\n" +
                         "Idea: The inner loop selects the minimum element in the unsorted array and places the elements in increasing order. \n" +
                         "Time complexity: O(N^2) \n");
                 process.selectionSort(arr);
                 break;
             case 3:
                 System.out.println("Insertion Sort\n" +
                         "Idea: Take an element from the unsorted array, place it in its corresponding position in the sorted part, and shift the elements accordingly. \n" +
                         "Time Complexity: O(N^2) ");
                 process.insertionSort(arr);
                 break;
             case 4:
                 System.out.println("_____________________\nTime Complexity of Merge sort is :O(nlogn)");
                 System.out.println("Here we are using extra space by creating a new array \n_____________________");
                 process.sort(arr, 0, arr.length-1);
                 process.printArray(arr,"merge Sort");
                 break;
             case 5:
                 System.out.println("_____________________\nTime Complexity of Quick sort in: ");
                 System.out.println("Worst Case : O(n^2) \nAverage Case : O(nlogn)");
                 System.out.println("Worst case occurs when pivot is always the smallest or the largest element.\n_____________________");
                 process.quickSort(arr, 0, arr.length-1);
                 process.printArray(arr,"Quick Sort");
                 break;
             case 6:
                 System.out.println("The sum of sub Arrays of a given Array is : ");
                 process.sumSubArr(arr);
                 break;
             default:
                 System.out.println("Please Enter valid number , Try again ");
                 break;

         }
     }
}
