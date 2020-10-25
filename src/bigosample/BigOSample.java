/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigosample;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Student
 */
public class BigOSample {
    private static int N = 100000;
    private static Random r = new Random();
    public static void main(String[] args) {
        Integer[] a1 = new Integer[N];
        Integer[] a2 = new Integer[N];
        Integer[] a3 = new Integer[N];
        Integer[] a4 = new Integer[N];
        initial(a1);
        System.arraycopy(a1, 0, a2, 0, a1.length);
        System.arraycopy(a1, 0, a3, 0, a1.length);
        System.arraycopy(a1, 0, a4, 0, a1.length);

        long begin;
        long cal;

        begin = System.currentTimeMillis();
        Arrays.sort(a1);
        cal = System.currentTimeMillis()-begin;
        System.out.println("Array.sort time : " + cal +" Millisecond");
        
        begin = System.currentTimeMillis();
        selectionSort(a2);
        cal = System.currentTimeMillis()-begin;
        System.out.println("selectionSort time : " + cal +" Millisecond");
        
        
    }
    
    private static void initial(Integer[] a1){
        for(int i = 0 ; i< a1.length ; i++){
            a1[i] = r.nextInt(N);
            
        }
    }

    public static void runBubbleSort(){
        Integer[] a1 = new Integer[N];
        Integer[] a2 = new Integer[N];
        Integer[] a3 = new Integer[N];
        Integer[] a4 = new Integer[N];
        initial(a1);
        System.arraycopy(a1, 0, a2, 0, a1.length);
        System.arraycopy(a1, 0, a3, 0, a1.length);
        System.arraycopy(a1, 0, a4, 0, a1.length);

        long begin;
        long end;
        long cal;

        begin = System.currentTimeMillis();
        Arrays.sort(a2);
        end = System.currentTimeMillis();
        cal = end - begin;
        System.out.println("TIME FOR ARRAY SORT : " + cal);

        begin = System.currentTimeMillis();
        bubbleSort(a2);
        end = System.currentTimeMillis();
        cal = end - begin;
        System.out.println("TIME FOR BUBBLE SORT : " + cal);
    }

    public static void runInsertionSort(){
        Integer[] a1 = new Integer[N];
        Integer[] a2 = new Integer[N];
        Integer[] a3 = new Integer[N];
        Integer[] a4 = new Integer[N];
        initial(a1);
        System.arraycopy(a1, 0, a2, 0, a1.length);
        System.arraycopy(a1, 0, a3, 0, a1.length);
        System.arraycopy(a1, 0, a4, 0, a1.length);

        long begin;
        long end;
        long cal;

        begin = System.currentTimeMillis();
        Arrays.sort(a2);
        end = System.currentTimeMillis();
        cal = end - begin;
        System.out.println("TIME FOR ARRAY SORT : " + cal);

        begin = System.currentTimeMillis();
        InsertionSort(a2);
        end = System.currentTimeMillis();
        cal = end - begin;
        System.out.println("TIME FOR INSERT SORT : " + cal);
    }

    public static void runMergeSort(){
        Integer[] a1 = new Integer[N];
        Integer[] a2 = new Integer[N];
        Integer[] a3 = new Integer[N];
        Integer[] a4 = new Integer[N];
        initial(a1);
        System.arraycopy(a1, 0, a2, 0, a1.length);
        System.arraycopy(a1, 0, a3, 0, a1.length);
        System.arraycopy(a1, 0, a4, 0, a1.length);

        long begin;
        long end;
        long cal;

        begin = System.currentTimeMillis();
        Arrays.sort(a2);
        end = System.currentTimeMillis();
        cal = end - begin;
        System.out.println("TIME FOR ARRAY SORT : " + cal);

        begin = System.currentTimeMillis();
        mergeSort(a2);
        end = System.currentTimeMillis();
        cal = end - begin;
        System.out.println("TIME FOR MERGE SORT : " + cal);
    }



    
    static void selectionSort(Integer items[]) {
 
        // select item one by one based on index
        for (int i = 0; i < items.length - 1; i++) {
            // Find the minimum item in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < items.length; j++)
                if (items[j] < items[min_idx])
                    min_idx = j;
 
            // Swap the found minimum selected item with
            // the first selected item
            int temp = items[min_idx];
            items[min_idx] = items[i];
            items[i] = temp;
        }
    
    }

    static void insertionSort(Integer[] arr) 
    { 
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
    } 

    static void bubbleSort(Integer[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    //swap elements  
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    static void mergeSort(int[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left+right)/2;
        mergeSort(array, left, mid);
        mergeSort(array, mid+1, right);
        merge(array, left, mid, right);
        
    void merge(int[] array, int left, int mid, int right) {
            // calculating lengths
            int lengthLeft = mid - left + 1;
            int lengthRight = right - mid;
        
            int leftArray[] = new int [lengthLeft];
            int rightArray[] = new int [lengthRight];
        
            for (int i = 0; i < lengthLeft; i++)
                leftArray[i] = array[left+i];
            for (int i = 0; i < lengthRight; i++)
                rightArray[i] = array[mid+i+1];
        
            int leftIndex = 0;
            int rightIndex = 0;
        
            for (int i = left; i < right + 1; i++) {
                // if there are still uncopied elements in R and L, copy minimum of the two
                if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                    if (leftArray[leftIndex] < rightArray[rightIndex]) {
                        array[i] = leftArray[leftIndex];
                        leftIndex++;
                    }
                    else {
                        array[i] = rightArray[rightIndex];
                        rightIndex++;
                    }
                }
                // if all the elements have been copied from rightArray, copy the rest of leftArray
                else if (leftIndex < lengthLeft) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                // if all the elements have been copied from leftArray, copy the rest of rightArray
                else if (rightIndex < lengthRight) {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
        }
    }

}

