package com.algorithms4th;

import com.algorithms4th.lib.In;
import com.algorithms4th.lib.StdIn;
import com.algorithms4th.lib.StdOut;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class BinarySearch {

    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            System.out.println("mid = " + mid);
            System.out.println("lo = " + lo);
            System.out.println("hi = " + hi);
            if(key < a[mid])
                hi = mid - 1;
            else if(key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        String filename = BinarySearch.class.getClassLoader().getResource("largeW.txt").getFile();
        int[] whitelist = In.readInts(filename);
        printArray(whitelist);
        Arrays.sort(whitelist);
        System.out.println("--------------");
        printArray(whitelist);
        while(!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            System.out.println("key = " + key);
            if(rank(key, whitelist) == -1)
                StdOut.println(key);
        }
    }

    public static void printArray(int[] array) {
        Arrays.stream(array).forEach(System.out::println);
    }
}
