package com.crsardar.handson.algos.sortings;

import java.util.Comparator;
/**
 * @author Chittaranjan Sardar
 */
public class HeapSort<T> {

    public T[] sort(final T inArr[], final Comparator<T> comparator) {

        if (inArr == null || inArr.length <= 1) {

            return inArr;
        }

        for (int i = (inArr.length / 2); i >= 0; i--) {

            heapify(inArr, i, inArr.length - 1, comparator);
        }

        for (int length = inArr.length - 1; length >= 1; length--) {

            swap(inArr, 0, length);

            heapify(inArr, 0, length - 1, comparator);
        }

        return inArr;
    }

    // Here `arrLastIndex` is i.e. n-1
    private void heapify(final T[] arr, final int index, final int arrLastIndex, final Comparator comparator) {

        if (index > arrLastIndex) {

            return;
        }

        T largest = arr[index];
        int largestIndex = index;

        int lc = 2 * index + 1;
        if (lc <= arrLastIndex && comparator.compare(arr[lc], largest) > 0) {

            largestIndex = lc;
            largest = arr[largestIndex];
        }

        int rc = 2 * index + 2;
        if (rc <= arrLastIndex && comparator.compare(arr[rc], largest) > 0) {

            largestIndex = rc;
            largest = arr[largestIndex];
        }

        if (index != largestIndex) {

            swap(arr, index, largestIndex);

            heapify(arr, largestIndex, arrLastIndex, comparator);
        }
    }

    private void swap(final T arr[], final int i, final int j) {

        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
