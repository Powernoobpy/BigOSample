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
}

