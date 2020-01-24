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
    private static int N = 10000000;
    private static Random r = new Random();
    public static void main(String[] args) {
        int[] a1 = new int[N];
        int[] a2 = new int[N];
        int[] a3 = new int[N];
        test5(a1);
        System.arraycopy(a1,0,a2,0,a1.length);
        System.arraycopy(a1,0,a3,0,a1.length);
        
        long begin = System.currentTimeMillis();
        
        Arrays.sort(a1);
        
        System.out.println("Duration:"+(System.currentTimeMillis()-begin)+"milliseconds\n");
        
        
//        Integer[] b1 = new Integer[N];
//        Integer[] b2 = new Integer[N];
//        Integer[] b3 = new Integer[N];
//        initial(b1);
//        System.arraycopy(b1,0,b2,0,b1.length);
//        System.arraycopy(b1,0,b3,0,b1.length);
//        
//        begin = System.currentTimeMillis();
//        
//        Arrays.sort(b1);
//        
//        System.out.println("Duration:"+(System.currentTimeMillis()-begin)+"milliseconds\n");
//             
    }
    
    private static void initial(Integer[] a1){
        for(int i = 0 ; i< a1.length ; i++){
            a1[i] = r.nextInt(N);
            
        }
    }
    
    private static void insertionSort(int[] array) {
  // insertion sort starts from second element
  for (int i = 1; i < array.length; i++) {
    int numberToInsert = array[i];

    int compareIndex = i;
    while (compareIndex > 0 && array[compareIndex - 1] > numberToInsert) {
       array[compareIndex] = array[compareIndex - 1]; // shifting element
       compareIndex--; // moving backwards, towards index 0
    }

    // compareIndex now denotes proper place for number to be sorted
     array[compareIndex] = numberToInsert;
   }
 }
    
    private static void test1(int[] array) {
  for (int i = 0; i < array.length; ++i) {
    array[i] = r.nextInt(N);
 }
    }

    private static void test2(int[] array) {
  for (int i = 1; i < array.length; i*=2) {
    array[i] = r.nextInt(N);
 }
    }

        private static void test3(int[] array) {
  for (int i = array.length-1; i != 0; i/=2) {
    array[i] = r.nextInt(N);
 }
    }
    private static void test4(int[] array) {
  for (int i = 0; i < array.length; ++i) {
      if(i%2==0)
    array[i] = r.nextInt(N);
 }
    }
    private static void test5(int[] array) {
  for (int i = 0; i < array.length; ++i) {
      for (int j = i; j < array.length; ++j){
    array[i] = r.nextInt(N);
      }
 }
    }}
