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
}

