package com.hippoz.algorithm.class01;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * 典型的二分查找
 * Q：在一个有序数组中，找到某个值的位置
 */
public class Code01_BSExist {

    // 二分算法 O(logN)
    public static boolean exist(int[] sortedArr,int num){
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
        while (L < R){
            mid = L + ((R - L) >> 1);
            if(sortedArr[mid] == num){
                return true;
            }else if(sortedArr[mid] > num){
                R = mid - 1;
            }else{
                L = mid + 1;
            }
        }
        return sortedArr[L]==num;
    }
    public static int exist2(int[] sortedArr,int num){
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
        System.out.println("num --->" + num);
        while (L < R){

            mid = L + ((R - L) >> 1);

            if(sortedArr[mid] == num){
                return mid;
            }else if(sortedArr[mid] > num){
                R = mid - 1;
            }else{
                L = mid + 1;
            }
            System.out.println("mid --->" + mid);
            System.out.println("sortedArr[mid]  --->" + sortedArr[mid] );
            System.out.println("L --->" + L);
            System.out.println("R --->" + R);
        }
        return -1;
    }

    // 暴力测试
    public static boolean test (int[] sortedArr,int num){
        for (int i = 0; i < sortedArr.length; i++) {
            if(num == sortedArr[i]){
                return true;
            }
        }
        return false;
    }

    private static int[] generateRandomSortedArr(int length, int range){
        int[] arr = new int[(int)(Math.random() * length) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * range) - (range >> 1);
        }
        Arrays.sort(arr);
        return arr;
    }

    public static void main(String[] args){
        int times = 200000;
        boolean good = Boolean.TRUE;
        for (int i = 0; i < times; i++) {
            int length = 100;
            int range = 200;
            int[] sortedArr = generateRandomSortedArr(length,range);

            int num =  (int)(Math.random() * range) - (range >> 1);
//            System.out.println("range --> " + range);
//            System.out.println("length --> " + length);
//            System.out.println("num --> " + num);
//            System.out.println("sortedArr --> " + sortedArr.length);
//            for (int i1 : sortedArr) {
//                System.out.print(i1 + " ");
//                System.out.println();
//            }
            boolean goal = exist(sortedArr, num);
            boolean target = test(sortedArr, num);
//                            System.out.println("goal --> " + goal);
//                System.out.println("target --> " + target);
            if(goal != target){
                good = Boolean.FALSE;
//
//                System.out.println("range --> " + range);
//                System.out.println("length --> " + length);
                System.out.println("num --> " + num);
//                System.out.println("sortedArr --> " + sortedArr.length);
//                for (int i1 : sortedArr) {
//                    System.out.print(i1 + " ");
//                    System.out.println();
//                }

                System.out.println("sortedArr --> " + sortedArr.length);
                for (int i1 : sortedArr) {
                    System.out.print(i1 + " ");
                    System.out.println();
                }
                System.out.println("goal --> " + goal);
                System.out.println("target --> " + target);
                System.out.println("出错了！");
                exist2(sortedArr, num);
            }
        }
        if(good) System.out.println("完美！");
    }

}
