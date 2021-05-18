package org.dsa.arrays;
import java.util.stream.IntStream;

public class QuickSort {

    public void quickSort(int[] numbers, int low, int high){
        if(low < high){
            int pi = partition(numbers,low, high);
            quickSort(numbers,low, pi-1);
            quickSort(numbers, pi+1,high);
        }
    }


    // I'll increase the count of the pivotIndex unless I find an element which is bigger than pivot element.
    // This position is a potential index for pivot element ( potentialPivotIndex) .
    // But it is possible that there are more smaller elements on the right side of this larger element (Found at pivotIndex).
    // Hence, we continue looking for smaller elements on the right of pivotIndex and keep swapping them with the
    // larger items found at pivotIndex and increase the pivotIndex by 1. Once we reaches the end of array, we know that
    // position currently pointed by pivotIndex is the position of pivot element as all elements before pivotIndex are
    // lesser than the pivot element. Thus we do a final swap of pivot with element at pivotIndex.

    public int partition(int[] numbers, int low, int high){

        int pi = low;
        int pivot = numbers[high];
        for(int index = low; index < high ; index++){
            if(numbers[index] < pivot){

                if(pi != index){
                    swap(numbers, index,pi);
                }
                pi++;
            }
        }
        swap(numbers, pi,high);
        return pi;

    }

    public void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }


    public static void main(String[] args) {

        int[] numbers = {2,5,1,9,10,6,8};
        QuickSort qs = new QuickSort();
        qs.quickSort(numbers,0,numbers.length-1);
        IntStream.of(numbers).forEach(e -> System.out.print(e + ","));
    }
}
