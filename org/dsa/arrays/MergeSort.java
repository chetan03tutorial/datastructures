package org.dsa.arrays;

import java.util.stream.IntStream;

public class MergeSort {

    public void mergeSort(int[] numbers, int start, int end){

        if( start < end){
            int mid = start + (end - start) /2;
            mergeSort(numbers, start, mid);
            mergeSort(numbers, mid+1, end);
            merge(numbers, start, mid, end);
        }
    }

    private void merge(int[] numbers, int start, int mid, int end) {

        int li = start;
        int ri = mid+1;
        int[] result = new int[end-start+1];
        int k = 0;

        while(li <= mid && ri <= end ) {
            result[k++] = numbers[li] <= numbers[ri] ? numbers[li++] : numbers[ri++];
        }

        while(li <= mid){
            result[k++] = numbers[li++];
        }

        while(ri <= end){
            result[k++] = numbers[ri++];
        }

        for(int i =0; i < result.length ; i++) {
            numbers[start+i] = result[i];
        }
    }

    public static void main(String[] args) {
        int[] numbers = {2,5,3,4,7,6,10};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(numbers, 0, numbers.length-1);
        IntStream.of(numbers).forEach(e-> System.out.print(e + " ,"));
    }
}
