package com.example.demo720.utils;

import java.util.Arrays;

public class quicksort {

    public static void runquicksort(int [] arr){
        qsort(arr,0,arr.length-1);
    }

    private static void qsort(int[] arr, int low, int high) {
        if(low<high){
            int pivot = partition(arr,low,high);
            qsort(arr,low,pivot-1);
            qsort(arr,pivot+1,high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while(low<high){
            while(low<high&&arr[high]>=pivot) {
                --high;
            }
            arr[low]=arr[high];
            while(low<high&&arr[low]<=pivot) {
                ++low;
            }
            arr[high]=arr[low];
        }
        arr[low]=pivot;
        return low;
    }
}


















