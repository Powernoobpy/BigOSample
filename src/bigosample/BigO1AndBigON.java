/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigo;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Khaitong
 */
public class BigO1AndBigON {

    private static List l2 = new ArrayList();
    private static Map m1 = new HashMap();

    private static final int SMALL = 100;
    private static final int MEDIUM = 500_000;
    private static final int LARGE = 1_000_000;

    private static final int NO_OF_SEARCH_KEYS = 50_000;

    private static DecimalFormat df = new DecimalFormat("#,###");

    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();

        String[] small = new String[SMALL];
        String[] medium = new String[MEDIUM];
        String[] large = new String[LARGE];

        for (int i = 0; i < large.length; i++) {
            large[i] = new BigInteger(130, random).toString(32);
        }

        System.arraycopy(large, 0, small, 0, small.length);
        System.arraycopy(large, 0, medium, 0, medium.length);

        addKeys(small);
        search(small);
        remove(small);

        addKeys(large);
        search(large);
        remove(large);
    }

    public static void addKeys(String[] keys) {

        l2.clear();
        m1.clear();

        long startTime = System.currentTimeMillis();
        for (String s : keys) {
            l2.add(s);
        }
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Array List added " + df.format(keys.length) + " keys : " + duration);

        startTime = System.currentTimeMillis();
        for (String s : keys) {
            m1.put(s, s);
        }
        duration = System.currentTimeMillis() - startTime;
        System.out.println("Hash Map added " + df.format(keys.length) + " keys : " + duration);

        System.out.println("----------------------------------------------------");
    }

    public static void search(String[] keys) {

        long startTime = System.currentTimeMillis();
        int count = 0;
        for (String s : keys) {
            l2.indexOf(s);
            if(++count>10000) {
                break;
            }
        }
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Array List search " + NO_OF_SEARCH_KEYS+ " keys  from " + df.format(keys.length) +" keys, Duration: "+ df.format(duration));
        
        count = 0;
        startTime = System.currentTimeMillis();
        for (String s : keys) {
            m1.get(s);
            if(++count>10000) {
                break;
            }
        }
        duration = System.currentTimeMillis() - startTime;
        System.out.println("Hash Map search " + + NO_OF_SEARCH_KEYS+ " keys  from " + df.format(keys.length) +" keys, Duration: "+ df.format(duration));

        System.out.println("--------------------------------------------------");
    }

    public static void remove(String[] keys) {
        long startTime = System.currentTimeMillis();
        for (String s : keys) {
            l2.remove(s);
        }
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Array List removed " + df.format(keys.length) + " keys : " + df.format(duration));

        startTime = System.currentTimeMillis();
        for (String s : keys) {
            m1.remove(s);
        }
        duration = System.currentTimeMillis() - startTime;
        System.out.println("Hash Map removed " + df.format(keys.length) + " keys : " + df.format(duration));

        System.out.println("--------------------------------------------------");
    }

}
